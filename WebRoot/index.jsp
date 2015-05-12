<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/index.css" />  
<title>Speed Book</title>
</head>
<body >
<div class="content">
	<div class="left" id="kuangjia">
		<ul>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
			<li><a href="#">test</a></li>
		</ul>
	</div>
	
	<div class="lunbo" id="kuangjia">
			轮播器	
	</div>
	
	<div class="right" id="kuangjia" >
		<h1>右</h1>
	</div>
	
	<ul class="main">
		<p><a href="hotbook.jsp"><h1>热门图书 </h1></a></p>
		<li>
			<%for(int i=0;i<8;i++) {%>
			<div class="booklist">
				<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div> 
				<a href="#" class="title" >标题标题标题标题标题标题标题标题标题标题</a>	
                <h4 class="author" >作者作者作者作者作者作者作者作者 </h4>
                <h4 class="unitprice" >￥ 0.00</h4>
			</div>
			<% }%>
		</li>
		
		<p><a href="newbook.jsp"><h1>最新图书 </h1></a></p>
		<li>
			<%for(int i=0;i<8;i++) {%>
			<div class="booklist">
				<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div> 
				<a href="#" class="title" >标题标题标题标题标题标题标题标题标题标题</a>	
                <h4 class="author" >作者作者作者作者作者作者作者作者 </h4>
                <h4 class="unitprice" >￥ 0.00</h4>
			</div>
			<% }%>
		</li>
		
		<p><a href="tjbook.jsp"><h1>推荐图书 </h1></a></p>
		<li>
		  	<%for(int i=0;i<8;i++) {%>
			<div class="booklist">
				<div class="pic1"><img alt="" src="image/pic1.jpg"  style="float: left;"/></div> 
				<a href="#" class="title" >标题标题标题标题标题标题标题标题标题标题</a>	
                <h4 class="author" >作者作者作者作者作者作者作者作者 </h4>
                <h4 class="unitprice" >￥ 0.00</h4>
			</div>
			<% }%>
		</li>
	</ul>
</div>
</body>
 <%@ include file="footer.jsp" %>
</html>