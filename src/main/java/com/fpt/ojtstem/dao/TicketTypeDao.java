package com.fpt.ojtstem.dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fpt.ojtstem.config.Config;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.TicketType;


public class TicketTypeDao{
	static Connection con;
	static PreparedStatement ps;
	public List<TicketType> getAll() {
		List<TicketType> ticketType = new ArrayList<>();
		try {
			con = Config.getCon();
			String query = "SELECT * FROM TicketType";
			ps = con.prepareStatement(query);

			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				 String ticketTypeID = rs.getString("Ticketid");
			     String ticketTypeName = rs.getString("TicketTypeName");
				 int price = rs.getInt("ToTal");
				 ticketType.add(new TicketType(ticketTypeID, ticketTypeName, price));
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return ticketType;
	}
	
	public void addTicketType(TicketType ticketType){
		try {
			con = Config.getCon();
			String query = "INSERT INTO TicketType (TicketTypeName, ToTal) VALUES (?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1,ticketType.getTicketTypeID());
			ps.setString(2,ticketType.getTicketTypeName());
			ps.setFloat(3, ticketType.getPrice());
			ps.executeUpdate();
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateTicketType(TicketType ticketType){
		try {
			con = Config.getCon();
			String query = "UPDATE TICKETTYPE set  TicketTypeName=?, ToTal=? where Ticketid=? ";
			ps = con.prepareStatement(query);
			ps.setString(1,ticketType.getTicketTypeName());
			ps.setFloat(2, ticketType.getPrice());
			ps.setString(3,ticketType.getTicketTypeID());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void deleteTicketType(String ticketTypeID){
		try {
			con = Config.getCon();
			String query= "DELETE TICKETTYPE WHERE TTicketid=?";
			ps = con.prepareStatement(query);
			ps.setString(1, ticketTypeID);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public TicketType findTicketType(String key) {
		TicketType ticketType = null;
		try {
			con = Config.getCon();
			String query= "SELECT * FROM  tickettype where  TicketTypeName=? ";
			ps = con.prepareStatement(query);
			ps.setString(1,key);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 String ticketTypeID=rs.getString("Ticketid");
			     String ticketTypeName=rs.getString("TicketTypeName");
				 Float price =rs.getFloat("ToTal");
			     ticketType=new TicketType(ticketTypeID, ticketTypeName, price);		
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return ticketType;
	}
	
	
}
