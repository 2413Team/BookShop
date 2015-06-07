<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%@include file="header.jsp" %>
  <body>
    <div style="width:720px; height:180px; margin: 0 auto; margin-top: 20px;">
    	<img alt="" src="image/pic1.jpg" style="float: left;"/>
    	<h2 style="width: 300px; float: left; text-indent:3px; font-size: 18px;">${sessionScope.Book.title}</h2>
    	<h1 style="text-align: right; float: right;">已加入购物车！</h1>
    	<div style="float: right; height: 30px; width:70%; margin-top: 5px; text-align: right;">
    		<p>小计：￥${sessionScope.UnitPrice*sessionScope.Quantity }</p>
    		<p>数量：${sessionScope.Quantity }</p>
    	</div>
    	<div style="float: right; height: 20px; width:70%; margin-top: 47px; text-align: right;">
    		<a href="CartServlet?act=getcart" >去购物车结算</a>
    		<a href="#" >继续购物</a>
    	</div>
    </div>
  </body>
  <%@include file="footer.jsp" %>
</html>
