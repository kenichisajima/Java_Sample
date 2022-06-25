package com.example.web.seller;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class RegisterProductForm {

	@NotEmpty
	private String name;
	@Range(min = 1)
	private int stock;
	private String remarks;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
