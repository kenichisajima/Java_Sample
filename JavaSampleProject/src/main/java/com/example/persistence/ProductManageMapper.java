package com.example.persistence;

import java.util.List;

import com.example.domain.ProductInfo;

public interface ProductManageMapper {

	/**
	 * ログインユーザの登録している商品の一覧を取得するメソッド
	 * @param userID ログインユーザのID
	 * @return ログインユーザの登録している商品情報が格納されているBean
	 */
	public List<ProductInfo> getProductInfoWithLoginUserID(int userID);

	/**
	 * 商品の予約数を取得するメソッド
	 * @param id 商品のID
	 * @return 予約数
	 */
	public int countReserve(int id);

}
