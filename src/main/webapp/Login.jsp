<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Food Clone</title>
    <link rel="stylesheet" href="Login.css">
    <script src="Login.js"></script>
    
</head>
<body>
    <form name="loginForm" action="Login" method="post" onsubmit="return validateForm()">
        <h2>Login to Food Clone</h2>
        <label for="email">Email:</label>
        <input type="email" name="email" id="email"><br>
        
        <label for="password">Password:</label>
        <input type="password" name="password" id="password"><br>
        <input type="submit" name="Login" value="Login">
        <p class="not-registered-text">If You Haven't Registered Yet Click Here To <a href="Register.jsp" class="register-link">Register</a></p>
    </form>
</body>
</html>
