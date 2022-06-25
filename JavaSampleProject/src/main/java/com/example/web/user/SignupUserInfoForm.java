package com.example.web.user;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class SignupUserInfoForm implements Serializable{

	private static final long serialVerionUID = 1L;

	@NotEmpty
	private String loginID;
	@NotEmpty
	private String password;
	private String confPassword;

	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}


}
