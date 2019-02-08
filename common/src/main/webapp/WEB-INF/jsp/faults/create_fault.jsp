<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<div align="center">
    <div>

    <div>
        <form action="FrontController" id="form-page-registration">
            <input type="hidden" name="command" value="registration">

            <input type="text" id="Employee_Sector" name="employeeSector" size="20" maxlength="25"
                   placeholder="EmployeeSector">

            <div class="tr">
                <div class="login">
                    <input type="text" id="Login" name="login" size="20" maxlength="25" placeholder="Login">
                </div>
            </div>


            <a href="main">Go to back </a>
        </form>
    </div>
    </div>
</div>
</body>
</html>