
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
                <li><a href="register.jsp">注册</a></li>
                <li><a href="Login.jsp">登陆</a></li>
                <li><a href="">购物车</a>(<a href="">0</a>)</li>
            </ul>
      </div>  
      <div class="search">
            <a href="index.jsp"  class="logo"></a> 
            <form action="BookServlet?act=findbook" method="post" id=search >
                      <input type="text"  id="text"  name="key"  class="text"/>
                      <input type="submit"  value="搜索"  id="btn"  name="btn"  class="btn"/>
            </form>      
      </div> 
    </div>
  </div>
</body>
</html>