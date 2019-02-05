
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>main</title>
</head>
<body>
<div align="center">
        <div>
                <form action="FrontController" id="form-page-registration">
                        <input type="hidden" name="command" value="autorization">
                        <div class="table">
                                <div class="tr">
                                        <div class="login">
                                                <input type="text" id="Login" name="login" size="20" maxlength="25" placeholder="Login">
                                        </div>
                                </div>
                                <div class="tr">
                                        <div class="password">
                                                <input type="password" id="Password" name="password" size = "20" maxlength="25"  placeholder="Password">
                                        </div>
                                </div>

                        </div>
                        <input type="submit" id="finish_button" value="Login">
                </form>
                <button>
                        <a href="registration">Registration</a>
                </button>
        </div>
</div>


</body>
</html><%--
<div align="center">
        <div>
                <form action="FrontController" id="create_employee">
                        <input type="hidden" name="command" value="create_employee">
                        <input type="text" id="Login" name="login" size="20" maxlength="25" placeholder="Login">
                        <input type="password" id="Password" name="password" size="20" maxlength="25" placeholder="Password">
                        <input type="submit" id="finish_button" value="Reg me!">
                </form>
        </div>
</div> --%>
<%--
<a href="FrontController?command=view_all_employees">View employees List </a> --%>


