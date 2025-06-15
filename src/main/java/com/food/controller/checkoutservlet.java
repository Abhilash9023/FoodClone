package com.food.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.food.dao.Ordersdao;
import com.food.dao.Ordersitemsdao;
import com.food.daoimpl.Ordersdaoimpl;
import com.food.daoimpl.Ordersitemsdaoimpl;
import com.food.daoimpl.cart;
import com.food.model.Cartitem;
import com.food.model.Menu;
import com.food.model.Orders;
import com.food.model.Ordersitems;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class checkoutservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        cart cart = (cart) session.getAttribute("cart");
        ArrayList<Menu> Mlist = (ArrayList<Menu>) session.getAttribute("menulist");

        int restaurantid = 0;
        if (Mlist != null && !Mlist.isEmpty()) {
            restaurantid = Mlist.get(0).getRestaurantId();
        }

        String payment = req.getParameter("paymentMethod");

        int totalAmount = (int) session.getAttribute("totalAmount");
        float total = (float) totalAmount;

        User user = (User) session.getAttribute("user");
        int userid = user.getUserid();

        String status = "pending";

        Ordersdao ordersDao = new Ordersdaoimpl();
        Orders newOrder = new Orders(userid, restaurantid, total, status, payment);
        int orderid = ordersDao.insert(newOrder);

        if (cart != null && !cart.getCartItems().isEmpty()) {
            Collection<Cartitem> items = cart.getCartItems();
            for (Cartitem item : items) {
                int itemTotal = item.getPrice() * item.getQuantity();
                int menuid = item.getMenuid();
                int quantity = item.getQuantity();

                Ordersitems orderItem = new Ordersitems(orderid, menuid, quantity, itemTotal);
                Ordersitemsdao orderItemsDao = new Ordersitemsdaoimpl();
                orderItemsDao.insert(orderItem);
            }
        }

        resp.sendRedirect("success.jsp");
    }
}
