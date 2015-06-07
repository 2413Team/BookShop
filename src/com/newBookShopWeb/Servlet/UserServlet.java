package com.newBookShopWeb.Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newBookShopWeb.dao.UserDao;
import com.newBookShopWeb.entity.OurUser;

@WebServlet(urlPatterns="/userAct")
public class UserServlet extends HttpServlet {
	private OurUser user;
	private UserDao dao;
	private String act;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	/*
	 * 普通用户对应的servlet
	 * act对应不同的动作
	 * act-login：普通用户的登陆操作
	 * act-register：普通用户的注册操作
	 * act-exit：退出登录
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		act=req.getParameter("act");
		if(act.equals("login"))
			doLogin(req,resp);
		if(act.equals("register"))
			doRegister(req, resp);
		if(act.equals("exit"))
			userExit(req,resp);
	}
	protected void doLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		UserDao dao=new UserDao();
		user=new OurUser();
		user.setLoginId(req.getParameter("loginId"));
		user.setLoginPwd(req.getParameter("loginPwd"));
		user=dao.doLogin(user);
		if(user.getId()!=0){
			ServletContext application=this.getServletContext();
			application.setAttribute("user", user);
			resp.sendRedirect("index.jsp");
		}
		else{
			resp.sendRedirect("user_login.jsp");
		}	
	}
	protected void doRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		user=new OurUser();
		dao=new UserDao();
		user.setLoginId(req.getParameter("loginId"));
		user.setLoginPwd(req.getParameter("loginPwd"));
		user.setName(req.getParameter("name"));
		user.setAddress(req.getParameter("address"));
		user.setPhone(req.getParameter("phone"));
		user.setMail(req.getParameter("mail"));
		if(dao.doRegister(user))
				resp.sendRedirect("user_login.jsp");
		else
				resp.sendRedirect("user_register.jsp");
	}
	protected void userExit(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		ServletContext application=this.getServletContext();
		application.setAttribute("user", null);
		resp.sendRedirect("index.jsp");
	}
}
