package com.fpt.ojtstem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.MovieDao;
import com.fpt.ojtstem.dao.RoomDao;
import com.fpt.ojtstem.dao.ScheduleDao;
import com.fpt.ojtstem.dao.ShowTimeDao;
import com.fpt.ojtstem.dao.TypeMovieDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.Movie;
import com.fpt.ojtstem.model.Room;
import com.fpt.ojtstem.model.Schedule;
import com.fpt.ojtstem.model.ShowTime;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowMovieAction extends ActionSupport implements SessionAware, ServletRequestAware {
	private Map<String, Object> session;
	public HttpServletRequest request;

	/**
	 * 
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private static final long serialVersionUID = 1L;
	private List<Movie> movies;
	private Movie movie;
	private String nameType;
	private List<String> listName;
	private String id;
	private List<Schedule> list = new ArrayList<Schedule>();
    private String errorMessage;
    
	public String execute() throws Exception {
		if(session.containsKey("user")) {
			Account account = (Account) session.get("user");
			if(account.getRoldId()!=1)	{
				return ERROR;
			}
		}

		HttpSession sessiont = request.getSession();
		errorMessage = (String) sessiont.getAttribute("Thông báo");
		if (errorMessage != null) {
			addActionError(errorMessage);
			sessiont.removeAttribute("Thông báo");
		}

		MovieDao moviedao = new MovieDao();
		this.movies = moviedao.getAll();

		session.put("movies", movies);

		return SUCCESS;
	}

	public String getTypeName() {

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
		return SUCCESS;
	}

	public String getMovieOne() {
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

	public String update() {
		MovieDao movieDao = new MovieDao();
		// this.movies = movieDao.getAll();
		movieDao.updateMovie(movie);
		return SUCCESS;

	}

	private boolean checkNameMovie(String movieName) {
		for (Movie movie : movies) {
			if (movie.getMovieName().equals(movieName)) {
				return true;
			}
		}
		return false;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<String> getListName() {
		return listName;
	}

	public void setListName(List<String> listName) {
		this.listName = listName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public List<Schedule> getList() {
		return list;
	}

	public void setList(List<Schedule> list) {
		this.list = list;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}