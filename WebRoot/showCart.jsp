<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Speed Book</title>
<SCRIPT LANGUAGE="JavaScript">
	function ck(b) {
		var input = document.getElementsByTagName("input");

		for (var i = 0; i < input.length; i++) {
			if (input[i].type == "checkbox")
				input[i].checked = b;
		}
	}
</SCRIPT>
<link href="CSS/showcart.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<p style="width:100%; height: 2px; background-color: #c81623;"></p>
	<div class="cart">
		<div class="detail">
			<c:if test="${sessionScope.Cart!=null }">
			<table border="1" cellspacing="0" cellpadding="0"
				bordercolor="#ffffff" height="50px"; >
				<tr>
					<td align="center" bgcolor="#00a0d8"><input type="button"
						onclick="ck(true)" value="全部选择" class="check"></td>
					<td align="center" bgcolor="#00a0d8">图片</td>
					<td align="center" bgcolor="#00a0d8">书名</td>
					<td align="center" bgcolor="#00a0d8">单价</td>
					<td align="center" bgcolor="#00a0d8">数量</td>
					<td align="center" bgcolor="#00a0d8">操作</td>

				</tr>
					<c:forEach items="${sessionScope.Cart}" var="cart">
						<tr class="tr1">
							<td bgcolor="#e8e8e8" align="center"><INPUT TYPE="checkbox"
								NAME="a"></td>
							<td bgcolor="#e8e8e8" align="center"><img alt=""
								src="picpath/ASP2.0.jpg" /></td>
							<td bgcolor="#e8e8e8" align="center">${cart.book.title}</td>
							<td bgcolor="#e8e8e8" align="center">
								<label id="UnitPrice">${cart.book.unitPrice*cart.quantity}</label>
							</td>
							<td bgcolor="#e8e8e8" align="center">
								<a id="btn" name="btn" class="btn1" href="CartServlet?act=changequantity&doing=down&cartbookid=${cart.id}" >-</a>
								<input type="text" value="${cart.quantity}" id="text" name="text"	class="text" />
								<a id="btn" name="btn" class="btn2" href="CartServlet?act=changequantity&doing=up&cartbookid=${cart.id}" >+</a>
							</td>
							<td bgcolor="#e8e8e8" align="center">
								<a href="CartServlet?act=deletecartbook&bookISBN=${cart.bookISBN}">删除</a>
							</td>
						</tr>
					</c:forEach>
				<tr>
					<td align="center"><input type="button" onclick="ck(false)"
						value="取消全选"></td>
				</tr>
			</table>
			<p>当前总价：${sessionScope.Total}</p>
		  </c:if>
		  <c:if test="${sessionScope.Cart==null }">
		  		<h1>你的购物车为空！！！！</h1>
		  </c:if>

			<form>

				<input type="submit" value="继续购物" class="continue" id="continue"
					name="continue" /> 
				<input type="submit" value="提交订单" class="order"
					id="order" name="order" /> 
				<a class="clear" id="clear" name="clear"  href="CartServlet?act=clearcart"  style="width:20px; height: 10px;">清空购物车</a>
			</form>

		</div>
	</div>
</body>
<%@ include file="footer.jsp"%>
</html>