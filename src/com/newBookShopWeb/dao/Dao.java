package com.newBookShopWeb.dao;

import com.newBookShopWeb.entity.OurUser;
/*
 * д��һ���ӿڣ���ȫ��֪����ɶ��
 */
public interface Dao {
	public boolean doLogin(OurUser user);
	public boolean doRegister(OurUser user);
}
