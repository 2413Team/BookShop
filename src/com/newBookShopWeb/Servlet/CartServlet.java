package com.newBookShopWeb.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newBookShopWeb.dao.BookDao;
import com.newBookShopWeb.dao.CartDao;
import com.newBookShopWeb.entity.Book;
import com.newBookShopWeb.entity.Cartbook;
import com.newBookShopWeb.entity.OurUser;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String act;
	OurUser user;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		act = request.getParameter("act");
		if (act.equals("addcart"))
			AddCart(request, response);
		if(act.equals("getcart"))
			GetCart(request, response);
		if(act.equals("getordercart"))
			GetOrderCart(request, response);
		if(act.equals("deletecartbook"))
			DeleteCartBook(request, response);
		if(act.equals("clearcart"))
			ClearCart(request,response);
		if(act.equals("changequantity"))
			ChangeQuantity(request, response);
	}

	protected void AddCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CartDao cartdao = new CartDao();
		BookDao bookdao=new BookDao();
		ServletContext application = this.getServletContext();
		user = (OurUser) application.getAttribute("user");
		String bookISBN=request.getParameter("bookISBN");
		String quantity=request.getParameter("Quantity");
		String unitPrice=request.getParameter("unitPrice");
		if (user != null){
			int cartId;
			cartId=cartdao.Add(user);
			cartdao.AddBook(cartId, bookISBN, quantity, unitPrice);
			Book book;
			book=bookdao.getBookByISBN(bookISBN);
			HttpSession out=request.getSession();
			out.setAttribute("Book", book);
			out.setAttribute("UnitPrice", unitPrice);
			out.setAttribute("Quantity",quantity );
			response.sendRedirect("book_buy.jsp");
		}
		else
			response.sendRedirect("user_login.jsp");
	}
	protected void GetCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CartDao catdao=new CartDao();
		Double total;
		ServletContext application = this.getServletContext();
		user = (OurUser) application.getAttribute("user");
		List<Cartbook> cart=catdao.getCart(user.getId());
		total=catdao.GetCartTotal(user);
		HttpSession out=request.getSession();
		out.setAttribute("Cart", cart);
		out.setAttribute("Total", total);
		response.sendRedirect("book_showcart.jsp");
	}
	
	protected void GetOrderCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CartDao catdao=new CartDao();
		Double total;
		ServletContext application = this.getServletContext();
		user = (OurUser) application.getAttribute("user");
		List<Cartbook> cart=catdao.getCart(user.getId());
		total=catdao.GetCartTotal(user);
		HttpSession out=request.getSession();
		out.setAttribute("Cart", cart);
		out.setAttribute("Total", total);
		response.sendRedirect("book_showorder.jsp");
	}
	protected void DeleteCartBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookISBN;
		bookISBN=request.getParameter("bookISBN");
		CartDao catdao=new CartDao();
		ServletContext application = this.getServletContext();
		user = (OurUser) application.getAttribute("user");
		catdao.deleteCartBook(bookISBN,user);
		response.sendRedirect("CartServlet?act=getcart");
	}
	
	protected void ClearCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CartDao cartdao=new CartDao();
		ServletContext application = this.getServletContext();
		user = (OurUser) application.getAttribute("user");
		cartdao.clearCart(user);
		response.sendRedirect("CartServlet?act=getcart");
	}
	protected void ChangeQuantity(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CartDao cartdao=new CartDao();
		String doing=request.getParameter("doing");
		String cartbookid=request.getParameter("cartbookid");
		if(doing.equals("up"))
			cartdao.QuantityUp(cartbookid);
		if(doing.equals("down"))
			cartdao.QuantityDown(cartbookid);
		response.sendRedirect("CartServlet?act=getcart");
	}
}
