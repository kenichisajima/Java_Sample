package com.example.web.user;

import javax.validation.constraints.NotEmpty;

public class EditUserInfoForm {

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
