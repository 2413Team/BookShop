package com.newBookShopWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	/*
	 * 通关书的名字进行查询
	 * 暂时用在后台的查询页面，后期整合
	 */
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
	/*
	 * 通过一个关键词key来匹配书名或者作者名进行查询
	 * count一个页面的展示个数，page表示页码
	 */
	public List<Book> findBook(String key,int count,int page){
		Book book;
		List<Book> list=new ArrayList<Book>();
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM books WHERE title LIKE '%"+key+"%' OR Author LIKE '%"+key+"%'";
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet set=stmt.executeQuery(sql);
				if(page!=1)
					set.absolute((page-1)*count);
				else
					set.first();
				int i=0;
				while(set.next()&&i<count){
					book=new Book();
					book.setTitle(set.getString("Title"));
					book.setAuthor(set.getString("Author"));
					book.setUnitPrice(set.getFloat("UnitPrice"));
					list.add(book);
					i++;
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 初始化某些页面的图书信息，通过类型type进行匹配
	 * count一个页面展示的个数，page表示当前页码
	 */
	public List<Book> manybooklist(String type,int count,int page){
		Book book;
		List<Book> list=new ArrayList<Book>();
		try {
			if(!conn.isClosed()){
				String sql ="SELECT * FROM books ORDER BY "+type+" DESC";
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet set=stmt.executeQuery(sql);
				if(page!=1)
					set.absolute((page-1)*count);
				int i=0;
				while(set.next()&&i<count){
					book=new Book();
					book.setId(set.getInt("id"));
					book.setTitle(set.getString("Title"));
					book.setAuthor(set.getString("Author"));
					book.setUnitPrice(set.getFloat("UnitPrice"));
					book.setiSBN(set.getString("ISBN"));
					list.add(book);
					i++;
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 用在主页初始化三个分区的图书信息-注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意
	 * 此代码冗余，后期与manybooklist()整合
	 */
	public List<Book> indexManybooklist(String type){
		Book book;
		List<Book> list=new ArrayList<Book>();
		try {
			if(!conn.isClosed()){
				String sql ="SELECT * FROM books ORDER BY "+type+" DESC LIMIT 8";
				PreparedStatement stmt=conn.prepareStatement(sql);
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					book=new Book();
					book.setId(set.getInt("id"));
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
	/*
	 * 根据图书种类ID查询图书
	 */
	public  List<Book> getBookByCId(String catid,int count,int page){
  	  ArrayList<Book> blist=new ArrayList<Book>();
  	  Book b;
  	  try {
  		if(!conn.isClosed()){
  		  String sql="select b.* from books b,categories c where b.CategoryId=c.Id and c.Id="+catid;
  		  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  		  ResultSet set=stmt.executeQuery(sql);
  		  if(page!=1)
  			  set.absolute((page-1)*count);
  		  int i=0;
  		  while(set.next()&&i<count){
  			 b=new Book();
  			 b.setId(set.getInt("id"));
  			 b.setTitle(set.getString("Title"));
  			 b.setAuthor(set.getString("Author"));
  			 b.setUnitPrice(set.getFloat("unitPrice"));
  			 blist.add(b);
  			 i++;
	       }
  		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  return blist;
    }
	/*
	 * 根据图书出版社查询图书
	 */
	public  List<Book> getBookByPId(String pubid,int count,int page){
	  	  ArrayList<Book> blist=new ArrayList<Book>();
	  	  Book b;
	  	  try {
	  		if(!conn.isClosed()){
	  		  String sql="select b.* from books b,publishers p where b.PublisherId=p.Id and p.Id="+pubid;
	  		  Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	  		  ResultSet set=stmt.executeQuery(sql);
	  		  if(page!=1)
	  			  set.absolute((page-1)*count);
	  		  int i=0;
	  		  while(set.next()&&i<count){
	  			 b=new Book();
	  			 b.setId(set.getInt("id"));
	  			 b.setTitle(set.getString("Title"));
	  			 b.setAuthor(set.getString("Author"));
	  			 b.setUnitPrice(set.getFloat("unitPrice"));
	  			 blist.add(b);
	  			 i++;
		       }
	  		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  return blist;
	    }
	/*
	 * 获得总页码，注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意注意
	 * 并没有完成
	 */
	public int getTotalPage(int count,String type,String key,int catid){
		String sql=null;
		if(type.equals("findbook"))
			sql="SELECT * FROM books WHERE title LIKE '%"+key+"%' OR Author LIKE '%"+key+"%'";
		if(type.equals("catefindbook"))
			 sql="select b.* from books b,categories c where b.CategoryId=c.Id and c.Id="+catid;
		int total=0;
		try {
			if(!conn.isClosed()){
				Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet set=stmt.executeQuery(sql);
				while(set.next())
					total++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (total%count==0?total/count:total/count+1);
	}
}
