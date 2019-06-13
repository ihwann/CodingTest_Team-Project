<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.11.3.min.js"></script>


<script>
$(document).ready(function(){

$("#email").blur(function(){
	alert('eamil2');
});
});
</script>
<title>Insert title here</title>
</head>
<body>
name : <input type = "text" id = "name" name="name"><br>
email : <input type="text" id = "email" name ="email">
</body>
</html>