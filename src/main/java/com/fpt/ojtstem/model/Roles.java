package com.fpt.ojtstem.model;
public class Roles{
	private int roleId;
	private String roleName;
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}