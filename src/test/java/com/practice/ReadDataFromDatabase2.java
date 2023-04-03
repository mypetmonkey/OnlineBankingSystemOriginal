package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase2 {
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			Statement state = con.createStatement();
			String quary="select * from OBS;";
			ResultSet result = state.executeQuery(quary);
			
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
			}
			
		}catch(Exception e) {
			
		}
		finally {
			con.close();
		}
		
	}
}
