<%--
  Created by IntelliJ IDEA.
  User: saikr
  Date: 9/29/2022
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration-Success</title>
</head>
<body>
<h1>Registration is Successfully</h1>

<h2>The details entered are:</h2>
Name: ${userRegistrationInfo.name}
<br>

Hobbies:
<c:forEach var="temp"  items="${userRegistrationInfo.hobbies}">
    ${temp}
</c:forEach>
<br>
Password: ${userRegistrationInfo.password}


</body>
</html>
