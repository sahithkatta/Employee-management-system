package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet 
{
protected void dopost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
{
	HttpSession hs=req.getSession(false);//Accessing existing session
	if(hs==null) 
	{
		req.setAttribute("msg", "session Expired");
		req.getRequestDispatcher("msg.jsp").forward(req, res);
	
	}
	else
	{
		EmployeeBean eb=new EmployeeBean();
		eb.setEid( (String) req.getAttribute("eid"));
		eb.setEname((String) req.getAttribute("ename"));
		eb.setEdesg((String) req.getAttribute("edesg"));
		int bsal=(Integer)req.getAttribute("bsal");
		float h=(float)req.getAttribute("hra");
		float d=(float)req.getAttribute("da");
		float hra=(float)(h*bsal);
		float da=(float)(d*bsal);
		float totsal=bsal+hra+da;
		eb.setTotsal(totsal);
		int k=new AddEmployeeDAO().insert(eb);
		if(k>0)
		{
			req.setAttribute("msg", "Employee Added successfully");
			req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
			
		}
		
	}
}
	
	
	
}
