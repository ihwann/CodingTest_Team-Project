<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.stevelee.java.dto.ReviewDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">

</head>
<body>

<%
	ArrayList<ReviewDto> reviews = (ArrayList<ReviewDto>)request.getAttribute("reviewList");
	
	
	/* 
	for(int i = 0; i < reviews.size(); i++) {
		System.out.println(reviews.get(i).getReview_title());
		
	} */
	

%>
	<div>
		<form style="display: inline; margin-left: 800px">
			<select name="company" >
				<%-- <c:forEach var="code" items="${ }" --%>
				<option value="">--회사 선택-- </option>
				<option value="ss">삼성</option>
				<option value="sk">SK</option>
				<option value="lg">LG</option>
				<option value="hh">한화</option>
				<option value="lt">롯데</option>
				<option value="kt">KT</option>
				<option value="etc">기타 </option> 
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
        <th scope="cols" style="width:50%">제목 </th>
        <th scope="cols" style="width:25%">작성자 </th>
        <th scope="cols" style="width:25%">작성일 </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><a href="">내용이 들어갑니다.</a></td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>

    </tr>
    <tr>
        <td><a href="">내용이 들어갑니다.</a></td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>
    </tr>
    <tr>
        <td><a href="">내용이 들어갑니다.</a></td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>
    </tr>
    </tbody>
</table>
	</div>
</body>
</html>