package com.fpt.ojtstem.action;

import java.util.List;

import com.fpt.ojtstem.dao.AccountDao;
import com.fpt.ojtstem.model.Account;
import com.opensymphony.xwork2.ActionSupport;
public class AccountAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    private List<Account> account;
    public String execute() throws Exception {
		AccountDao accountDao=new AccountDao();
	    this.account=accountDao.getAll();
	    return SUCCESS;
    																																																																	}
    public List<Account> getAccount(){
    	AccountDao accountDao=new AccountDao();
	    this.account=accountDao.getAll();
		return account;
	}
    
}