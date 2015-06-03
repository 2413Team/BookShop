package com.newBookShopWeb.entity;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
	private List<Cartbook> cart;
	private Double Total;

	public List<Cartbook> getCart() {
		return cart;
	}

	public void setCart(List<Cartbook> cart) {
		this.cart = cart;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		Total = total;
	}
	
	
}
