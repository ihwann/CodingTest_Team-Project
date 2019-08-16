<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	window.onload=function() {
		var check = "${loginCheck}";
		
		if(check === "allOk"){
			alert("로그인이 성공하셨습니다");
			
			location.href = "/";
			
		} else if (check === "idOk") {
			alert("비밀번호가 틀렸으니 다시 로그인해주세요");
			
			location.href="/login";
		} else {
			alert("이메일이 틀렸으니 다시 로그인해주세요");
			
			location.href="/login";
		}
		
		
	};
</script>