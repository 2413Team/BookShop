package com.newBookShopWeb.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Book;
import com.newBookShopWeb.entity.Cartbook;
import com.newBookShopWeb.entity.OurUser;

public class OrderDao {
	Connection conn;
	public OrderDao(){
		try {
			conn = DataSourceProvider.getInstance().getDataSoruce()
					.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//提交订单
	public void SubmitOrder(OurUser user,Double total,List<Cartbook> cart){
		CartDao cartdao=new CartDao();
		int orderid=AddOrder(user, total);
		AddOrderBook(cart, orderid);
		cartdao.clearCart(user);
	}
	//得到购物车的方法
		public List<Cartbook> getOrder(int userid){
			System.out.println("0");
			List<Cartbook> cart=new ArrayList<Cartbook>();
			System.out.println("2");
			cart=getOrderBook1(userid);
			System.out.println("size:"+cart.size());
			System.out.println("3");
			cart=getOrderBook2(cart);
			System.out.println("4");
			return cart;
		}
	/*
	 * 该方法执行插入一个订单的操作，但是每次插入都是一个单独的订单
	 * 不能通过修改订单来完成操作，提交后不能再次修改。
	 * 1，插入一个空的订单
	 * 2，得到插入订单的id
	 */
	private int AddOrder(OurUser user,Double total){
		int orderid=0;
		try {
			if(!conn.isClosed()){
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				CallableStatement stmt=conn.prepareCall("CALL pro_insertorder(?,?,?)");
				stmt.setString(1, sdf.format(date));
				stmt.setInt(2, user.getId());
				stmt.setDouble(3, total);
				stmt.executeUpdate();
				
				System.out.println("执行完插入一个订单的操作");
				String sql="SELECT * FROM orders WHERE UserId=? ORDER BY OrderDate DESC";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, user.getId());
				ResultSet set=pstmt.executeQuery();
				if(set.next()){
					orderid=set.getInt("id");
				}
				System.out.println("执行完查询订单ID的操作："+orderid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderid;
	}
	/*
	 * 完成新插入订单对应的详细内容
	 * 插入时为bookid而非bookisbn
	 */
	private void AddOrderBook(List<Cartbook> cart,int orderid){
		String sql;
		try {
			if(!conn.isClosed()){
				for(int i=0;i<cart.size();i++){
					sql="CALL pro_insertobook(?,?,?,?)";
					CallableStatement stmt=conn.prepareCall(sql);
					stmt.setInt(1, orderid);
					stmt.setInt(2, cart.get(i).getBook().getId());
					stmt.setInt(3, cart.get(i).getQuantity());
					stmt.setDouble(4, cart.get(i).getBook().getUnitPrice());
					stmt.executeUpdate();
				}
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
	
	private List<Cartbook> getOrderBook2(List<Cartbook> cart){
		Book book;
		try {
			if(!conn.isClosed()){
				for(int i=0;i<cart.size();i++){
					String sql="SELECT * FROM books WHERE books.id=?";
					PreparedStatement stmt=conn.prepareStatement(sql);
					stmt.setInt(1, cart.get(i).getBookid());
					ResultSet set=stmt.executeQuery();
					if(set.next()){
						book=new Book();
						book=getOneBook(set);
						System.out.println(book.getTitle());
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
	
	private List<Cartbook> getOrderBook1(int userid){
		List<Cartbook> cart=new ArrayList<Cartbook>();
		try {
			if(!conn.isClosed()){
				String sql="SELECT ob.BookID,ob.Quantity,ob.Id FROM orders o,orderbook ob WHERE o.UserId=? AND ob.OrderID=o.Id";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, userid);
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					Cartbook cartbook=new Cartbook();
					cartbook.setQuantity(set.getInt("Quantity"));
					cartbook.setId(set.getInt("id"));
					cartbook.setBookid(set.getInt("bookid"));
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
}
