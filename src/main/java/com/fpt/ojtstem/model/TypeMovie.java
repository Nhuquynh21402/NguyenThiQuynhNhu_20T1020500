package com.fpt.ojtstem.model;
public class TypeMovie{
	 private String typeMovieID;
	 private String typeMovieName;
	public TypeMovie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeMovie(String typeMovieID, String typeMovieName) {
		super();
		this.typeMovieID = typeMovieID;
		this.typeMovieName = typeMovieName;
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
	

     
}