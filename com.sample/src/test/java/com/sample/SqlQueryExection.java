package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SqlQueryExection {

	public static void main(String[] args) throws SQLException {
Connection con=null;
//create instance for mysql driver
Driver driver=new Driver();
//register the driver
DriverManager.registerDriver(driver);
//get the connection
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
//create statement and query
Statement state = con.createStatement();
String query="select * from demo;";
//execute query
ResultSet result = state.executeQuery(query);
while(result.next())
{
	System.out.println(result.getString(1));
}


con.close();
	}

}
