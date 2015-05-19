package com.newBookShopWeb.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.OurUser;

public class UserDao implements Dao {
	private Connection conn;
	public UserDao(){
			//获取链接
			try {
				conn=DataSourceProvider.getInstance().getDataSoruce().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/*
	 * 实现了普通用户的登陆
	 */
	public boolean doLogin(OurUser user){
		try {
			if(!conn.isClosed()){
				CallableStatement stmt=conn.prepareCall("CALL pro_userLogin(?,?)");
				stmt.setString(1, user.getLoginId());
				stmt.setString(2, user.getLoginPwd());
				ResultSet rs=stmt.executeQuery();
				if(rs.next()){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * 实现了普通用户的注册
	 */
	public boolean doRegister(OurUser user){
		try {
			if(!conn.isClosed()){
				CallableStatement stmt=conn.prepareCall("CALL pro_register(?,?,?,?,?,?)");;
				stmt.setString(1, user.getLoginId());
				stmt.setString(2, user.getLoginPwd());
				stmt.setString(3, user.getName());
				stmt.setString(4, user.getAddress());
				stmt.setString(5, user.getPhone());
				stmt.setString(6, user.getMail());
				if(stmt.executeUpdate()>0)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
