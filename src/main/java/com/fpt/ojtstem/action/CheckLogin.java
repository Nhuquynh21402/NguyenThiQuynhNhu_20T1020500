package com.fpt.ojtstem.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.fpt.ojtstem.model.Account;
import com.opensymphony.xwork2.ActionContext;


public class CheckLogin extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	@Override
    public String intercept(ActionInvocation invocation) throws Exception {
      
        ActionContext context = invocation.getInvocationContext();
        Account account = (Account) context.getSession().get("user");
        
        if (account != null) {
            
            return invocation.invoke();
        } else {
           
            return "login";
        }
    }
}