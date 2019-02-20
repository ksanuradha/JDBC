package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListProducts {
	public static void main(String[] args) {
		try
		{
		//register driver
		Class.forName("oracle.jdbc.OracleDriver");
		//create connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		//create statement object
		Statement st=con.createStatement();
		//execute your sql statement
		ResultSet rs=st.executeQuery("Select * from Product");
			
		//process result set
		while(rs.next())
		{
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getDouble(3));
		}
		//close connection
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
