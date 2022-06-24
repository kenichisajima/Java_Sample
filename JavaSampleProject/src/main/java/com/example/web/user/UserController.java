package com.example.web.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.LoginUserInfo;
import com.example.service.DBAccessService;
import com.example.sessionBean.UserInfoSessionBean;


@Controller
public class UserController {

	@Autowired
	private UserInfoSessionBean userInfoSessionBean;

	@Autowired
	private DBAccessService dbAccessService;

	@ModelAttribute("loginUserInfoForm")
	public LoginUserInfoForm setLoginUserInfoForm() {
		return new LoginUserInfoForm();
	}


	// ログイン画面へアクセスがあった場合の処理メソッド
	@RequestMapping("/")
	public String toLoginPage() {
		return "user/login";
	}

	// ログイン画面のログインボタンが押下された時の処理メソッド
	@RequestMapping(value = "/login", params = "login_btn", method = RequestMethod.POST)
	public String login(@Validated LoginUserInfoForm form, BindingResult result) {

		LoginUserInfo  loginUserInfo = new LoginUserInfo();
		BeanUtils.copyProperties(form, loginUserInfo);

		if(result.hasErrors()) {
			return "user/login";
		} else {
			if(!dbAccessService.loginCheck(loginUserInfo)) {
				result.reject("errors.thereIsNotAccount");
			}

			if(result.hasErrors()) {
				return "user/login";
			}
		}

		userInfoSessionBean.setUserID(dbAccessService.getLoginUserID(loginUserInfo));
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

	// 新規ユーザ登録確認画面の登録ボタンが押下された時の処理メソッドのリダイレクト後の処理メソッド
	@RequestMapping(value = "/signupConf", params = "finish", method = RequestMethod.GET)
	public String redirectSignup() {
		return "user/signupFin";
	}


	// 新規ユーザ登録確認画面の戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/signupConf", params = "back_btn", method = RequestMethod.POST)
	public String backToSignupPage() {
		return "user/signup";
	}

	// 新規ユーザ登録完了画面のメニューボタンが押下された時の処理メソッド
	@RequestMapping(value = "/signupFin", params = "menu_btn", method = RequestMethod.POST)
	public String toMenuPage() {
		return "user/menu";
	}

	// メニュー画面の購入者メニューボタンが押下された時の処理メソッド
	@RequestMapping(value = "/menu", params = "buyer_btn", method = RequestMethod.POST)
	public String toBuyerPage() {
		return "forward:/buyerPage";
	}

	// メニューボタンの販売者メニューボタンが押下された時の処理メソッド
	@RequestMapping(value = "/menu", params = "seller_btn", method = RequestMethod.POST)
	public String toSellerPage() {
		return "forward:/sellerPage";
	}

	// メニューボタンのユーザ情報編集ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/menu", params = "userInfoEdit_btn", method = RequestMethod.POST)
	public String toUserInfoEditPage() {
		return "user/userInfoEdit";
	}

	// メニューボタンのログアウトボタンが押下された時の処理メソッド
	@RequestMapping(value = "/menu", params = "logout_btn", method = RequestMethod.POST)
	public String logout() {
		return "user/login";
	}

	// ユーザ情報編集画面の変更するボタンが押下された時の処理メソッド
	@RequestMapping(value = "/userInfoEdit", params = "edit_btn", method = RequestMethod.POST)
	public String userInfoEdit() {
		return "redirect:/userInfoEdit?finish";
	}

	// ユーザ情報編集画面の変更するボタンが押下された時の処理メソッドのリダイレクト後の処理メソッド
	@RequestMapping(value = "/userInfoEdit", params = "finish", method = RequestMethod.GET)
	public String redirectUserInfoEdit() {
		return "user/userInfoEdit";
	}

	// ユーザ情報編集画面のメニューボタンが押下された時の処理メソッド
	@RequestMapping(value = "/userInfoEdit", params = "menu_btn", method = RequestMethod.POST)
	public String backToMenuPage() {
		return "user/menu";
	}
}
