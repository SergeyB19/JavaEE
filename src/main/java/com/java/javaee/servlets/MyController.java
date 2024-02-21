package com.java.javaee.servlets;

import com.java.javaee.jsp.MyModel;
import com.java.javaee.jsp.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MyController")
public class MyController extends HttpServlet {
    MyModel myModel = new MyModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = myModel.getStudent();
        req.setAttribute("Student", student);
        req.getSession().setAttribute("Student", student);
        req.getServletContext().setAttribute("Student", student);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/MyView.jsp");
        requestDispatcher.forward(req,resp);
    }
}
