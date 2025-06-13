package com.food.controller;

import java.io.IOException;
import com.food.daoimpl.cart;
import com.food.model.Cartitem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
     
        HttpSession session = req.getSession();

        cart cartObj = (cart) session.getAttribute("cart");

        if (cartObj == null) {
            cartObj = new cart();
        }
        
        
        

        String action = req.getParameter("action");

        int menuid = Integer.parseInt(req.getParameter("menuid"));
        
        int restaurantid = Integer.parseInt(req.getParameter("restaurantid"));
      

        switch (action) {
            case "add":
                String name = req.getParameter("name");
                int price = Integer.parseInt(req.getParameter("price"));

                Cartitem item = new Cartitem(menuid, restaurantid, name, price, 1);
                cartObj.addItem(item); 
                break;

            case "update":
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                cartObj.updateItem(menuid, quantity); 
                break;

            case "remove":
                cartObj.removeItem(menuid);
                break;

            case "clear":
                cartObj.clearAllItems(); 
                break;
        }

        session.setAttribute("cart", cartObj);
        
        
      

        resp.sendRedirect("cart.jsp");
    }
}
