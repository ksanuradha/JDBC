package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InsertProduct2 {
	public static void main(String[] args) {
		try
		{
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
		Scanner sc=new Scanner(System.in);
		int pid; String desc; double price;
		System.out.println("Enter new product id, description and price: ");
		pid=sc.nextInt(); desc=sc.next(); price=sc.nextDouble();
		
		String sql="Insert into product values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,pid);
		pst.setString(2,desc);
		pst.setDouble(3,price);
		int x=pst.executeUpdate();
		System.out.println(x+" Record(s) inserted successfuly");
		
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	 }
}
