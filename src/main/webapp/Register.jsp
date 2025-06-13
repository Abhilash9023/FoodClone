<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - Food Clone</title>
    <link rel="stylesheet" href="Register.css">
    <script src="Register.js"></script>
</head>
<body>
 
    <form name="registerForm" action="Register" method="post" onsubmit="return validateForm()">
        <p class="welcome-message">Welcome to <strong>Food Clone</strong>! Create an account to start ordering delicious food now!</p>

        <label for="username">Name:</label>
        <input type="text" name="username"><br>

        <label for="password">Password:</label>
        <input type="password" name="password"><br>

        <label for="cpassword">Confirm Password:</label>
        <input type="password" name="cpassword"><br>

        <label for="email">Email:</label>
        <input type="email" name="email"><br>

        <label for="address">Address:</label>
        <input type="text" name="address"><br>

        <input type="submit" name="Register" value="Register">
        
        
       <p class="registration-text">If You Have Registered Click Here To <a href="Login.jsp" class="login-link"><strong>Login</strong></a></p>

    </form>

    
</body>
</html>
