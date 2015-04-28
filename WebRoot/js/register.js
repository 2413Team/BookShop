 function everyThingIsOk(){
        	  if(document.all.loginPwdRe.value != document.all.loginPwd.value)
        	 {      
        		  document.getElementById("passIsOk").innerHTML = "两次密码不一样！"
        		  return false;
             }
        	  else
        		  document.getElementById("passIsOk").innerHTML = ""
        	  
        	var sMobile = document.all.phone.value
          	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile)))
          	{
          		document.getElementById("phoneIsOk").innerHTML = "不是完整的11位手机号或者正确的手机号前七位！"
          		return false;
          	}
        	  document.getElementById("phoneIsOk").innerHTML = ""
        		  
        	var sMail = document.all.mail.value
        	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;      
        	if(!reg.test(sMail))
        	{ 
        	    document.getElementById("mailIsOk").innerHTML = "邮箱输入有误！"
        	    return false;
        	}        
        	else
            document.getElementById("mailIsOk").innerHTML = ""
        return true;
 }
 
 function loginPwdIsOk(){
	 if(document.all.loginPwdRe.value != document.all.loginPwd.value)
	 {      
		  document.getElementById("passIsOk").innerHTML = "两次密码不一样！"
		  return false;
     }
	  else
		  document.getElementById("passIsOk").innerHTML = ""
 }
 
 function teleIsOk(){
	 var sMobile = document.all.phone.value
   	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile)))
   	{
   		document.getElementById("phoneIsOk").innerHTML = "不是完整的11位手机号或者正确的手机号前七位！"
   		return false;
   	}
 	  document.getElementById("phoneIsOk").innerHTML = ""
 }
 
 function mailIsOk(){
	 var sMail = document.all.mail.value
 	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;      
 	if(!reg.test(sMail))
 	{ 
 	    document.getElementById("mailIsOk").innerHTML = "邮箱输入有误！"
 	    return false;
 	}        
 	else
     document.getElementById("mailIsOk").innerHTML = ""
 }
 
 
 
 
 
