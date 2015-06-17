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

import com.newBookShopWeb.dao.AdminUserDao;
import com.newBookShopWeb.dao.BookDao;
import com.newBookShopWeb.dao.UserDao;
import com.newBookShopWeb.entity.Book;
import com.newBookShopWeb.entity.OurUser;

@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("act");
		if(act.equals("getUser"))
			getUserByName(request, response);
		if(act.equals("getOneUser"))
			getOneUser(request, response);
		if(act.equals("addUser"))
			addUser(request, response);
		if(act.equals("deleteUser"))
			deleteUser(request, response);
		if(act.equals("updateUser"))
			updateUser(request, response);
	}
	
	protected void getUserByName(HttpServletRequest request, HttpServletResponse response) throws IOException{
		AdminUserDao aud=new AdminUserDao();
		String key=request.getParameter("Name");
		List<OurUser> list=aud.getUserList(key);
		HttpSession out=request.getSession();
		out.setAttribute("List", list);
		response.sendRedirect("admin_user.jsp");
	}
	
	protected void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		UserDao userDao=new UserDao();
		OurUser user=new OurUser();
		user.setLoginId(request.getParameter("loginId"));
		user.setLoginPwd(request.getParameter("loginPwd"));
		user.setName(request.getParameter("name"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(request.getParameter("phone"));
		user.setMail(request.getParameter("mail"));
		userDao.doRegister(user);
		response.sendRedirect("admin_adduser.jsp");
	}
	
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		AdminUserDao aud=new AdminUserDao();
		int userid=Integer.parseInt(request.getParameter("userid"));
		OurUser user=new OurUser();
		user.setId(userid);
		aud.deleteUser(user);
		response.sendRedirect("AdminUserServlet?act=getUser&Name=");
	}
	
	protected void getOneUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		AdminUserDao aud=new AdminUserDao();
		int userid=Integer.parseInt(request.getParameter("userid"));
		OurUser user=aud.getUser(userid);
		HttpSession out=request.getSession();
		out.setAttribute("User", user);
		response.sendRedirect("admin_updateuser.jsp");
	}
	
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		AdminUserDao aud=new AdminUserDao();
		OurUser user=new OurUser();
		int userid=Integer.parseInt(request.getParameter("userid"));
		user.setId(userid);
		user.setLoginId(request.getParameter("loginId"));
		user.setLoginPwd(request.getParameter("loginPwd"));
		user.setName(request.getParameter("name"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(request.getParameter("phone"));
		user.setMail(request.getParameter("mail"));
		aud.updateUser(user);
		response.sendRedirect("AdminUserServlet?act=getUser&Name=");
	}

}
