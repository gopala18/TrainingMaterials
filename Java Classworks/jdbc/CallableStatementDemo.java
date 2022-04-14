package com.csscorp.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementDemo {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			//Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123Welcome");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//{call procedureName(parameters)}
		CallableStatement cs=con.prepareCall("{?=call insertEmployee(?,?,?)}");
		cs.registerOutParameter(1, Types.BOOLEAN);
		cs.setInt(2, 222);
		cs.setString(3, "Prakash");
		Date date=new Date(new java.util.Date().getTime());
		//cs.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
		cs.setDate(4, date);
		cs.execute();
		System.out.println(cs.getBoolean(1));
		con.close();
	}
}
