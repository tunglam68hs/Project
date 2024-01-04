<%-- 
    Document   : LoginPage
    Created on : Jan 4, 2024, 8:55:03 PM
    Author     : tungl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
            Username:<input type="text" name="username" placeholder="Enter username"><br>
            Password:<input type="password" name="password" placeholder="Enter password"><br>
            <input type="checkbox" name="remember">Remember password<br>
            <div style="color: red"> ${mes} </div><br>
            <input type="submit" value="Login"><br>
        </form>
        Do not have an account? <a href="register">Register</a><br>
        Forgot password? <a href="forgot">Reset password</a>
    </body>
</html>
