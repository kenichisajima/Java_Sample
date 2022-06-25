package com.example.web.seller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.ProductInfo;
import com.example.service.DBAccessService;
import com.example.sessionBean.UserInfoSessionBean;

@Controller
public class SellerController {

	@Autowired
	private UserInfoSessionBean userInfoSessionBean;

	@Autowired
	private DBAccessService dbAccessService;

	@Autowired
	private MessageSource messageSource;


	// メニュー画面の購入者メニューボタンが押下された時の処理メソッドのフォワード後の処理メソッド
	@RequestMapping(value = "/sellerPage")
	public String sellerPage(Model model) {
		List<ProductInfo> productInfoList = dbAccessService.getProductInfoWithLoginUserID(userInfoSessionBean.getUserID());

		List<ProductInfoListView> productInfoListViews = new ArrayList<>();
		for(ProductInfo productInfo : productInfoList) {
			ProductInfoListView productInfoListView = new ProductInfoListView();
			BeanUtils.copyProperties(productInfo, productInfoListView);

			int reserveCount = dbAccessService.countReserve(productInfo.getId());
			productInfoListView.setReserve(reserveCount);


			productInfoListViews.add(productInfoListView);
		}

		model.addAttribute("productInfoList", productInfoListViews);

		return "seller/sellerPage";
	}

	// 販売者メニュー画面の商品登録ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/seller", params = "productRegister_btn", method = RequestMethod.POST)
	public String toProductRegisterPage() {
		return "seller/productRegister";
	}

	// 販売者メニュー画面の商品編集ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/seller", params = "productEdit_btn", method = RequestMethod.POST)
	public String toProductEditPage() {
		return "seller/productEdit";
	}

	// 販売者メニュー画面のメニュー選択に戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/seller", params = "backMenu_btn", method = RequestMethod.POST)
	public String backMenuFromBuyerPage() {
		return "user/menu";
	}

	// 商品登録画面の登録ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/productRegister", params = "register_btn", method = RequestMethod.POST)
	public String productRegister() {
		return "redirect:/productRegister?finish";
	}

	// 商品登録画面の登録ボタンが押下された時の処理メソッドのリダイレクト後の処理メソッド
	@RequestMapping(value = "/productRegister", params = "finish", method = RequestMethod.GET)
	public String redirectProductRegister() {
		return "seller/productRegister";
	}

	// 商品登録画面の戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/productRegister", params = "back_btn", method = RequestMethod.POST)
	public String backToSellerMenuFromProductRegister() {
		return "seller/sellerPage";
	}

	// 商品編集画面の確定ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/productEdit", params = "fix_btn", method = RequestMethod.POST)
	public String productEdit() {
		return "redirect:/productEdit?finish";
	}

	// 商品編集画面の確定ボタンが押下された時の処理メソッドのリダイレクト後の処理メソッド
	@RequestMapping(value = "/productEdit", params = "finish", method = RequestMethod.GET)
	public String redirectProductEdit() {
		return "seller/productEdit";
	}

	// 商品編集画面の戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/productEdit", params = "back_btn", method = RequestMethod.POST)
	public String backToSellerMenuFromProductEdit() {
		return "seller/sellerPage";
	}

}
