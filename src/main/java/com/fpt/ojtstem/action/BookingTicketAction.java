package com.fpt.ojtstem.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.InvoiceDao;
import com.fpt.ojtstem.dao.MovieDao;
import com.fpt.ojtstem.dao.RoomDao;
import com.fpt.ojtstem.dao.ScheduleDao;

import com.fpt.ojtstem.dao.ShowTimeDao;
import com.fpt.ojtstem.dao.TicketTypeDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.Invoice;
import com.fpt.ojtstem.model.Movie;
import com.fpt.ojtstem.model.Room;
import com.fpt.ojtstem.model.Schedule;
import com.fpt.ojtstem.model.ShowTime;
import com.fpt.ojtstem.model.TicketType;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class BookingTicketAction extends ActionSupport implements SessionAware, ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private String selectedMovie;
	private String selectedRoom;
	private String bookingDate;
	private String selectedShowTime;
	private Map<String, Object> session;
	private String listSeatId;
	private Movie movie;
	private Room room;
	private ShowTime showTime;
	private List<TicketType> listTicket = new ArrayList<TicketType>();
	private String idSeat;
	private String selectedTicketType;
	private String selectedMethodPayment;
	private float total;
	private String EmployeeName;
	TicketType ticketType = new TicketType();
	private List<String> seatIdList = new ArrayList<>();
	private List<Invoice> listInvoice = new ArrayList<>();
	private List<Movie> listMovie = new ArrayList<Movie>();
	private List<Room> listRoom = new ArrayList<Room>();
	private List<ShowTime> listShowtime = new ArrayList<ShowTime>();
	HttpServletRequest request;
	
	private boolean hasSchedule;
    private String errorMessage;
	 public String init() {
	
			  if (!session.containsKey("user")) {
			  
			  return ERROR; } 
			  else {
			 
			  Account account = (Account) session.get("user");
			
			
			 if (account.getRoldId() == 1 || account.getRoldId() == 2) {
			 
			   return SUCCESS; } 
			 else {
			 
			 return ERROR; } 
			 }
			
		
    }

	public String execute() throws Exception {
		HttpSession sessionRequest = request.getSession();
		errorMessage = (String) sessionRequest.getAttribute("Thông báo");
		if (errorMessage != null) {
			addActionError(errorMessage);
			sessionRequest.removeAttribute("Thông báo");
		}
		session.remove("selectedMovie");
		session.remove("selectedRoom");
		session.remove("bookingDate");
		session.remove("schedule");
		session.remove("selectedShowTime");
		session.remove("listSeatId");
		ScheduleDao dao = new ScheduleDao();
		MovieDao moviedao = new MovieDao();
		List<Movie> movies = new ArrayList<Movie>();
		for (Schedule schedule : dao.getByMovie()) {
			movies.add(moviedao.getOneMovie(schedule.getMovieId()));
		}
		session.put("movies", movies);

		RoomDao roomDao = new RoomDao();
		for (Schedule schedule : dao.getByRoomBooking()) {
			listRoom.add(roomDao.findRoom(schedule.getRoomId()));
		}
		session.put("listRoom", listRoom);

		ShowTimeDao showTimeDao = new ShowTimeDao();
		this.listShowtime = showTimeDao.getAll();
		session.put("listShowtime", listShowtime);

		return SUCCESS;
	}

	public String selectRoom() {
		if (session.containsKey("selectedMovie") ) {
		if (!StringUtil.isNullOrEmpty(bookingDate) ) {

			try {	
				 RoomDao roomDao = new RoomDao();
			     ScheduleDao scheduleDao = new ScheduleDao();
			     String selectedMovie = (String) session.get("selectedMovie");
			     
			     for(Schedule schedule : scheduleDao.getByRoom(selectedMovie,bookingDate)) {
			    	 listRoom.add(roomDao.findRoom(schedule.getRoomId()));
			     }
			     session.put("listRoom", listRoom);
			     session.put("bookingDate", bookingDate);
			  
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		} else {
			addActionError("Cần chọn ngày để biết thêm thông tin khác");
			return ERROR;
		}

	} else {
		addActionError("Cần chọn phim để biết thêm thông tin khác");
		return ERROR;
	}
	}
	public String showSeat() {
		 try {
			  String bookingDate = (String) session.get("bookingDate");
		 if(!StringUtil.isNullOrEmpty(selectedMovie) || !StringUtil.isNullOrEmpty(bookingDate) || !StringUtil.isNullOrEmpty(selectedRoom) || !StringUtil.isNullOrEmpty(selectedShowTime)) {
			 if(!StringUtil.isNullOrEmpty(selectedMovie)) {
				 if(!StringUtil.isNullOrEmpty(bookingDate)) {
					 if(!StringUtil.isNullOrEmpty(selectedRoom)) {
						 if(!StringUtil.isNullOrEmpty(selectedShowTime)) {
			
			  ScheduleDao scheduleDao = new ScheduleDao(); 
			  Schedule schedule =  scheduleDao.getSchedule(selectedRoom, bookingDate, selectedShowTime, selectedMovie); 
			  this.hasSchedule = schedule != null ? true : false;
			  InvoiceDao invoiceDao = new InvoiceDao(); 
			  this.listInvoice =  invoiceDao.getAll(selectedMovie, selectedRoom, bookingDate, selectedShowTime);
				for (Invoice invoice : listInvoice) {
					seatIdList.add(invoice.getSeatId());
				}
				   session.put("seatIdList", seatIdList);
				if (session.containsKey("schedule")) {
					session.remove("schedule");
				} else {
					session.put("schedule", schedule);
				}
				session.put("selectedShowTime",selectedShowTime);
			    ShowTimeDao showtimedao = new ShowTimeDao();
			    ShowTime showtime = showtimedao.getOne("selectedShowTime");
			    session.put("showtime",showtime);
						 } else {
							 addActionError("Cần chọn ca chiếu để biết thêm thông tin khác!!!");
							 return ERROR;
						 }
					 } else {
						 addActionError("Cần chọn phòng để biết thêm thông tin khác!!!");
						 return ERROR;
					 }
				 } else {
						addActionError("Cần chọn ngày để  biết thêm thông tin khác!!!");
						return ERROR;
				 }
			 }else {
					addActionError("Cần chọn phim để biết thêm thông tin khác!!!");
					return ERROR;
			 }
		 }else {
					addActionError("Cần chọn đủ thông tin để  biết thêm chi tiết!!!");
					return ERROR;
			 }
				return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	
	
		
		
	}
	
	public String selectShowtime() {
		if (session.containsKey("selectedMovie") ) {
			if (session.containsKey("bookingDate") ) {
		if(!StringUtil.isNullOrEmpty(selectedRoom) ) {
			try {
			ShowTimeDao showtime = new ShowTimeDao();
			ScheduleDao scheduleDao = new ScheduleDao();
			String selectedMovie = (String) session.get("selectedMovie");
			String bookingDate = (String) session.get("bookingDate");
			 for(Schedule schedule : scheduleDao.getByShowtime(selectedMovie,bookingDate,selectedRoom)) {
				 listShowtime.add(showtime.getOne(schedule.getShowTimeId()));
			 }
			 
			 RoomDao roomDao = new RoomDao();
			 Room room= roomDao.findRoom(selectedRoom);
			 session.put("listShowtime", listShowtime);
			 session.put("selectedRoom", selectedRoom);
			 session.put("room", room);
			 
       
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		} else {
			addActionError("Cần chọn phòng để biết thêm thông tin khác!!!");
			return ERROR;
		}
			}
		else {
			addActionError("Cần chọn ngày để  biết thêm thông tin khác!!!");
			return ERROR;
		}
		}
		else {
		addActionError("Cần chọn phim để biết thêm thông tin khác!!!");
		return ERROR;
		}
	}
	
	
	public String selectDate() {
		if (!StringUtil.isNullOrEmpty(selectedMovie) ) {
			try {
				 List<String> showdates = new ArrayList<String> ();
				 ScheduleDao scheduleDao = new ScheduleDao();
				 List<Schedule> list = new ArrayList<Schedule>();
		         list = scheduleDao.getByDate(selectedMovie);
				  for(Schedule schedule : list ){
					  showdates.add(schedule.getShowDate());
				  }
				     session.put("selectedMovie", selectedMovie);
					 session.put("showdates", showdates);
					  return SUCCESS;
					  
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
		  }
		}else {
			addActionError("Cần chọn phim để biết thêm thông tin khác!!");
			return ERROR;
			
		}
		
	}
	
	
	

	public String confirmTicket() {
		TicketTypeDao ticketDao = new TicketTypeDao();
		this.listTicket = ticketDao.getAll();
		MovieDao movieDao = new MovieDao();
		movie = movieDao.getOneMovie((String) session.get("selectedMovie"));
		if(session.containsKey("listSeatId")) {
			listSeatId=(String) session.get("listSeatId");
		}
		session.remove("schedule");
		session.put("listTicket", listTicket);
		session.put("listSeatId", listSeatId);
		
		return SUCCESS;
	}

	public String Payment() {
		HttpSession sessionRequest = request.getSession();
		errorMessage = (String) sessionRequest.getAttribute("errorMessage");
		if (errorMessage != null) {
			addActionError(errorMessage);
			sessionRequest.removeAttribute("Thông báo");
		}
		if(session.containsKey("selectedTicketType")) {
			selectedTicketType = (String) session.get("selectedTicketType");
		}
		if(session.containsKey("selectedMethodPayment")) {
			selectedMethodPayment = (String) session.get("selectedMethodPayment");
		}
		String movieId = (String) session.get("selectedMovie");
		String roomId = (String) session.get("selectedRoom");
		String showTimeID = (String) session.get("selectedShowTime");
		bookingDate = (String) session.get("bookingDate");
		MovieDao movieDao = new MovieDao();
		movie = movieDao.getOneMovie(movieId);

		RoomDao roomDao = new RoomDao();
		room = roomDao.findRoom(roomId);

		ShowTimeDao showTimeDao = new ShowTimeDao();
		showTime = showTimeDao.getOne(showTimeID);

		String seatId = (String) session.get("listSeatId");
		TicketTypeDao ticketDao = new TicketTypeDao();
		ticketType = ticketDao.findTicketType(selectedTicketType);
		session.put("selectedTicketType", selectedTicketType);
		session.put("selectedMethodPayment", selectedMethodPayment);
		total = ticketType.getPrice() * seatId.split(",").length;
		return SUCCESS;
	}

	public String buy() {
		try {
			boolean checkId = false;
			  Account acc = (Account) session.get("user");
			String movieId = (String) session.get("selectedMovie");
			String roomId = (String) session.get("selectedRoom");
			String showTimeID = (String) session.get("selectedShowTime");
			bookingDate = (String) session.get("bookingDate");
			MovieDao movieDao = new MovieDao();
			movie = movieDao.getOneMovie(movieId);

			RoomDao roomDao = new RoomDao();
			room = roomDao.findRoom(roomId);

			ShowTimeDao showTimeDao = new ShowTimeDao();
			showTime = showTimeDao.getOne(showTimeID);
			if(session.containsKey("listSeatId")) {
				listSeatId=(String) session.get("listSeatId");
			}
			if(!listSeatId.equals(idSeat)) {
				HttpSession sessionRequest = request.getSession();
				sessionRequest.setAttribute("errorMessage","Ghế đã chọn không đúng!!!");
				return "back";
			}
				
			
			String seatIds[] = idSeat.split(",");
			TicketTypeDao ticketDao = new TicketTypeDao();
			List<Invoice> invoices = new ArrayList<Invoice>();
			InvoiceDao invoiceDao = new InvoiceDao();
			invoices = invoiceDao.getAll(movieId, roomId, bookingDate, showTimeID);
			ticketType = ticketDao.findTicketType(selectedTicketType);
			List<String> list = new ArrayList<String>();
			for (Invoice hd : invoices) {
				list.add(hd.getSeatId());
			}
			for (String id : seatIds) {
				for (String idSear : list) {
					if (id.equals(idSear)) {
						checkId = true;
						break;
					}
				}
				if (checkId == true) {
					break;
				}
			}
			if (!checkId) {
				for (String id : seatIds) {
					Invoice invoice =new Invoice(0, null, ticketType.getPrice(), id.trim(), ticketType.getTicketTypeID(), roomId, bookingDate, movieId, showTimeID);
					ScheduleDao schDao = new ScheduleDao();
					int idSchedule = schDao.getById(movieId, bookingDate, roomId, showTimeID);
					 invoiceDao.Insert(invoice, idSchedule,acc.getId());
					invoice= invoiceDao.getOne(movieId, roomId, bookingDate, showTimeID, id);
					this.listInvoice.add(invoice);
					
				}
			}else {
				HttpSession sessionRequest = request.getSession();
				sessionRequest.setAttribute("Thông báo","Ghế đã được đặt!!");
				session.remove("selectedMovie");
				session.remove("selectedRoom");
				session.remove("bookingDate");
				session.remove("schedule");
				session.remove("selectedShowTime");
				session.remove("listSeatId");
						return ERROR;
			} 
			
			HttpSession sessionRequest = request.getSession();
			sessionRequest.setAttribute("Thông báo","Một vé xem phim đã được đặt!!!");
			session.remove("selectedMovie");
			session.remove("selectedRoom");
			session.remove("bookingDate");
			session.remove("schedule");
			session.remove("selectedShowTime");
			session.remove("listSeatId");
			return SUCCESS;

		} catch (Exception e) {
			
			return ERROR;
		}

	}
	

	public String getListSeatId() {
		return listSeatId;
	}

	public void setListSeatId(String listSeatId) {
		this.listSeatId = listSeatId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getSelectedMovie() {
		return selectedMovie;
	}

	public void setSelectedMovie(String selectedMovie) {
		this.selectedMovie = selectedMovie;
	}

	public String getSelectedRoom() {
		return selectedRoom;
	}

	public void setSelectedRoom(String selectedRoom) {
		this.selectedRoom = selectedRoom;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSelectedShowTime() {
		return selectedShowTime;
	}

	public void setSelectedShowTime(String selectedShowTime) {
		this.selectedShowTime = selectedShowTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getSeatIdList() {
		return this.seatIdList;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public ShowTime getShowTime() {
		return showTime;
	}

	public void setShowTime(ShowTime showTime) {
		this.showTime = showTime;
	}

	public List<TicketType> getListTicket() {
		return listTicket;
	}

	public void setListTicket(List<TicketType> listTicket) {
		this.listTicket = listTicket;
	}

	public String getIdSeat() {
		return idSeat;
	}

	public void setIdSeat(String idSeat) {
		this.idSeat = idSeat;
	}

	public String getSelectedTicketType() {
		return selectedTicketType;
	}

	public void setSelectedTicketType(String selectedTicketType) {
		this.selectedTicketType = selectedTicketType;
	}

	public String getSelectedMethodPayment() {
		return selectedMethodPayment;
	}

	public void setSelectedMethodPayment(String selectedMethodPayment) {
		this.selectedMethodPayment = selectedMethodPayment;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}


	public List<Invoice> getListInvoice() {
		return listInvoice;
	}

	public void setListInvoice(List<Invoice> listInvoice) {
		this.listInvoice = listInvoice;
	}

	public void setSeatIdList(List<String> seatIdList) {
		this.seatIdList = seatIdList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public boolean getIsSchedule() {
		return this.hasSchedule;
	}

	public List<Movie> getListMovie() {
		return listMovie;
	}

	public void setListMovie(List<Movie> listMovie) {
		this.listMovie = listMovie;
	}

	public List<Room> getListRoom() {
		return listRoom;
	}

	public void setListRoom(List<Room> listRoom) {
		this.listRoom = listRoom;
	}

	public List<ShowTime> getListShowtime() {
		return listShowtime;
	}

	public void setListShowtime(List<ShowTime> listShowtime) {
		this.listShowtime = listShowtime;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request =request;
		
	}



}