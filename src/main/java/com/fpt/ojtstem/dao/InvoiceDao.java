package com.fpt.ojtstem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fpt.ojtstem.config.Config;
import com.fpt.ojtstem.model.Invoice;

public class InvoiceDao {
	static Connection con;
	static PreparedStatement ps;

	public void Insert(Invoice invoice,int id,String Accountid) {
		try {
			con = Config.getCon();
			String query = "INSERT INTO invoice (BOOKING_DATE, total_money, seat_id, ticketid, roomid, showdate, movie_id, showtimeid,id,AccountID) VALUES (GETDATE(), ?, ?, ?, ?, CONVERT(DATE, ?, 101), ?, ?,?,?)";
			ps = con.prepareStatement(query);
			ps.setFloat(1, invoice.getTotal());
			ps.setString(2, invoice.getSeatId());
			ps.setString(3, invoice.getTicketTypeId());
			ps.setString(4, invoice.getRoomId());
			ps.setString(5, invoice.getShowDate());
			ps.setString(6, invoice.getMovieId());
			ps.setString(7, invoice.getShowTimeId());
			ps.setInt(8,id);
			ps.setString(9,Accountid);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Invoice> getAll(String movieid, String roomid, String showdate, String showtimeid) {
		List<Invoice> list = new ArrayList<>();
		try {

			con = Config.getCon();
			String query = "select * from invoice where movie_id=? and roomid=? and showtimeid=? and CONVERT(DATE, showdate, 101) = ? ";
			ps = con.prepareStatement(query);
			ps.setString(1, movieid);
			ps.setString(2, roomid);
			ps.setString(3, showtimeid);
			ps.setString(4, showdate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int invoiceID = rs.getInt("INVOICE_ID");
				String bookingDate = rs.getString("BOOKING_DATE");
				float total = rs.getFloat("TOTAL_MONEY");
				String seatId = rs.getString("SEAT_ID");
				String ticketTypeId = rs.getString("Ticketid");
				String roomId = rs.getString("ROOMID");
				String showDate = rs.getString("SHOWDATE");
				String movieId = rs.getString("MOVIE_ID");
				String showTimeid = rs.getString("SHOWTIMEID");
				list.add(new Invoice(invoiceID, bookingDate, total, seatId, ticketTypeId, roomId, showDate, movieId,
						showTimeid));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public Invoice getOne(String movieid, String roomid, String showdate, String showtimeid, String seat) {

		try {

			con = Config.getCon();
			String query = "select * from invoice where movie_id=? and roomid=? and showtimeid=? and CONVERT(DATE, showdate, 101) = ? and  SEAT_ID=?";
			ps = con.prepareStatement(query);
			ps.setString(1, movieid);
			ps.setString(2, roomid);
			ps.setString(3, showtimeid);
			ps.setString(4, showdate);
			ps.setString(5, seat);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int invoiceID = rs.getInt("INVOICE_ID");
				String bookingDate = rs.getString("BOOKING_DATE");
				float total = rs.getFloat("TOTAL_MONEY");
				String seatId = rs.getString("SEAT_ID");
				String ticketTypeId = rs.getString("Ticketid");
				String roomId = rs.getString("roomId");
				String showDate = rs.getString("SHOWDATE");
				String movieId = rs.getString("movie_id");
				String showTimeid = rs.getString("SHOWTIMEID");
				return new Invoice(invoiceID, bookingDate, total, seatId, ticketTypeId, roomId, showDate, movieId,
						showTimeid);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	public List<Invoice> getAllbyID (String id) {
		List<Invoice> list = new ArrayList<>();
		try {

			con = Config.getCon();
			StringBuilder query = new StringBuilder();
			query.append("select Invoice.INVOICE_ID, Invoice.BOOKING_DATE, Invoice.TOTAL_MONEY, Invoice.SEAT_ID, Invoice.Ticketid,Room.roomName,Invoice.SHOWDATE, movie.movieName, ShowTime.fromTime ")
			.append("from Invoice join movie on movie.movie_id = Invoice.movie_id join Room on Invoice.roomId=Room.roomId ")
			.append("join ShowTime on Invoice.SHOWTIMEID=ShowTime.SHOWTIMEID ")
			.append("where AccountID=? AND Booking_Date >= DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0) ")
			.append("AND Booking_Date < DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()) + 1, 0)")
			.append("GROUP BY Invoice.INVOICE_ID, Invoice.BOOKING_DATE, Invoice.TOTAL_MONEY, Invoice.SEAT_ID, Invoice.Ticketid,Room.roomName,Invoice.SHOWDATE, movie.movieName, ShowTime.fromTime");
			String sql = query.toString();
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int invoiceID = rs.getInt("INVOICE_ID");
				String bookingDate = rs.getString("BOOKING_DATE");
				float total = rs.getFloat("TOTAL_MONEY");
				String seatId = rs.getString("SEAT_ID");
				String ticketTypeId = rs.getString("Ticketid");
				String roomId = rs.getString("roomName");
				String showDate = rs.getString("SHOWDATE");
				String movieId = rs.getString("movieName");
				String showTimeid = rs.getString("fromTime");
				list.add(new Invoice(invoiceID, bookingDate, total, seatId, ticketTypeId, roomId, showDate, movieId,
						showTimeid));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

}