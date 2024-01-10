<%@ page import="com.example.demo3.entity.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Admin admin = session.getAttribute("admin") == null ? null : (Admin) session.getAttribute("admin");
    if(admin==null){
        out.print("非法用户，请<a href=\"login.jsp\">登录</a>");
        return;
    }
%>