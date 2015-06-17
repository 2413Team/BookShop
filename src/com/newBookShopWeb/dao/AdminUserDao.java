package com.newBookShopWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Book;
import com.newBookShopWeb.entity.OurUser;

public class AdminUserDao {
	private Connection conn;
	public AdminUserDao(){
		try {
			conn = DataSourceProvider.getInstance().getDataSoruce()
					.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OurUser> getUserList(String key){
		List<OurUser> list=new ArrayList<OurUser>();
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM users WHERE loginid like ?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, "%"+key+"%");
				ResultSet set=stmt.executeQuery();
				while(set.next()){	
					OurUser user=getOneUser(set);
					list.add(user);
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public OurUser getUser(int userid){
		OurUser user=new OurUser();
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM users WHERE id = ?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, userid);
				ResultSet set=stmt.executeQuery();
				if(set.next())
					user=getOneUser(set);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteUser(OurUser user){
		try {
			if(!conn.isClosed()){
				String sql="DELETE FROM users WHERE id= ?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, user.getId());
				int flag=stmt.executeUpdate();
				if(flag!=0)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateUser(OurUser user){
		try {
			if(!conn.isClosed()){
				String sql="UPDATE users SET "
						+ "loginid=?,loginpwd=?,name=?,address=?"
						+ ",phone=?,mail=? WHERE id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, user.getLoginId());
				stmt.setString(2, user.getLoginPwd());
				stmt.setString(3, user.getName());
				stmt.setString(4, user.getAddress());
				stmt.setString(5, user.getPhone());
				stmt.setString(6, user.getMail());
				stmt.setInt(7, user.getId());
				int flag=stmt.executeUpdate();
				if(flag!=0)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private OurUser getOneUser(ResultSet set) {
		OurUser user=new OurUser();
		try {
			user.setId(set.getInt("id"));
			user.setName(set.getString("name"));
			user.setLoginId(set.getString("loginid"));
			user.setLoginPwd(set.getString("loginpwd"));
			user.setAddress(set.getString("address"));
			user.setPhone(set.getString("phone"));
			user.setMail(set.getString("mail"));
			user.setUserRoleId(set.getInt("userroleid"));
			user.setUserStateId(set.getInt("userstateid"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
