package com.example.persistence;

import org.apache.ibatis.annotations.Param;

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
	 * @param userInfo ユーザ登録画面で入力された情報が格納されたBean
	 */
	public void signup(UserInfo userInfo);

	/**
	 * ログインしているユーザのIDをもとにユーザ情報を取得するメソッド
	 * @param id ログインユーザのID
	 * @return ログインユーザの情報が格納されているBean
	 */
	public UserInfo getLoginUserInfo(int id);

	/**
	 * ログインユーザが変更しようとしているログインIDが現在のログインID以外で登録されているか判定するメソッド
	 * @param id ログインユーザのID
	 * @return ログインIDが存在している場合1、存在していない場合0
	 */
	public int checkUserLoginIDWithoutLoginUser(int id, String loginID);

	/**
	 * ログインユーザの情報を入力された情報で更新するメソッド
	 * @param id ログインユーザのID
	 * @param userInfo ユーザ情報編集画面で入力された情報が格納されたBean
	 */
	public void updateUserInfo(@Param("id") int id, @Param("userInfo") UserInfo userInfo);
}
