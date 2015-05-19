package com.newBookShopWeb.dao;

import com.newBookShopWeb.entity.OurUser;
/*
 * 写了一个接口，完全不知道有啥用
 */
public interface Dao {
	public boolean doLogin(OurUser user);
	public boolean doRegister(OurUser user);
}
