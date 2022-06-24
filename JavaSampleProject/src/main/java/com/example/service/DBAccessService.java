package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.LoginUserInfo;
import com.example.persistence.UserManageMapper;

@Service
public class DBAccessService {

	@Autowired
	private UserManageMapper userManageMapper;


	/**
	 * ログイン画面で入力された情報が正しいか判定するメソッド
	 *
	 */
	public boolean loginCheck(LoginUserInfo loginUserInfo) {
		Integer count = userManageMapper.loginCheck(loginUserInfo);

		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ログインユーザ情報を取得するメソッド
	 */
	public int getLoginUserID(LoginUserInfo loginUserInfo) {
		return userManageMapper.getLoginUserID(loginUserInfo);
	}
}
