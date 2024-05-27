package com.fpt.ojtstem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.TypeMovieDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.TypeMovie;

import com.opensymphony.xwork2.ActionSupport;



public class ShowTypeMovieAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TypeMovie> listType;
	private List<String> listName = new ArrayList<String>();
	private Map<String, Object> session;
	
	
	public List<TypeMovie> getListType() {
		return listType;
	}

	public void setListType(List<TypeMovie> listType) {
		this.listType = listType;
	}

	public List<String> getListName() {
		return listName;
	}

	public void setListName(List<String> listName) {
		this.listName = listName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String execute() throws Exception {
		if(session.containsKey("user")) {
			Account account = (Account) session.get("user");
			if(account.getRoldId()!=1)	{
				return ERROR;
			}
		}
		TypeMovieDao typeDao = new TypeMovieDao();
		this.listType = typeDao.getAll();
		return SUCCESS;
	}

	public String getTypeName() {
		TypeMovieDao typeDao = new TypeMovieDao();
		listName = typeDao.getAllNameType();
	   
		/*
		 * Map<String, Object> session = ActionContext.getContext().getSession();
		 * session.put("listName", listName);
		 */

		return SUCCESS;
	}
	

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}



}