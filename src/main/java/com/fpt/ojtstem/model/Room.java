package com.fpt.ojtstem.model;
public class Room{
	private String roomId;
	private String roomName;
	private String seatQuantity;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(String roomId, String roomName, String seatQuantity) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.seatQuantity = seatQuantity;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getSeatQuantity() {
		return seatQuantity;
	}
	public void setSeatQuantity(String seatQuantity) {
		this.seatQuantity = seatQuantity;
	}
	


	
	
	
}