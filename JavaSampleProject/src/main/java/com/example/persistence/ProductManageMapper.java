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

	/**
	 * 商品情報を登録するメソッド
	 * @param productInfo 登録する商品情報が格納されたBean
	 */
	public void registerProduct(ProductInfo productInfo);

	/**
	 * 商品IDが一致する商品情報を取得するメソッド
	 * @param id 検索する商品ID
	 * @return 商品情報が格納されたBean
	 */
	public ProductInfo getProductInfoWithProductID(int id);

	/**
	 * 商品IDが一致する商品情報を更新するメソッド
	 * @param productInfo 変更する商品情報が格納されたBean
	 */
	public void updateProductInfo(ProductInfo productInfo);

}
