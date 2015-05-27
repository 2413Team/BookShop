package com.newBookShopWeb.Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newBookShopWeb.dao.CartDao;
import com.newBookShopWeb.entity.OurUser;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String act;
	OurUser user;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		act=request.getParameter("act");
		if(act.equals("addcart"))
			AddCart(request, response);
	}
	
	protected void AddCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDao cartdao=new CartDao();
		ServletContext application=this.getServletContext();
		user=(OurUser)application.getAttribute("user");
		cartdao.Add(user);
	}
}
