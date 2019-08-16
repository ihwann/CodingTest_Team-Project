<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.stevelee.java.dto.ReviewDto"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<style>
 #type01 {
 background-color:#EEF7FF;width:10%;vertical-align: middle;
 	}
</style>
</head>
<% ReviewDto review = (ReviewDto)request.getAttribute("review");%>
<body>
<div style="width:65%;margin:auto;">
<span style="margin-left:50px;font-size:30pt;"> 코딩테스트 후기 </span>
<br><br>



<form action='modifyReview' >

	
	<table class="type09" style="margin-left: 40px">
    <tbody>
    <tr>
    	<th id="type01">작성자</th>
    	<td style="text-align:left;vertical-align: middle;height:25px;"><%=review.getReview_user() %></td>
    </tr>
    <tr>
    	<th id="type01">작성일</th>
        <td style="text-align:left;vertical-align: middle;height:20px;"><%=review.getReview_date() %></td>
    </tr>
   
    <tr>
    	<th id="type01" style="height:100px;">제목</th>
    	<td style="text-align:left;vertical-align: middle;"><%=review.getReview_title() %></td>
    </tr>
    <tr>
    	<th id="type01">기업명 </th>
    	<td style="text-align:left;vertical-align: middle;height:20px;"><%=review.getReview_comp() %></td>
    </tr>
    <tr>
    	<td colspan="2" id="textbox01"><%=review.getReview_content() %></td>
    </tr>
    
    </tbody>
    
</table>
<br>

<!-- 
<input type="submit" class="large blue button"  value="수정" style="float: right">
<input type="button" onClick="location='uploadReview?id=<%=review.getReview_num() %>'" value="수정하기" style="float:right" class="large red button">
 -->
<input type="hidden" name="reviewnum" value="<%=review.getReview_num() %>">
<!--<input type="submit" class="large blue button"  value="수정하기" style="float: right"> -->
<input type="button" onClick="location='deleteReview?id=<%=review.getReview_num() %>'" value="삭제" style="float:right" class="large red button">

	
</form>
</div>
</body>
</html>