
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*,yun.yi.Student" %>
<html>
<head>
    <title>展示所有</title>
</head>
<body>
<%
    ArrayList<Student> stulist=(ArrayList<Student>) session.getAttribute("stulist");
    for(Student stu:stulist){
%>
        <%=stu.getId()%>
        <%=stu.getName()%>
<br>
<%
    }
%>
</body>
</html>
