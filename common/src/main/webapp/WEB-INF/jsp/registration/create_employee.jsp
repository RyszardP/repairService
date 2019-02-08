<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta charset="UTF-8">
    <title>create_employee</title>
</head>
<body>
<div align="center">
    Hello new employee!
    <br>
    Please insert information about yourself.
    <br>

    <div>
        <form action="FrontController" id="form-page-registration">
            <input type="hidden" name="command" value="registration">
            </br>
            <input type="text" id="Login" name="login" size="20" maxlength="25" placeholder="Login">
            </br>
            <input type="password" id="Password" name="password" size="20" maxlength="25" placeholder="Password">
            </br>
            <input type="text" id="UserName" name="name" size="20" maxlength="25" placeholder="Name">
            </br>
            <input type="text" id="Surname" name="surname" size="20" maxlength="25" placeholder="Surname">
            </br>
            <input type="text" id="Email" name="email" size="20" maxlength="25" placeholder="Email">
            </br>
            <input type="text" id="Speciality" name="speciality" size="20" maxlength="25" placeholder="Speciality">
            </br>
            <input type="text" id="Employee_Sector" name="employeeSector" size="20" maxlength="25" placeholder="EmployeeSector">
            </br>
            <input type="submit" id="finish_button" value="registration">
            </br>
            <a href="index.jsp">Go to back </a>
        </form>
    </div>



</div>
</body>
</html>