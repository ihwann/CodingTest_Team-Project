<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">
	<title>upload or modify review</title>
</head>
<body>

	<div class="form-style">
	<form>
	<select>
	    <option selected>회사 선택 </option>
	    <option>삼성 </option>
	    <option>SK</option>
	    <option>LG</option>
	    <option>한화 </option>
	    <option>롯데 </option>
	    <option>기타 </option>
	</select>
	<br>
	<br>
	<input type="text" class="text-style"  style="width:800px;"name="title" placeholder="제목을 입력하세요"><br><br>
    
    <textarea id="message" class="text-style" name="message" rows="20" cols="120" placeholder="내용을 입력해주세요 "></textarea>
    <br><br>
	<div class="submit_div" style="width:900px">
    <input type="submit" class="myButton" value=" 저장 " style="float:right"> 
    <input type="button" class="myButton" value="뒤로" style="float:right">
    
    </div>
	
	</form>

</div>
 	
</body>
</html>