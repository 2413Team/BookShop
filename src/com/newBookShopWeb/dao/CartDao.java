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
	
	public int Add(OurUser user){
		int cartId;
		cartId=HaveCart(user);
		if(cartId==0)
			AddCart(user);
		cartId=HaveCart(user);
		return cartId;
	}
	public void AddBook(int cartId,String bookISBN,String Quantity,String unitprice){
		AddCartBook(cartId, bookISBN, Quantity, unitprice);
	}
	public void UpdateCart(int cartId){
		UpdateCartDao(cartId);
	}
	
	
	private int HaveCart(OurUser user){
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM carts WHERE UserId=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, user.getId());
				ResultSet set=stmt.executeQuery();
				if(set.next()){
					int cartId=set.getInt("id");
					return cartId;
				}					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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
	private void AddCartBook(int cartId,String bookISBN,String Quantity,String unitprice){
		try {
			if(!conn.isClosed()){
				String sql="INSERT INTO cartbook VALUES(null,?,?,?,?)";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, cartId);
				stmt.setString(2, bookISBN);
				stmt.setInt(3, Integer.parseInt(Quantity));
				stmt.setDouble(4, Double.parseDouble(Quantity)*Double.parseDouble(unitprice));
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void UpdateCartDao(int cartId){
		try {
			if(!conn.isClosed()){
				String sql="UPDATE carts c SET c.TotalPrice=(SELECT SUM(cb.UnitPrice) FROM cartbook cb WHERE cb.CartsId=c.Id)"+
							"WHERE c.Id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, cartId);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
