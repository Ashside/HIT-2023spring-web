package com.example.demo3.action;

import com.example.demo3.dao.StudentDao;
import com.example.demo3.dao.impl.StudentDaoImpl;
import com.example.demo3.entity.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        StudentDao studentDao = new StudentDaoImpl();
        if(action.equals("add")){
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            char gender = request.getParameter("gender").charAt(0);
            int age = Integer.parseInt(request.getParameter("age"));
            java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
            String mid = request.getParameter("mid");
            studentDao.add(new Student(sid,sname, gender, age, birthday, mid));
        } else if (action.equals("modify")) {
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            char gender = request.getParameter("gender").charAt(0);
            int age = Integer.parseInt(request.getParameter("age"));
            java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
            String mid = request.getParameter("mid");
            studentDao.modify(new Student(sid,sname, gender, age, birthday, mid));
        } else if (action.equals("remove")) {
            studentDao.remove(request.getParameter("sid"));
        }
        response.sendRedirect("student.jsp");
    }
}
