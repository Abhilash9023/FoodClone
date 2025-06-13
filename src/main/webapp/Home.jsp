<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.food.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant List</title>
    <link rel="stylesheet" href="Home.css"> 
</head>
<body>
<script src="Home.js"></script>

<div class="container">
    <%
        User u = (User) session.getAttribute("user");
        ArrayList<Restaurant> rList = (ArrayList<Restaurant>) session.getAttribute("restList");
    %>

    <div class="top-bar">
        <div class="welcome">
            Hello <%= (u != null) ? u.getUsername() : "Guest" %>
        </div>
        <div class="search-sort">
            <input type="text" id="searchInput" placeholder="Search Restaurants" onkeyup="filterRestaurants()">
            <select id="sortSelect" onchange="sortRestaurants()">
                <option value="name">Sort by Name</option>
                <option value="rating">Sort by Rating</option>
                <option value="delivery">Sort by Delivery Time</option>
            </select>
        </div>
    </div>

    <!-- ✅ Place grid container OUTSIDE the loop -->
    <div class="restaurant-grid" id="restaurantGrid">
        <%
            if (rList != null) {
                for (Restaurant r : rList) {
        %>
            <!-- ✅ a.card-link is the clickable wrapper -->
            <a href="menu?restid=<%=r.getRestaurantid()%>" class="card-link restaurant-card"
               data-name="<%= r.getName_of_the_restaurant().toLowerCase() %>"
               data-rating="<%= r.getRatings() %>"
               data-delivery="<%= r.getDeliveryTime() %>">

                <img src="<%= r.getImagepath() %>" alt="Image" class="restaurant-image">
                <h2><%= r.getName_of_the_restaurant() %></h2>
                <p><strong>Cuisine:</strong> <%= r.getCuisine() %></p>
                <p><strong>Delivery Time:</strong> <%= r.getDeliveryTime() %> mins</p>
                <p><strong>Address:</strong> <%= r.getAddress() %></p>
                <p><strong>Ratings:</strong> ⭐ <%= r.getRatings() %></p>
                <p><strong>Active:</strong> <%= r.isActive() ? "Yes" : "No" %></p>
            </a>
        <%
                }
            } else {
        %>
            <p>No restaurants available.</p>
        <%
            }
        %>
    </div>
</div>

</body>
</html>
