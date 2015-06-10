<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ include file="header.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=stylesheet href="CSS/revisebook.css" type="text/css">  
<title>Speed Book</title>
</head>
<body>
      <div class="content">
              <ul>
                    <li>
                        <label for="Title" ><b>标题:</b></label>
                        <input type="text" name="title"  class="right" />
                    </li>
                     <li>
                        <label for="Author"><b>作者:</b></label>
                        <input type="text" name="author" class="right"/>
                    </li>
                     <li>
                        <label for="PublisherId"><b>出版社ID:</b></label>
                        <input type="text" name="PublisherId" class="right"/>
                    </li>
                    <li>
                        <label for="PublishDate"><b>出版日期:</b></label>
                        <input type="text" name="PublishDate" class="right"/>
                    </li>
                    <li>
                        <label for="ISBN"><b>ISBN:</b></label>
                        <input type="text" name="ISBN" class="right"/>
                    </li>
                    <li>
                         <label for="WordsCount"><b>总字数:</b></label>
                         <input type="text" name="ISBN" class="right"/>
                    </li>
                    <li>
                         <label for="UnitPrice"><b>价格:</b></label>
                         <input type="text" name="UnitPrice" class="right"/>
                    </li>
                     <li>
                          <label for="ContentDescription"><b>内容简介:</b><br></label>
                          <textarea name="ContentDescription" cols="37" rows="5"  ></textarea>
                     </li>
                     <li>
                          <label for="AurhorDescription"  ><b>作者简介:</b><br></label>
                          <textarea name="AurhorDescription" cols="37" rows="5"  ></textarea>
                     </li>
                     <li>
                          <label for="EditorComment"><b>评价:</b><br></label>
                          <textarea name="EditorComment" cols="37" rows="5"  ></textarea>
                     </li>
                     <li>
                          <label for="TOC"><b>TOC:</b><br></label>
                          <textarea name="TOC" cols="37" rows="5"  ></textarea>
                     </li>
                     <li>
                         <label for="CategoryId"><b>种类ID:</b></label>
                         <input type="text" name="CategoryId" class="right"/>
                    </li>
                    <li>
                         <label for="Clicks"><b>点击数:</b></label>
                         <input type="text" name="Clicks" class="right"/>
                    </li>
              </ul>
      </div>

</body>
 <%@ include file="footer.jsp" %>
</html>