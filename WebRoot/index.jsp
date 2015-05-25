<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<jsp:useBean id="dao" class="com.newBookShopWeb.dao.BookDao" scope="page"></jsp:useBean>
<jsp:useBean id="cdao" class="com.newBookShopWeb.dao.CategoriesDao" scope="page"></jsp:useBean>
<jsp:useBean id="pdao" class="com.newBookShopWeb.dao.PublishersDao" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/index.css" />  
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="js/banner.js" type="text/javascript"></script>
<title>Speed Book</title>
</head>
<body >
<ul style="width:1280px; height:50px; margin: 0 auto;">
		<li style="float: left; width:150px; height:100%; background-color: #b1191a; line-height: 45px; color:#fff; ">图书种类</li>
		<li style="float: right; width: 191px; height: 100%; margin-right:13.5px; background-color:green; line-height: 45px; color:#fff; ">出版社</li>
</ul>
<p style="width:100%; height: 2px; background-color: #c81623;"></p>
<div class="content">
	<div class="left" id="kuangjia">
		<ul>
			<c:set var="list" scope="page" value="${cdao.getCategories()}"/>
				<c:if test="${list!=null }">
					<c:forEach items="${list }" var="cat">
						<li><a href='BookServlet?act=catefindbook&id=${cat.id }&page=1'>${cat.name}</a></li>
					</c:forEach>
				</c:if>
		</ul>
	</div>
	
	<div class="lunbo" id="kuangjia">
              <div class="slides">
                <ul class="slide-pic">
               		 <li class="cur"><a href="#" target="_blank"> <img alt="" src="image/1.jpg" /></a></li>
                	 <li><a href="#" target="_blank"><img alt="" src="image/2.jpg" /></a></li>
                	 <li><a href="#" target="_blank"><img alt="" src="image/3.jpg" /></a></li>
                 	 <li><a href="#" target="_blank"><img alt="" src="image/4.jpg" /></a></li>
                	 <li><a href="#" target="_blank"><img alt="" src="image/5.jpg" /></a></li>
           		 </ul>
            	<ul class="slide-li op">
                	<li class="cur"></li>
                	<li></li>
                	<li></li>
                	<li></li>
                	<li></li>
            	 </ul>
            	 <ul class="slide-li slide-txt">
                	<li class="cur"><a href="#"></a></li>
                	<li><a href="#"></a></li>
                	<li><a href="#"></a></li>
                	<li><a href="#"></a></li>
                	<li><a href="#"></a></li>
            	 </ul>
        </div>       
	</div>
	
	<div class="right" id="kuangjia" >
		<ul>
			<c:set var="list" scope="page" value="${pdao.getPublishers()}"/>
				<c:if test="${list!=null }">
					<c:forEach items="${list }" var="pub">
						<li><a href='BookServlet?act=pubfindbook&id=${pub.id }&page=1'>${pub.name}</a></li>
					</c:forEach>
				</c:if>
		</ul>
	</div>
	
	<ul class="main">
		<p><a href="BookServlet?act=hotbook&page=1"><h1>热门图书 </h1></a></p>
		<li>
		<c:set var="list" scope="page" value='${dao.manybooklist("clicks",8,1)}'/>
  			 <c:if test="${list!=null }">
   				<c:forEach items="${list }" var="book">
					<div class="booklist">
						<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div> 
						<a href='BookServlet?act=detailbook&bookisbn=${book.iSBN}' class="title" >${book.title }</a>	
                		<h4 class="author" >${book.author }</h4>
               			 <h4 class="unitprice" >￥ ${book.unitPrice }</h4>
					</div>
				</c:forEach>
			</c:if>
		</li>
		
		<p><a href="BookServlet?act=newbook&page=1"><h1>最新图书 </h1></a></p>
		<li>
		<c:set var="list" scope="page" value='${dao.manybooklist("publishdate",8,1)}'/>
  			 <c:if test="${list!=null }">
   				<c:forEach items="${list }" var="book">
					<div class="booklist">
						<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div> 
						<a href='BookServlet?act=detailbook&bookisbn=${book.iSBN}' class="title" >${book.title }</a>	
                		<h4 class="author" >${book.author }</h4>
               			 <h4 class="unitprice" >￥ ${book.unitPrice }</h4>
					</div>
				</c:forEach>
			</c:if>
		</li>
		
		<p><a href="BookServlet?act=tjbook&page=1"><h1>推荐图书 </h1></a></p>
		<li>
		<c:set var="list" scope="page" value='${dao.manybooklist("unitPrice",8,1)}'/>
  			 <c:if test="${list!=null }">
   				<c:forEach items="${list }" var="book">
					<div class="booklist">
						<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div> 
						<a href='BookServlet?act=detailbook&bookisbn=${book.iSBN}'class="title" >${book.title }</a>	
                		<h4 class="author" >${book.author }</h4>
               			 <h4 class="unitprice" >￥ ${book.unitPrice }</h4>
					</div>
				</c:forEach>
			</c:if>
		</li>
		
		<p><a href="BookServlet?act=quantitybook&page=1"><h1>热销图书 </h1></a></p>
		<li>
		<c:set var="list" scope="page" value='${dao.manybooklist("qunatity",8,1)}'/>
  			 <c:if test="${list!=null }">
   				<c:forEach items="${list }" var="book">
					<div class="booklist">
						<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div> 
						<a href='BookServlet?act=detailbook&bookisbn=${book.iSBN}' class="title" >${book.title }</a>	
                		<h4 class="author" >${book.author }</h4>
               			 <h4 class="unitprice" >￥ ${book.unitPrice }</h4>
					</div>
				</c:forEach>
			</c:if>
		</li>
	</ul>
</div>
</body>
 <%@ include file="footer.jsp" %>
</html>