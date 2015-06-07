package com.newBookShopWeb.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newBookShopWeb.dao.CartDao;
import com.newBookShopWeb.dao.OrderDao;
import com.newBookShopWeb.entity.Cartbook;
import com.newBookShopWeb.entity.OurUser;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OurUser user;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
		if(act.equals("submitorder"))
			SubmitOrder(request, response);
	}
	protected void SubmitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderdao=new OrderDao();
		CartDao cartdao=new CartDao();
		ServletContext application=this.getServletContext();
		this.user=(OurUser)application.getAttribute("user");
		Double total=Double.parseDouble(request.getParameter("total"));
		List<Cartbook> cart=cartdao.getCart(user.getId());
		orderdao.SubmitOrder(user, total, cart);
	}
}
