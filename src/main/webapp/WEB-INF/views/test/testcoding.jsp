<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- ace editor -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.4.4/ace.js"></script>
<!--<script src="${pageContext.request.contextPath}/resources/js/ace.js"></script>-->

</head>

<body>
<iframe src="editor"></iframe>
<div style="display:flex; align-items: center; justify-content: center; width: 100%; padding: 30px 0px;">

	<div class="codingTest_main">
		<div class="codingTest_main_left">
			<div id="editor">asdf</div>
		</div>
		
		<div class="codingTest_main_right">
			<div>
				<span>사용시간</span><input type="text" readonly="readonly" class="timer"><br><br>
				<span>문제번호</span><input type="text" readonly="readonly" class="codeLength"><br><br>
				<span>코드길이</span><input type="text" readonly="readonly" class="codeLength"><br><br>
				<span>메모리양</span><input type="text" readonly="readonly" class="codeLength"><br><br>
				<span>실행속도</span><input type="text" readonly="readonly" class="codeLength"><br><br>
				<span>도전회차</span><input type="text" readonly="readonly" class="codeLength"><br><br>
				<span>에러숫자</span><input type="text" readonly="readonly" class="codeLength"><br><br>
				
				<input type="button" onclick="submit()" value="문제제출">
				
			</div>
		</div>
		


	</div>
</div>

<script>

	// ace edtior 세팅
	var editor = ace.edit("editor");
	editor.setTheme("ace/theme/twilight");
	editor.getSession().setMode("ace/mode/javascript");
	
	
	
	// 정답제출
	function submit(){
		
		alert("실행11");
		var code = editor.getValue();
		alert(code);
		
		$.ajax({
	        url: 'insertProblem',
	        type: 'post',
	        data: {"code":code},
	        success: function(data){
	            alert("성공");
	        },
			error:function(request,status,error){
	        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
	    })
	}
	
	
	
	// 코드길이 측정
	editor.session.on('change', function(delta) {
		var code = editor.getValue();
		var leng = code.length;
		$(".codeLength").val(leng);
	});
	
	
	
	// 타이머
	/*
	var time = 0;
	
	function timer() {
		time = time + 1;
		$(".timer").val(time);		
	}

	setInterval(timer, 1000);				
*/





</script>
</body>
</html>