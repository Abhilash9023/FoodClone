package com.food.controller;

import java.io.IOException;

import com.food.dao.Userdao;
import com.food.daoimpl.Userdaoimpl;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password=(req.getParameter("password"));
		
		if(password.equals(req.getParameter("cpassword"))){
			String name=req.getParameter("username");
			String email=req.getParameter("email");
			String address=req.getParameter("address");
			
			Userdao f=new Userdaoimpl();
			
			User u=new User(name,password,email,address);
			
			int x=f.insert(u);
			if(x>0) {
				resp.sendRedirect("Login.jsp");
			}else {
				resp.sendRedirect("Failure.jsp");
			}
			
		}
		else {
			resp.sendRedirect("Failure.html");
		}
		
	}
	
	

}
