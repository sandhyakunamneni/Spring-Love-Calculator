<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="sendemail" method="get" modelAttribute="emailDTO">
  <div align="right">
  <a href="/Spring-LoveCalculator/register">Register</a>
  </div>
    <div align="center">
   <h1> Hi ${userInfo.userName} , Please enter your email</h1>
        <p>
            <label for="userEmail">Email:</label>
            <form:input id="userEmail" path="userEmail"/>
        
        </p>
        
        <input type="submit" value="Send Email">
        
    </div>
</form:form>
</body>
</html>