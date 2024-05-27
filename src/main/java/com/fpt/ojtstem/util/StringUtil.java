package com.fpt.ojtstem.util;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

public class StringUtil implements SessionAware{
	private Map<String, Object> session;

	/**
	   * Check whether a string is null or empty.
	   *
	   * @param str String to check
	   * @return true : if string is null or empty false : if string is not null or empty
	   */
	  public static boolean isNullOrEmpty(String str) {
	    if (str == null || str.equals(StringUtils.EMPTY)) {
	      return true;
	    }
	    return false;
	  }
	  /**
	   * Check whether a string is a number string.
	   *
	   * @param str String to check
	   * @return true : if string is a number string false : if string is not a number string
	   */
	  public static boolean isNumber(String str) {
	    String regex = "^[+-]?[\\d]*[.]?[\\d]*$";
	    if (str.matches(regex)) {
	      return true;
	    }
	    return false;
	  }
	  public static boolean isString(String str) {
		    String regex ="^[\\p{L}0-9\\s]+$";
		    if (str.matches(regex)) {
		      return true;
		    }
		    return false;
		  }
	  public static boolean isCheck(String str) {
		    String regex ="^[\\p{L}0-9\\s,.]+$";
		    if (str.matches(regex)) {
		      return true;
		    }
		    return false;
		  }
	  
	  
	  
      public static boolean containsWhitespace(String str) {
		    if (str != null) {
		        for (int i = 0; i < str.length(); i++) {
		            if (!Character.isWhitespace(str.charAt(i))) {
		                return false;
		            }
		        }
		    }
		    return true;
		}
 
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	public Map<String, Object> getSession() {
		return session;
	}
   
	  /**
	   * Check is valid email.
	   *
	   * @param email
	   * @return true: is valid email. false: is invalid email.
	   */
	
	
	  
}