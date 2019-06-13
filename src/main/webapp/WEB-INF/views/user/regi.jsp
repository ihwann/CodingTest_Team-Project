<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.11.3.min.js"></script>
<title>Insert title here</title>

<!--회원가입 유효성 검사   -->
<script>
var regi_formArr = new Array(4).fill(true);
    $(document).ready(function() {
    	
    	// 이메일 유효성 검사
        $('#user_eMail').blur(function() {
            var user_eMail = $('#user_eMail').val();
            var emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

            if (!(user_eMail.match(emailExp))) {
                $("#email_check").text("올바른 이메일 형식이 아닙니다.");
                $("#email_check").css("color", "red");
                regi_formArr[0] = false;
            } else {
            	
            	// 이메일 중복 유효성 검사
                $.ajax({
                    url: '${pageContext.request.contextPath}/eMailchk?user_eMail=' + user_eMail,
                    type: 'post',
                    success: function(data) {

                        if (data >= 1) {
                            $("#email_check").text("사용중인 이메일입니다");
                            $("#email_check").css("color", "red");
                            regi_formArr[0] = false;
                        } else {
                            $("#email_check").text("사용가능한 이메일 입니다.");
                            $("#email_check").css("color", "white");
                            regi_formArr[0] = true;
                        }
                    },
                    error: function() {
                        console.log("실패");
                    }
                });
            }
        });
        
        // 비밀번호 유효성 검사
        $("#user_pw").blur(function() {
            var user_pw = $("#user_pw").val();
            var pwExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,20}$/;
            if (!(user_pw.match(pwExp))) {
                $("#pw_check").text("올바른 비밀번호 형식이 아닙니다.");
                $("#pw_check").css("color", "red");
                regi_formArr[1] = false;
            } else {
                $("#pw_check").text("사용가능한 비밀번호 입니다.");
                $("#pw_check").css("color", "white");
                regi_formArr[1] = true;
            }
        });
        
        // 비밀번호 일치 유효성 검사
        $("#user_pw2").blur(function() {
            if ($('#user_pw').val() != $(this).val() || $(this).val() == "") {
                $("#pw2_check").text("비밀번호가 일치하지 않습니다.");
                $("#pw2_check").css("color", "red");
                regi_formArr[2] = false;
            } else {
                $("#pw2_check").text("비밀번호가 일치합니다.");
                $("#pw2_check").css("color", "white");
                regi_formArr[2] = true;
            }
        });
        
        // 닉네임 유효성 검사
        $("#user_nickName").blur(function() {
        	var user_nickName = $("#user_nickName").val();
        	var nickNameExp = /^[0-9가-힣a-zA-Z]+$/;
        	
        	if(!(user_nickName.match(nickNameExp))){
        		$("#name_check").text("특수문자 혹은 공백 사용이 불가능합니다.");
        		$("#name_check").css("color", "red");
        		regi_formArr[3] = false;
        	}else{
        		
        		// 닉네임 중복 유효성 검사
                $.ajax({
                    url: '${pageContext.request.contextPath}/nickchk?user_nickName=' + user_nickName,
                    type: 'post',
                    success: function(data) {

                        if (data >= 1) {
                            $("#name_check").text("사용중인 닉네임 입니다");
                            $("#name_check").css("color", "red");
                            regi_formArr[3] = false;
                        } else {
                            $("#name_check").text("사용가능한 닉네임 입니다.");
                            $("#name_check").css("color", "white");
                            regi_formArr[3] = true;
                        }
                    },
                    error: function() {
                        console.log("실패");
                    }
                });
        	}
        });
        
        // 가입완료 버튼 유효성 검사
        $("#reg_submit").click(function(){
        	var regi_formArr_chk = true;
            for(var i = 0; i<regi_formArr.length; i++){
            	if(regi_formArr[i] == false){
            		regi_formArr_chk = false;
            		break;
            	}
            }
            
            if(regi_formArr_chk){
            	return true;
            }else{
            	return false;
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
					<input type="text" class="form-control" name="user_eMail" id="user_eMail" placeholder="정확하게 써주세요" required>
					<div class="check_font" id="email_check"></div>
					</br>
			</div>
			<!-- 비밀번호 -->
			<div class="form-group">
				<label for="user_pw">비밀번호</label>
					<input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="(6-20자) 문자 ,특수문자, 숫자 포함" required>
				<div class="check_font" id="pw_check"></div></br>
			</div>
			<!-- 비밀번호 재확인 -->
			<div class="form-group">
				<label for="user_pw2">비밀번호 확인</label>
					<input type="password" class="form-control" id="user_pw2" name="user_pw2" placeholder="(6-20자) 문자 ,특수문자, 숫자 포함" required>
				<div class="check_font" id="pw2_check"></div></br>
			</div>
			<!-- 닉네임-->
			<div class="form-group">
				<label for="user_nickName">닉네임</label>
					<input type="text" class="form-control" id="user_nickName" name="user_nickName" placeholder="숫자, 한글, 영문만 사용" required>
				<div class="check_font" id="name_check"></div></br>
			</div>
		
			<div class="reg_button">
				<a class="btn btn-primary px-3" href="${pageContext.request.contextPath}">
					<i class="fa fa-heart pr-2" aria-hidden="true"></i>취소하기
				</a>&nbsp;&nbsp;
				<button class="btn btn-primary px-3" id="reg_submit">
					<i class="fa fa-heart pr-2" aria-hidden="true"></i>가입하기
				</button>
			</div>
	</form>

</body>
</html>