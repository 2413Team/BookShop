<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/myorder.css" type="text/css">  
<title>Insert title here</title>
</head>
<body>
      <div class="content">
      <table  border="1" cellspacing="0" cellpadding="0"  bordercolor="#ffffff"  height="50px"; >
					<tr>
						<td align="center"  bgcolor="#00a0d8" height="30px">收货人姓名</td>
						<td align="center"  bgcolor="#00a0d8">收货人地址</td>
				    	<td align="center"  bgcolor="#00a0d8">书名</td> 
						<td align="center"  bgcolor="#00a0d8">单价</td>
						<td align="center"  bgcolor="#00a0d8" >数量</td>
						<td align="center"  bgcolor="#00a0d8">付款方式</td>
						<td align="center"  bgcolor="#00a0d8">是否收货</td>
					</tr>
					<c:forEach items="${sessionScope.Cart}" var="cart">
					<tr class="tr1">
					     <td bgcolor="#e8e8e8" align="center" height="30px">${applicationScope.user.name }</td>
					      <td bgcolor="#e8e8e8" align="center" >${applicationScope.user.address }</td>
					     <td bgcolor="#e8e8e8" align="center" >${cart.book.title}</td>
					     <td bgcolor="#e8e8e8" align="center" >${cart.book.unitPrice*cart.quantity}</td>
					     <td bgcolor="#e8e8e8" align="center" >${cart.quantity} </td>
					     <td bgcolor="#e8e8e8" align="center" >货到付款</td>
					     <td bgcolor="#e8e8e8" align="center" >否</td>
					</tr>		
					</c:forEach>	
				</table>   
      </div>

</body>
 <%@ include file="footer.jsp" %>
</html>