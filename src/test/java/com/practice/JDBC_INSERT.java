package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_INSERT {
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		int res = 0;
		try {
			
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement state = con.createStatement();
		String quary="insert into OBS values('sidhu',57,'punjab',234323465,null);";
		res = state.executeUpdate(quary);
		     
		 
		}catch(Exception e) {
			
		}
		finally {
			if(res==1) {
				System.out.println("updated");
			}
			else {
				System.err.println("not updated");
			}
		}
		con.close();
	}

}
