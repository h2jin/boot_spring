package com.example.demo2_ex.dto;

public class UserRequest {
	
	private String id;
	private String pw;
	private String name;
	private String phoneNum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", pw=" + pw + ", name=" + name + ", phoneNum=" + phoneNum + "]";
	}
	
	

}
