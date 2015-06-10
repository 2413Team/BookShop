
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
       			<c:if test="${applicationScope.user==null}">
            		<ul>
                		<li><a href="user_register.jsp">注册</a></li>
            	    	<li><a href="user_login.jsp">登录</a></li>
          		      	<li><a href="">购物车</a>(<a href="">0</a>)</li>
          	 	 	</ul>
          	  </c:if>
           	 <c:if test="${applicationScope.user!=null}">
            		<ul>
                		<li>欢迎回来!   <a href="#">${applicationScope.user.loginId }</a></li>
                		<li><a href="CartServlet?act=getcart&goorder=false">购物车</a>(<a href="">?</a>)</li>
                		<li><a href="userAct?act=exit">退出登录</a></li>
            		</ul>
        	    </c:if>
     	 </div>  
    <div class="headercontent">
      	<div class="search">
           	 <a href="index.jsp"  class="logo"></a> 
           	 <form action="BookServlet?act=findbook&page=1" method="post" id=search >
            	          <input type="text"  id="text"  name="key"  class="text"/>
            	          <input type="submit"  value="搜索"  id="btn"  name="btn"  class="btn"/>
        	    </form>      
      	</div> 
      	<div class="twoforhorse">
      	</div>
      </div>
	  </div>
</body>
</html>