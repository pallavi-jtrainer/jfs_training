package com.springpeople.projectx.fileio;

import java.io.Serializable;

public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5615210126711421062L;
	
	private int userId;
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Users() {}
	
	public Users(int userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "[User: id => " + userId + ", name => " + userName + "]";
	}
}
