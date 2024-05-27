package com.fpt.ojtstem.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import javax.servlet.http.HttpServletResponse;

public class DetailMessage extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String result = invocation.invoke();

        if ("success".equals(result)) {
            HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
            response.getWriter().write("<script>alert('Action đã được thực hiện thành công!');</script>");
        }
        if("error".equals(result)){
        	  HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
              response.getWriter().write("<script>alert('Action đã được thực hiện thành công!');</script>");	
        	
        }

        return result;
    }
}
