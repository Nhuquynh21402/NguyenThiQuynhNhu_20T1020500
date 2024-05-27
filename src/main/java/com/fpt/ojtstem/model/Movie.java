package com.fpt.ojtstem.model;


public class Movie{
	private String movieId;
	private String movieName;
	private String direction;
	private String actor;
	private int yearOfProduction;
	private String typeName;
	private String producter;
	private String image;
	private String content;
	private int duration;
	private int quantity;
	private float income;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String movieId, String movieName, String direction, String actor, int yearOfProduction,
			String typeName, String producter, String image, String content, int duration) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.direction = direction;
		this.actor = actor;
		this.yearOfProduction = yearOfProduction;
		this.typeName = typeName;
		this.producter = producter;
		this.image = image;
		this.content = content;
		this.duration = duration;
	}
	
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
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
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getProducter() {
		return producter;
	}
	public void setProducter(String producter) {
		this.producter = producter;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
}