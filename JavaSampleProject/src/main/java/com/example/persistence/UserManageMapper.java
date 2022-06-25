package com.example.persistence;

import com.example.domain.UserInfo;

public interface UserManageMapper {

	/**
	 * ログイン画面で入力された情報が正しいか判断するメソッド
	 * @param loginUserInfo ログイン画面で入力された情報が格納されたBean
	 * @return ログインIDとパスワード組み合わせの組が存在している場合1、存在していない場合0
	 */
	public int loginCheck(UserInfo userInfo);

	/**
	 * ログイン画面で入力された情報をもとにログインユーザのIDを取得するメソッド
	 * @param loginUserInfo ログイン画面で入力された情報が格納されたBean
	 * @return ログインユーザのID
	 */
	public int getLoginUserID(UserInfo userInfo);

	/**
	 * ユーザ登録画面で入力されたログインIDが存在するか判定するメソッド
	 * @param loginID 入力されたログインID
	 * @return ログインIDとパスワード組み合わせの組が存在している場合1、存在していない場合0
	 */
	public int signupCheckLoginID(String loginID);

	/**
	 * ユーザ登録画面で入力された情報をDBに登録するメソッド
	 */
	public void signup(UserInfo userInfo);
}
