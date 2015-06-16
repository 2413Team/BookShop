package com.newBookShopWeb.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Book;

public class AdminBookDao {
	Connection conn;
	public AdminBookDao() {
		try {
			conn = DataSourceProvider.getInstance().getDataSoruce()
					.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertBook(Book b){
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd"); 
		String date=fmt.format(new Date());
  	  try {
			if (!conn.isClosed()) {
				PreparedStatement stmt;
				String sql="INSERT INTO books VALUE(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, b.getTitle());
				stmt.setString(2, b.getAuthor());
				stmt.setInt(3,2);
				stmt.setString(4, date);
				stmt.setString(5, b.getiSBN());
				stmt.setInt(6,b.getWordsCount());
				stmt.setDouble(7, b.getUnitPrice());
				stmt.setString(8, b.getContentDescription());
				stmt.setString(9, b.getAurhorDescription());
				stmt.setString(10, b.getEditorComment());
				stmt.setString(11, b.gettOc());
				stmt.setInt(12,28);
				stmt.setInt(13,0);
				int what = stmt.executeUpdate();
				if(what!= 0){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteBook(Book book){
		try {
			if(!conn.isClosed()){
				String sql="DELETE FROM books WHERE id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, book.getId());
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
	
	public boolean updateBook(Book b){
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd"); 
		String date=fmt.format(new Date());
	  try {
			if (!conn.isClosed()) {
				String sql="UPDATE books SET "
						+ "Title=?,"
						+ "Author=?,"
						+ "PublisherId=?,"
						+ "PublishDate=?,"
						+ "ISBN=?,"
						+ "WordsCount=?,"
						+ "UnitPrice=?,"
						+ "ContentDescription=?,"
						+ "AurhorDescription=?,"
						+ "EditorComment=?,"
						+ "TOC=?,"
						+ "CategoryId=?,"
						+ "Clicks=? "
						+ "WHERE Id=?;";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, b.getTitle());
				stmt.setString(2, b.getAuthor());
				stmt.setInt(3,2);
				stmt.setString(4, date);
				stmt.setString(5, b.getiSBN());
				stmt.setInt(6,b.getWordsCount());
				stmt.setDouble(7, b.getUnitPrice());
				stmt.setString(8, b.getContentDescription());
				stmt.setString(9, b.getAurhorDescription());
				stmt.setString(10, b.getEditorComment());
				stmt.setString(11, b.gettOc());
				stmt.setInt(12,28);
				stmt.setInt(13,0);
				stmt.setInt(14, b.getId());
				int what = stmt.executeUpdate();
				if(what!=0)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
