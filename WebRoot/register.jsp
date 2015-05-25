                                                                        <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>来加入SpeedBook吧！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/register.css">
	<script language="javascript" src="js/register.js"></script>
	
	<!--<script language="javascript" src="js/SelectAddress.js"></script>  -->

  </head>
  <%@include file="header.jsp" %>
  <body>
  <p style="width:100%; height: 2px; background-color: #c81623;"></p>
  <div class="all">
  	<div class="hello"></div>
  	<div class="register">
      <form action="userAct?act=register" method="post" name="registerForm" onsubmit="return everyThingIsOk()" >
      		<h1 id="title">注册：</h1>
      		<input type="text"  name="loginId" required placeholder="请输入用户名" id="shuru"/>
      		<br>
      		<input type="password"  name="loginPwd"  required placeholder="请输入密码" id="shuru"/>
      		<br>
      		<input type="password"  name="loginPwdRe" required placeholder="请再次输入密码" id="shuru" onkeyup="return loginPwdIsOk()" />
      		<span id="passIsOk"></span>
      		<br>
      		<input type="text"  name="name" required placeholder="请输入真实姓名" id="shuru"/>
      		<br>  
      		<input type="text"  name="address" required placeholder="请输入您的地址" id="shuru"/>  		 
      		<br>
      		<input type="text"  name="phone" required placeholder="请输入您的电话号码" id="shuru"   onkeyup="return teleIsOk()"/>
      		<span id="phoneIsOk"></span>
      		<br>
      		<p>
      		 <input type="text"  name="mail" required placeholder="请输入邮箱" id="shuru"  onkeyup="return mailIsOk()"/>
      		 <span id="mailIsOk"></span>
      		 </p>
      		<input type="submit" value=" 注册" class="button" >
      </form>
     </div>
 </div>
    </script>
  </body>
  <%@include file="footer.jsp" %>
</html>
