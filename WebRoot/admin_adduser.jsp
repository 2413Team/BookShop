<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_addbook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form method="post" action="AdminUserServlet?act=addUser">
    	<label>登录名</label>
    	<br />
    	<input type="text" name="loginId">
    	<br />
    	<label>登陆密码</label>
    	<br />
    	<input type="text" name="loginPwd">
    	<br />
    	<label>姓名</label>
    	<br />
    	<input type="text" name="name">
    	<br />
    	<label>地址</label>
    	<br />
    	<input type="text" name="address">
    	<br />
    	<label>电话</label>
    	<br />
    	<input type="text" name="phone">
    	<br />
    	<label>邮箱</label>
    	<br />
    	<input type="text" name="mail">
    	<br />
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
