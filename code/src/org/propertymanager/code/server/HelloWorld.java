package org.propertymanager.code.server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;


public class HelloWorld {
	public static void main(String args[]){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		try{
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/sakila?user=testuser&password=test");//,"testuser","test");
			System.out.println(conn);
			ps = (PreparedStatement) conn.prepareStatement("select * from actor");
			rs = ps.executeQuery();
			if(rs!=null && rs.next()){
				System.out.println(rs.getString(2));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			if(rs!=null){
			rs.close();
			}
			if(ps!=null){
				ps.close();
				}
			if(conn!=null){
				conn.close();
				}
			}catch(Exception ex){
				
			}
		}
			
	}
	 

}
