package com.fpt.ojtstem.model;
public class TicketType{
	private String ticketTypeID;
	private String ticketTypeName;
	private float price;
	public TicketType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TicketType(String ticketTypeID, String ticketTypeName, float price) {
		super();
		this.ticketTypeID = ticketTypeID;
		this.ticketTypeName = ticketTypeName;
		this.price = price;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}