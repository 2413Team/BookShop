package com.newBookShopWeb.dao;

import java.util.List;

import com.newBookShopWeb.entity.Cartbook;
import com.newBookShopWeb.entity.OurUser;

public class OrderDao {
	public void SubmitOrder(OurUser user,Double total,List<Cartbook> cart){
		int orderid=AddOrder(user, total);
	}
	private int AddOrder(OurUser user,Double total){
		/*
		 * 该方法执行插入一个订单的操作，但是每次插入都是一个单独的订单
		 * 不能通过修改订单来完成操作，提交后不能再次修改。
		 * 1，插入一个空的订单
		 * 2，得到插入订单的id
		 */
		return 0;
	}
	private void AddOrderBook(List<Cartbook> cart,int orderid){
		/*
		 * 完成新插入订单对应的详细内容
		 * 插入时为bookid而非bookisbn
		 */
	}
}
