 package com.fpt.ojtstem.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.containsKey("user")) {
			  session.clear();
			  return SUCCESS;
		}
		else {
			return ERROR;
		}
		
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}