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
	public OurUser doLogin(OurUser user){
		OurUser ouruser=new OurUser();
		ouruser.setId(0);
		try {
			if(!conn.isClosed()){
				CallableStatement stmt=conn.prepareCall("CALL pro_userLogin(?,?)");
				stmt.setString(1, user.getLoginId());
				stmt.setString(2, user.getLoginPwd());
				ResultSet rs=stmt.executeQuery();
				if(rs.next()){
					ouruser.setId(rs.getInt("id"));
					ouruser.setLoginId(rs.getString("LoginId"));
					ouruser.setLoginPwd(rs.getString("LoginPwd"));
					ouruser.setName(rs.getString("Name"));
					ouruser.setAddress(rs.getString("Address"));
					ouruser.setPhone(rs.getString("Phone"));
					ouruser.setMail(rs.getString("Mail"));
					ouruser.setUserRoleId(rs.getInt("UserRoleId"));
					ouruser.setUserStateId(rs.getInt("UserStateId"));
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
