<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台登录界面</title>
<link rel="stylesheet"   type="text/css"   href="CSS/adminLogin.css" />
</head>

<body>
    <div id="login">
    <h1>SpeedBook人工后台管理系统登录</h1>
    <p>用户名：</p>
    <span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
    <form action="AdminServlet?act=login"  method="post">
    <input type="text"  name="LoginId"  id="text"  required/>
    <input type="password"  name="LoginPwd"  id="text1"  required />
    <input type="submit"  name="button"  id="button"  value="登录" />
    <input type="reset"  name="button"  id="button1" value="重置" />
    </form>
</div>
</body>
</html>
