package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;

/* 
Only (public) 0 args cons allowed 
tightly couples as it extends HttpServlet
u must override doGet() and doPost() methods
main() won't help you to create web apps
servlet lifecycle will be followed
static ---> cons ---> init()(1) ---> doGet()(n) ---> destroy()
*/
@WebServlet("/mango")
public class Info extends HttpServlet
{
    static {
        IO.println("I am static block!!!");
    }
    public Info(){
        IO.println("I am 0 args constructor!!!");
    }
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
        IO.println("Thread is: "+Thread.currentThread().getName());
		pw.println("<body bgcolor='orange' text='purple'><h1>I am Servlet!!!</h1></body>");
		pw.close();
	}
    public void destroy(){
        IO.println("I am destroy!!!!");
    }
}