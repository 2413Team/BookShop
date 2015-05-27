package com.newBookShopWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.OurUser;

public class CartDao {
	private Connection conn;

	public CartDao() {
		try {
			conn = DataSourceProvider.getInstance().getDataSoruce()
					.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Add(OurUser user){
		if(!HaveCart(user))
			AddCart(user);
	}
	private boolean HaveCart(OurUser user){
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM carts WHERE UserId=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, user.getId());
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
	private void AddCart(OurUser user){
		try {
			if(!conn.isClosed()){
				String sql="INSERT carts VALUES(NULL,?,0)";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, user.getId());
				stmt.executeUpdate();	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
