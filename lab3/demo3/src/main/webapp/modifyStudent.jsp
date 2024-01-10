<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="checkLogin.jsp"%>
<jsp:useBean id="studentDao" class="com.example.demo3.dao.impl.StudentDaoImpl" scope="session"/>
<jsp:useBean id="majorDao" class="com.example.demo3.dao.impl.MajorDaoImpl" scope="session"/>
<%@ page import="com.example.demo3.entity.*,java.util.List,java.sql.Date" %>
<html>
<head>
    <title>修改学生</title>
</head>
<body>
<%  String sid=request.getParameter("sid"); %>
<%  String sname;
    char gender;
    int age;
    Date birthday;
    String mid;
    Student student = studentDao.getBySid(sid);
    sname = student.getSname();
    gender = student.getGender();
    age = student.getAge();
    birthday = student.getBirthday();
    mid = student.getMid();
%>

<form method="post" action="StudentServlet">
    <input type="hidden" name="action" value="modify">
    <table>
        <tr>
            <td>学号</td>
            <td>
                <input type="text" name="sid" id="sid" value="<%=sid%>" readonly>
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="sname" id="sname" value="<%=sname%>">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="m"<% if(gender=='m') out.print("checked = \"true\"");%>>男
                <input type="radio" name="gender" value="f"<% if(gender=='f') out.print("checked = \"true\"");%>>女
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="number" name="age" id="age" value="<%=age%>">
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="date" name="birthday" id="birthday" value="<%=birthday%>">
            </td>
        </tr>
        <tr>
            <td>专业</td>
            <td>
                <select name="mid" id="mid">
                    <%
                        List<Major> majorList = majorDao.getAll("select * from major");
                        String _mid,_mname;
                        for(Major major: majorList){
                            _mid = major.getMid();
                            _mname = major.getMname();
                    %>
                    <option value="<%=_mid%>"<% if(_mid.equals(mid)) out.print("selected = \"true\"");%>><%=_mname%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
