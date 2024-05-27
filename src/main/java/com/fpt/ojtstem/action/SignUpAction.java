package com.fpt.ojtstem.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import com.fpt.ojtstem.dao.AccountDao;
import com.fpt.ojtstem.model.Account;
import com.fpt.ojtstem.util.StringUtil;
import com.fpt.ojtstem.util.ValidationUtil;
import com.opensymphony.xwork2.ActionSupport;
public class SignUpAction extends ActionSupport implements SessionAware, ServletRequestAware {
	private static final long serialVersionUID = 1L;
    private Account account;
    private String prePassWord;
    List<Account> list = new ArrayList<Account>();
    private Map<String, Object> session;
	public HttpServletRequest request;
    public String init() {
    	return SUCCESS;
    	
    }
    
    public String execute() {
     if(!ValidationUtil.isEmail(account.getEmail())) {
    	 addActionError("Email không đúng!!!");
    	 return ERROR;
     }
       AccountDao accDao = new AccountDao();
       list = accDao.getAll();
       for( Account acc : list) {
    	   if(account.getUserName().equals(acc.getUserName())) {
    		   addActionError("Tên tài khoản đã được sử dụng!!!");
    	    	 return ERROR; 
    	   }
    	   if(account.getSDT()==acc.getSDT()) {
    		   addActionError("SDT đã được sử dụng!!!");
  	    	   return ERROR; 
    	   }
    	   if(acc.getEmail().equals(account.getEmail())) {
    		   addActionError("Email đã được sử dụng!!!");
  	    	   return ERROR; 
    	   }
    	 
       }
       if(!account.getPassWord().equals(encryptPassword(prePassWord))) {
    	   addActionError("Mật khẩu nhập lại không đúng!!!");
	    	 return ERROR;   
	   }
       accDao.Insert(account);
       
        return SUCCESS;
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
    
    
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPrePassWord() {
		return prePassWord;
	}

	public void setPrePassWord(String prePassWord) {
		this.prePassWord = prePassWord;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public List<Account> getList() {
		return list;
	}

	public void setList(List<Account> list) {
		this.list = list;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	
}