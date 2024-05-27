package com.fpt.ojtstem.action;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.MovieDao;
import com.fpt.ojtstem.dao.ScheduleDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.Schedule;
import com.fpt.ojtstem.model.Statistic;
import com.opensymphony.xwork2.ActionSupport;

public class StatisticAction extends ActionSupport implements SessionAware{
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selectedCriteria;
	private List<Statistic> movies = new ArrayList<Statistic>();
	private String selectedTime;
	private Map<String, Object> session;
	private Statistic all = new Statistic();
	private List<Statistic> allIncome = new ArrayList<Statistic>();
	
	public String execute() throws Exception {
		if(session.containsKey("user")) {
			Account account = (Account) session.get("user");
			if(account.getRoldId()!=1)	{
				return ERROR;
			}
		}
		session.clear();
		session.remove("selectedCriteria");
	    MovieDao movieDao = new MovieDao();
	    ScheduleDao scheduleDao = new ScheduleDao();
	    List<Statistic> statistics = new ArrayList<>(scheduleDao.getStatistic());
        all = scheduleDao.getAllStatistic();
        session.put("all", all);
        		
	    for (Schedule schedule : scheduleDao.getByMovie()) {
	        boolean found = false;
	        for (Statistic statistic : statistics) {
	            if (schedule.getMovieId().equals(statistic.getMovieId())) {
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            statistics.add(new Statistic(schedule.getMovieId(), movieDao.getOneMovie(schedule.getMovieId()).getMovieName(), "0", "0"));
	        }
	    }
	    
	    this.movies = statistics;
		this.allIncome=scheduleDao.getStatisticByDayIncome();
		session.put("allIncome", allIncome);
		session.put("top1", scheduleDao.getStatisticByDayTop1());
		session.put("top1week", scheduleDao.getStatisticByWeekTop1());
	    return SUCCESS;
	}
	
	public String selectedCriteria() {
		session.put("selectedCriteria", selectedCriteria);
		ScheduleDao scheduleDao = new ScheduleDao();
		if(selectedCriteria.equals("quantity")) {
			this.movies = scheduleDao.getStatisticByDayQuantity();  
			return SUCCESS;
		} else
		{
			this.movies = scheduleDao.getStatisticByDayIncome();
			return SUCCESS;
		}
		
	}
	public String selectedTime() {
		ScheduleDao scheduleDao = new ScheduleDao();
		if(selectedTime.equals("day")&&selectedCriteria.equals("income")) {
			this.movies=scheduleDao.getStatisticByDayIncome();
			return SUCCESS;
		}
		if(selectedTime.equals("day")&&selectedCriteria.equals("quantity")) {
			this.movies=scheduleDao.getStatisticByDayQuantity();
			return SUCCESS;
		}if(selectedTime.equals("week")&&selectedCriteria.equals("quantity")) {
			this.movies=scheduleDao.getStatisticByWeekQuantity();
			all = scheduleDao.getStatisticByWeek();
	
			return SUCCESS;
		}
		if(selectedTime.equals("week")&&selectedCriteria.equals("income")) {
			this.movies=scheduleDao.getStatisticByWeekIncome();
			all = scheduleDao.getStatisticByWeek();
			
			return SUCCESS;
		}
		if(selectedTime.equals("month")&&selectedCriteria.equals("income")) {
			this.movies=scheduleDao.getStatisticByMonthIncome();
			all = scheduleDao.getStatisticByMonth();
			
			return SUCCESS;
		}
		if(selectedTime.equals("month")&&selectedCriteria.equals("quantity")) {
			this.movies=scheduleDao.getStatisticByMonthQuantity();
			all = scheduleDao.getStatisticByMonth();
			
			return SUCCESS;
		}
		if(selectedTime.equals("month")&&selectedCriteria.equals("")) {
			this.movies=scheduleDao.getStatisticByMonthQuantity();
			all = scheduleDao.getStatisticByMonth();
			
			return SUCCESS;
		}
		if(selectedTime.equals("week")&&selectedCriteria.equals("")) {
			all = scheduleDao.getStatisticByWeek();
			session.put("allSD",movies);
			this.movies=scheduleDao.getStatisticByWeekIncome();
			return SUCCESS;
		}else {
			this.movies=scheduleDao.getStatisticByDayIncome();
			return SUCCESS;
		}
			
	}
	public String selectedTop3() {
		ScheduleDao scheduleDao = new ScheduleDao();
		if(selectedTime.equals("day")) {
			this.movies=scheduleDao.getStatisticByDayTop3();
			return SUCCESS;
		}
		if(selectedTime.equals("week")) {
			this.movies=scheduleDao.getStatisticByWeekTop3();
			return SUCCESS;
		}
		
		else{
			this.movies=scheduleDao.getStatisticByMonthTop3();
			return SUCCESS;
		}
		
			
	}

	public List<Statistic> getMovies() {
		return movies;
	}

	public void setMovies(List<Statistic> movies) {
		this.movies = movies;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSelectedCriteria() {
		return selectedCriteria;
	}

	public void setSelectedCriteria(String selectedCriteria) {
		this.selectedCriteria = selectedCriteria;
	}

	public String getSelectedTime() {
		return selectedTime;
	}

	public void setSelectedTime(String selectedTime) {
		this.selectedTime = selectedTime;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Statistic getAll() {
		return all;
	}

	public void setAll(Statistic all) {
		this.all = all;
	}

	public List<Statistic> getAllIncome() {
		return allIncome;
	}

	public void setAllIncome(List<Statistic> allIncome) {
		this.allIncome = allIncome;
	}
	
	
}