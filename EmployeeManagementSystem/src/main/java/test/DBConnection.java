package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
private static Connection con=null;
private DBConnection() {}
static
{
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("DBInfo.DBurl","DBInfo.uname","DBInfo.pword");
	
	}
	catch(Exception e) {e.printStackTrace();}

}
public static Connection getcon()
{
	return con;
}

}