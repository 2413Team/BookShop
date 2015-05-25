<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ include file="header.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/detailbook.css" type="text/css">  
<script language="javascript" src="js/register.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/jquery.validate.js"></script>
<title>Speed Book</title>
<script>
	$.validator.addMethod(        
                "selectsf",                             // name验证方法名     
                function(value, element)        // 验证规则     
                {     
                        if (value == "省份")        // select默认值需要设置为"none"(当然可以自定义其他值）     
                        {        
                                return false;        
                        }        
                        else        
                        {     
                                return true;        
                        }     
                },        
                "请选择正确的省份"        // 默认验证消息（自定义规则信息的国际化是否不起作用？）     
        );   
    $.validator.addMethod(        
                "selectcity",                             // name验证方法名     
                function(value, element)        // 验证规则     
                {     
                        if (value == "地级市")        // select默认值需要设置为"none"(当然可以自定义其他值）     
                        {        
                                return false;        
                        }        
                        else        
                        {     
                                return true;        
                        }     
                },        
                "请选择正确的城市"        // 默认验证消息（自定义规则信息的国际化是否不起作用？）     
        );  
   $.validator.addMethod(        
                "selectcountry",                             // name验证方法名     
                function(value, element)        // 验证规则     
                {     
                        if (value == "市、县级市")        // select默认值需要设置为"none"(当然可以自定义其他值）     
                        {        
                                return false;        
                        }        
                        else        
                        {     
                                return true;        
                        }     
                },        
                "请选择正确的县市"        // 默认验证消息（自定义规则信息的国际化是否不起作用？）     
        );    
	$().ready(function() {
	// validate signup form on keyup and submit
		$("#registration").validate({
			rules: {
				password: {
					required: true,
					minlength: 5
				},
				email: {
					required: true,
					email: true
				},
				againpassword:{
					required:true,
					equalTo:'#passwordInput'
				},
				s_province:{
					selectsf:"省份",
				},
				s_city:{
					selectcity:"地级市",
				},
				s_county:{
					selectcountry:"市、县级市",
				},
				address:{
					required:true,
					minlength: 6
				}
				
			},
		});
	
	});
	</script>
</head>

<body>
	<p style="width:100%; height: 2px; background-color: #c81623;"></p>
    <div class="body">
        <div class="content">
             <div  class="bookpic">
                   
             </div>
             <div class="detail">
             <c:forEach var="b" items="${sessionScope.List}">
             <h4>${b.title}</h4>
                   <div id="p1">
                         <p>${b.contentDescription}</p>
                     </div>
                       <div id="p2">
                         <p><a href="#">${b.author }</a></p>
                     </div>
                       <div id="p3">
                         <p> 飞书价：<b>${b.unitPrice }</b> [8折] [原价：￥${b.unitPrice/0.8}] <a href="#"> (降价通知)</a></p>
                     </div>
               </c:forEach>   
                <div class="input-wrapper" id="password-wrapper">
          		<label for="address">配送地址：</label>
				<select id="s_province" name="s_province"></select>  
	    		<select id="s_city" name="s_city" ></select>  
	    		<select id="s_county" name="s_county"></select>
	    		<script class="resources library" src="js/area.js" type="text/javascript"></script>
	    		<script type="text/javascript">_init_area();</script>
	    		<p>有货，支持 <a href="#">79免运费 </a> |  <a href="#">货到付款</a></p>
	    		</div>	 
	    		

                      <input type="text"  value=""  id="text"  name="text"  class="text"/>
                      <div class="btn">
                      <input type="button"  value="+"  id="btn"  name="btn"  class="btn1"/>
                       <input type="button"  value="-"  id="btn"  name="btn"  class="btn2"/>
                       </div>
                  
	    		<button class="submit" type="submit">加入购物车</button>

        </div>
        </div>
        
        </div>
</body>

 <%@ include file="footer.jsp" %>
</html>