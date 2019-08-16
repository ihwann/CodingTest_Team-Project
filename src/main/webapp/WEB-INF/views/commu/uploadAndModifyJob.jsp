<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title> Upload Job Recruit</title>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
	
<body>

<div style="width:60%;margin:auto;">
	<span id="topText">구인 작성  </span><br><br><br>
	<div class="form-style">
	<form action="uploadJob" method="POST">
	
	<select id="selbox" name="job_main_lang" >
				<option value="">--언어 선택-- </option>
				<c:forEach items="${job_main_lang_list}" var="val">
				<option value="${val}">
				 <c:out value = "${val}" />
				</option>
				</c:forEach> 
	</select><br><br>
	<select  id="selbox" name="job_field" >
				<option value="">--분야 선택-- </option>
				<c:forEach items="${job_field_list}" var="val">
				<option value="${val}">
				 <c:out value = "${val}" />
				</option>
				</c:forEach>
	</select><br><br>
	<select  id="selbox" name="job_loc" >
				<option value="">--지역 선택-- </option>
				<c:forEach items="${job_loc_list}" var="val">
				<option value="${val}">
				 <c:out value = "${val}" />
				</option>
				</c:forEach>
	</select>
	<br><br>
	<select id="selbox" name="job_smsi" >
		<option value="">--SM/SI--</option>
		<option value="SM">SM</option>
		<option value="SI">SI</option>
	</select>
	
	<br>
	<br>
	<input type="text" class="text-style"  style="width:800px" name="job_title" placeholder="제목을 입력하세요"><br><br>
    
    <textarea id="message" class="text-style" name="job_content" rows="20" cols="120" placeholder="내용을 입력해주세요 "></textarea>
    <br><br>
	<div class="submit_div" style="width:900px">
    <input type="submit" class="myButton" value="저장" style="float:right"> 
    <input type="button" onClick="location='jobs'" class="myButton" value="뒤로" style="float:right">
    
    </div>
	
	</form>
	
</div>
 	</div>
</body>
</html>
