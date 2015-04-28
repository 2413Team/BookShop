<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/index.css" type="text/css">  
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="js/banner.js" type="text/javascript"></script>
<title>Speed Book</title>
</head>
<body>
       	<div class="content">
              <div id="categorylist">
                      <div class="sback">种类列表</div>
              </div>
              
              <div id="lunbo">
              <div class="slides">
                <ul class="slide-image">
                <li class="cur"><a href="#" target="_blank">
                    <img alt="" src="image/1.jpg" /></a></li>
                <li><a href="#" target="_blank">
                    <img alt="" src="image/2.jpg" /></a></li>
                <li><a href="#" target="_blank">
                    <img alt="" src="image/3.jpg" /></a></li>
                <li><a href="#" target="_blank">
                    <img alt="" src="image/4.jpg" /></a></li>
                <li><a href="#" target="_blank">
                    <img alt="" src="image/5.jpg" /></a></li>
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
              
              <div id="kefu">
                      <div class="sback">客户投诉</div>
                      
              </div>
              <div id="hotbook">
                      <div class="bback">最热图书</div>
              </div>
              <div id="newbook">
                      <div class="bback">最新图书</div>
              </div>
              <div id="tjbook">
                      <div class="bback">推荐图书</div>
              </div>
       </div>
      
</body>
 <%@ include file="footer.jsp" %>
</html>