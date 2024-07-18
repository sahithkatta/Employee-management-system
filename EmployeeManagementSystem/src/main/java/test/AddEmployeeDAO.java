package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmployeeDAO 
{
public int k=0;
public int insert(EmployeeBean eb)
{
	try
	{
		Connection con=DBConnection.getcon();
		PreparedStatement ps=con.prepareStatement("insert into Employee59 values(?,?,?,?,?,?,?)");
		ps.setString(1, eb.getEid());
		ps.setString(2,eb.getEname() );
		ps.setString(3,eb.getEdesg());
		ps.setInt(4,eb.getBsal());
		ps.setFloat(5, eb.getHra());
		ps.setFloat(6, eb.getDa());
		ps.setFloat(7, eb.getTotsal());
		k=ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	return k;
}
}
