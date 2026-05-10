package com.example;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


public class Test extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<body bgcolor='red' text='yellow'><h1>I am Servlet!!!</h1></body>");
		pw.close();
	}
}