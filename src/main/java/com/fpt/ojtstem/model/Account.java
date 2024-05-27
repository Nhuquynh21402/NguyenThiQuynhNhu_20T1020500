package com.fpt.ojtstem.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Account{
	private String id;
	private String userName;
	private String passWord;
	private String fullName;
	private String email;
	private int SDT;
	private int roldId;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	







	public Account(String id, String userName, String passWord, String fullName, String email, int sDT, int roldId) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.email = email;
		SDT = sDT;
		this.roldId = roldId;
	}









	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
	        this.passWord = encryptPassword(passWord);
	}

	public int getRoldId() {
		return roldId;
	}

	public void setRoldId(int roldId) {
		this.roldId = roldId;
	}
	
	
	  public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getSDT() {
		return SDT;
	}

	public void setSDT(int sDT) {
		SDT = sDT;
	}
    
	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	private String encryptPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(password.getBytes());
	            byte[] bytes = md.digest();
	            StringBuilder sb = new StringBuilder();
	            for (byte aByte : bytes) {
	                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	          
	            e.printStackTrace();
	            return null;
	        }
	    }
	
}