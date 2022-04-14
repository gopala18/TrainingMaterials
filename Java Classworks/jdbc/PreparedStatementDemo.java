package com.csscorp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class PreparedStatementDemo {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123Welcome");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		PreparedStatement ps=con.prepareStatement("INSERT INTO Employee VALUES(?,?,?)");
		ps.setInt(1, 123);
		ps.setString(2, "Gopi");
		ps.setDate(3, new java.sql.Date(new Date().getTime()));
		
		System.out.println(ps.execute());
		
		con.close();
	}
}
