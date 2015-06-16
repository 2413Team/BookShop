package com.newBookShopWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newBookShopWeb.database.DataSourceProvider;
import com.newBookShopWeb.entity.Categories;
public class CategoriesDao{
	private List<Categories> list;
	Connection conn;
	public CategoriesDao(){
		try {
			conn=DataSourceProvider.getInstance().getDataSoruce().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 获得所有的图书种类
	 */
	public List<Categories> getCategories(){
		Categories cat;
		list=new ArrayList<Categories>();
		try {
			if(!conn.isClosed()){
				String sql ="SELECT * FROM categories  LIMIT 18";
				PreparedStatement stmt=conn.prepareStatement(sql);
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					cat=new Categories();
					cat.setId(set.getInt("id"));
					cat.setName(set.getString("name"));
					list.add(cat);
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Categories> getCategoriesForAdmin(String key){
		Categories cat;
		list=new ArrayList<Categories>();
		try {
			if(!conn.isClosed()){
				String sql ="SELECT * FROM categories WHERE name LIKE ?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, "%"+key+"%");
				ResultSet set=stmt.executeQuery();
				while(set.next()){
					cat=new Categories();
					cat.setId(set.getInt("id"));
					cat.setName(set.getString("name"));
					list.add(cat);
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
