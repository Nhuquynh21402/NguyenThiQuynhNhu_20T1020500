package com.fpt.ojtstem.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.TicketTypeDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.TicketType;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ShowTypeTicketAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TicketType> listTicket=new ArrayList<TicketType>();
    private TicketType ticket;
	private float price;
	private Map<String, Object> session;
	
	public String execute() throws Exception {
		if(session.containsKey("user")) {
			Account account = (Account) session.get("user");
			if(account.getRoldId()!=1)	{
				return ERROR;
			}
		}
	TicketTypeDao ticketDao =new TicketTypeDao();
	this.listTicket=ticketDao.getAll();
	return SUCCESS;
	}

	
	
	public String add() { 
		try {
			TicketTypeDao tketDao =new TicketTypeDao();
			this.listTicket=tketDao.getAll();
			 if (StringUtil.isNullOrEmpty(ticket.getTicketTypeName())) {
				addActionError("Tên không được để trống");
				return ERROR;
			} else if (ticket.getTicketTypeName().length() > 50) {
	            addActionError("Tên loại vé không được quá 50 kí tự !!");
	            return ERROR;
	        }else if(!ticket.getTicketTypeName().matches("^[\\p{L}\\s]+$")) {
				 addActionError("Tên loại vé chỉ được chứa các ký tự chữ cái!!");
		            return ERROR;
			}
			else if (String.valueOf(ticket.getPrice()).isEmpty()) {
				addActionError("Giá vé không được để trống");
				return ERROR;
			}
			else if(ticket.getPrice()<=0 ||ticket.getPrice()>=100000) {
				addActionError("Giá vé không hợp lệ!!");
				return ERROR;
			}else if(!String.valueOf(ticket.getPrice()).matches("^[+-]?[\\d]*[.]?[\\d]*$")) {
	        	 addActionError("Giá vé  phải là một số!!");
		            return ERROR;
	        }
		   else {
				if(! checkType(listTicket, ticket.getTicketTypeID().trim(),ticket.getTicketTypeName().trim())) {
				    tketDao.addTicketType(ticket);
				   return "Add";
				}else {
					
					addActionError("Id hoặc tên loại vé đã được sử dụng.");
					return ERROR;
				}
			}
		
			}catch (Exception e) {
		return ERROR;
	}	
	}
	
	private boolean checkType(List<TicketType> listTicket, String id, String name) {
		for (TicketType ticket : listTicket) {
			if (ticket.getTicketTypeID().equals(id) || ticket.getTicketTypeName().equals(name)) {
					return true;
			
			}
		}
		return false;
	}



	public List<TicketType> getListTicket() {
		return listTicket;
	}



	public void setListTicket(List<TicketType> listTicket) {
		this.listTicket = listTicket;
	}



	public TicketType getTicket() {
		return ticket;
	}



	public void setTicket(TicketType ticket) {
		this.ticket = ticket;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}



}