package com.newBookShopWeb.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Book;
import com.newBookShopWeb.entity.OurUser;

public class AdminDao implements Dao {
	private Connection conn;
	public AdminDao() {
		try {
			conn=DataSourceProvider.getInstance().getDataSoruce().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 实现管理员用户的登陆操作
	 */
	@Override
	public boolean doLogin(OurUser user) {
		// TODO Auto-generated method stub
		try {
			if(!conn.isClosed()){
				CallableStatement stmt=conn.prepareCall("CALL pro_adminLogin(?,?)");
				stmt.setString(1, user.getLoginId());
				stmt.setString(2, user.getLoginPwd());
				ResultSet set=stmt.executeQuery();
				if(set.next())
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * 实现管理员用户的注册操作
	 */
	@Override
	public boolean doRegister(OurUser user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean addBook(Book book){
		return true;
	}
}
