<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<style type="text/css">
@import url("//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");

/*  .banner-sec{background:url(https://static.pexels.com/photos/33972/pexels-photo.jpg)  no-repeat left bottom; background-size:cover; min-height:500px; border-radius: 0 10px 10px 0; padding:0;}*/
.login-block {
}
.container{
	background:#F4F4F4; 
	border-radius: 10px; 
}
.carousel-caption{
	text-align:left; left:5%; top: 30%;
}
.login-sec{
	padding: 50px 30px; 
	position:relative;
}
.login-sec .copy-text{
	position:absolute; 
	width:80%; 
	bottom:20px; 
	font-size:13px; 
	text-align:center;
}
.login-sec .copy-text i{
	color:#FEB58A;
}
.login-sec .copy-text a{
	color:#E36262;
}
.login-sec h2{
	margin-bottom:30px; 
	font-weight:800; 
	font-size:30px; 
	color: #5EB4E7;
}
.login-sec h2:after{
	content:" "; 
	width:100px; 
	height:5px; 
	background:#5EB4E7; 
	display:block; margin-top:20px; 
	border-radius:3px; 
	margin-left:auto;
	margin-right:auto
}
.btn-login{
	background: #5EB4E7; 
	color:#fff; 
	font-weight:600;
}
.banner-text{
	width:70%; 
	position:absolute; 
	bottom:40px; 
	padding-left:20px;
}
.banner-text h2{
	color:#5EB4E7; 
	position: relative;
	font-weight:600;
	top: 150px;
}
.banner-text h2:after{
	content:" "; 
	width:100px; 
	height:5px; 
	background: #7dbffa; 
	display:block; 
	margin-top:20px; 
	border-radius:3px;
} 
.banner-text ul{
	color:#5EB4E7;
	position:absolute;
	top: 260px;
}
</style>
<!------ Include the above in your HEAD tag ---------->
<script>
var loginFormArr = new Array(2).fill(false);

// 이메일 유효성 검사
$(document).ready(function() {
	$("#email1").focusout(function() {
	    var email = $(this).val();
	    var emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var emailCheck = $("#emailCheck");
		
	    if (!(email.match(emailExp))) {
	    	emailCheck.text("올바른 이메일 형식이 아닙니다.");
	    	emailCheck.css("color", "red");
	        loginFormArr[0] = false;
	    } else {
	    	emailCheck.text("올바른 이메일 형식으로 입력했습니다.");
	    	emailCheck.css("color", "#191970");
            loginFormArr[0] = true;
        }
	    
	});
	
	
	// 비밀번호 유효성 검사
    $("#pw").focusout(function() {
        var pw = $(this).val();
        var pwExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,20}$/;
        var pwCheck = $("#pwCheck");
        
        if (!(pw.match(pwExp))) {
        	pwCheck.text("올바른 비밀번호 형식이 아닙니다.");
        	pwCheck.css("color", "red");
            loginFormArr[1] = false;
        } else {
        	pwCheck.text("비밀번호 형식에 맞게 입력했습니다.");
        	pwCheck.css("color", "#191970");
            loginFormArr[1] = true;
        }
    });
	
	$("#chkBox").click(function() {
		if($("#chkBox").is(":checked") == true) {
			$("#chk").val(1);
		}
		
	});
	
});
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">

<div class="login-block">
    <div class="container">
		<div class="row">
			<div class="col-md-4 login-sec">
		   		<h2 class="text-center">Login Now</h2>
		    		<form class="login-form" action="logincheck" method="post">
					  <div class="form-group">
						  <label for="exampleInputEmail1" class="text-uppercase">UserEmail</label>
						  <input type="text" id="email1" name="email1" class="form-control" placeholder="">
					  </div>
					  <div class="check_font" id="emailCheck">
					  </div>
					  <div class="form-group">
						  <label for="exampleInputPassword1" class="text-uppercase">Password</label>
						  <input type="password" id="pw" name="pw" class="form-control" placeholder="">
					  </div>
					  <div class="check_font" id="pwCheck">
				      </div>
				      <div class="form-check">
					      <label class="form-check-label">
					      	<input type="checkbox" class="chkBox form-check-input" id="chkBox" name="chkBox">
					      	<input type="hidden" id="chk" name="chk" value="0">
					      	
					      	<small>Remember Me</small>
					      </label>
				      	  <button type="submit" class="btn btn-login float-right">Submit</button>
				  	  </div>
					</form>
					<div class="copy-text">SteveLeeJava <i class="fa fa-heart"></i></div>
			</div>
		
			<div class="col-md-8 banner-sec">
			    <div class="carousel-item active">
			      <img class="d-block img-fluid" src="resources/img/coding.png" alt="First slide">
			      <div class="carousel-caption d-none d-md-block">
			        <div class="banner-text">
			            <h2>다음과 같은 서비스를 이용하실 수 있습니다.</h2>
			            <ul>
			            	<li>코딩테스트 시험연습</li>
			            	<li>테스트 결과 통계데이터 확인</li>
			            	<li>커뮤니티활동</li>
			            </ul>
			        </div>	
			  	  </div>
				</div>
			</div>
		</div>
	</div>	
</div>