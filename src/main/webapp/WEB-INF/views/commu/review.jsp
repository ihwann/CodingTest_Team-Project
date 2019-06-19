<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">

</head>
<body>

	<div>
		<form style="display: inline; margin-left: 800px">
			<select name="company" >
				<option value="">--회사 선택-- </option>
				<c:forEach items="${compList}" var="val">
				<option value="${val}">
				 <c:out value = "${val}" />
				</option>
				</c:forEach>
				
			</select>       
			&nbsp; &nbsp;&nbsp; 
			<input class="keyword"type="text" placeholder="Search..">
			&nbsp;
			<input class="myButton" type="submit" value="조회 ">
			
			
		</form>
	</div>
	
	<br><br>
	
	<div style="width:1400px">
	
	<table class="type09" style="margin-left: 40px">
    <thead>
    <tr>
        <th scope="cols" style="width:60%">제목 </th>
        <th scope="cols" style="width:20%">작성자 </th>
        <th scope="cols" style="width:20%">작성일 </th>
    </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${reviewList}" var="val">
    <tr>
    	<td><a href="showReview?id=${val.getReview_num()}"><c:out value = "${val.review_title}" /></a></td>
    	<td><c:out value = "${val.review_user}" /></td>
    	<td><c:out value = "${val.review_date}" /></td>
    </tr>
    </c:forEach>
    
    	
  
    </tbody>
</table>
<br>
<input type="button" class="myButton" value="후기 작성" onClick="location='uploadAndModify.jsp'"
	style="margin-left:1350px;">
	</div>
	
	
</body>
</html>