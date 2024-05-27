package com.fpt.ojtstem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.freemarker.template.GetAsStringFMModel;

import com.fpt.ojtstem.config.Config;
import com.fpt.ojtstem.model.Schedule;
import com.fpt.ojtstem.model.Statistic;
import com.fpt.ojtstem.util.StringUtil;

public class ScheduleDao {
	static Connection con;
	static PreparedStatement ps;

	public Schedule getSchedule(String room_Id, String show_Date, String showTime, String movie_Id) {
		String query = "SELECT * FROM schedule WHERE roomid = ? AND movieid = ? AND showtimeid = ? AND CONVERT(DATE, showdate, 101) = ?";

		
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1, room_Id);
			ps.setString(2, movie_Id);
			ps.setString(3, showTime);
			ps.setString(4, show_Date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 String showDate=rs.getString("showdate");
				 String showTimeId=rs.getString("showtimeid");
				 String roomId=rs.getString("roomid");
				 String movieId=rs.getString("movieid");
				 if (!StringUtil.isNullOrEmpty(movieId)) {
				   return new Schedule(showDate, showTimeId, roomId, movieId);
				 }
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	public boolean  isSchedule (String key){
		String query="select * from schedule where room_id=? or showtime_id=? or movie_id=?";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,key);
			ps.setString(2,key);
			ps.setString(3,key);
		ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false ;
	}
	public List<Schedule>  getisSchedule (String key){
		List<Schedule> schedule = new ArrayList<Schedule>();
		String query="select * from schedule where room_id=? or showtime_id=? or movie_id=?";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,key);
			ps.setString(2,key);
			ps.setString(3,key);
		ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			 String showDate = rs.getString("show_date");
			 String showTimeId =rs.getString("showtime_id");
			 String RoomId = rs.getString("room_id");
			 String movieId = rs.getString("movie_id");
	         schedule.add(new Schedule(showDate, showTimeId, RoomId, movieId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return schedule;
		
	}
	public boolean  isSchedules (String room_id, String showtime_id, String showdate){
		String query="SELECT * FROM schedule WHERE roomid = ? AND showtimeid = ? AND CONVERT(DATE, showdate, 101) = ?";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,room_id);
			ps.setString(2,showtime_id);
			ps.setString(3,showdate);
		    ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false ;
	}
	public List<Schedule> getByMovie(){
		List<Schedule> list =new ArrayList<Schedule>();
		String query="select DISTINCT m.movie_id from  movie m join schedule sc on m.movie_id = sc.movieid";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
		
	     	ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			 String movieId = rs.getString("movie_id");
			 list.add(new Schedule(null, null, null, movieId));
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public void insertSchedule(String room_id, String showtime_id, String showdate,String movie_id){
	
		String query="INSERT INTO SCHEDULE (SHOWDATE, MOVIEID, ROOMID, SHOWTIMEID) VALUES (CONVERT(DATE, ?, 101), ?, ?, ?)";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
		    ps.setString(1,showdate);
		    ps.setString(2,movie_id);
		    ps.setString(3,room_id);
		    ps.setString(4,showtime_id);
		    ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public List<Schedule> getByRoomBooking(){
		List<Schedule> list =new ArrayList<Schedule>();
		String query="select DISTINCT sc.roomid from  room r join schedule sc on r.roomid = sc.roomid";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
		
	     	ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			 String roomId = rs.getString("roomid");
			 list.add(new Schedule(null, null,  roomId, null));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<Schedule> getByRoom(String movie,String showdate){
		List<Schedule> list =new ArrayList<Schedule>();
		String query="select DISTINCT sc.roomid from  movie m join schedule sc on m.movie_id = sc.movieid where m.movie_id=? and CONVERT(DATE, showdate, 101) = ?";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,movie);
			ps.setString(2,showdate);
	     	ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			 String room = rs.getString("roomid");
			 list.add(new Schedule(null, null, room, null));
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public List<Schedule> getByDate(String movieId){
		List<Schedule> list =new ArrayList<Schedule>();
		String query="select DISTINCT CONVERT(VARCHAR, sc.showdate, 101)  as show_date from  movie m join schedule sc on m.movie_id = sc.movieid where m.movie_id=? AND sc.showdate >= CONVERT(DATE, GETDATE())";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,movieId);
	     	ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			 String showdate = rs.getString("show_date");
			 list.add(new Schedule(showdate, null, null, null));
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public int getById(String movie,String showdate, String Room,String showtimeid){
		String query="select id from  movie m join schedule sc on m.movie_id = sc.movieid where m.movie_id=? AND CONVERT(DATE, showdate, 101) = ? and sc.showtimeid=? and sc.roomid=?";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,movie);
			ps.setString(2,showdate);
			ps.setString(3,showtimeid);
			ps.setString(4,Room);
	     	ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			return rs.getInt("id");
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public List<Schedule> getByShowtime(String movie,String showdate, String Room){
		List<Schedule> list =new ArrayList<Schedule>();
		String query="select DISTINCT sc.showtimeid from  movie m join schedule sc on m.movie_id = sc.movieid where m.movie_id=? and CONVERT(DATE, showdate, 101) = ? and sc.roomid=?";
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,movie);
			ps.setString(2,showdate);
			ps.setString(3,Room);
	     	ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			 String showtime_id = rs.getString("showtimeid");
			 list.add(new Schedule(null, showtime_id, null, null));
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public int getQuantity(String movieId) {
		String query="select count(invoice_id) as soluong from invoice where movie_id=?";
		int quantity = 0;
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,movieId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				quantity = rs.getInt("soluong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}
	public float getIncome(String movieId) {
		String query="SELECT SUM(total_money) AS doanhthu FROM invoice WHERE movie_id = ? GROUP BY movie_id";
		float income=0;
		try {
			con = Config.getCon();
			ps = con.prepareStatement(query);
			ps.setString(1,movieId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				income = rs.getFloat("doanhthu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return income;	

	}
	
	
	public List<Statistic> getStatistic() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	     .append("FROM invoice i ")
	     .append("JOIN movie m ON i.movie_id = m.movie_id ")
	     .append("WHERE MONTH(i.booking_date) = MONTH(GETDATE()) ")
	     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ")
	     .append("GROUP BY m.movie_id, m.moviename ")
	     .append("ORDER BY MIN(i.booking_date) ASC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public  Statistic getAllStatistic() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT SUM(total_money) AS doanhthu, COUNT(invoice_id) AS soluongve FROM invoice ")
	     .append("WHERE CONVERT(date, booking_date) = CONVERT(date, GETDATE())");
	 Statistic statistics = new Statistic();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next()) {
	            String income = rs.getString("doanhthu");
	            String quantity = rs.getString("soluongve");
	            statistics= new Statistic(null, null, income, quantity);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByQuantity() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movie_id = m.movie_id ")
	         .append("GROUP BY m.movie_id, m.movie_name ")
	         .append("ORDER BY COUNT(i.invoice_id) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	
	public List<Statistic> getStatisticByIncome() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movie_id = m.movie_id ")
	         .append("GROUP BY m.movie_id, m.movie_name ")
	         .append("ORDER BY  SUM(i.total_money) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByDayIncome() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movie_id = m.movie_id ")
	         .append("where CONVERT(date, booking_date) = CONVERT(date, GETDATE()) ")
	         .append("GROUP BY m.movie_id, m.moviename ")
	         .append("ORDER BY  SUM(i.total_money) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByDayQuantity() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movie_id = m.movie_id ")
	         .append("where CONVERT(date, booking_date) = CONVERT(date, GETDATE()) ")
	         .append("GROUP BY m.movie_id, m.moviename ")
	         .append("ORDER BY  COUNT(i.invoice_id) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByWeekQuantity() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	     .append("FROM invoice i ")
	     .append("JOIN movie m ON i.movieid = m.movie_id ")
	     .append("WHERE DATEPART(ISO_WEEK, i.booking_date) = DATEPART(ISO_WEEK, GETDATE()) ")
	     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ")
	     .append("GROUP BY m.movie_id, m.moviename ")
	     .append("ORDER BY COUNT(i.invoice_id) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByWeekIncome() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	     .append("FROM invoice i ")
	     .append("JOIN movie m ON i.movie_id = m.movie_id ")
	     .append("WHERE DATEPART(ISO_WEEK, i.booking_date) = DATEPART(ISO_WEEK, GETDATE()) ")
	     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ")
	     .append("GROUP BY m.movie_id, m.moviename ")
	     .append("ORDER BY SUM(i.total_money) DESC");

	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByMonthQuantity() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	     .append("FROM invoice i ")
	     .append("JOIN movie m ON i.movie_id = m.movie_id ")
	     .append("WHERE MONTH(i.booking_date) = MONTH(GETDATE()) ")
	     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ")
	     .append("GROUP BY m.movie_id, m.moviename ")
	     .append("ORDER BY COUNT(i.invoice_id) DESC");

	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByMonthIncome() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movie_id = m.movie_id ")
		     .append("WHERE MONTH(i.booking_date) = MONTH(GETDATE()) ")
		     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ")
	         .append("GROUP BY m.movie_id, m.moviename ")
	         .append("ORDER BY  SUM(i.total_money) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByDayTop3() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movieid = m.movie_id ")
	         .append("where TRUNC(i.booking_date) = TRUNC(SYSDATE) ")
	         .append("GROUP BY m.movie_id, m.movie_name ")
	         .append("ORDER BY  SUM(i.total_money) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        int count = 0;
	        while (rs.next() && count < 3) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	            count++;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByWeekTop3() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	     .append("FROM invoice i ")
	     .append("JOIN movie m ON i.movie_id = m.movie_id ")
	     .append("WHERE DATEPART(ISO_WEEK, i.booking_date) = DATEPART(ISO_WEEK, GETDATE()) ")
	     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ")
	     .append("GROUP BY m.movie_id, m.moviename ")
	     .append("ORDER BY SUM(i.total_money) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        int count = 0;
	        while (rs.next() && count<3) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("movie_name");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	            count++;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public List<Statistic> getStatisticByMonthTop3() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movie_id = m.movie_id ")
		     .append("WHERE MONTH(i.booking_date) = MONTH(GETDATE()) ")
		     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ")
	         .append("GROUP BY m.movie_id, m.moviename ")
	         .append("ORDER BY  SUM(i.total_money) DESC");
	    List<Statistic> statistics = new ArrayList<>();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        int count = 0;
	        while (rs.next() && count<3) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics.add(new Statistic(movieId, movieName, income, quantity));
	            count++;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public Statistic getStatisticByDayTop1() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movie_id = m.movie_id ")
	         .append("where CONVERT(date, booking_date) = CONVERT(date, GETDATE()) ")
	         .append("GROUP BY m.movie_id, m.moviename ")
	         .append("ORDER BY  SUM(i.total_money) DESC ")
	         .append("FETCH FIRST 1 ROWS ONLY");
	   Statistic statistics = new Statistic();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	  
	       if (rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics = new Statistic(movieId, movieName, income, quantity);
	         
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	public Statistic getStatisticByWeekTop1() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT TOP 1 m.movie_id, m.moviename, SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
		     .append("FROM invoice i ")
		     .append("JOIN movie m ON i.movie_id = m.movie_id ")
		     .append("WHERE DATEPART(ISO_WEEK, i.booking_date) = DATEPART(ISO_WEEK, GETDATE()) ")
		     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ")
		     .append("GROUP BY m.movie_id, m.moviename ")
		     .append("ORDER BY SUM(i.total_money) DESC");

	   Statistic statistics = new Statistic();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	   
	        if(rs.next()) {
	            String movieId = rs.getString("movie_id");
	            String movieName = rs.getString("moviename");
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics = new Statistic(movieId, movieName, income, quantity);
	          
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	
	public Statistic getStatisticByWeek() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movieid = m.movie_id ")
		     .append("WHERE DATEPART(ISO_WEEK, i.booking_date) = DATEPART(ISO_WEEK, GETDATE()) ")
		     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ");
	   Statistic statistics = new Statistic();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	   
	        if(rs.next()) {
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics = new Statistic(null, null, income, quantity);
	          
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}

	public Statistic getStatisticByMonth() {
	    StringBuilder query = new StringBuilder();
	    query.append("SELECT SUM(i.total_money) AS tong_doanh_thu, COUNT(i.invoice_id) AS soluongve ")
	         .append("FROM invoice i ")
	         .append("JOIN movie m ON i.movieid = m.movie_id ")
		     .append("WHERE MONTH(i.booking_date) = MONTH(GETDATE()) ")
		     .append("AND YEAR(i.booking_date) = YEAR(GETDATE()) ");
	   Statistic statistics = new Statistic();
	    String sql = query.toString();
	    
	    try {
	        con = Config.getCon();
	        ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	   
	        if(rs.next()) {
	            String income = rs.getString("tong_doanh_thu");
	            String quantity = rs.getString("soluongve");
	            statistics = new Statistic(null, null, income, quantity);
	          
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return statistics;
	}
	
}
