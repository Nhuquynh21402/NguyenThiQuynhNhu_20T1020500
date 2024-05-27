package com.fpt.ojtstem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.RoomDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.Room;
import com.opensymphony.xwork2.ActionSupport;

public class ShowRoomAction extends ActionSupport implements ServletRequestAware,SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Room> listRoom= new ArrayList<Room>();
	public HttpServletRequest request;
	private Map<String, Object> session;
	
	public String execute() throws Exception {
		if(session.containsKey("user")) {
			Account account = (Account) session.get("user");
			if(account.getRoldId()!=1)	{
				return ERROR;
			}
		}
		HttpSession session = request.getSession();
	    String errorMessage = (String) session.getAttribute("errorMessage");
		if(errorMessage!=null) {
			 addActionError(errorMessage);
			 session.removeAttribute("errorMessage");
		}
		RoomDao roomDao= new RoomDao();
		this.listRoom=roomDao.getAllRoom();
	
		return SUCCESS;
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
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	

	
}