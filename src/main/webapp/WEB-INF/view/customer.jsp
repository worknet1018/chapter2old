<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2020/7/29
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户管理</title>

</head>
<body>

<h1>客户列表</h1>
<table>
    <tr>
    <thead>客户名称</thead>
    <thead>联系人</thead>
    <thead>电话号码</thead>
    <thead>邮箱地址</thead>
    <thead>操作</thead>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.contact}</td>
            <td>${customer.telephone}</td>
            <td>${customer.email}</td>
            <td>
                <a href="${BASE}/customer_edit?id=${customer.id}">编辑</a>
                <a href="${BASE}/customer_delete?id=${customer.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
