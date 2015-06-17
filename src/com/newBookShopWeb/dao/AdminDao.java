package com.newBookShopWeb.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Book;
import com.newBookShopWeb.entity.OurUser;

public class AdminDao implements Dao {
	private Connection conn;

	public AdminDao() {
		try {
			conn = DataSourceProvider.getInstance().getDataSoruce()
					.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 实现管理员用户的登陆操作
	 */
	@Override
	public OurUser doLogin(OurUser user) {
		// TODO Auto-generated method stub
		OurUser ouruser=new OurUser();
		ouruser.setId(0);
		try {
			if (!conn.isClosed()) {
				CallableStatement stmt=conn.prepareCall("CALL pro_adminlogin(?,?)");
				stmt.setString(1, user.getLoginId());
				stmt.setString(2, user.getLoginPwd());
				ResultSet set = stmt.executeQuery();
				if (set.next()) {
					ouruser.setId(set.getInt("id"));
					ouruser.setLoginId(set.getString("LoginId"));
					ouruser.setLoginPwd(set.getString("LoginPwd"));
					ouruser.setName(set.getString("Name"));
					ouruser.setAddress(set.getString("Address"));
					ouruser.setPhone(set.getString("Phone"));
					ouruser.setMail(set.getString("Mail"));
					ouruser.setUserRoleId(set.getInt("UserRoleId"));
					ouruser.setUserStateId(set.getInt("UserStateId"));
					return ouruser;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ouruser;
	}

	/*
	 * 实现管理员用户的注册操作
	 */
	@Override
	public boolean doRegister(OurUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addBook(Book book) {
		return true;
	}
}
