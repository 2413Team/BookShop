<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*,com.newBookShopWeb.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/admin_book.css" />
<title>Insert title here</title>
</head>
<body>
<p style="width:100%; height: 2px; background-color: #c81623;"></p>
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
              <li><a href="admin_index.jsp">关于我们</a></li>
              <li><a href="#">客户服务</a></li>
              <li><a href="admin_book.jsp">图书管理</a></li>
              <li><a href="admin_categories.jsp">图书种类管理</a></li>
              <li><a href="#">用户管理</a></li>
         </ul>
    </div>
          <div class="search">
            <form action="BookServlet?act=get" method="post" id=search name="search">
                      <input type="text"  value=""  id="text"  name="Name"  class="text"/>
                      <input type="submit"  value="搜索"  id="btn"  name="btn"  class="btn"/>
            </form>      
      </div>
	<div class="list">
		<c:catch var="e">
			<c:if test="${sessionScope.List!=null }">
				<c:forEach var="b" items="${List}">
					<div
						style="width: 100%; float: left; margin-left:1%;border-bottom: 1px  #999 solid; "
						class="booklist">
						<ul style="list-style: none;">
							<li>
								<div style="overflow: hidden;">
									<a href="BookServlet?act=detailbook&bookisbn=${book.iSBN}'">${b.title}</a>
								</div>
								<div style="float: left;" class="unitprice">￥${b.unitPrice}</div>
								<div style="float: left; margin-left: 15px; ">${b.author}</div>
								<div style="float: right; margin-right: 15px;">
									<a href="AdminBookServlet?act=getbook&bookisbn=${b.iSBN}">修改</a>
									<a href="AdminBookServlet?act=deletebook&bookid=${b.id}">删除</a>
								</div>
							</li>
						</ul>
					</div>
				</c:forEach>
			</c:if>
		</c:catch>
		<c:out value="${e}"></c:out>
	</div>
	<a href="javascript:window.open('admin_addbook.jsp','newwindow','height=600,width=250,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no')"  class="btnAdd">添加</a>

</body>
</html>