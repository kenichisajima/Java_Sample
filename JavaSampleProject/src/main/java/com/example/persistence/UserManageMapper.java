package com.example.persistence;

import com.example.domain.LoginUserInfo;

public interface UserManageMapper {

	/**
	 * ログイン画面で入力された情報が正しいか判断するメソッド
	 * @param loginUserInfo ログイン画面で入力された情報が格納されたBean
	 * @return ログインIDとパスワード組み合わせの組が存在している場合1、存在していない場合0
	 */
	public int loginCheck(LoginUserInfo loginUserInfo);

	public int getLoginUserID(LoginUserInfo loginUserInfo);
}
