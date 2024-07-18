package test;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings({ "serial", "unused" })
@WebServlet("/Alog")
public class AdminLoginServlet extends HttpServlet
{
protected void dopost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
String un=req.getParameter("uname");
String pw=req.getParameter("pword");
AdminLoginDAO DAO=new AdminLoginDAO();
AdminBean ab=DAO.login(un,pw);
if(ab==null)
{
	req.setAttribute("msg","invalid login process");
    req.getRequestDispatcher("msg.jsp").forward(req,res);;

}
else
{
	 HttpSession hs=req.getSession();
	 hs.setAttribute("ubean",ab);
	 req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
}

}
}
