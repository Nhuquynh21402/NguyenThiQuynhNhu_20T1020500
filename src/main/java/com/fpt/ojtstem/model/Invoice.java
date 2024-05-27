package com.fpt.ojtstem.model;


public class Invoice{
    private int invoiceID;
	private String dateBooking;
	
	private float total;
	private String seatId;
	private String ticketTypeId;
	private String roomId;
	private String showDate;
	private String movieId;
	private String showTimeId;
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(int invoiceID, String dateBooking, float total, String seatId, String ticketTypeId,
			String roomId, String showDate, String movieId, String showTimeId) {
		super();
		this.invoiceID = invoiceID;
		this.dateBooking = dateBooking;
		this.total = total;
		this.seatId = seatId;
		this.ticketTypeId = ticketTypeId;
		this.roomId = roomId;
		this.showDate = showDate;
		this.movieId = movieId;
		this.showTimeId = showTimeId;
	}

	public int getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	public String getDateBooking() {
		return dateBooking;
	}
	public void setDateBooking(String dateBooking) {
		this.dateBooking = dateBooking;
	}

	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public String getTicketTypeId() {
		return ticketTypeId;
	}
	public void setTicketTypeId(String ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getShowTimeId() {
		return showTimeId;
	}
	public void setShowTimeId(String showTimeId) {
		this.showTimeId = showTimeId;
	}
	

}