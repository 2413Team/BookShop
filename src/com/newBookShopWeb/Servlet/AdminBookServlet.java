package com.newBookShopWeb.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newBookShopWeb.dao.AdminBookDao;
import com.newBookShopWeb.entity.Book;

@WebServlet("/AdminBookServlet")
public class AdminBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
		if(act.equals("addbook"))
			addBook(request, response);
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
	}
}
