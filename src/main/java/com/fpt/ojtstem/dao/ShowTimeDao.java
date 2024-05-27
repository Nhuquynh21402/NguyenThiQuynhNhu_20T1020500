package com.fpt.ojtstem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.ojtstem.config.Config;
import com.fpt.ojtstem.model.ShowTime;



public class ShowTimeDao{
	static Connection con;
	static PreparedStatement ps;
	public List<ShowTime> getAll() {
		String queryShow = "SELECT * FROM showtime";
		List<ShowTime> list= new ArrayList<>();
		try {
			con = Config.getCon();
			ps = con.prepareStatement(queryShow);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 String showTimeID=rs.getString("showtimeid");
				 String fromTime=rs.getString("fromtime");
				 String toTime =rs.getString("totime");
				 list.add(new ShowTime(showTimeID, fromTime, toTime));
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public ShowTime getOne(String id) {
		String queryShow = "SELECT * FROM showtime where showtimeid=?";
	    ShowTime showTime= new ShowTime();
		try {
			con = Config.getCon();
			ps = con.prepareStatement(queryShow);
			ps.setString(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 String showTimeID=rs.getString("showtimeid");
				 String fromTime=rs.getString("fromtime");
				 String toTime =rs.getString("totime");
				showTime = new ShowTime(showTimeID, fromTime, toTime);
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return showTime;
	}

}