<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/Login.css" rel="stylesheet" type="text/css" /> 
<title>SpeedBook打卡中心</title>
</head>
	<%@include file="header.jsp" %>
<body>
<p style="width:100%; height: 2px; background-color: #c81623;"></p>
	<div class="login">
		<form method="post" action="userAct?act=login" name="loginForm">
			<h2>登录：</h2>
				<input type="text"  name="loginId"  placeholder="请输入用户名"  required  class="userName" id="shuru"/>
				<br>
				<input type="password" name="loginPwd" placeholder="请输入密码"  required class="passWord" id="shuru"/>
				<br>
				<input type="text"  value="·这是验证码" onfocus="if(value == defaultValue){value='';this.style.color='#000'}" maxlength="4px" class="yanzheng" />
				<input type="image" class='img' />
				<a href="register.jsp">立即注册</a>
				<br>
				<input type="submit" value=" 登陆" class="button" >
		</form>
	</div>
</body>
	<%@include file="footer.jsp" %>
</html>