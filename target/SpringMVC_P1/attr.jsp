<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/5/31
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%-- 这里要用下面这个头，因为访问控制器要用到EL表达式--%>
<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>测试数据传递机制，数据的获取</h1>

    ${requestScope.name}
    <br>
    ${requestScope.user.id} -- ${requestScope.user.name} -- ${requestScope.user.age} -- ${requestScope.user.bir}
    <br>
    <%--需要先去引入jstl依赖，引完后直接写c标签，回车，该页面上方就会自动加上引用--%>
    <c:forEach var="list" items="${requestScope.list}">
        ${list.name} -- ${list.id} -- ${list.age} -- <fmt:formatDate value="${list.bir}" pattern="yyyy年MM月dd日"/> -- ${list.toString()} <br>
    </c:forEach>

    <h1>获取问号后的数据11</h1>
    ${param.id} -- ${param.name} <br>

    ${sessionScope.id}

</body>
</html>
