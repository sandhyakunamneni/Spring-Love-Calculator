<%--
  Created by IntelliJ IDEA.
  User: saikr
  Date: 9/29/2022
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1 align="center"> Love Calulator</h1>
<hr>
<style type="text/css">
    .error{
        color: red;
        position: fixed;
        text-align: left;
        margin-left: 30px;
    }
</style>
<form:form action="process-homepage" method="get" modelAttribute="userInfo">

    <div align="center">
        <p>
            <label for="yn">Yor Name:</label>
            <form:input id="yn" path="userName"/>
            <form:errors path="userName" cssClass="error"/>
        </p>
        <p>
            <label for="cn">Crush Name:</label>
            <form:input  id="cn" path="crushName"/>
        </p>
        <input type="submit" value="Calculate">
    </div>
</form:form>
</body>
</html>
