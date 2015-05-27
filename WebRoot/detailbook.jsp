<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<jsp:useBean id="dao" class="com.newBookShopWeb.dao.BookDao"
	scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/detailbook.css" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>
<title>Speed Book</title>
<script>
	$.validator.addMethod("selectsf", // name验证方法名     
	function(value, element) // 验证规则     
	{
		if (value == "省份") // select默认值需要设置为"none"(当然可以自定义其他值）     
		{
			return false;
		} else {
			return true;
		}
	}, "请选择正确的省份" // 默认验证消息（自定义规则信息的国际化是否不起作用？）     
	);
	$.validator.addMethod("selectcity", // name验证方法名     
	function(value, element) // 验证规则     
	{
		if (value == "地级市") // select默认值需要设置为"none"(当然可以自定义其他值）     
		{
			return false;
		} else {
			return true;
		}
	}, "请选择正确的城市" // 默认验证消息（自定义规则信息的国际化是否不起作用？）     
	);
	$.validator.addMethod("selectcountry", // name验证方法名     
	function(value, element) // 验证规则     
	{
		if (value == "市、县级市") // select默认值需要设置为"none"(当然可以自定义其他值）     
		{
			return false;
		} else {
			return true;
		}
	}, "请选择正确的县市" // 默认验证消息（自定义规则信息的国际化是否不起作用？）     
	);
	$().ready(function() {
		// validate signup form on keyup and submit
		$("#registration").validate({
			rules : {
				password : {
					required : true,
					minlength : 5
				},
				email : {
					required : true,
					email : true
				},
				againpassword : {
					required : true,
					equalTo : '#passwordInput'
				},
				s_province : {
					selectsf : "省份",
				},
				s_city : {
					selectcity : "地级市",
				},
				s_county : {
					selectcountry : "市、县级市",
				},
				address : {
					required : true,
					minlength : 6
				}

			},
		});

	});

	$(function() {
		var t = $("#goodsNum");
		$("#add").click(function() {
			t.val(parseInt(t.val()) + 1)
			setTotal();
		})
		$("#min").click(function() {
			t.val(parseInt(t.val()) - 1)
			setTotal();
		})
		function setTotal() {
			$("#total").html(
					(parseInt(t.val()) * ${sessionScope.Book.unitPrice})
							.toFixed(2));
		}
		setTotal();
	})
</script>
</head>

<body>
	<p style="width:100%; height: 2px; background-color: #c81623;"></p>
	<div class="body">
		<div class="contentback">
			<div class="content">
				<div class="bookpic">
					<img src="image/pic1.jpg" style="width: 100%; height: 100%;" />
				</div>
				<div class="detail">
					<h4>${sessionScope.Book.title}</h4>
					<div id="p1">
						<p>${sessionScope.Book.contentDescription}</p>
					</div>
					<div id="p2">
						<p>
							<a href="#">${sessionScope.Book.author }</a>
						</p>
					</div>
					<div id="p3">
						<p>
							飞书价：<b>${sessionScope.Book.unitPrice }</b> [8折]
							[原价：￥${sessionScope.Book.unitPrice/0.8}] <a href="#"> (降价通知)</a>
						</p>
					</div>
					<div class="input-wrapper" id="password-wrapper">
						<label for="address">配送地址：</label> <select id="s_province"
							name="s_province"></select> <select id="s_city" name="s_city"></select>
						<select id="s_county" name="s_county"></select>
						<script class="resources library" src="js/area.js"
							type="text/javascript"></script>
						<script type="text/javascript">
							_init_area();
						</script>
						<p>
							有货，支持 <a href="#">79免运费 </a> | <a href="#">货到付款</a>
						</p>
					</div>

					<form action="CartServlet?act=addcart&	bookISBN=${sessionScope.Book.iSBN}" method="post">
						<input type="text" value="1" id="goodsNum" name="bookNum" class="text" />
						<div class="btn">
							<input type="button" value="+" id="add" name="btn" class="btn1" />
							<input type="button" value="-" id="min" name="btn" class="btn2" />
						</div>
						<input class="submit" type="submit" value="加入购物车"></input> 当前总价：<label
							id="total" style="color: red;"></label>
					</form>
				</div>
			</div>
		</div>
	</div>

	<ul class="main">
		<p>
			<a href="BookServlet?act=tjbook&page=1"><h1>推荐图书</h1></a>
		</p>
		<li><c:set var="list" scope="page"
				value='${dao.manybooklist("unitPrice",8,1)}' /> <c:if
				test="${list!=null }">
				<c:forEach items="${list }" var="book">
					<div class="booklist">
						<div class="pic1">
							<img alt="" src="image/pic1.jpg" style="float: left;" />
						</div>
						<a href='BookServlet?act=detailbook&bookisbn=${book.iSBN}'
							class="title">${book.title }</a>
						<h4 class="author">${book.author }</h4>
						<h4 class="unitprice">￥ ${book.unitPrice }</h4>
					</div>
				</c:forEach>
			</c:if></li>

		<p>
			<a href="BookServlet?act=quantitybook&page=1"><h1>热销图书</h1></a>
		</p>
		<li><c:set var="list" scope="page"
				value='${dao.manybooklist("qunatity",8,1)}' /> <c:if
				test="${list!=null }">
				<c:forEach items="${list }" var="book">
					<div class="booklist">
						<div class="pic1">
							<img alt="" src="image/pic1.jpg" style="float: left;" />
						</div>
						<a href='BookServlet?act=detailbook&bookisbn=${book.iSBN}'
							class="title">${book.title }</a>
						<h4 class="author">${book.author }</h4>
						<h4 class="unitprice">￥ ${book.unitPrice }</h4>
					</div>
				</c:forEach>
			</c:if></li>
	</ul>
</body>
<%@ include file="footer.jsp"%>
</html>