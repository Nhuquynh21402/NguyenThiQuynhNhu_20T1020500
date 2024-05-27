package com.fpt.ojtstem.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.RoomDao;
import com.fpt.ojtstem.model.Room;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AddRoomAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Room room;
	List<Room> listRoom;
	private Map<String, Object> session;
	

	public String execute() throws Exception {
	    try {
	        RoomDao rDao = new RoomDao();    
	        if (StringUtil.isNullOrEmpty(room.getRoomName())) {
	            addActionError("Tên phòng không được bỏ trống!!");
	            return ERROR;
	        } else if (room.getRoomName().length() > 20) {
	            addActionError("Tên phòng không được quá 20 kí tự !!");
	            return ERROR;
	        } else if (StringUtil.isNumber(room.getRoomName())) {
	            addActionError("Tên phòng không hợp lệ !!");
	            return ERROR;
	        } else if (!StringUtil.isCheck(room.getRoomName())) {
	            addActionError("Tên chỉ được chứa các ký tự chữ cái, số!!");
	            return ERROR;
	        } 
	        if (StringUtil.isNullOrEmpty(room.getSeatQuantity())) {
	            addActionError("Số lượng ghế không được bỏ trống!!");
	            return ERROR;
	        }else if(!StringUtil.isNumber(String.valueOf(room.getSeatQuantity()))) {
	        	 addActionError("Số lượng ghế phải là một số!!");
		            return ERROR;
	        }
	        else if (Integer.parseInt(room.getSeatQuantity()) <= 0 || Integer.parseInt(room.getSeatQuantity()) % 1 != 0) {
	            addActionError("Số lượng ghế không hợp lệ!!");
	            return ERROR;
	        }else if (Integer.parseInt(room.getSeatQuantity()) > 100) {
	            addActionError("Số lượng ghế không được quá 100!!");
	            return ERROR;
	        } 
	        else {
	            if (!checkIdRoom(rDao.getAllRoom(),room.getRoomName().trim())) {
	                rDao.insertRoom(room);
	                return SUCCESS;
	            } else {
	                addActionError("Id hoặc tên phòng đã được sử dụng");
	                return ERROR;
	            }
	        }
	    } catch (Exception e) {
	        return ERROR;
	    }
	}



	private boolean checkIdRoom(List<Room> listRoom, String name) {
		for (Room rom : listRoom) {
			if (rom.getRoomName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	



	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

}