package com.newBookShopWeb.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newBookShopWeb.dao.BookDao;
import com.newBookShopWeb.entity.Book;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String act;
	private BookDao dao;
	private Book book;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		act=request.getParameter("act");
		if(act.equals("get")){
			getBookByName(request, response);
		}
		if(act.equals("findbook")){
			findBook(request,response);
		}
			
	}
	protected void getBookByName(HttpServletRequest request, HttpServletResponse response) throws IOException{
		dao=new BookDao();
		List<Book> list =new ArrayList<Book>();
		list=dao.getBookByName(request.getParameter("Name"));
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		response.sendRedirect("adminBook.jsp");
	}
	protected void findBook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("Ö´ÐÐÁË²Ù×÷");
		dao=new BookDao();
		List<Book> list =new ArrayList<Book>();
		list=dao.findBook(request.getParameter("key"));
		System.out.println(list.get(0).getTitle());
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		response.sendRedirect("findbookSuccess.jsp");
	}
}
