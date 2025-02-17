package com.library.user.model.vo;

import java.sql.Date;

public class User {
	private String userNo;
	private String userId;
	private String userName;
	private int age;
	private String userAddr;
	private String gender;
	private Date enrollDate;
	
	public User(){}
	
	public User(String userId, String userName, int age, String userAddr, String gender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
		this.userAddr = userAddr;
		this.gender = gender;
	}




	public String getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getAge() {
		return age;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public String getGender() {
		return gender;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", age=" + age + ", userAddr=" + userAddr
				+ ", gender=" + gender + ", EnrollDate=" + enrollDate + "]";
	}
	
	
}
