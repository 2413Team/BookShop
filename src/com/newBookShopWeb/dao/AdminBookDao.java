package com.newBookShopWeb.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
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
				CallableStatement stmt;
				stmt = conn.prepareCall("{call pro_binsert(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				stmt.setString(1, b.getTitle());
				stmt.setString(2, b.getAuthor());
				stmt.setInt(3,2);
				stmt.setString(4, date);
				stmt.setString(5, b.getiSBN());
				stmt.setInt(b.getWordsCount(), 6);
				stmt.setDouble(7, b.getUnitPrice());
				stmt.setString(8, b.getContentDescription());
				stmt.setString(9, b.getAurhorDescription());
				stmt.setString(10, b.getEditorComment());
				stmt.setString(11, b.gettOc());
				stmt.setInt(12,28);
				stmt.setInt(13,0);
				int what = stmt.executeUpdate();
				if(what!= 0)
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
				CallableStatement stmt;
				stmt = conn	.prepareCall("{call pro_bupdate(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				stmt.setString(1, b.getTitle());
				stmt.setString(2, b.getAuthor());
				stmt.setInt(b.getPublisherId(), 3);
				stmt.setString(4, date);
				stmt.setString(5, b.getiSBN());
				stmt.setInt(b.getWordsCount(), 6);
				stmt.setDouble(7, b.getUnitPrice());
				stmt.setString(8, b.getContentDescription());
				stmt.setString(9, b.getAurhorDescription());
				stmt.setString(10, b.getEditorComment());
				stmt.setString(11, b.gettOc());
				stmt.setInt(b.getCategoryId(), 12);
				stmt.setInt(b.getClicks(), 13);
				stmt.setInt(b.getId(), 14);
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
