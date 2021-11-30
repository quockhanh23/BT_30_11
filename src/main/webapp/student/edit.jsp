<%--
  Created by IntelliJ IDEA.
  User: Asus VivoBook
  Date: 11/30/2021
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="number" name="id" value="${sEdit.id}">
    <input type="text" name="name" value="${sEdit.name}">
    <input type="number" name="math" value="${sEdit.math}">
    <input type="number" name="physics" value="${sEdit.physics}">
    <input type="number" name="chemistry" value="${sEdit.chemistry}">
    <button>Click</button>
</form>
</body>
</html>
