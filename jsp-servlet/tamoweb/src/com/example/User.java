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
@WebServlet("/user")
public class User extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        IO.println("Thread is: " + Thread.currentThread().getName());
        String name = request.getParameter("t1");
        String address = request.getParameter("t2");
        String email = request.getParameter("t3");
        String pass = request.getParameter("t4");
        String skills[] = request.getParameterValues("s");

        StringBuffer sf = new StringBuffer("");
        sf.append(name);
        sf.append("\n"+address);
        sf.append("\n"+email);
        sf.append("\n"+pass);
        
        pw.println("<h2>User info:- "+sf+"</h2><br><br>");

        for(String i : skills){
            pw.println("<h2>User skill:- "+i+"</h2><br><br>");
        }
        pw.close();
    }
}