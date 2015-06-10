<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ include file="header.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/order.css" type="text/css">  
<title>Insert title here</title>
</head>
<body>
       <div class="content">
       <div id="title">
            <h3>填写并核对订单信息</h3>
        </div>
             <div class="user">
                <h5>收货人信息</h5>
           
                <span><b>${applicationScope.user.name}</b> 配送到：${applicationScope.user.address }</span>
             </div>
             <div class="buyer">
                <h5>付款方式</h5>
                <input type="radio" id="buy1" name="buy"  value="1" />  货到付款<br>
                <input type="radio" id="buy2" name="buy"  value="2" />  网银支付（暂时无用）
  
             </div>
             <div  class="order">
                 <h5>送货清单</h5>
                 <div class="leftorder">
                       <h5>配送方式</h5>
                        <input type="radio" id="order1" name="order"  value="1" />  快递送货
                       <input type="radio" id="order2" name="order"  value="2" />  上门自提
                 </div>
                   <div class="rightorder">
                   <table  border="1" cellspacing="0" cellpadding="0"  bordercolor="#ffffff"  height="50px"; >
                   <tr>
						<td align="center"  bgcolor="#00a0d8">封面</td>
				    	<td align="center"  bgcolor="#00a0d8">书名</td> 
						<td align="center"  bgcolor="#00a0d8">单价</td>
						<td align="center"  bgcolor="#00a0d8" >数量</td>					
					</tr>
					<c:forEach items="${sessionScope.Cart}" var="cart">
                 	  <tr >
					     <td bgcolor="#e8e8e8" align="center" ><img alt="" src="picpath/1.jpg"  /></td>
					     <td bgcolor="#e8e8e8" align="center" ><a href="BookServlet?act=detailbook&bookisbn=${cart.bookISBN}">${cart.book.title}</a></td>
					     <td bgcolor="#e8e8e8" align="center" >${cart.book.unitPrice*cart.quantity}</td>
					     <td bgcolor="#e8e8e8" align="center" >${cart.quantity}</td>
					  </tr>	
					 </c:forEach>
                   </table>
                 </div>
             </div>

           	    <form action="OrderServlet?act=submitorder&total=${sessionScope.Total}" method="post">    	
					<input type="submit" value="结算"  class="smallorder"  id="smallorder"  name="order" /> 
				</form>
				 <p><b>商品总价：</b>${sessionScope.Total}</p>
       </div>
</body>
 <%@ include file="footer.jsp" %>
</html>