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
    <style type="text/css">
    .error{
        color: red;
        position: fixed;
        text-align: left;
        margin-left: 30px;
    }
</style>
</head>
<body>
<h1 align="center"> Love Calulator</h1>
<hr>
<form:form action="registration-sucess" method="get" modelAttribute="userRegistrationInfo">
    <div align="center">
        <p>
            <label for="yn">Name:</label>
            <form:input id="yn" path="name"/>
        </p>
        <p>
            <label for="un">User Name:</label>
            <form:input id="un" path="userName"/>
        </p>
        <p>
            <label for="pw">Password:</label>
            <form:password id="pw" path="password"/>
        </p>
         <p>
            <label for="age">Age:</label>
            <form:input id="age" path="age"/>
            <form:errors path="age" cssClass="error"/>
        </p>
        <p>
        <td>Country:</td>
        <form:select path="countryName">
            <form:option value="Ind" itemLabel="India"/>
            <form:option value="USA" itemLabel="USA"/>
            <form:option value="AUS" itemLabel="Australia"/>
        </form:select>
        </p>
        <p>
            <label>hobby: </label>
            Cricket: <form:checkbox path="hobbies" value="Cricket"/>
            F1: <form:checkbox path="hobbies" value="F1"/>
            BasketBall: <form:checkbox path="hobbies" value="BasketBall"/>
        </p>
        <p>
            <label> Gender</label>
            <form:radiobutton path="gender" value="M"/>Male
            <form:radiobutton path="gender" value="F"/>Female
        </p>
        <p>
        Communication
        
        
        </p>
          <p>
       <label>email</label>
       
       <form:input path="communicationDTO.email"/>
        </p>
       <p>
       <label>Phone</label>
        <form:input path="communicationDTO.phone"/>
        
        </p>

        <input type="submit" value="register">


    </div>
</form:form>
</body>
</html>
