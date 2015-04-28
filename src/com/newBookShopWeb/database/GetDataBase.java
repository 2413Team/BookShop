package com.newBookShopWeb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 *********************************************************被DataSourceProvider顶替*********************************************************************
 */
public class GetDataBase {
	Properties p;
	String driverName,url;
	String userName,pwd;
	//初始化数据库的一些信息
	public GetDataBase(){
		p=new Properties();
		try{
			p.load(GetDataBase.class.getResourceAsStream("db.properties"));
			driverName=p.getProperty("driverName");
			url=p.getProperty("url");
			userName=p.getProperty("userName");
			pwd=p.getProperty("pwd");
			Class.forName(driverName);
		}
		catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//获得链接
	public Connection getConnection(){
		try{
			Connection conn=DriverManager.getConnection(url,userName,pwd);
			return conn;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	//关闭链接
	public void closeConnection(){
		this.closeConnection();
	}
}
