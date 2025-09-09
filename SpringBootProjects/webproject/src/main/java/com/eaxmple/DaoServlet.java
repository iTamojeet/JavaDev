package com.eaxmple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dao")
public class DaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String fname = req.getParameter("f");
        String lname = req.getParameter("l");
        String email = req.getParameter("email");

        SaveStudent saveStudent = new SaveStudent();
        Student stu = saveStudent.saveStudent(new Student(fname, lname, email));
        req.setAttribute("student", stu);

        req.getRequestDispatcher("display.jsp").forward(req,resp);
    }
}
