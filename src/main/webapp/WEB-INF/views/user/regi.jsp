<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.11.3.min.js"></script>
<title>스티브리자바 회원가입</title>


<!--회원가입 유효성 검사   스크립트-->
<script>

// 회원가입 항목별 bool 체크 위한 배열선언
var regi_formArr = new Array(5).fill(false);

//난수+이메일+세션ID 합혀진 인증키
var user_authKey;
var regi_authKey;
var submit_authKey;

$(document).ready(function() {

    // 이메일 유효성 검사
    $('#user_eMail').focusout(function() {
        var user_eMail = $(this).val();
        var emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

        if (!(user_eMail.match(emailExp))) {
            $("#email_check").text("올바른 이메일 형식이 아닙니다.");
            $("#email_check").css("color", "red");
            $("#btn_sendAuth").attr("disabled", true);
            regi_formArr[0] = false;
        } else {

            // 이메일 중복 유효성 검사
            $.ajax({
                url: '${pageContext.request.contextPath}/eMailchk?user_eMail=' + user_eMail,
                type: 'post',
                success: function(data) {

                    if (data >= 1) {
                        $("#email_check").text("사용 중인 이메일입니다.");
                        $("#email_check").css("color", "red");
                        $("#btn_sendAuth").attr("disabled", true);
                        regi_formArr[0] = false;

                    } else {
                        $("#email_check").text("사용 가능한 이메일 입니다.");
                        $("#email_check").css("color", "#191970");
                        $("#btn_sendAuth").attr("disabled", false);
                        regi_formArr[0] = true;
                    }
                }
            });
        }
    });

    // 인증번호 보내기
    $("#btn_sendAuth").click(function() {
        var user_eMail = event;
        user_authKey = "";
        alert("인증번호를 전송 했습니다.");
        $.ajax({
            url: '${pageContext.request.contextPath}/sendEmail?user_eMail=' + $('#user_eMail').val(),
            type: 'post',
            success: function(result) {
                user_authKey = result;
                //alert(user_authKey);
            }
        });
        // 다른 이벤트로 전달 차단
        return false;
    });

    // 인증번호 유효성 검사
    $("#authNum").focusout(function() {
        regi_authKey = $(this).val() + '<%=(String)session.getId()%>' + $("#user_eMail").val();
        if (regi_authKey == user_authKey) {
            $("#authNum_check").text("인증되었습니다.");
            $("#authNum_check").css("color", "#191970");
            regi_formArr[1] = true;
        } else if (regi_authKey != user_authKey) {
            $("#authNum_check").text("이메일 혹은 인증번호가 일치하지 않습니다.");
            $("#authNum_check").css("color", "red");
            regi_formArr[1] = false;
        }
    });

    // 비밀번호 유효성 검사
    $("#user_pw").focusout(function() {
        var user_pw = $(this).val();
        var pwExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,20}$/;
        if (!(user_pw.match(pwExp))) {
            $("#pw_check").text("올바른 비밀번호 형식이 아닙니다.");
            $("#pw_check").css("color", "red");
            regi_formArr[2] = false;
        } else {
            $("#pw_check").text("사용 가능한 비밀번호 입니다.");
            $("#pw_check").css("color", "#191970");
            regi_formArr[2] = true;
        }
    });

    // 비밀번호 일치 유효성 검사
    $("#user_pw2").focusout(function() {
        if ($('#user_pw').val() != $(this).val() || $(this).val() == "") {
            $("#pw2_check").text("비밀번호가 일치하지 않습니다.");
            $("#pw2_check").css("color", "red");
            regi_formArr[3] = false;
        } else {
            $("#pw2_check").text("비밀번호가 일치합니다.");
            $("#pw2_check").css("color", "#191970");
            regi_formArr[3] = true;
        }
    });

    // 닉네임 유효성 검사
    $("#user_nickName").focusout(function() {
        var user_nickName = $(this).val();
        var nickNameExp = /^[0-9가-힣a-zA-Z]+$/;

        if (!(user_nickName.match(nickNameExp))) {
            $("#name_check").text("특수문자 혹은 공백 사용이 불가능합니다.");
            $("#name_check").css("color", "red");
            regi_formArr[4] = false;
        } else {

            // 닉네임 중복 유효성 검사
            $.ajax({
                url: '${pageContext.request.contextPath}/nickchk?user_nickName=' + user_nickName,
                type: 'post',
                success: function(data) {

                    if (data >= 1) {
                        $("#name_check").text("사용 중인 닉네임 입니다");
                        $("#name_check").css("color", "red");
                        regi_formArr[4] = false;
                    } else {
                        $("#name_check").text("사용 가능한 닉네임 입니다.");
                        $("#name_check").css("color", "#191970");
                        regi_formArr[4] = true;
                    }
                },
                error: function() {
                    console.log("실패");
                }
            });
        }
    });


    // 가입하기 버튼 유효성 검사
    $("#reg_submit").click(function() {
        var regi_formArr_chk = true;
        // 가입 버튼 누르기 전 인증키 계산
        submit_authKey = $("#authNum").val() + '<%=(String)session.getId()%>' + $("#user_eMail").val();
        for (var i = 0; i < regi_formArr.length; i++) {
            if (!regi_formArr[i]) {
                // 회원가입 항목 중 한개라도 false면(유효성에 맞지 않다면) 회원가입 비활성화
                regi_formArr_chk = false;
                break;

                // 모든 유효성 검사를 통과하고 가입버튼 누르기 직전 이메일 정보를 수정했을 경우를 대비
            } else if (user_authKey != submit_authKey) {
                regi_formArr_chk = false;
                $("#authNum_check").text("이메일 혹은 인증번호가 일치하지 않습니다.");
                $("#authNum_check").css("color", "red");
                break;
            }
        }
        if (regi_formArr_chk) {
            return true;
        } else {
            alert("다시 한번 확인해 주세요.");
            return false;
        }
    });
});

</script>

</head>
<body>
<div class="row">
	<div class="col-md-8">
		<section>
		<h1 class="entry-title"><span>&nbsp;&nbsp;회원가입</span></h1></section>
		<hr>
		<form class="form-horizontal" method="post" action="/java/regiControl" accept-charset="utf-8">
			<!-- 본인확인 이메일 -->
			<div class="form-group">
				<label class="control-label col-sm-3" for="user_eMail">이메일</label>
				<div class="col-md-5 col-sm-8">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
						<input type="email" class="form-control" name="user_eMail" id="user_eMail" placeholder="정확하게 써주세요" required>
					</div>
					<div class="check_font" id="email_check"></div><br>
					<button class="btn btn-primary" id="btn_sendAuth" disabled="disabled">
						인증하기 </button>
					<div class="check_font" id="send_check"></div>
				</div>
			</div>
			<!-- 이메일 인증 확인하기 -->
			<div class="form-group">
				<label class="control-label col-sm-3" for="authEmail">인증번호</label>
				<div class="col-md-5 col-sm-8">
					<div class="input-group">
						<input type="text" class="form-control" id="authNum" name="authNum" required="required">
					</div>
					<div class="check_font" id="authNum_check"></div>
				</div>
			</div>
			<!-- 비밀번호 -->
			<div class="form-group">
				<label class="control-label col-sm-3" for="user_pw">비밀번호</label>
				<div class="col-md-5 col-sm-8">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						<input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="( 6 - 20자 ) 영문, 특수문자, 숫자 포함" required>
					</div>
					<div class="check_font" id="pw_check">
					</div>
				</div>
			</div>
			<!-- 비밀번호 재확인 -->
			<div class="form-group">
				<label class="control-label col-sm-3" for="user_pw2">비밀번호 확인</label>
				<div class="col-md-5 col-sm-8">
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						<input type="password" class="form-control" id="user_pw2" name="user_pw2" placeholder="( 6 - 20자 ) 영문, 특수문자, 숫자 포함" required>
					</div>
					<div class="check_font" id="pw2_check">
					</div>
				</div>
			</div>
			<!-- 닉네임-->
			<div class="form-group">
				<label class="control-label col-sm-3" for="user_nickName">닉네임</label>
				<div class="col-md-5 col-sm-8">
					<div class="input-group">
						<input type="text" class="form-control" id="user_nickName" name="user_nickName" placeholder="숫자, 한글, 영문만 사용" required>
					</div>
					<div class="check_font" id="name_check">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="reg_button">
					<div class="col-xs-offset-3 col-xs-10">
						<button class="btn btn-danger" type ="button" id="cancel_submit" onclick="location='${pageContext.request.contextPath}'">취소하기</button>
						&nbsp;&nbsp;
						<button class="btn btn-success" id="reg_submit">가입하기</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>