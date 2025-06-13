package com.food.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.food.dao.Restaurantdao;
import com.food.daoimpl.Restaurantdaoimpl;
import com.food.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class Getallrestaurant extends HttpServlet {
	
	private HttpSession session;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getCookies()[0].getValue()!=null)
		{
			Restaurantdao rest=new Restaurantdaoimpl();
			ArrayList<Restaurant> restList = rest.fetchall();
			session=req.getSession();
			session.setAttribute("restList", restList);
			resp.sendRedirect("Home.jsp");
			
		}
		else {
			resp.sendRedirect("Login.jsp");
		}
		
		
	}}

