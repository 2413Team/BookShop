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
  <div style="width: 300px; margin: 0 auto;">
    <form method="post" action="AdminUserServlet?act=updateUser&userid=${sessionScope.User.id}">
    	<label>登录名</label>
    	<br />
    	<input type="text" name="loginId" value="${sessionScope.User.loginId }">
    	<br />
    	<label>登陆密码</label>
    	<br />
    	<input type="text" name="loginPwd" value="${sessionScope.User.loginPwd }">
    	<br />
    	<label>姓名</label>
    	<br />
    	<input type="text" name="name" value="${sessionScope.User.name }">
    	<br />
    	<label>地址</label>
    	<br />
    	<input type="text" name="address" value="${sessionScope.User.address }">
    	<br />
    	<label>电话</label>
    	<br />
    	<input type="text" name="phone" value="${sessionScope.User.phone }">
    	<br />
    	<label>邮箱</label>
    	<br />
    	<input type="text" name="mail" value="${sessionScope.User.mail }">
    	<br />
    	<input type="submit" value="提交">
    </form>
    </div>
  </body>
</html>
