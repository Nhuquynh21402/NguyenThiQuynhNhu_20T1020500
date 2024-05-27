package com.fpt.ojtstem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.RoomDao;
import com.fpt.ojtstem.dao.TicketTypeDao;
import com.fpt.ojtstem.dao.TypeMovieDao;
import com.fpt.ojtstem.model.Room;
import com.fpt.ojtstem.model.TicketType;
import com.fpt.ojtstem.model.TypeMovie;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

import net.bytebuddy.implementation.bytecode.Throw;

public class EditTypeTicketAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private TicketType ticket = null;
	private String ticketTypeID;
	private String ticketTypeName;
	private int price;
	private String ticketId;
	List<TicketType> listType = new ArrayList<TicketType>();
	private Map<String, Object> session;
	// Getter và Setter cho request

	@Override
	public String execute() throws Exception {
		TicketTypeDao ticketDao = new TicketTypeDao();
		ticket = ticketDao.findTicketType(id);
		return SUCCESS;
	}

	public String update() {
		try {
			if (!session.containsKey("ticket")) {
				session.put("ticket", ticketId);
			
			} else {
				ticketId = (String) session.get("ticket");
			}

			TicketTypeDao ticketDao = new TicketTypeDao();
			this.listType = ticketDao.getAll();
			if (StringUtil.isNullOrEmpty(ticketTypeName)) {
				addActionError("Tên loại vé không được để trống");
				return ERROR;
			} else if (ticketTypeName.length() > 50) {
	            addActionError("Tên loại vé không được quá 50 kí tự !!");
	            return ERROR;
	        }else if(!ticketTypeName.matches("^[\\p{L}\\s]+$")) {
				 addActionError("Tên loại vé chỉ được chứa các ký tự chữ cái!!");
		            return ERROR;
			}
			else if (String.valueOf(price).isEmpty()) {
				addActionError("Giá vé không được để trống");
				return ERROR;
			}
			else if(price<=0 ||price>=100000) {
				addActionError("Giá vé không hợp lệ!!");
				return ERROR;
			}else if(!String.valueOf(price).matches("^[+-]?[\\d]*[.]?[\\d]*$")) {
	        	 addActionError("Số lượng ghế phải là một số!!");
		            return ERROR;
	        }
			else if (!checkNameType(ticketTypeName.trim())) {
				TicketType newTicket = new TicketType(ticketId, ticketTypeName, price);
				ticketDao.updateTicketType(newTicket);
				session.remove("ticket");
				return "update";
			} else {
				if (ticketTypeName.equals(ticketDao.findTicketType(ticketId).getTicketTypeName())) {
					TicketType newTicket = new TicketType(ticketId, ticketTypeName, price);
					ticketDao.updateTicketType(newTicket);
					session.remove("ticket");
					return "update";
				}else {
					addActionError("Tên loại vé đã được sử dụng");
					return ERROR;
				}
				
			}
		} catch (Exception e) {
			return ERROR;
		}
	}

	private boolean checkNameType(String TicketTypeName) {
		for (TicketType ticket : listType) {
			if (ticket.getTicketTypeName().equals(TicketTypeName)) {
				return true;
			}
		}
		return false;
	}

	public String delete() {
		try {
			TicketTypeDao ticketDao = new TicketTypeDao();
			ticketDao.deleteTicketType(ticketId);
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TicketType getTicket() {
		return ticket;
	}

	public void setTicket(TicketType ticket) {
		this.ticket = ticket;
	}

	public String getTicketTypeID() {
		return ticketTypeID;
	}

	public void setTicketTypeID(String ticketTypeID) {
		this.ticketTypeID = ticketTypeID;
	}

	public String getTicketTypeName() {
		return ticketTypeName;
	}

	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public List<TicketType> getListType() {
		return listType;
	}

	public void setListType(List<TicketType> listType) {
		this.listType = listType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public Map<String, Object> getSession() {
		return session;
	}

}