package com.cg.demo;
import java.sql.*;
public class DemoDelete {

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
			String query="delete from employee where empno=101";
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
