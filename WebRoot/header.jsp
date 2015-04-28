<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/header.css" type="text/css">  
<title>Speed Book</title>
</head>
<body>
       <div class="header">
       <div class="user">  
            <ul>
                <li>你好！请登陆</li>
                <li><a href="register.jsp">注册</a></li>
                <li><a href="Login.jsp">登陆</a></li>
                <li><a href="">购物车</a>(0)</li>
            </ul>
      </div>  
      <div class="search">
            <a href="#"  class="logo"></a> 
            <form action="" method="post" id=search name="search">
                      <input type="text"  value=""  id="text"  name="text"  class="text"/>
                      <input type="button"  value="搜索"  id="btn"  name="btn"  class="btn"/>
            </form>      
      </div> 
            <div class="nav">
              <ul>
                      <li class="first"><a href="#">首页</a></li>
                      <li><a href="">最热书籍</a></li>
                      <li><a href="">最新书籍</a></li>
                      <li><a href="">新书推荐</a></li>
                      <li><a href="">关于我们</a></li>
                      <li><a href="">站内内容</a></li>
              </ul>
      </div>
       </div>
</body>
</html>