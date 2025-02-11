package com.cg.demo;
import java.sql.*;
import java.util.*;

import com.cg.util.JdbcUtil;
public class demobatch {

public static void main(String[] args) {
		
		Connection con=JdbcUtil.getConnection();
		PreparedStatement pstmt=null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSetMetaData mrs=null;
		try {
			if(con!=null) {
			String query="insert into employee values(?,?,?,?)";
			pstmt=con.prepareStatement(query);
			String s;
			Scanner sc=new Scanner(System.in);
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from employee");
			mrs=rs.getMetaData();
			System.out.println("enter yes to add new data");
			s=sc.nextLine();
			int r=0;
			
			con.setAutoCommit(false);			
			while(s.equals("yes")) {
				System.out.println("enter "+mrs.getColumnName(1));
				pstmt.setInt(1,sc.nextInt());
				sc.nextLine();
				System.out.println("enter "+mrs.getColumnName(2));
				pstmt.setString(2,sc.nextLine());
				System.out.println("enter "+mrs.getColumnName(3));
				pstmt.setString(3,sc.nextLine());
				System.out.println("enter "+mrs.getColumnName(4));
				pstmt.setInt(4,sc.nextInt());
				sc.nextLine();
				pstmt.addBatch();
				System.out.println("enter yes to add new data");
				s=sc.nextLine();
			}
			
			int rst[]=pstmt.executeBatch();
			int j=1;
			for(int i:rst) {
				if(i==1) {
				System.out.println("record "+ j+" is ecexuted");
				}
				else {
					System.out.println("record "+ j+" is not ecexuted");
				}
			}
			con.commit();
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
				pstmt.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

}
