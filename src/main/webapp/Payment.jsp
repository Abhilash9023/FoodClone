<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Page</title>
    <style>
        body {
            background: linear-gradient(to right, #d4fc79, #96e6a1); 
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 40px;
        }

        h2 {
            text-align: center;
            color: #2e7d32;
        }

        form {
            background-color: #e8f5e9; 
            max-width: 500px;
            margin: 0 auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.15);
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #2e7d32;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .radio-group {
            display: flex;
            flex-direction: column;
            margin-top: 10px;
            margin-bottom: 20px;
        }

        .radio-option {
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #28a745; 
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

    <h2>Payment & Delivery Details</h2>
    
    <form action="checkout" method="post">
        
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required>

        <label for="pincode">Pincode:</label>
        <input type="number" id="pincode" name="pincode" required>

        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" required>

        <p><strong>Payment Method:</strong></p>
        <div class="radio-group">
            <div class="radio-option">
                <input type="radio" id="creditCard" name="paymentMethod" value="Credit Card" required>
                <label for="creditCard">Credit Card</label>
            </div>
            <div class="radio-option">
                <input type="radio" id="upi" name="paymentMethod" value="UPI">
                <label for="upi">UPI</label>
            </div>
            <div class="radio-option">
                <input type="radio" id="cod" name="paymentMethod" value="Cash on Delivery">
                <label for="cod">Cash on Delivery</label>
            </div>
        </div>

        <input type="submit" value="Place Order">
    </form>

    <%
        String totalAmount = request.getParameter("totalAmount");
        if (totalAmount != null) {
            session.setAttribute("totalAmount", Integer.parseInt(totalAmount));
        }
    %>

</body>
</html>
