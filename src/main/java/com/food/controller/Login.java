package com.food.controller;

import java.io.IOException;

import com.food.dao.Userdao;
import com.food.daoimpl.Userdaoimpl;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {
	
	

	private HttpSession sess;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=(req.getParameter("email"));
		String password=(req.getParameter("password"));
		Userdao f=new Userdaoimpl();
		
	     User k=f.fetchemail(email);
		if(password.equals(k.getPassword())) {
			sess=req.getSession();
			sess.setAttribute("user", k);
			Cookie ck = new Cookie("email",email);
			resp.addCookie(ck);
			resp.sendRedirect("Getallrestaurant");
		}else {
			resp.getWriter().println("not found");
		}
	}

	

}
