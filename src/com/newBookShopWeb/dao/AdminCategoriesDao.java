package com.newBookShopWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Categories;

public class AdminCategoriesDao {
	private Connection conn;
	public AdminCategoriesDao(){
		try {
			conn = DataSourceProvider.getInstance().getDataSoruce()
					.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertCategories(String categoriesName,int categoriesId){
		try {
			if(!conn.isClosed()){
				String sql="INSERT INTO categories value(?,?)";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, categoriesId);
				stmt.setString(2, categoriesName);
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
	
	public boolean deleteCategories(int categoriesId){
		try {
			if(!conn.isClosed()){
				String sql="DELETE FROM categories WHERE id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, categoriesId);
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
	
	public boolean updateCategories(int categoriesId,String categoriesName){
		try {
			if(!conn.isClosed()){
				String sql="UPDATE categories SET name=? WHERE id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, categoriesName);
				stmt.setInt(2, categoriesId);
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
	
	
	public Categories getCategories(int categoriesId){
		Categories categories=null;
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM categories WHERE id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, categoriesId);
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					categories=new Categories();
					categories.setId(set.getInt("id"));
					categories.setName(set.getString("name"));
				}
				return categories;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Categories> getCategoriesList(int categoriesId){
		List<Categories> list=new ArrayList<Categories>();
		try {
			if(!conn.isClosed()){
				String sql="SELECT * FROM categories WHERE id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, categoriesId);
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					Categories categories=new Categories();
					categories=new Categories();
					categories.setId(set.getInt("id"));
					categories.setName(set.getString("name"));
					list.add(categories);
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
