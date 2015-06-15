<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_addbook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form>
    	<label>书名</label>
    	<br />
    	<input type="text" name="Title">
    	<br />
    	<label>作者</label>
    	<br />
    	<input type="text" name="Author">
    	<br />
    	<label>ISBN</label>
    	<br />
    	<input type="text" name="ISBN">
    	<br />
    	<label>总字数</label>
    	<br />
    	<input type="text" name="WordsCount">
    	<br />
    	<label>单价</label>
    	<br />
    	<input type="text" name="UnitPrice">
    	<br />
    	<label>图书简介</label>
    	<br />
    	<textarea rows="5" cols="20" name="ContentDescription" ></textarea>
    	<br />
    	<label>作者简介</label>
    	<br />
    	<textarea rows="5" cols="20" name="AurhorDescription" ></textarea>
    	<br />
    	<label>内容简介</label>
    	<br />
    	<textarea rows="5" cols="20" name="EditorComment" ></textarea>
    	<br />
    	<label>目录</label>
    	<br />
    	<textarea rows="5" cols="20" name="Toc" ></textarea>
    	<br />
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
