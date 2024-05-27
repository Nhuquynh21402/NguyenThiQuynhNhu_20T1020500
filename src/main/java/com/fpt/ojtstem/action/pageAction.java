package com.fpt.ojtstem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.InvoiceDao;
import com.fpt.ojtstem.dao.MovieDao;
import com.fpt.ojtstem.dao.RoomDao;
import com.fpt.ojtstem.dao.ScheduleDao;
import com.fpt.ojtstem.dao.ShowTimeDao;
import com.fpt.ojtstem.dao.TicketTypeDao;
import com.fpt.ojtstem.dao.TypeMovieDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.Invoice;
import com.fpt.ojtstem.model.Movie;
import com.fpt.ojtstem.model.Room;
import com.fpt.ojtstem.model.Schedule;
import com.fpt.ojtstem.model.ShowTime;
import com.fpt.ojtstem.model.TicketType;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class pageAction extends ActionSupport implements SessionAware {
	 private Map<String, Object> session;
	 private String selectedShowTime;
	 private String selectedTicketType;
	 private List<Movie> listTop = new ArrayList<Movie>();
	 private List<String> listName;
	 private List<Schedule> list = new ArrayList<Schedule>();
	 private Movie movie;
	 private String bookingDate;
	 private List<Room> listRoom = new ArrayList<Room>();
	 private String id;
	 private String selectedRoom;
	 private String listSeatId;
     private boolean hasSchedule;
	 private List<ShowTime> listShowtime = new ArrayList<ShowTime>();
	 private List<String> seatIdList = new ArrayList<>();
	 private List<Invoice> listInvoice = new ArrayList<>();
	 private Room room;
	 private float total;
	 private ShowTime showTime;
	 TicketType ticketType = new TicketType();
	 private List<TicketType> listTicket = new ArrayList<TicketType>();
	 public String init() {
		 return SUCCESS;
	 }
	 public String execute() throws Exception{
		 MovieDao movieDao = new MovieDao();
		 this.listTop = movieDao.getAllHOT();
		 return SUCCESS;
		 
	 }
	 public String showMovie() {
		   TypeMovieDao typeDao = new TypeMovieDao();
			this.listName = typeDao.getAllNameType();
			

			session.put("TypeName", listName);

			ShowTimeDao showTimeDao = new ShowTimeDao();
			List<ShowTime> listShowTime = new ArrayList<ShowTime>();
			listShowTime = showTimeDao.getAll();
			session.put("listShowTime", listShowTime);

			RoomDao roomDao = new RoomDao();
			List<Room> listRoom = new ArrayList<Room>();
			listRoom = roomDao.getAllRoom();
			session.put("listRoom", listRoom);
			try {
				MovieDao movieDao = new MovieDao();
				movie = movieDao.getOneMovie(id);
				String[] type = movie.getTypeName().split(",");
				session.put("type", type);
	            ScheduleDao scheduleDao = new ScheduleDao();
	            this.list = scheduleDao.getisSchedule(id);
			} catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
			return SUCCESS;
	 }
	 
	 public String booking() {
		 showMovie();
					try {
						 List<String> showdates = new ArrayList<String> ();
						 ScheduleDao scheduleDao = new ScheduleDao();
						 List<Schedule> list = new ArrayList<Schedule>();
				         list = scheduleDao.getByDate(id);
						  for(Schedule schedule : list ){
							  showdates.add(schedule.getShowDate());
						  }
						     session.put("selectedMovie", id);
							 session.put("showdates", showdates);
							  return SUCCESS;
							  
					} catch (Exception e) {
						e.printStackTrace();
						return ERROR;
				  }
		
	 }
	 public String selectRoom() {
		  id = (String) session.get("selectedMovie");
		  MovieDao movieDao = new MovieDao();
		  movie = movieDao.getOneMovie(id);
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

		}
	 public String selectShowtime() {
		     id = (String) session.get("selectedMovie");
		     MovieDao movieDao = new MovieDao();
		     movie = movieDao.getOneMovie(id);
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
	 
		public String showSeat() {
			 try {
				String selectedMovie = (String) session.get("selectedMovie");
				     MovieDao movieDao = new MovieDao();
				     movie = movieDao.getOneMovie(selectedMovie);
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
		
		public String confirmTicket() {	
		String movieId = (String) session.get("selectedMovie");
		String roomId = (String) session.get("selectedRoom");
		String showTimeID = (String) session.get("selectedShowTime");
		bookingDate = (String) session.get("bookingDate");
		MovieDao movieDao = new MovieDao();
		movie = movieDao.getOneMovie(movieId);
		
		TicketTypeDao ticketDao = new TicketTypeDao();
		this.listTicket = ticketDao.getAll();

		RoomDao roomDao = new RoomDao();
		room = roomDao.findRoom(roomId);

		ShowTimeDao showTimeDao = new ShowTimeDao();
		showTime = showTimeDao.getOne(showTimeID);
		session.put("listTicket", listTicket);
        
		session.put("listSeatId", listSeatId);
			
			return SUCCESS;
		}
    public String showMoney() {
    	String movieId = (String) session.get("selectedMovie");
		String roomId = (String) session.get("selectedRoom");
		String showTimeID = (String) session.get("selectedShowTime");
		bookingDate = (String) session.get("bookingDate");
		MovieDao movieDao = new MovieDao();
		movie = movieDao.getOneMovie(movieId);
		
		TicketTypeDao ticketDao = new TicketTypeDao();
		

		RoomDao roomDao = new RoomDao();
		room = roomDao.findRoom(roomId);

		ShowTimeDao showTimeDao = new ShowTimeDao();
		showTime = showTimeDao.getOne(showTimeID);
		String seatId = (String) session.get("listSeatId");
		ticketType = ticketDao.findTicketType(selectedTicketType);
		total = ticketType.getPrice() * seatId.split(",").length;
		session.put("selectedTicketType", selectedTicketType);
		
		return SUCCESS;
		
    	
    }public String buy() {
        try {
            boolean checkId = false;
            String movieId = (String) session.get("selectedMovie");
            Account acc = (Account) session.get("user");
            String roomId = (String) session.get("selectedRoom");
            String showTimeID = (String) session.get("selectedShowTime");
            selectedTicketType = (String) session.get("selectedTicketType");
            bookingDate = (String) session.get("bookingDate");
            String idSeat = (String) session.get("listSeatId");

            if (movieId == null || roomId == null || showTimeID == null || bookingDate == null || idSeat == null) {
                addActionError("Một hoặc nhiều thông tin cần thiết chưa được chọn.");
                return ERROR;
            }

            MovieDao movieDao = new MovieDao();
            movie = movieDao.getOneMovie(movieId);
            if (movie == null) {
                addActionError("Phim không tồn tại.");
                return ERROR;
            }

            RoomDao roomDao = new RoomDao();
            room = roomDao.findRoom(roomId);
            if (room == null) {
                addActionError("Phòng không tồn tại.");
                return ERROR;
            }

            ShowTimeDao showTimeDao = new ShowTimeDao();
            showTime = showTimeDao.getOne(showTimeID);
            if (showTime == null) {
                addActionError("Suất chiếu không tồn tại.");
                return ERROR;
            }

            String[] seatIds = idSeat.split(",");
            if (seatIds == null || seatIds.length == 0) {
                addActionError("Danh sách ghế trống.");
                return ERROR;
            }

            TicketTypeDao ticketDao = new TicketTypeDao();
            ticketType = ticketDao.findTicketType(selectedTicketType);
            if (ticketType == null) {
                addActionError("Loại vé không tồn tại.");
                return ERROR;
            }

            InvoiceDao invoiceDao = new InvoiceDao();
            List<Invoice> invoices = invoiceDao.getAll(movieId, roomId, bookingDate, showTimeID);
            if (invoices == null) {
                invoices = new ArrayList<Invoice>();
            }

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
                    Invoice invoice = new Invoice(0, null, ticketType.getPrice(), id.trim(), ticketType.getTicketTypeID(), roomId, bookingDate, movieId, showTimeID);
                    ScheduleDao schDao = new ScheduleDao();
                    int idSchedule = schDao.getById(movieId, bookingDate, roomId, showTimeID);
                    invoiceDao.Insert(invoice, idSchedule,acc.getId());
                    invoice = invoiceDao.getOne(movieId, roomId, bookingDate, showTimeID, id);
                    this.listInvoice.add(invoice);
                }
            } else {
                session.remove("selectedMovie");
                session.remove("selectedRoom");
                session.remove("bookingDate");
                session.remove("schedule");
                session.remove("selectedShowTime");
                session.remove("listSeatId");
                addActionError("Trùng ghế");
                return ERROR;
            }
            session.remove("selectedMovie");
            session.remove("selectedRoom");
            session.remove("bookingDate");
            session.remove("schedule");
            session.remove("selectedShowTime");
            session.remove("listSeatId");
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace(); // In ra chi tiết lỗi để dễ dàng xác định vấn đề
            return ERROR;
        }
    }

	

		

	@Override
	public void setSession(Map<String, Object> session) {
		this.session =session;
		
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public List<Movie> getListTop() {
		return listTop;
	}

	public void setListTop(List<Movie> listTop) {
		this.listTop = listTop;
	}
	public List<String> getListName() {
		return listName;
	}
	public void setListName(List<String> listName) {
		this.listName = listName;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<Schedule> getList() {
		return list;
	}
	public void setList(List<Schedule> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public List<Room> getListRoom() {
		return listRoom;
	}
	public void setListRoom(List<Room> listRoom) {
		this.listRoom = listRoom;
	}
	public String getSelectedRoom() {
		return selectedRoom;
	}
	public void setSelectedRoom(String selectedRoom) {
		this.selectedRoom = selectedRoom;
	}
	public List<ShowTime> getListShowtime() {
		return listShowtime;
	}
	public void setListShowtime(List<ShowTime> listShowtime) {
		this.listShowtime = listShowtime;
	}
	public String getSelectedShowTime() {
		return selectedShowTime;
	}
	public void setSelectedShowTime(String selectedShowTime) {
		this.selectedShowTime = selectedShowTime;
	}
	public boolean getIsSchedule() {
		return this.hasSchedule;
	}
	public boolean isHasSchedule() {
		return hasSchedule;
	}
	public void setHasSchedule(boolean hasSchedule) {
		this.hasSchedule = hasSchedule;
	}
	public List<String> getSeatIdList() {
		return seatIdList;
	}
	public void setSeatIdList(List<String> seatIdList) {
		this.seatIdList = seatIdList;
	}
	public List<Invoice> getListInvoice() {
		return listInvoice;
	}
	public void setListInvoice(List<Invoice> listInvoice) {
		this.listInvoice = listInvoice;
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
	public String getListSeatId() {
		return listSeatId;
	}
	public void setListSeatId(String listSeatId) {
		this.listSeatId = listSeatId;
	}
	public String getSelectedTicketType() {
		return selectedTicketType;
	}
	public void setSelectedTicketType(String selectedTicketType) {
		this.selectedTicketType = selectedTicketType;
	}
	public List<TicketType> getListTicket() {
		return listTicket;
	}
	public void setListTicket(List<TicketType> listTicket) {
		this.listTicket = listTicket;
	}
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	    
}