package com.example.util;

/**
 * エラーチェッククラス
 * @author sajic
 *
 */
public class ErrorCheck {

	/**
	 * 入力された文字列が同じか確認するメソッド
	 * @param str1 一つ目の文字列
	 * @param str2 二つ目の文字列
	 * @return 一致している場合true、一致していない場合false
	 */
	public static boolean isEquals(String str1, String str2) {
		if(str1.equals(str2)) {
			return true;
		} else {
			return false;
		}
	}
}
