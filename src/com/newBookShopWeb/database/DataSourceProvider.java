package com.newBookShopWeb.database;

import javax.sql.DataSource;
/*
 * ��db.properties��ȡ���ݿ����ӵ�˵��
 */
public class DataSourceProvider {
	private DataSource ds;
	private static DataSourceProvider instance;
	private DataSourceProvider(){	
	}
	public static DataSourceProvider getInstance(){
		if(instance==null)
			instance=new DataSourceProvider();
		return instance;
	}
	public void initDataSource(DataSource ds){
		this.ds=ds;
	}
	public DataSource getDataSoruce(){
		return ds;
	}
}
