package com.newBookShopWeb.entity;

import java.io.Serializable;

public class Cartbook implements Serializable {
	/*
	 * quantity-数量
	 * unitprice-对应的是这一个项目的总价，并非单本书的价格
	 */
	private int id;
	private int cartsId;
	private int bookISBN;
	private int quantity;
	private double unitprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartsId() {
		return cartsId;
	} 
	public void setCartsId(int cartsId) {
		this.cartsId = cartsId;
	}
	public int getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(int bookISBN) {
		this.bookISBN = bookISBN;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	
	
}
