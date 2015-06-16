package com.newBookShopWeb.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newBookShopWeb.dao.AdminBookDao;
import com.newBookShopWeb.dao.BookDao;
import com.newBookShopWeb.entity.Book;

@WebServlet("/AdminBookServlet")
public class AdminBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
		if(act.equals("addbook"))
			addBook(request, response);
		if(act.equals("deletebook"))
			deleteBook(request, response);
		if(act.equals("getbook"))
			getBook(request, response);
		if(act.equals("updatebook"))
			updateBook(request, response);
	}

	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=new Book();
		AdminBookDao adminbookdao=new AdminBookDao();
		book.setTitle(request.getParameter("Title"));
		book.setAuthor(request.getParameter("Author"));
		book.setiSBN(request.getParameter("ISBN"));
		book.setWordsCount(Integer.parseInt(request.getParameter("WordsCount")));
		book.setUnitPrice(Float.parseFloat(request.getParameter("UnitPrice")));
		book.setContentDescription(request.getParameter("ContentDescription"));
		book.setAurhorDescription(request.getParameter("AurhorDescription"));
		book.setEditorComment(request.getParameter("EditorComment"));
		book.settOc(request.getParameter("Toc"));
		adminbookdao.insertBook(book);
		response.sendRedirect("admin_addbook.jsp");
	}
	
	protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=new Book();
		AdminBookDao adminbookdao=new AdminBookDao();
		book.setId(Integer.parseInt(request.getParameter("bookid")));
		adminbookdao.deleteBook(book);
		response.sendRedirect("BookServlet?act=get&Name=");
	}
	
	protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bookdao=new BookDao();
		String bookisbn=request.getParameter("bookisbn");
		Book book=bookdao.getBookByISBN(bookisbn);
		HttpSession session=request.getSession();
		session.setAttribute("book", book);
		PrintWriter print = response.getWriter();
		response.sendRedirect("admin_updatebook.jsp");
	}
	
	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=new Book();
		AdminBookDao adminbookdao=new AdminBookDao();
		book.setId(Integer.parseInt(request.getParameter("bookid")));
		book.setTitle(request.getParameter("Title"));
		book.setAuthor(request.getParameter("Author"));
		book.setiSBN(request.getParameter("ISBN"));
		book.setWordsCount(Integer.parseInt(request.getParameter("WordsCount")));
		book.setUnitPrice(Float.parseFloat(request.getParameter("UnitPrice")));
		book.setContentDescription(request.getParameter("ContentDescription"));
		book.setAurhorDescription(request.getParameter("AurhorDescription"));
		book.setEditorComment(request.getParameter("EditorComment"));
		book.settOc(request.getParameter("Toc"));
		adminbookdao.updateBook(book);
		response.sendRedirect("BookServlet?act=getbyid&bookid="+book.getId());
	}
}
