<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.food.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <link rel="stylesheet" href="Menu.css">
    <script src="Menu.js" defer></script> 
</head>

<body>
<div class="menu-header">
    <h2>Menu</h2>
    <input type="text" id="searchInput" placeholder="Search menu..." />
</div>


<%
ArrayList<Menu> Mlist = (ArrayList<Menu>) session.getAttribute("menulist");
if (Mlist != null) {
%>
    <ul>
<%
    for (int i = 0; i < Mlist.size(); i++) {
        Menu m = Mlist.get(i);
%>
        <li>
            <div class="menu-item">
                <img src="<%= m.getImagepath() %>" alt="<%= m.getName() %>" class="menu-image"/>
                <div class="menu-details">
                    <strong><%= m.getName() %></strong> - ₹<%= m.getPrice() %>
                    <form action="CartServlet" method="post">
                        <input type="hidden" name="action" value="add" />
                        <input type="hidden" name="menuid" value="<%= m.getMenuId() %>" />
                        <input type="hidden" name="restaurantid" value="<%= m.getRestaurantId() %>" />
                        <input type="hidden" name="name" value="<%= m.getName() %>" />
                        <input type="hidden" name="price" value="<%= m.getPrice() %>" />
                        <button type="submit">Add to Cart</button>
                    </form>
                </div>
            </div>
        </li>
<%
    }
%>
    </ul>
<%
} else {
%>
    <p>No menu items found.</p>
<%
}
%>

</body>
</html>
