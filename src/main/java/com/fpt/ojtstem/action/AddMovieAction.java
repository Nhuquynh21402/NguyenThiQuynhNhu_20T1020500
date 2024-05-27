package com.fpt.ojtstem.action;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.fpt.ojtstem.dao.MovieDao;
import com.fpt.ojtstem.dao.ScheduleDao;
import com.fpt.ojtstem.model.Movie;
import com.fpt.ojtstem.model.Schedule;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AddMovieAction extends ActionSupport implements ServletRequestAware {
	public HttpServletRequest request;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File imgFile;
	private String imgFileFileName;
	private String imgFileContentType;

	private Movie movie;
	private String id;
	private List<Movie> movies = new ArrayList<Movie>();
	private String name;
	private Schedule schedule;
	private String toBookingDate;
	private String fromBookingDate;

	public String updateFile() {
		try {
			if (imgFile != null) {
				String path = request.getServletContext().getRealPath("/").concat("/img");
				File uploadFile = new File(path);
				File desFile = new File(uploadFile, imgFileFileName);
				FileUtils.copyFile(imgFile, desFile);
				return SUCCESS;
				
				
			} else {
				return INPUT;
			}
		}
			catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}

	}

	public String add() {
	   if (StringUtil.isNullOrEmpty(movie.getMovieName())) {
			addActionError("Tên phim không được bỏ trống!!!");
			return ERROR;
		}
	   else if (StringUtil.containsWhitespace(movie.getMovieName())) {
		   addActionError("Tên phim không được toàn dấu cách!!!");
			return ERROR;
	   }
	   else if (!StringUtil.isCheck(movie.getMovieName())) {
		   addActionError("Tên phim không hợp lệ!!!");
			return ERROR;
	   }
	   else if (movie.getMovieName().length()>50) {
		   addActionError("Tên phim không dài quá 100 kí tự!!!");
			return ERROR;
	   }

	   else if (StringUtil.isNullOrEmpty(movie.getDirection())) {
			addActionError("Tên đạo diễn không được bỏ trống không được bỏ trống!!!");
			return ERROR;
		}
	   else if (!StringUtil.isString(movie.getDirection())) {
			addActionError("Tên đạo diễn không hợp lệ!!!");
			return ERROR;
		}
	   else if (StringUtil.containsWhitespace(movie.getDirection())) {
			addActionError("Tên đạo diễn không được toàn dấu cách!!!");
			return ERROR;
		}
	   else if (StringUtil.isNumber(movie.getDirection())) {
				addActionError("Tên đạo diễn không được là một số!!!");
				return ERROR;
			}
	   else if (StringUtil.isNullOrEmpty(movie.getContent())) {
			addActionError("Mô tả phim không được bỏ trống không được bỏ trống!!!");
			return ERROR;
		} else if (StringUtil.isNullOrEmpty(String.valueOf(movie.getDuration()))) {
			addActionError("Thời lượng phim không được để trống không được bỏ trống không được bỏ trống!!!");
			return ERROR;
		} else if (!StringUtil.isNumber(String.valueOf(movie.getDuration()))) {
			addActionError("Thời lượng phim phải là một số!!!");
			return ERROR;
		}
		else {
			movie.setImage(imgFileFileName);
			MovieDao movieDao = new MovieDao();
			movieDao.getAll();
			if (!checkMovie(movie.getMovieName())) {
				  movieDao.addMovie(movie);
				 Movie movieTest=movieDao.getMovieByName(movie.getMovieName());
				String listShowTimeId [] = schedule.getShowTimeId().split(",");
				String listRoomId [] = schedule.getRoomId().split(",");
				 ScheduleDao scheduleDao = new ScheduleDao();
				for (String ShowTimeId : listShowTimeId) {
					for(String RoomId : listRoomId) {
						if(toBookingDate != null && !toBookingDate.isEmpty()) {
							   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
							    LocalDate startDate = LocalDate.parse(fromBookingDate, formatter);
						        LocalDate endDate = LocalDate.parse(toBookingDate, formatter);
						        for (LocalDate currentDate = startDate; !currentDate.isAfter(endDate); currentDate = currentDate.plusDays(1)) {
						        	 String currentDateAsString = currentDate.format(formatter);
						        	     if(!scheduleDao.isSchedules(RoomId.trim(), ShowTimeId.trim(),currentDateAsString)) {
						        	    	 scheduleDao.insertSchedule(RoomId.trim(), ShowTimeId.trim(), currentDateAsString,movie.getMovieId() );
						        	     }else {
						        	    	 addActionError("Lịch chiếu đã được lên trước đó. ");
						        	    	 return SUCCESS;
						        	     }
						                      
						                     
						        }
						}else {
						     if(!scheduleDao.isSchedules(RoomId.trim(), ShowTimeId.trim(),fromBookingDate)) {
						    	 scheduleDao.insertSchedule(RoomId.trim(), ShowTimeId.trim(), fromBookingDate,movieTest.getMovieId() );
			        	     }else {
			        	    	 addActionError("Lịch chiếu đã được lên trước đó.");
			        	    	 return SUCCESS;
			        	     }
			              
						}
					}
				}
			
				
			} else {
				addActionError("Id phim hoặc tên phim đã được sử dụng!!!");
				return ERROR;
			}
		}

		return SUCCESS;
	}

	private boolean checkMovie( String name) {
		for (Movie movie : movies) {
			if ( movie.getMovieName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public String delete() {
		try {
			ScheduleDao scheduleDao= new ScheduleDao();
			if(scheduleDao.isSchedule(id)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("errorMessage", "Phim đã được lên lịch chiếu!! Không thể xóa!! Xóa lịch chiếu trước đi !!");
	            return ERROR;
			}else {
			MovieDao movieDao = new MovieDao();
			movieDao.delete(id);
			}    
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public String getImgFileContentType() {
		return imgFileContentType;
	}

	public void setImgFileContentType(String imgFileContentType) {
		this.imgFileContentType = imgFileContentType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getToBookingDate() {
		return toBookingDate;
	}

	public void setToBookingDate(String toBookingDate) {
		this.toBookingDate = toBookingDate;
	}

	public String getFromBookingDate() {
		return fromBookingDate;
	}

	public void setFromBookingDate(String fromBookingDate) {
		this.fromBookingDate = fromBookingDate;
	}
	
	

}