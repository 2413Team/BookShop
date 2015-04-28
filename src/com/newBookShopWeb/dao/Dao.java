package com.newBookShopWeb.dao;

import com.newBookShopWeb.entity.OurUser;

public interface Dao {
	public boolean doLogin(OurUser user);
	public boolean doRegister(OurUser user);
}
