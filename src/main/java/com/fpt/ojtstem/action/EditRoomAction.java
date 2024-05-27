package com.fpt.ojtstem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Parameter.Request;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.RoomDao;
import com.fpt.ojtstem.dao.ScheduleDao;
import com.fpt.ojtstem.dao.TypeMovieDao;
import com.fpt.ojtstem.model.Room;
import com.fpt.ojtstem.model.Schedule;
import com.fpt.ojtstem.model.TypeMovie;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class EditRoomAction extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Room room = null;
	private String tenPhong;
	private String roomId;
	private String soLuongGhe;
	private Map<String, Object> session;
	public HttpServletRequest request;
	private List<Room> listRoom = new ArrayList<Room>();

	public String execute() throws Exception {
		try {
			RoomDao roomDao = new RoomDao();
			room = roomDao.findRoom(id);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}

	}

	public String update() {
	    try {
	        if (!session.containsKey("session")) {
	            session.put("session", id);
	        } else {
	            id = (String) session.get("session");
	        }
	        
	        RoomDao roomDao = new RoomDao();
	        this.listRoom = roomDao.getAllRoom();
	        
	        if (StringUtil.isNullOrEmpty(tenPhong)) {
	            addActionError("Tên phòng không được để trống");
	            return ERROR;
	        } else if (tenPhong.length() > 20) {
	            addActionError("Tên phòng không được quá 20 kí tự !!");
	            return ERROR;
	        } else if (tenPhong.matches("^[+-]?[\\d]*[.]?[\\d]*$")) {
	            addActionError("Tên phòng không hợp lệ !!");
	            return ERROR;
	        } else if (!tenPhong.matches("^[\\p{L}0-9\\s]+$")) {
	            addActionError("Tên chỉ được chứa các ký tự chữ cái, số và khoảng trắng!!");
	            return ERROR;
	        } else if (StringUtil.isNullOrEmpty(soLuongGhe)) {
	            addActionError("Số lượng ghế không được để trống");
	            return ERROR;
	        }else if(!soLuongGhe.matches("^[+-]?[\\d]*[.]?[\\d]*$")) {
	        	 addActionError("Số lượng ghế phải là một số!!");
		            return ERROR;
	        }
	        else {
	                if (Integer.parseInt(soLuongGhe)<= 0 || Integer.parseInt(soLuongGhe) > 100 || Integer.parseInt(soLuongGhe) % 1 !=0) {
	                    addActionError("Số lượng ghế không hợp lệ!!");
	                    return ERROR;
	        }
	        }
	    
	        if (!checkRoom(tenPhong.trim())) {
	            Room newRoom = new Room(id, tenPhong,soLuongGhe);
	            roomDao.updateRoom(newRoom, id);
	            return "update";
	        } else {
	            if (tenPhong.equals(roomDao.findRoom(id).getRoomName())) {
	                Room newRoom = new Room(id, tenPhong, soLuongGhe);
	                roomDao.updateRoom(newRoom, id);
	                return "update";
	            } else {
	                addActionError("Tên phòng đã được sử dụng");
	                return ERROR;
	            }
	        }
	    } catch (Exception e) {
	        return ERROR;
	    }
	}


	private boolean checkRoom(String tenphong) {
		for (Room room : listRoom) {
			if (room.getRoomName().equals(tenphong)) {
				return true;
			}
		}
		return false;
	}

	public String delete() {
		try {
			RoomDao rDao = new RoomDao();
			ScheduleDao scheduleDao= new ScheduleDao();
			if(scheduleDao.isSchedule(roomId)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("errorMessage", "Phòng đã được lên lịch chiếu!! Không thể xóa!! Xóa lịch chiếu trước đi !!");
	            return ERROR;
			}else {
				boolean deleted = rDao.delete(roomId.trim());
				if (deleted) return SUCCESS;
				else return ERROR; 
				
			}
			
			
			
			
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}



	
	public String getSoLuongGhe() {
		return soLuongGhe;
	}

	public void setSoLuongGhe(String soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}

	public List<Room> getListRoom() {
		return listRoom;
	}

	public void setListRoom(List<Room> listRoom) {
		this.listRoom = listRoom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	


}