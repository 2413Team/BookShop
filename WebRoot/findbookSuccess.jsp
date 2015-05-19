<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*,com.newBookShopWeb.entity.*"%>
<jsp:useBean id="dao" class="com.newBookShopWeb.dao.BookDao" scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/manybooklist.css" type="text/css">  
<title>Insert title here</title>
</head>
<body>
   <div class="big">
   		<c:if test="${sessionScope.List!=null }">
   			<c:forEach var="b" items="${List}" begin="0" end="11">
   				<div class="small">
                	<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div>   	
                		<a href="#?ibookid=${b.id }" class="title" >${b.title }</a>	
                		<h4 class="author" >${b.author }</h4>
                		<h4 class="unitprice" >￥${b.unitPrice }</h4>
   				</div>
   		     </c:forEach>
   		</c:if>
   </div>
   <p style="margin: 0 auto; margin-top:25px; display: block; width:500px; text-align: center;">
   		<a href='BookServlet?act=${sessionScope.pageAct }&key=${sessionScope.key}&page=1&id=${sessionScope.id}'>首页</a>
   		<a href='BookServlet?act=${sessionScope.pageAct }&key=${sessionScope.key}&page=${sessionScope.page-1}&id=${sessionScope.id}'>上一页</a>
   		<%for(int i=1;i<10;i++){ %>
   			<a href='BookServlet?act=${sessionScope.pageAct }&key=${sessionScope.key }&page=<%=i%>&id=${sessionScope.id}'><%=i %></a>
   		<%} %>
   		<a href='BookServlet?act=${sessionScope.pageAct }&key=${sessionScope.key}&page=${sessionScope.page+1}&id=${sessionScope.id}'>下一页</a>
   		<a href='BookServlet?act=${sessionScope.pageAct }&key=${sessionScope.key}&page=1&id=${sessionScope.id}'></a>
   </p>
</body>
 <%@ include file="footer.jsp" %>
</html>