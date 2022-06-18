package com.example.web.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SellerController {

	@RequestMapping(value = "/sellerPage")
	public String sellerPage() {
		return "seller/sellerPage";
	}
}
