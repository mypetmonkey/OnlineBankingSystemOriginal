package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.GenericUtilities.IPathConstantUtilities.IPathConstants;
import com.mysql.jdbc.Driver;

public class DatabaseUtilities {
	Connection con=null;
	
	//method to connect with db
	/**
	 * This method is register with database
	 * @throws Throwable
	 * @author rajhans
	 */
	public void connectTodb() throws Throwable{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection(IPathConstants.dburl,IPathConstants.dbun,IPathConstants.dbpwd);
		
	}
	//method to execute quary
	public String executeQuaryToGetData(String query,String expData,int columnIndex) throws Throwable    {
		
		ResultSet res = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(res.next()) {
			String data = res.getString(columnIndex);
			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) 
			System.out.println("data is verified");
		else 
			System.out.println("data is not verified");
		return expData;
		
	}
	//method to close connection with database
	public void closedb() throws Throwable {
		
		con.close();
		System.out.println("database connection closed");
	}

}
