<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 11/30/2021
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items='${requestScope["list"]}' var="student">
<h2>${student.id},
${student.name},
${student.math},
${student.physics},
${student.chemistry}
    <a href="/students?action=edit&id=${student.id}">Edit</a>
    <a href="/students?action=delete&id=${student.id}">Delete</a>
</h2>
</c:forEach>
</body>
</html>
