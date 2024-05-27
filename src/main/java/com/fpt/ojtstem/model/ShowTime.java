package com.fpt.ojtstem.model;

public class ShowTime{
	String showTimeID;
	String fromTime;
	String toTime;
	
	
	public ShowTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShowTime(String showTimeID, String fromTime, String toTime) {
		super();
		this.showTimeID = showTimeID;
		this.fromTime = fromTime;
		this.toTime = toTime;
	}

	public String getShowTimeID() {
		return showTimeID;
	}
	public void setShowTimeID(String showTimeID) {
		this.showTimeID = showTimeID;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	
	
}