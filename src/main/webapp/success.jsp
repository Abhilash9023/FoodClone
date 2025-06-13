<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #00b09b, #96c93d);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            background-color: #fff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 500px;
            width: 90%;
            animation: fadeIn 0.8s ease-in-out;
        }

        .emoji {
            font-size: 50px;
            margin-bottom: 10px;
            animation: bounce 1.5s infinite;
        }

        .card h2 {
            color: #2e8b57;
            font-size: 28px;
            margin-bottom: 15px;
        }

        .card p {
            font-size: 18px;
            color: #333;
            margin-bottom: 20px;
        }

        .btn-home {
            display: inline-block;
            padding: 12px 25px;
            background-color: #2e8b57;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .btn-home:hover {
            background-color: #246f47;
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(-20px);}
            to {opacity: 1; transform: translateY(0);}
        }

        @keyframes bounce {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-12px);
            }
        }
    </style>
</head>
<body>
    <div class="card">
        <div class="emoji">👍</div>
        <h2>🎉 Your Order Has Been Placed!</h2>
        <p>Thank you for ordering with us!</p>
        <p>Your food will be delivered soon. 😊</p>
        <a href="Home.jsp" class="btn-home">Back to Home</a>
    </div>
</body>
</html>
