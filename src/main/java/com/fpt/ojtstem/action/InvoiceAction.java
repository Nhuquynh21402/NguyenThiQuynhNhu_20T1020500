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
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.model.Invoice;
import com.fpt.ojtstem.model.Movie;
import com.opensymphony.xwork2.ActionSupport;

public class InvoiceAction extends ActionSupport implements SessionAware, ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	public HttpServletRequest request;
	private List<Movie> movies;
	private List<Invoice> listInvoice;
	 
		public String execute() throws Exception {
			  Account acc = (Account) session.get("user");
		    InvoiceDao invoiceDao = new InvoiceDao();
		    this.listInvoice = invoiceDao.getAllbyID(acc.getId());
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



	public HttpServletRequest getRequest() {
		return request;
	}



	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}



	public List<Movie> getMovies() {
		return movies;
	}



	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}







	public List<Invoice> getListInvoice() {
		return listInvoice;
	}



	public void setListInvoice(List<Invoice> listInvoice) {
		this.listInvoice = listInvoice;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Map<String, Object> getSession() {
		return session;
	}
	
	
}