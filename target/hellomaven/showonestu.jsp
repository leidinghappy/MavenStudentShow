
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" type="yun.yi.Student" scope="session"></jsp:useBean>
<html>
<head>
    <title>展示按学号查询</title>
</head>
<body>
<br><jsp:getProperty name="student" property="id"/><br>
<jsp:getProperty name="student" property="name"/>
</body>
</html>

