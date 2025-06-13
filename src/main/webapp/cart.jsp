<%@ page import="com.food.model.Cartitem" %>
<%@ page import="com.food.daoimpl.cart" %>
<%@ page import="java.util.*" %>
<%@ page session="true" %>
<html>
<head>
    <title>Your Cart</title>
    <link rel="stylesheet" href="cart.css">
</head>
<body>

<h2 class="cart-title">Your Cart</h2>

<%
    cart cartObj = (cart) session.getAttribute("cart");
    if (cartObj != null && !cartObj.getCartItems().isEmpty()) {
        Collection<Cartitem> items = cartObj.getCartItems();
        Cartitem[] itemsArray = items.toArray(new Cartitem[0]);  
        int total = 0;
%>
    <div class="cart-container">
    <%
        for (int i = 0; i < itemsArray.length; i++) {
            Cartitem item = itemsArray[i];
            int itemTotal = item.getPrice() * item.getQuantity();
            total += itemTotal;
    %>
        <div class="cart-card">
            <div><strong>Menu ID:</strong> <%= item.getMenuid() %></div>
            <div><strong>Name:</strong> <%= item.getName() %></div>
            <div><strong>Price:</strong> <%= item.getPrice() %></div>
            <div class="quantity-controls">
                <form action="CartServlet" method="post">
                    <input type="hidden" name="action" value="update" />
                    <input type="hidden" name="menuid" value="<%= item.getMenuid() %>" />
                    <input type="hidden" name="restaurantid" value="<%= item.getRestaurantid() %>" />
                    <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>" class="qty-btn" <%= (item.getQuantity() <= 1) ? "disabled" : "" %> >-</button>
                </form>
                <span><%= item.getQuantity() %></span>
                <form action="CartServlet" method="post">
                    <input type="hidden" name="action" value="update" />
                    <input type="hidden" name="menuid" value="<%= item.getMenuid() %>" />
                    <input type="hidden" name="restaurantid" value="<%= item.getRestaurantid() %>" />
                    <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>" class="qty-btn">+</button>
                </form>
            </div>
            <div><strong>Total:</strong> RS <%= itemTotal %></div>
            <form action="CartServlet" method="post">
                <input type="hidden" name="action" value="remove" />
                <input type="hidden" name="menuid" value="<%= item.getMenuid() %>" />
                <input type="hidden" name="restaurantid" value="<%= item.getRestaurantid() %>" />
                <input type="submit" value="Remove" class="remove-btn" />
            </form>
        </div>
    <%
        }
    %>
    </div>

    <div class="grand-total">
        <strong>Grand Total: RS   <%= total %></strong>
    </div>

    <div class="cart-actions">
        <form action="CartServlet" method="post">
            <input type="hidden" name="action" value="clear" />
            <input type="hidden" name="menuid" value="0" />
            <input type="hidden" name="restaurantid" value="0" />
            <input type="submit" value="Clear Cart" class="action-btn" />
        </form>

        <form action="Menu.jsp" method="get">
            <input type="submit" value="Add More Items" class="action-btn" />
        </form>

        <form action="Payment.jsp" method="post">
            <input type="hidden" name="totalAmount" value="<%= total %>" />
            <input type="submit" value="Continue" class="action-btn" />
        </form>
    </div>

<%
    } else {
%>
    <h3 class="empty-cart-msg">Your cart is empty.</h3>
    <div class="homebtn">
        <form action="Home.jsp" method="get">
            <input type="submit" value="Restaurant" class="home-btn"/>
        </form>
    </div>
<%
    }
%>

</body>
</html>
