package com.cg.util;
import java.sql.*;
public class jdbcex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/empdb";
		String user="root";
		String password="root";
		
		
		try {
			Connection con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null) {
			
			String q="select * from employee";
			try {
				Statement stmt=con.createStatement();
				 ResultSet rs=stmt.executeQuery(q);
				 while(rs.next()) {
					 System.out.println(rs.getString(1)+" "+rs.getString(2)
					 +" "+ rs.getString(3)+" "+rs.getString(4));
				 }
				 
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			       
			
		}
		else {
			System.out.println("Not Connected");
		}
		
		
		
	}

}
