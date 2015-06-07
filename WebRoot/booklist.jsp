<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.newBookShopWeb.entity.*"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/booklist.css">
  </head>
  
  
  <body>
  <c:catch var="e">
   	<c:if test="${sessionScope.List!=null }">
  	 	<c:forEach var="b" items="${List}">
            <div style="width: 100%; float: left; margin-left:1%;border-bottom: 1px  #999 solid; " class="booklist">
            	<ul style="list-style: none;">
            		<li>
            			<div style="overflow: hidden;"><a href="adminBook.jsp">${b.title}</a></div>
            			<div style="float: left;" class="unitprice">￥${b.unitPrice}</div>
            			<div style="float: left; margin-left: 15px; ">${b.author}</div>  			
            			<div style="float: right; margin-right: 15px;"><input type="radio" name="select"/></div>
            		</li>
            	</ul>
            </div>
      </c:forEach>
   	</c:if>
   </c:catch>
   <c:out value="${e}"></c:out>
  </body>
</html>
