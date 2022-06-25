package com.example.web.buyer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.ProductInfo;
import com.example.service.DBAccessService;
import com.example.sessionBean.UserInfoSessionBean;
import com.example.util.ProductInfoListView;

@Controller
@SessionAttributes({"reserveProductForm"})
public class BuyerController {

	@Autowired
	private UserInfoSessionBean userInfoSessionBean;

	@Autowired
	private DBAccessService dbAccessService;

	@Autowired
	private MessageSource messageSource;

	@ModelAttribute("reserveProductForm")
	public ReserveProductForm setReserveProductForm() {
		return new ReserveProductForm();
	}

	// メニュー画面の購入者メニューボタンが押下された時の処理メソッドのフォワード後の処理メソッド
	@RequestMapping(value = "/buyerPage")
	public String buyerPage(Model model) {
		List<ProductInfo> productInfoList = dbAccessService.getProductInfoWithoutLoginUserID(userInfoSessionBean.getUserID());

		List<ProductInfoListView> productInfoListViews = new ArrayList<>();
		for(ProductInfo productInfo : productInfoList) {
			ProductInfoListView productInfoListView = new ProductInfoListView();
			BeanUtils.copyProperties(productInfo, productInfoListView);

			int reserveCount = dbAccessService.countReserve(productInfo.getId());
			productInfoListView.setReserve(reserveCount);


			productInfoListViews.add(productInfoListView);
		}

		model.addAttribute("productInfoList", productInfoListViews);

		return "buyer/buyerPage";
	}

	// 購入者メニュー画面の予約確認ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/buyer", params = "reserveListConf_btn", method = RequestMethod.POST)
	public String reserveListConf(Model model) {
		List<ProductInfo> productInfoList = dbAccessService.getReserveProductList(userInfoSessionBean.getUserID());

		List<ProductInfoListView> productInfoListViews = new ArrayList<>();
		for(ProductInfo productInfo : productInfoList) {
			ProductInfoListView productInfoListView = new ProductInfoListView();
			BeanUtils.copyProperties(productInfo, productInfoListView);
			productInfoListViews.add(productInfoListView);
		}

		model.addAttribute("productInfoList", productInfoListViews);

		return "buyer/reserveListPage";
	}

	// 購入者メニュー画面のメニュー選択に戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/buyer", params = "backMenu_btn", method = RequestMethod.POST)
	public String backMenuFromBuyerPage() {
		return "user/menu";
	}

	// 購入者メニュー画面の予約ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/buyer", params = "reserve_btn", method = RequestMethod.POST)
	public String resrveConf(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes, Locale locale) {

		if(id == 0) {
			return "forward:/buyerPage";
		}
		if(dbAccessService.checkReserve(userInfoSessionBean.getUserID(), id)) {
			redirectAttributes.addFlashAttribute("alreadyReserveMassage", messageSource.getMessage("message.alreadyReserve", null, locale));
			return "redirect:/buyerPage";
		}

		ReserveProductForm reserveProductForm = new ReserveProductForm();
		ProductInfo productInfo = dbAccessService.getProductInfoWithProductID(id);
		BeanUtils.copyProperties(productInfo, reserveProductForm);

		model.addAttribute("reserveProductForm", reserveProductForm);

		return "buyer/reserveConf";
	}

	// 予約状況確認一覧画面の戻るボタンが押下された時の処理メソッド
	@RequestMapping(value = "/reserveListPage", params = "back_btn", method = RequestMethod.POST)
	public String backToBuyerPageFromReserveListPage() {
		return "forward:/buyerPage";
	}


	// 予約確認画面の予約ボタンが押下された時の処理メソッド
	@RequestMapping(value = "/reserveConf", params = "reserve_btn", method = RequestMethod.POST)
	public String reserve(ReserveProductForm form, SessionStatus sessionStatus) {
		System.out.println(form.getId());
		dbAccessService.reserveProduct(userInfoSessionBean.getUserID(), form.getId());

		sessionStatus.setComplete();

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
