<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/adminBook.css" />
<title>Insert title here</title>
</head>
<body>
<div class="header">
        <img src="image/header_left.jpg"  />
        <ul style="list-style:none;">
             <li>当前用户：admin &nbsp;&nbsp;</li>
             <li><a href="#">修改口令 &nbsp;&nbsp;</a></li>
             <li><a href="index.jsp">退出系统</a></li>
        </ul>
    </div>
    
    <div class="nav">
         <ul style="list-style:none;">
              <li><a href="adminIndex.jsp">关于我们</a></li>
              <li><a href="#">客户服务</a></li>
              <li><a href="adminBook.jsp">图书管理</a></li>
              <li><a href="order.jsp">订单管理</a></li>
              <li><a href="#">用户管理</a></li>
         </ul>
    </div>
          <div class="search">
            <form action="" method="post" id=search name="search">
                      <input type="text"  value=""  id="text"  name="text"  class="text"/>
                      <input type="button"  value="搜索"  id="btn"  name="btn"  class="btn"/>
            </form>      
      </div> 
      <div class="list">
      
      </div>
       
       <input type="button"  value="增"  id="btn"  name="btn"  class="btnAdd"/>
       <input type="button"  value="删"  id="btn"  name="btn"  class="btnDel"/>
       <input type="button"  value="改"  id="btn"  name="btn"  class="btnUpt"/>
       <input type="button"  value="查"  id="btn"  name="btn"  class="btnSel"/>
      

</body>
</html>