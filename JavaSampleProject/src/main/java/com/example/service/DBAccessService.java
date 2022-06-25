package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.ProductInfo;
import com.example.domain.UserInfo;
import com.example.persistence.ProductManageMapper;
import com.example.persistence.UserManageMapper;

@Service
public class DBAccessService {

	@Autowired
	private UserManageMapper userManageMapper;

	@Autowired ProductManageMapper productManageMapper;

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
	 * @param userInfo ユーザ登録画面で入力された情報が格納されたBean
	 */
	public void signup(UserInfo userInfo) {
		userManageMapper.signup(userInfo);
	}

	/**
	 * ログインしているユーザのIDをもとにユーザ情報を取得するメソッド
	 * @param id ログインユーザのID
	 * @return ログインユーザの情報が格納されているBean
	 */
	public UserInfo getLoginUserInfo(int id) {
		return userManageMapper.getLoginUserInfo(id);
	}

	/**
	 * ログインユーザが変更しようとしているログインIDが現在のログインID以外で登録されているか判定するメソッド
	 * @param id ログインユーザのID
	 * @return 存在する場合true、存在しない場合はfalse
	 */
	public boolean checkUserLoginIDWithoutLoginUser(int id, String loginID) {
		int count = userManageMapper.checkUserLoginIDWithoutLoginUser(id, loginID);

		if(count == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ログインユーザの情報を入力された情報で更新するメソッド
	 * @param id ログインユーザのID
	 * @param userInfo ユーザ情報編集画面で入力された情報が格納されたBean
	 */
	public void updateUserInfo(int id, UserInfo userInfo) {
		userManageMapper.updateUserInfo(id, userInfo);
	}

	/**
	 * ログインユーザの登録している商品の一覧を取得するメソッド
	 * @param userID ログインユーザのID
	 * @return ログインユーザの登録している商品情報が格納されているBean
	 */
	public List<ProductInfo> getProductInfoWithLoginUserID(int userID) {
		return productManageMapper.getProductInfoWithLoginUserID(userID);
	}

	/**
	 * 商品の予約数を取得するメソッド
	 * @param id 商品のID
	 * @return 予約数
	 */
	public int countReserve(int id) {
		return productManageMapper.countReserve(id);
	}

	/**
	 * 商品情報を登録するメソッド
	 * @param productInfo 登録する商品情報が格納されたBean
	 */
	public void registerProduct(ProductInfo productInfo) {
		productManageMapper.registerProduct(productInfo);
	}

	/**
	 * 商品IDが一致する商品情報を取得するメソッド
	 * @param id 検索する商品ID
	 * @return 商品情報が格納されたBean
	 */
	public ProductInfo getProductInfoWithProductID(int id) {
		return productManageMapper.getProductInfoWithProductID(id);
	}

	/**
	 * 商品IDが一致する商品情報を更新するメソッド
	 * @param productInfo 変更する商品情報が格納されたBean
	 */
	public void updateProductInfo(ProductInfo productInfo) {
		productManageMapper.updateProductInfo(productInfo);
	}

}
