<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.*,com.newBookShopWeb.entity.*"%>
	<jsp:useBean id="dao" class="com.newBookShopWeb.dao.BookDao" scope="session" />
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/manybooklist.css" type="text/css">  
<title>Insert title here</title>
</head>
<body>
   <div class="big">
   <c:set var="list" scope="session" value='${dao.manybooklist("clicks",12,1)}'/>
   <c:if test="${list!=null }">
   		<c:forEach items="${list }" var="book">
   				<div class="small">
                	<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div>   	
                		<a href='#?bookid=${book.id}'class="title" >${book.title}</a>	
                		<h4 class="author" >${book.author }</h4>
                		<h4 class="unitprice" >￥${book.unitPrice }</h4>
   				</div>
   		</c:forEach>
   	</c:if>
   </div>
   <p style="margin: 0 auto; margin-top:25px; display: block; width:500px; text-align: center;">
   		<a href="#">上一页</a>
   		<%for(int j=1;j<10;j++){ %>
   			<a href="hotbook.jsp?pageNum=<%=j%>"><%=j %></a>
   		<%} %>
   		<a href="#">下一页</a>
   </p>
</body>
 <%@ include file="footer.jsp" %>
</html>