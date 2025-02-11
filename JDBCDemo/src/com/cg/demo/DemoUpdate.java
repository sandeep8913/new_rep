package com.cg.demo;
import java.sql.*;
public class DemoUpdate {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/empdb";
		String user="root";
		String password="root";
		Connection con=null;
		Statement stmt=null;
		
		try {
			con=DriverManager.getConnection(url,user,password);
			if(con!=null) {
			stmt=con.createStatement();
			String query="update employee set salary=salary+100 where salary<3000";
			int r=stmt.executeUpdate(query);
			System.out.println("no of rows affected: "+r);
			}
			else {
				System.out.println("Connection Failed");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
