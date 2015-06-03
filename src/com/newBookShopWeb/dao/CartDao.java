package com.newBookShopWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Book;
import com.newBookShopWeb.entity.Cart;
import com.newBookShopWeb.entity.Cartbook;
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
	//添加购物车的方法
	public int Add(OurUser user){
		int cartId;
		cartId=HaveCart(user);
		if(cartId==0)
			AddCart(user);
		cartId=HaveCart(user);
		return cartId;
	}
	//添加购物车中的图书
	public void AddBook(int cartId,String bookISBN,String Quantity,String unitprice){
		AddCartBook(cartId, bookISBN, Quantity, unitprice);
		UpdateCartDao(cartId);
	}
	//得到购物车的方法
	public List<Cartbook> getCart(int userid){
		List<Cartbook> cart=new ArrayList<Cartbook>();
		cart=getCartBook1(userid);
		cart=getCartBook2(cart);
		return cart;
	}
	//数量增加
	public void QuantityUp(String cartbookid){
		try {
			if(!conn.isClosed()){
				String sql="UPDATE cartbook SET cartbook.Quantity=cartbook.Quantity+1 WHERE Id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, cartbookid);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//数量减少
	public void QuantityDown(String cartbookid){
		try {
			if(!conn.isClosed()){
				String sql="UPDATE cartbook SET cartbook.Quantity=cartbook.Quantity-1 WHERE Id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, cartbookid);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//得到总价
	public Double GetCartTotal(OurUser user){
		int cartId=HaveCart(user);
		Double total=0.0;
		try {
			if(!conn.isClosed()){
				String sql="SELECT SUM(cb.UnitPrice*cb.Quantity) FROM cartbook cb WHERE cb.CartsId=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, cartId);
				ResultSet set=stmt.executeQuery();
				if(set.next()){
					total=set.getDouble(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	//按照图书的isbn来删除图书
	public void deleteCartBook(String bookISBN,OurUser user){
		try {
			if(!conn.isClosed()){
				String sql="DELETE FROM cartbook WHERE cartbook.bookISBN=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, bookISBN);
				stmt.executeUpdate();
				int cartId=HaveCart(user);
				UpdateCartDao(cartId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearCart(OurUser user){
		int cartId;
		try {
			if(!conn.isClosed()){
				String sql="DELETE FROM cartbook WHERE cartbook.CartsId = (SELECT carts.Id FROM carts WHERE carts.UserId=? AND carts.Id=cartbook.CartsId)";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, user.getId());
				stmt.executeUpdate();
				cartId=HaveCart(user);
				sql="DELETE FROM carts WHERE carts.Id =?";
				stmt=conn.prepareStatement(sql);
				stmt.setInt(1, cartId);
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private List<Cartbook> getCartBook2(List<Cartbook> cart){
		Book book;
		try {
			if(!conn.isClosed()){
				for(int i=0;i<cart.size();i++){
					String sql="SELECT * FROM books WHERE books.ISBN=?";
					PreparedStatement stmt=conn.prepareStatement(sql);
					stmt.setString(1, cart.get(i).getBookISBN());
					ResultSet set=stmt.executeQuery();
					if(set.next()){
						book=new Book();
						book=getOneBook(set);
						cart.get(i).setBook(book);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}
	
	private List<Cartbook> getCartBook1(int userid){
		List<Cartbook> cart=new ArrayList<Cartbook>();
		try {
			if(!conn.isClosed()){
				String sql="SELECT cb.bookISBN,cb.Quantity,cb.Id FROM carts c,cartbook cb WHERE c.UserId=? AND cb.CartsId=c.Id";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, userid);
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					Cartbook cartbook=new Cartbook();
					cartbook.setBookISBN(set.getString("bookISBN"));
					cartbook.setQuantity(set.getInt("Quantity"));
					cartbook.setId(set.getInt("id"));
					cart.add(cartbook);
				}
				return cart;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
				stmt.setDouble(4, Double.parseDouble(unitprice));
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
				String sql="UPDATE carts c SET c.TotalPrice=(SELECT SUM(cb.UnitPrice*cb.Quantity) FROM cartbook cb WHERE cb.CartsId=c.Id)"+
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
	
	private Book getOneBook(ResultSet set) {
		Book book = new Book();
		try {
			book.setId(set.getInt("id"));
			book.setTitle(set.getString("Title"));
			book.setAuthor(set.getString("Author"));
			book.setPublisherId(set.getInt("PublisherId"));
			book.setPublisherDate(set.getString("PublishDate"));
			book.setiSBN(set.getString("ISBN"));
			book.setWordsCount(set.getInt("WordsCount"));
			book.setUnitPrice(set.getFloat("UnitPrice"));
			book.setContentDescription(set.getString("ContentDescription"));
			book.setAurhorDescription(set.getString("AurhorDescription"));
			book.setEditorComment(set.getString("EditorComment"));
			book.settOc(set.getString("TOC"));
			book.setCategoryId(set.getInt("CategoryId"));
			book.setClicks(set.getInt("Clicks"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
}
