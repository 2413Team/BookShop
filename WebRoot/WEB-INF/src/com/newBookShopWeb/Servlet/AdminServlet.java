package com.newBookShopWeb.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newBookShopWeb.dao.AdminDao;
import com.newBookShopWeb.entity.OurUser;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDao dao;
    private OurUser user;
    private String act;
    public AdminServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		act=request.getParameter("act");
		if(act.equals("login"))
			doLogin(request, response);
	}
	
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user=new OurUser();
		dao=new AdminDao();
		user.setLoginId(request.getParameter("LoginId"));
		user.setLoginPwd(request.getParameter("LoginPwd"));
		HttpSession session=request.getSession();
		if(dao.doLogin(user)){
			session.setAttribute("LoginId", user.getLoginId());
			response.sendRedirect("adminIndex.jsp");
		}
		else
			response.sendRedirect("adminLogin.jsp");
	}
}
