package com.csscorp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		Connection con=null;
	/*	try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		try {
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test","postgres","123Welcome");
		} catch (SQLException e) {
				e.printStackTrace();
		}
		Statement stmt=null;
		try{
			stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from employee");
			//[0]  --- resultset  rs.next();
			//[1][2].... query result
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString("designation"));
				System.out.println(rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
