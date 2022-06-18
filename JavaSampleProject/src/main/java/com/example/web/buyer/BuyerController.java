package com.example.web.buyer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BuyerController {

	// メニュー画面の購入者メニューボタンが押下された時の処理メソッドのフォワード後の処理メソッド
	@RequestMapping(value = "/buyerPage")
	public String buyerPage() {
		return "buyer/buyerPage";
	}

	// 購入者メニュー画面の予約確認ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/buyer", params = "reserveListConf_btn", method = RequestMethod.POST)
	public String reserveListConf() {
		return "buyer/reserveListPage";
	}

	// 購入者メニュー画面のメニュー選択に戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/buyer", params = "backMenu_btn", method = RequestMethod.POST)
	public String backMenuFromBuyerPage() {
		return "user/menu";
	}

	// 購入者メニュー画面の予約するボタンが押下された時の処理メソッド
	@RequestMapping(value = "/buyer", params = "reserve_btn", method = RequestMethod.POST)
	public String resrveConf() {
		return "buyer//reserveConf";
	}

	// 予約状況確認一覧画面の戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/reserveListPage", params = "back_btn", method = RequestMethod.POST)
	public String backToBuyerPageFromReserveListPage() {
		return "forward:/buyerPage";
	}


	// 予約確認画面の予約ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/reserveConf", params = "reserve_btn", method = RequestMethod.POST)
	public String reserve() {
		return "redirect:/reserveConf?finish";
	}

	// 予約確認画面の予約ボタンが押下された時の処理メソッドのリダイレクト後の処理メソッド
	@RequestMapping(value = "/reserveConf", params = "finish", method =  RequestMethod.GET)
	public String redirectReserve() {
		return "buyer/reserveFin";
	}

	// 予約確認画面の戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/reserveConf", params = "back_btn", method = RequestMethod.POST)
	public String backToBuyerPageFromReserveConf() {
		return "forward:/buyerPage";
	}

	// 予約完了画面の購入者メニューボタンが押下された時の処理メソッド
	@RequestMapping(value = "/reserveFin", params = "buyerMenu_btn", method = RequestMethod.POST)
	public String toBuyerPageFromReserveFin() {
		return "forward:/buyerPage";
	}
}
