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

<b><%=review.getReview_date() %></b>
<br><br>
<%=review.getReview_user() %>
<br><br>
<%=review.getReview_title() %>
<br><br>
<%=review.getReview_comp() %>
<br><br>
<%=review.getReview_content() %>
<br><br>

<input type="submit" value="수정">
</form>

</body>
</html>