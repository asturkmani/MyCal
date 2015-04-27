package projecttrial1;

import java.sql.*;

public class sqltrial2 {

	public static void main(String[] args) {
		//SQL Part
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			conn = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			stmt = conn.createStatement();
			//rs = stmt.executeQuery("select * from user");
			
			while(rs.next())
			{
				System.out.println(rs.getString(3));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return;
		}
		
		
	
	
	}

	}


