<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.11.3.min.js"></script>
<title>Insert title here</title>
<script>
$(document).ready(function() {
$('#user_eMail').blur(function() {
	var user_eMail = $('#user_eMail').val();
	var emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	$.ajax({
		url : '${pageContext.request.contextPath}/eMailchk?user_eMail='+ user_eMail,
		type : 'get',
		success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data >= 1) {
					// 1 : 아이디가 중복되는 문구
					$("#email_check").text("사용중인 이메일입니다");
					$("#email_check").css("color", "red");
					$("#reg_submit").attr("disabled", true);
				} else {
					if(user_eMail.match(emailExp) != null){
						$("#email_check").text("올바른 이메일 형식이 아닙니다.");
						$("#email_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					}else{
						$("#email_check").text("사용가능한 이메일 입니다.");
						$("#email_check").css("color", "white");
						$("#reg_submit").attr("disabled", false);	
					}
					
				}
			}, error : function() {
					console.log("실패");
			}
		});
	});
});
</script>
<script>
	$(document).ready(function() {
		$("#user_pw2").blur(function() {
			if ($('#user_pw1').val() != $(this).val()) {
				$("#pw2_check").text("비밀번호가 일치하지 않습니다.");
				$("#pw2_check").css("color", "red");
				$("#reg_submit").attr("disabled", true);
			} else {
				$("#pw2_check").text("");
				$("#reg_submit").attr("disabled", false);
			}
		});
	});
</script>

</head>
<body>
	<form method="post" action="/java/regiControl">

			<!-- 본인확인 이메일 -->
			<div class="form-group">
				<label for="user_eMail">이메일</label>
					<input type="text" class="form-control" name="user_eMail" id="user_eMail" placeholder="E-MAIL" required>
					<div class="check_font" id="email_check"></div>
					</br>
			</div>
			<!-- 비밀번호 -->
			<div class="form-group">
				<label for="user_pw">비밀번호</label>
					<input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="PASSWORD" required>
				<div class="check_font" id="pw_check"></div></br>
			</div>
			<!-- 비밀번호 재확인 -->
			<div class="form-group">
				<label for="user_pw2">비밀번호 확인</label>
					<input type="password" class="form-control" id="user_pw2" name="user_pw2" placeholder="CONFIRM PASSWORD" required>
				<div class="check_font" id="pw2_check"></div></br>
			</div>
			<!-- 닉네임-->
			<div class="form-group">
				<label for="user_nickName">닉네임</label>
					<input type="text" class="form-control" id="user_nickName" name="user_nickName" placeholder="NICKNAME" required>
				<div class="check_font" id="name_check"></div></br>
			</div>
		
			<div class="reg_button">
				<a class="btn btn-danger px-3" href="${pageContext.request.contextPath}">
					<i class="fa fa-rotate-right pr-2" aria-hidden="true"></i>취소하기
				</a>&nbsp;&nbsp;
				<button class="btn btn-primary px-3" id="reg_submit">
					<i class="fa fa-heart pr-2" aria-hidden="true"></i>가입하기
				</button>
			</div>
	</form>

</body>
</html>