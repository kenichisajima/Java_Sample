package com.example.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	/**
	 * ログインユーザの登録している商品以外の一覧を取得するメソッド
	 * @param userID ログインユーザのID
	 * @return ログインユーザの登録している商品情報が格納されているBean
	 */
	public List<ProductInfo> getProductInfoWithoutLoginUserID(int userID);

	/**
	 * 予約している商品情報を取得するメソッド
	 * @param userID ログインしているユーザーのID
	 * @return 予約している商品情報が格納されているBean
	 */
	public List<ProductInfo> getReserveProductList(int userID);

	/**
	 * 予約しようとしている商品がすでに予約しているか確認するメソッド
	 * @param userID 予約しようとしているユーザのID
	 * @param productID 予約しようとしている商品のID
	 * @return 予約している場合は1、していない場合は0
	 */
	public int checkReserve(@Param("userID")int userID, @Param("productID")int productID);

	/**
	 * 予約情報を登録するメソッド
	 * @param userID ログインユーザのID
	 * @param productID 登録する商品のID
	 */
	public void reserveProduct(@Param("userID")int userID, @Param("productID")int productID);

}
