package com.fpt.ojtstem.model;


public class Schedule{
	
	private String showDate;
	private String showTimeId;
	private String RoomId;
	private String movieId;
	
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule( String showDate, String showTimeId, String roomId, String movieId) {
		super();
		
		this.showDate = showDate;
		this.showTimeId = showTimeId;
		RoomId = roomId;
		this.movieId = movieId;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTimeId() {
		return showTimeId;
	}

	public void setShowTimeId(String showTimeId) {
		this.showTimeId = showTimeId;
	}

	public String getRoomId() {
		return RoomId;
	}

	public void setRoomId(String roomId) {
		RoomId = roomId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
}