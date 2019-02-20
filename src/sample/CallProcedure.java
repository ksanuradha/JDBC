package sample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class CallProcedure {
	
	public static void main(String[] args) {
		try
		{
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
		Scanner sc=new Scanner(System.in);
		int pid; String desc; double price;
		System.out.println("Enter product id: ");
		pid=sc.nextInt();
		
		CallableStatement cst=con.prepareCall("{call getProduct(?,?,?)}");
		cst.setInt(1,pid);
		cst.registerOutParameter(2,Types.VARCHAR);
		cst.registerOutParameter(3, Types.DOUBLE);
		
		cst.executeUpdate();
		desc=cst.getString(2);
		price=cst.getDouble(3);
		
		System.out.println(desc);
		System.out.println(price);
		
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
