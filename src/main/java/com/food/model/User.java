package com.food.model;

public class User {
     private int Userid;
     private String username;
     private String password;
     private String email;
     private String address;
	public User() {
		super();
	}
	public User( int Userid,String username, String password, String email, String address) {
		super();
		this.Userid=Userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	public User(String username, String password, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return   Userid+"   "+username + "    " + password + "    " + email
				+ "    " + address;
	}
	
	
	
	
}

