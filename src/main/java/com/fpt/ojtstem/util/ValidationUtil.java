package com.fpt.ojtstem.util;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtil{
	/**
	   * Check is valid email.
	   *
	   * @param email
	   * @return true: is valid email. false: is invalid email.
	   */
	  public static boolean isEmail(String email) {
	    String emailRegexString =
	        "\\b(^[_A-Za-z0-9-]+([\\.]*[_A-Za-z0-9-+]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	    if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(email.trim())) {
	      if (!Pattern.matches(emailRegexString, email.trim())) {
	        return false;
	      }
	    }
	    return true;
	  }
	  /**
	   * Check is float number
	   *
	   * @param number
	   * @return true: is Float number false: is not Float number
	   */
	  public static boolean isNumber(String sNumber) {
	    try {
	      Double.parseDouble(sNumber);
	      return true;
	    } catch (Exception e) {
	      return false;
	    }
	  }
	  /**
	   * Check is telephone 
	   *
	   * @param tel
	   * @return true: is valid tel 
	   */
	  public static boolean isTelephone(String number) {
	  // code here
	    return true;
	  }
}