package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.UserInfo;
import com.example.persistence.UserManageMapper;

@Service
public class DBAccessService {

	@Autowired
	private UserManageMapper userManageMapper;


	/**
	 * ログイン画面で入力された情報が正しいか判定するメソッド
	 * @param loginUserInfo ログイン画面で入力された情報が格納されたBean
	 * @return 正しい場合はtrue、間違っている場合はfalse
	 */
	public boolean loginCheck(UserInfo userInfo) {
		int count = userManageMapper.loginCheck(userInfo);

		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ログインユーザ情報を取得するメソッド
	 * @param loginUserInfo ログイン画面で入力された情報が格納されたBean
	 * @return ログインユーザのID
	 */
	public int getLoginUserID(UserInfo userInfo) {
		return userManageMapper.getLoginUserID(userInfo);
	}

	/**
	 * ユーザ登録画面で入力されたログインIDが存在するか判定するメソッド
	 * @param loginID ユーザ登録画面で入力されたログインID
	 * @return 存在する場合true、存在しない場合はfalse
	 */
	public boolean signupCheckLoginID(String loginID) {
		int count = userManageMapper.signupCheckLoginID(loginID);

		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ユーザ登録画面で入力画面で入力された情報をDBに登録するメソッド
	 */
	public void signup(UserInfo userInfo) {
		userManageMapper.signup(userInfo);
	}

}
