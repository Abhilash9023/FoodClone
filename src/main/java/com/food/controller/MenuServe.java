package com.food.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.food.dao.Menudao;
import com.food.daoimpl.Menudaoimpl;
import com.food.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menu")
public class MenuServe extends HttpServlet {

    private ArrayList<Menu> MenuList;
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String res = req.getParameter("restid");

       

       
            int restid = Integer.parseInt(res);

            
            Menudao menus = new Menudaoimpl();
            MenuList = menus.fetchbyrestid(restid);

           
          
                session = req.getSession();
                session.setAttribute("menulist", MenuList);
                resp.sendRedirect("Menu.jsp");
           

        }
    }
