package com.example.web.user;

import javax.validation.constraints.NotEmpty;

public class LoginUserInfoForm {

	@NotEmpty
	private String loginID;
	@NotEmpty
	private String password;


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


}
