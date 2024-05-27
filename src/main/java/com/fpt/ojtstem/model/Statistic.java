package com.fpt.ojtstem.model;
public class Statistic{
	private String movieId;
	private String movieName;
	private String income;
	private String quantity;
	public Statistic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Statistic(String movieId, String movieName, String income, String quantity) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.income = income;
		this.quantity = quantity;
	}

	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}