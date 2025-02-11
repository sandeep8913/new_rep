package com.cg.demo;
import java.sql.*;
public class JdbcDemo {

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
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(url,user,password);
			if(con!=null) {
			stmt=con.createStatement();
			String query="select*from employee";
			rs=stmt.executeQuery(query);
			
			//this is for knowing meta data of our resultset
			ResultSetMetaData rsm=rs.getMetaData();
			int c=rsm.getColumnCount();
			int n=1;
			System.out.println();
			while(rs.next()) {
				System.out.println("Record"+ n++ +":");
				for(int i=1;i<=c;i++) {
					System.out.print(rsm.getColumnName(i)+"->"+rs.getString(i)+"  ");
				}
				System.out.println();
				
			}
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
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
