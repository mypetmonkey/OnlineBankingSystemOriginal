package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {
	public static void main(String[] args) throws Throwable {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//establish/create a connecton
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		//create a statement
		Statement st = con.createStatement();
		//execute the statement or quary and store it in result set
		ResultSet res = st.executeQuery("select CUST_NAME from OBS;");
		while(res.next()) {
			String name = res.getString("CUST_NAME");
			System.out.println(name);
			
		}
		con.close();     
	}

}
