<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.stevelee.java.dto.ReviewDto"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
</head>
<body>

<% ReviewDto review = (ReviewDto)request.getAttribute("review");
%>
<form action='modifyReview?id=<%=review.getReview_num()%>' >



<div style="width:1400px">
	
	<table class="type09" style="margin-left: 40px">
    <tbody>
    <tr>
    	<th scope="cols" style="width:8%;">작성일</th>
        <td style="text-align:left;"><%=review.getReview_date() %></td>
    </tr>
    <tr>
    	<th scope="cols" style="width:8%">작성자</th>
    	<td style="text-align:left;"><%=review.getReview_user() %></td>
    </tr>
    <tr>
    	<th scope="cols" style="width:8%">제목</th>
    	<td style="text-align:left;"><%=review.getReview_title() %></td>
    </tr>
    <tr>
    	<th scope="cols" style="width:8%">회사</th>
    	<td style="text-align:left;"><%=review.getReview_comp() %></td>
    </tr>
    <tr>
    	<td><%=review.getReview_content() %></td>
    </tr>
    <tbody>
    
    	
  
    </tbody>
</table>
<br>
<input type="submit" style="margin-left: 1350px"class="myButton" value="수정">
	</div>
</form>

</body>
</html>