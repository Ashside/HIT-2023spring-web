<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="checkLogin.jsp"%>
<jsp:useBean id="studentDao" class="com.example.demo3.dao.impl.StudentDaoImpl" scope="session"/>
<jsp:useBean id="majorDao" class="com.example.demo3.dao.impl.MajorDaoImpl" scope="session"/>
<%@ page import="com.example.demo3.entity.*,java.util.List" %>

<html>
<head>
    <title>新增学生</title>
    <script>
        $(document).ready(function () {
            $("#toAdd").validate({
                rules:{
                    "sid":{
                        required:true,
                    },
                    "sname":{
                        required:true,
                    },
                    "age":{
                        required:true,
                        number:true,
                    },
                    "birthday":{
                        required:true,
                        date:true
                    }
                },
                messages:{
                    "sid":{
                        required:"学号不能为空"
                    },
                    "sname":{
                        required:"姓名不能为空"
                    },
                    "age":{
                        required:"年龄不能为空",
                        number:"年龄必须为数字",
                    },
                    "birthday":{
                        required:"生日不能为空",
                        date:"生日格式不正确"
                    }
                }
            })
        })
    </script>
</head>
<body>
<form  id= "toAdd" method="post" action="StudentServlet" >
    <input type="hidden" name="action" value="add">
    <table>
        <tr>
            <td>学号</td>
            <td>
                <input type="text" name="sid" id="sid">
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="sname" id="sname">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="m" checked>男
                <input type="radio" name="gender" value="f">女
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="number" name="age" id="age">
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="date" name="birthday" id="birthday">
            </td>
        </tr>
        <tr>
            <td>专业</td>
            <td>
                <select name="mid" id="mid">
                    <%
                        List<Major> majorList = majorDao.getAll("select * from major");
                        String mid,mname;
                        for(Major major: majorList){
                            mid = major.getMid();
                            mname = major.getMname();
                    %>
                    <option value="<%=mid%>"><%=mname%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="新增">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
