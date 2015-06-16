package com.newBookShopWeb.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newBookShopWeb.dao.AdminCategoriesDao;
import com.newBookShopWeb.dao.BookDao;
import com.newBookShopWeb.dao.CategoriesDao;
import com.newBookShopWeb.entity.Book;
import com.newBookShopWeb.entity.Categories;

@WebServlet("/AdminCategoriesServlet")
public class AdminCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
		if(act.equals("insertCategories"))
			insertCategories(request, response);
		if(act.equals("deleteCategories"))
			deleteCategories(request, response);
		if(act.equals("getCategories"))
			getCategories(request, response);
		if(act.equals("getCategoriesList"))
			getCategoriesList(request, response);
		if(act.equals("updateCategories"))
			updateCategories(request, response);
	}
	
	protected void insertCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminCategoriesDao acd=new AdminCategoriesDao();
		int categoriesId=Integer.parseInt(request.getParameter("categoriesId"));
		acd.insertCategories(request.getParameter("categoriesName"),categoriesId);
		response.sendRedirect("admin_addcategories.jsp");
	}
	
	protected void deleteCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminCategoriesDao acd=new AdminCategoriesDao();
		int categoriesId=Integer.parseInt(request.getParameter("categoriesId"));
		acd.deleteCategories(categoriesId);
		response.sendRedirect("BookServlet?act=getcategories&Name=");
	}
	protected void updateCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminCategoriesDao acd=new AdminCategoriesDao();
		int categoriesId=Integer.parseInt(request.getParameter("categoriesId"));
		acd.updateCategories(categoriesId, request.getParameter("categoriesName"));
		response.sendRedirect("AdminCategoriesServlet?act=getCategoriesList&categoriesId="+categoriesId);
	}
	
	protected void getCategoriesList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		AdminCategoriesDao acd=new AdminCategoriesDao();
		int categoriesId=Integer.parseInt(request.getParameter("categoriesId"));
		List<Categories> list=acd.getCategoriesList(categoriesId);
		HttpSession session=request.getSession();
		session.setAttribute("List", list);
		PrintWriter print = response.getWriter();
		response.sendRedirect("admin_categories.jsp");
	}
	
	protected void getCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminCategoriesDao acd=new AdminCategoriesDao();
		int categoriesId=Integer.parseInt(request.getParameter("categoriesId"));
		Categories categories=acd.getCategories(categoriesId);
		HttpSession session=request.getSession();
		session.setAttribute("categories", categories);
		PrintWriter print = response.getWriter();
		response.sendRedirect("admin_updatecategories.jsp");
	}

}
