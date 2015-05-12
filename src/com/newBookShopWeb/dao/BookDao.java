package com.newBookShopWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;
import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Book;

public class BookDao {
	private Connection conn;
	public BookDao(){
		try {
			conn=DataSourceProvider.getInstance().getDataSoruce().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Book> getBookByName(String name){
		Book book;
		List<Book> list=new ArrayList<Book>();
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM books WHERE title like ?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, "%"+name+"%");
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					book=new Book();
					book.setTitle(set.getString("Title"));
					book.setAuthor(set.getString("Author"));
					book.setUnitPrice(set.getFloat("UnitPrice"));
					list.add(book);
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Book> findBook(String key){
		Book book;
		List<Book> list=new ArrayList<Book>();
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM books WHERE title LIKE ? OR Author LIKE ? LIMIT 12";
				System.out.println(sql+"key:"+key);
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, "%"+key+"%");
				stmt.setString(2, "%"+key+"%");
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					book=new Book();
					book.setTitle(set.getString("Title"));
					book.setAuthor(set.getString("Author"));
					book.setUnitPrice(set.getFloat("UnitPrice"));
					list.add(book);
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Book> manybooklist(String type){
		Book book;
		List<Book> list=new ArrayList<Book>();
		try {
			if(!conn.isClosed()){
				String sql ="SELECT * FROM books ORDER BY "+type+" DESC LIMIT 12";
				PreparedStatement stmt=conn.prepareStatement(sql);
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					book=new Book();
					book.setTitle(set.getString("Title"));
					book.setAuthor(set.getString("Author"));
					book.setUnitPrice(set.getFloat("UnitPrice"));
					book.setiSBN(set.getString("ISBN"));
					list.add(book);
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
