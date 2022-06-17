package com.example.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	// ログイン画面へアクセスがあった場合の処理メソッド
	@RequestMapping("/")
	public String toLoginPage() {
		return "user/login";
	}

	// ログイン画面のログインボタンが押下された時の処理メソッド
	@RequestMapping(value = "/login", params = "login_btn", method = RequestMethod.POST)
	public String login() {
		return "user/menu";
	}

	// ログイン画面の新規ユーザ登録ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/login", params = "signup_btn", method = RequestMethod.POST)
	public String toSignupPage() {
		return "user/signup";
	}

	// 新規ユーザ登録画面の確認ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/signup", params = "conf_btn", method = RequestMethod.POST)
	public String toSingupConf() {
		return "user/signupConf";
	}

	// 新規ユーザ登録画面の戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/signup", params = "back_btn", method = RequestMethod.POST)
	public String backToLoginPage() {
		return "user/login";
	}

	// 新規ユーザ登録確認画面の登録ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/signupConf", params = "reg_btn", method = RequestMethod.POST)
	public String signup() {
		return "redirect:/signupConf?finish";
	}

	// 新規ユーザ登録確認画面の登録ボタンが押下された時の処理メソッドのリダイレクト処理メソッド
	@RequestMapping(value = "/signupConf", params = "finish", method = RequestMethod.GET)
	public String redirectSignup() {
		return "user/signupFin";
	}


	// 新規ユーザ登録確認画面の戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/signupConf", params = "back_btn", method = RequestMethod.POST)
	public String backToSignupPage() {
		return "user/signup";
	}

	// 新規ユーザ登録完了画面のメニューボタンが押下された時
	@RequestMapping(value = "/signupFin", params = "menu_btn", method = RequestMethod.POST)
	public String toMenuPage() {
		return "user/menu";
	}
}
