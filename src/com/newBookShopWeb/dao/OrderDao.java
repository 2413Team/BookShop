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
		 * �÷���ִ�в���һ�������Ĳ���������ÿ�β��붼��һ�������Ķ���
		 * ����ͨ���޸Ķ�������ɲ������ύ�����ٴ��޸ġ�
		 * 1������һ���յĶ���
		 * 2���õ����붩����id
		 */
		return 0;
	}
	private void AddOrderBook(List<Cartbook> cart,int orderid){
		/*
		 * ����²��붩����Ӧ����ϸ����
		 * ����ʱΪbookid����bookisbn
		 */
	}
}
