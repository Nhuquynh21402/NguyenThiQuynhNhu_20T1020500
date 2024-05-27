package com.fpt.ojtstem.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts2.interceptor.ServletRequestAware;

import com.fpt.ojtstem.dao.TypeMovieDao;
import com.fpt.ojtstem.model.TypeMovie;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AddTypeMovieAction extends ActionSupport implements  ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typeMovieID;
	private String typeMovieName;
	List<TypeMovie> listType = new ArrayList<TypeMovie>();
	public HttpServletRequest request;
	

public String execute() throws Exception {
	    try {
	        TypeMovie type = new TypeMovie();
	        TypeMovieDao typeDao = new TypeMovieDao();
	        this.listType = typeDao.getAll();
	
	        if (StringUtil.isNullOrEmpty(typeMovieID) || StringUtil.isNullOrEmpty(typeMovieName)) {
	        	 addActionError("Tên và ID không được dể trống.");
	            return ERROR;
	        }
	     
	        if (typeMovieID.length() > 20) {
	            addActionError("Id thể loại phim không được dài hơn 20 ký tự.");
	            return ERROR;
	        }
	        
	 
	        if (!typeMovieID.matches("^[\\p{L}]+$")) {
	            addActionError("Id thể loại chỉ được chứa các ký tự chữ cái!!");
	            return ERROR;
	        }
	        if ( typeMovieID.length()>7 && !StringUtil.containsWhitespace(typeMovieID)) {
	        	 addActionError("Id thể loại phim không đúng");
		            return ERROR;
	        }
	        
	        if (typeMovieName.length() > 50) {
	            addActionError("Tên thể loại phim không được dài hơn 50 ký tự.");
	            return ERROR;
	        }
	        if ( typeMovieName.length()>7 && !StringUtil.containsWhitespace(typeMovieName)) {
	        	
	        	 addActionError("Tên thể loại phim không đúng");
		            return ERROR;
	        }
	        
	        if (!typeMovieName.matches("^[\\p{L}\\s]+$")) {
	            addActionError("Tên thể loại phim chỉ được chứa các ký tự chữ cái và khoảng trắng.");
	            return ERROR;
	        }
	        

	        if (!checkType(typeMovieID, typeMovieName.trim())) {
	            type.setTypeMovieID(typeMovieID);
	            type.setTypeMovieName(typeMovieName);
	            typeDao.insertTypeMovie(type);
	            return SUCCESS;
	        } else {
	            addActionError("Tên hoặc ID của thể loại phim đã được sử dụng");
	            return ERROR;
	        }
	    } catch (Exception e) {
	        return ERROR;
	    }
	}

	private boolean checkType(String id, String name) {
		for (TypeMovie type : listType) {
			if (type.getTypeMovieID().equals(id) || type.getTypeMovieName().equals(name)) {
				return true;
			}
		}
		return false;
	}


	public String getTypeMovieID() {
		return typeMovieID;
	}

	public void setTypeMovieID(String typeMovieID) {
		this.typeMovieID = typeMovieID;
	}

	public String getTypeMovieName() {
		return typeMovieName;
	}

	public void setTypeMovieName(String typeMovieName) {
		this.typeMovieName = typeMovieName;
	}

	public List<TypeMovie> getListType() {
		return listType;
	}

	public void setListType(List<TypeMovie> listType) {
		this.listType = listType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}


	

}