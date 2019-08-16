<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.stevelee.java.dto.ReviewDto"%>
<script src="resources/jquery/jquery-1.11.3.min.js"></script>
<html>
<head>
	
	<%-- <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css"> --%>
	<title>upload or modify review</title>
</head>
<!-- 
<script>
$(document).ready(function(){
	
	var rtn = 0;
	if(rtn == 1) {
		alert('게시글 삭제 완료 되었습니다.');
	}
	
});
</script>
 -->
<body>

<div style="width:60%;margin:auto;">
	<span id="topText">코딩테스트 후기 작성  </span><br><br><br>
	<div class="form-style">
	<form action="uploadReview" method="POST">
		<select id="selbox" name="review_comp" >
			<option value="">--기업 선택-- </option>
			<c:forEach items="${compList}" var="val">
			<option value="${val}">
			 <c:out value = "${val}" />
			</option>
			</c:forEach>
			
		</select>
		<br>
		<br>
		<input type="text" class="text-style"  style="width:800px" name="review_title" placeholder="제목을 입력하세요" ><br><br>
	    
	    <textarea id="message" class="text-style" name="review_content" rows="20" cols="120" placeholder="내용을 입력해주세요 "></textarea>
	    <br><br>
		<div class="submit_div" style="width:900px">
		    <input type="submit" class="myButton" value="저장" style="float:right"> 
		    <input type="button" onClick="location='review'" class="myButton" value="뒤로" style="float:right">
		    
	    </div>
	
	</form>
	
	</div>
 	</div>
</body>
</html>