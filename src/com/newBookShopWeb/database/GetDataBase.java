package com.newBookShopWeb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 *********************************************************��DataSourceProvider����*********************************************************************
 */
public class GetDataBase {
	Properties p;
	String driverName,url;
	String userName,pwd;
	//��ʼ�����ݿ��һЩ��Ϣ
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
	//�������
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
	//�ر�����
	public void closeConnection(){
		this.closeConnection();
	}
}
