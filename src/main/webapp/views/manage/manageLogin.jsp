<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>Animated Login Form | CodingNepal</title>
    <style><%@include file="style.css"%></style>
</head>

<body>
    <div class="center">
        <h1>Login</h1>
        <form method="post" action="${pageContext.request.contextPath}/manager-login">
            <div class="txt_field">
                <input type="text" required name="username">
                <span></span>
                <label>Username</label>
            </div>
            <div class="txt_field">
                <input type="password" required name="password">
                <span></span>
                <label>Password</label>
            </div>
            <div class="pass">Forgot Password?</div>
            <input type="submit" value="Login">
        </form>
    </div>

</body>

</html>