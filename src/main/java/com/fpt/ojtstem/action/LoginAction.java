package com.fpt.ojtstem.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fpt.ojtstem.dao.AccountDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private Map<String, Object> session;
    
    public String init() {
    	return SUCCESS;
    	
    }
    public String execute() throws Exception {
    	if(StringUtil.isNullOrEmpty(username) || StringUtil.isNullOrEmpty(password)) {
    		return ERROR;
    	}else {
        AccountDao accDao = new AccountDao();
        Account account = accDao.checkLogin(username, encryptPassword(password));
       
        
        if (account != null) {
            session.put("user", account);
            if (account.getRoldId() == 1) {
                return "admin";
            } else if (account.getRoldId() == 2) {
                return "employees";
            } else {
                return "user";
            }
        } else {
            addActionError("Tên đăng nhập và mật khẩu sai!!!");
            return  ERROR;
        }
    	}
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
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