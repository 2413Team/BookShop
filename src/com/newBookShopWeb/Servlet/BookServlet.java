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
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	/*
	 * 图书相关的servlet
	 * act对应不一样的行为
	 * act-get：通过书名查询图书，此行为应该放在AdminServlet里面去，而且方法冗余需要修改
	 * act-findbook：查询图书动作
	 * act-catefindbook：通过种类查询图书动作
	 * act-pubfindbook：通过出版社查询图书动作
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		act=request.getParameter("act");
		HttpSession out=request.getSession();
		out.setAttribute("pageAct", act);
		if(act.equals("get"))
			getBookByName(request, response);
		if(act.equals("findbook"))
			findBook(request,response);
		if(act.equals("catefindbook"))
			catefindbook(request, response);
		if(act.equals("pubfindbook"))
			pubfindbook(request,response);
		if(act.equals("hotbook"))
			hotbook(request,response);
		if(act.equals("newbook"))
			newbook(request,response);
		if(act.equals("tjbook"))
			tjbook(request,response);
		if(act.equals("quantitybook"))
			quantitybook(request,response);
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
		dao=new BookDao();
		List<Book> list =new ArrayList<Book>();
		int page=Integer.parseInt(request.getParameter("page"));
		String key=request.getParameter("key");
		key=new String(key.getBytes("iso-8859-1"),"gb2312");
		System.out.println(key);
		list=dao.findBook(key,12,page);
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		out.setAttribute("page", page);
		out.setAttribute("key", key);
		response.sendRedirect("findbookSuccess.jsp");
	}
	
	protected void catefindbook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		dao=new BookDao();
		String id=request.getParameter("id");
		System.out.println(id);
		List<Book> list=new ArrayList<Book>();
		int page=Integer.parseInt(request.getParameter("page"));
		list=dao.getBookByCId(id,12,page);
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		out.setAttribute("page", page);
		out.setAttribute("id", id);
		response.sendRedirect("findbookSuccess.jsp");
	}
	
	protected void pubfindbook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		dao=new BookDao();
		String id=request.getParameter("id");
		System.out.println(id);
		List<Book> list=new ArrayList<Book>();
		int page=Integer.parseInt(request.getParameter("page"));
		list=dao.getBookByPId(id,12,page);
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		out.setAttribute("page", page);
		out.setAttribute("id", id);
		response.sendRedirect("findbookSuccess.jsp");
	}

	protected void hotbook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		dao=new BookDao();
		String id=request.getParameter("id");
		System.out.println(id);
		List<Book> list=new ArrayList<Book>();
		int page=Integer.parseInt(request.getParameter("page"));
		list=dao.manybooklist("clicks", 12, page);
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		out.setAttribute("page", page);
		out.setAttribute("id", id);
		response.sendRedirect("findbookSuccess.jsp");
	}
	
	protected void newbook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		dao=new BookDao();
		String id=request.getParameter("id");
		System.out.println(id);
		List<Book> list=new ArrayList<Book>();
		int page=Integer.parseInt(request.getParameter("page"));
		list=dao.manybooklist("publishdate", 12, page);
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		out.setAttribute("page", page);
		out.setAttribute("id", id);
		response.sendRedirect("findbookSuccess.jsp");
	}
	
	protected void tjbook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		dao=new BookDao();
		String id=request.getParameter("id");
		System.out.println(id);
		List<Book> list=new ArrayList<Book>();
		int page=Integer.parseInt(request.getParameter("page"));
		list=dao.manybooklist("unitprice", 12, page);
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		out.setAttribute("page", page);
		out.setAttribute("id", id);
		response.sendRedirect("findbookSuccess.jsp");
	}
	
	protected void quantitybook(HttpServletRequest request, HttpServletResponse response) throws IOException{
		dao=new BookDao();
		String id=request.getParameter("id");
		System.out.println(id);
		List<Book> list=new ArrayList<Book>();
		int page=Integer.parseInt(request.getParameter("page"));
		list=dao.manybooklist("qunatity", 12, page);
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		out.setAttribute("page", page);
		out.setAttribute("id", id);
		response.sendRedirect("findbookSuccess.jsp");
	}
}
