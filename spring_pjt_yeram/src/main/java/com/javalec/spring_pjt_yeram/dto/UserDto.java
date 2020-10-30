package com.javalec.spring_pjt_yeram.dto;

public class UserDto {
	private String userEmail;
	private String userPassword;
	private String userTel;
	
	
	public UserDto() {
	}
	
	public UserDto(String userEmail, String userPassword, String userTel) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	
}
