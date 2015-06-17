<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="CSS/admin_index.css" />
</head>

<body>
    <div class="header">
        <img src="image/header_left.jpg"  />
        <ul style="list-style:none;">
             <li>当前用户：${LoginId} &nbsp;&nbsp;</li>
             <li><a href="#">修改口令 &nbsp;&nbsp;</a></li>
             <li><a href="index.jsp">退出系统</a></li>
        </ul>
    </div>
    
    <div class="nav">
         <ul style="list-style:none;">
              <li><a href="admin_index.jsp">关于我们</a></li>
              <li><a href="#">客户服务</a></li>
              <li><a href="admin_book.jsp">图书管理</a></li>
              <li><a href="admin_categories.jsp">图书种类管理</a></li>
              <li><a href="admin_user.jsp">用户管理</a></li>
         </ul>
    </div>
     
     <div class="main">
       <div class="k1">
              <p>当前位置：</p>
       </div>
            <div class="k2">
                <img src="image/admin_p.gif" />
                <ul style="list-style:none;">
                     <li>当前时间：<%= new Date().toString() %></li>
                     <li>${User.loginId}</li>
                     <li>欢迎进入网站管理中心！</li>
                </ul>
            </div>
            <div class="k3"></div>
            <div class="k4">
                <ul style="list-style:none;">
                     <li>登陆账号：<span>${User.loginId}</span></li>
                        <li>真实姓名：<span>${User.name }</span></li>
                        <li>邮箱：<span>${User.mail }</span></li>
                        <li>IP地址：<span>216.192.168.400</span></li>
                        <li>你好</li>
            </div>
     </div>
</body>
</html>
