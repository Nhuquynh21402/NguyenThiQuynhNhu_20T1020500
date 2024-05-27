package com.fpt.ojtstem.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.MovieDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.Movie;
import com.opensymphony.xwork2.ActionSupport;

public class ScheduleAction extends ActionSupport implements SessionAware, ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	public HttpServletRequest request;
	private List<Movie> movies;
	 
		public String execute() throws Exception {
			if(session.containsKey("user")) {
				Account account = (Account) session.get("user");
				if(account.getRoldId()!=1)	{
					return ERROR;
				}
			}
			MovieDao moviedao = new MovieDao();
			this.movies = moviedao.getAll();

			session.put("movies", movies);

			return SUCCESS;
		}

	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	
}