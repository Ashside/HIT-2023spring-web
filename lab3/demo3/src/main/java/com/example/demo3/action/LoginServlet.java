package com.example.demo3.action;

import com.example.demo3.dao.LoginDao;
import com.example.demo3.dao.impl.LoginDaoImpl;
import com.example.demo3.entity.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String uid= request.getParameter("uid");
        String pwd = request.getParameter("pwd");
        LoginDao loginDao = new LoginDaoImpl();
        if(loginDao.login(uid, pwd)){
            HttpSession session= request.getSession();
            session.setAttribute("admin", new Admin(uid, pwd));
            String rememberMe=request.getParameter("remember");
            if(rememberMe!=null&&rememberMe.equals("1")){
                Cookie cookie = new Cookie("admin",uid);
                cookie.setMaxAge(60);
                response.addCookie(cookie);
            }
            response.sendRedirect("student.jsp");
        }else {
            PrintWriter out = response.getWriter();
            out.print("非法用户，请<a href=\"login.jsp\">登录</a>");
        }
    }
}
