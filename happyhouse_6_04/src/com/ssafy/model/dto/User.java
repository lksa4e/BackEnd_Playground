package com.ssafy.model.dto;

public class User {

	private String userId;
	private String userPw;
	private String userName;
	private String userAddress;
	private String userTel;
	
	public User(String userId, String userPw, String userName, String userAddress, String userTel) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userTel = userTel;
	}
	
	
	public User(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	@Override
	public String toString() {
		return userId+"\t"+userPw+"\t"+userName+"\t"+userAddress+"\t"+userTel;
	}
	
}
