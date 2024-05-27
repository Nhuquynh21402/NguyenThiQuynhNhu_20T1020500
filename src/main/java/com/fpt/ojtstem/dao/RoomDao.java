package com.fpt.ojtstem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.ojtstem.config.Config;
import com.fpt.ojtstem.model.Movie;
import com.fpt.ojtstem.model.Room;
import com.fpt.ojtstem.model.TypeMovie;

public class RoomDao {
	static Connection con;
	static PreparedStatement ps;
    
	public List<Room> getAllRoom() {
		String queryRoom = "SELECT * FROM room";
		List<Room> rooms = new ArrayList<>();
		try {
			con = Config.getCon();
			ps = con.prepareStatement(queryRoom);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 String roomId=rs.getString("roomId");
				 String roomName=rs.getString("roomName");
				 String seatQuantity =rs.getString("quantity");
				 rooms.add(new Room(roomId, roomName, seatQuantity));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return rooms;
	}
	public void insertRoom(Room Room) {
		try {
			String query="insert into room(roomname,quantity) VALUES (?,?)";
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,Room.getRoomName());
			ps.setString(2, Room.getSeatQuantity());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void updateRoom(Room room, String id) {
	    try {
	        String query = "UPDATE room SET roomname=?, quantity=? WHERE roomid=?";
	        con = Config.getCon();
	        ps = con.prepareStatement(query);
	        ps.setString(1, room.getRoomName());
	        ps.setString(2, room.getSeatQuantity());
	        ps.setString(3,room.getRoomId());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	public boolean delete(String key) {
		try {
		String query ="delete from room  where roomid=? ";
		con = Config.getCon();
		ps = con.prepareStatement(query);
		ps.setString(1,key);
		int rows = ps.executeUpdate();
		return rows>0;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	public Room findRoom(String key) {
		 Room room=null;
		try {
		con = Config.getCon();
		String query = "SELECT * FROM room where roomid=?";
		ps = con.prepareStatement(query);
		ps.setString(1, key);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			 String roomId = rs.getString("roomid");
			 String roomName = rs.getString("roomname");
			 String seatQuantity = rs.getString("quantity");
			 room =new Room(roomId, roomName, seatQuantity);
		}
		rs.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		return room;
	}
	


}