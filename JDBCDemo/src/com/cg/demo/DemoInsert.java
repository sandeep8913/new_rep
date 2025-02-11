package com.cg.demo;
import java.sql.*;
import com.cg.util.*;
public class DemoInsert {

	public static void main(String[] args) {
		
		
		try {
			Connection con=JdbcUtil.getConnection();
			if(con!=null) {
			String query="insert into employee values(105,'apple','apple@gmail.com',5600)";
			Statement st=con.createStatement();
			int r=st.executeUpdate(query);
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
