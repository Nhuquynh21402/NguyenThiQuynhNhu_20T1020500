package com.fpt.ojtstem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.fpt.ojtstem.config.Config;
import com.fpt.ojtstem.model.Account;



public class AccountDao{
	static Connection con;
	static PreparedStatement ps;
    String sql;
	public List<Account> getAll() {

		List<Account> Account = new ArrayList<Account>();
		try {
			con = Config.getCon();
			sql="select * from Account";
			ps = con.prepareStatement(sql);

			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("AccountID");
				String userName = rs.getString("UserName");
			    String passWord =rs.getString("PassWord");
			    String fullName =rs.getString("fullName");
			    String email =rs.getString("email");
			    int SDT =rs.getInt("sdt");
			    int roldId =rs.getInt("RoldId");
			    Account.add(new Account(id, userName, passWord, fullName, email, SDT, roldId));
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return Account;
	}
	
	
	public Account checkLogin(String user, String pass) {

		Account Account = null;
		try {
			con = Config.getCon();
			sql="select * from Account where UserName=?  and PassWord=?";
			ps = con.prepareStatement(sql);

			System.out.println(ps);
			ps.setString(1,user);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("AccountID");
				String userName = rs.getString("UserName");
			    String passWord =rs.getString("PassWord");
			    int roldId =rs.getInt("RoldID");
			    String email =rs.getString("email");
			    String fullName =rs.getString("fullName");
			    int SDT =rs.getInt("sdt");
			    Account=new Account(id, userName, passWord, fullName, email, SDT, roldId);
				
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return Account;
	}
	public void Insert(Account acc) {
		try {
			con = Config.getCon();
			sql="INSERT INTO Account (UserName, PassWord,RoldID, fullName, SDT, email) VALUES (?,?,3,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,acc.getUserName());
			ps.setString(2,acc.getPassWord());
			ps.setString(3,acc.getFullName());
			ps.setInt(4,acc.getSDT());
			ps.setString(5,acc.getEmail());
			ps.executeUpdate();		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}