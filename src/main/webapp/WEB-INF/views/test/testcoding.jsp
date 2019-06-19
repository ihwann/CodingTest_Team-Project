<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- ace editor -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.4.4/ace.js"></script>

</head>

<body>

<div class="testcoding">

	<!-- 문제유형 & 문제타입 -->
	<div class="testcoding_header">
		<h1 class="testName">문제유형 _ ${map.cate }</h1>
	</div>
	
	
	
	
	
	<!-- 문제지도 -->
	<div class="testcoding_map">
		<c:forEach items="${testList }" var="item" >
			<div class="map" onclick="example(${item })">
				<span>${item }번</span>
			</div>
		</c:forEach>
	</div>
	
	
	
	
	
	<!-- 문제 detail 시작 -->
	<div class="testInfo">
		<div class="testInfo_top">
        	<div class="testInfo_top_top">
          		<h3 class="testName2">${map.sentence_title }</h3>
          		<span class="testDetail2">${map.sentence }</span>
<pre class="testPre">
${map.sentence_strong }
</pre>

				<span class="testDetail2">입력</span>
<pre class="testPre">
${map.sentence_input }            
</pre>

				<span class="testDetail2">출력</span>
<pre class="testPre">
${map.sentence_output }              
</pre>
			</div>

		<div class="testInfo_top_bottom">
			<div class="div_pre">
            	<span class="testDetail2">입력예시</span>
<c:choose>
<c:when test = "${map.sentence_inputex } eq null">
입력 예시가 없는 문제입니다.
</c:when>
<c:otherwise>
<pre class="testType">
${map.sentence_inputex }
</pre>
</c:otherwise>
</c:choose>
			</div>
			<div class="div_pre">
			<span class="testDetail2">출력예시</span>
<c:choose>
<c:when test = "${map.sentence_outputex } eq null">
출력 예시가 없는 문제입니다.
</c:when>
<c:otherwise>
<pre class="testType">
${map.sentence_outputex }
</pre>
</c:otherwise>
</c:choose>
				</div>
			</div>
		</div>
    </div>
    <!-- 문제 detial 종료 -->
    
    
    	


	<!-- 문제푸는 영역 & 평가결과 조회 & 이전에 제출했던 내역선택하여 조회하는 창 시작 -->
	<div class="testcoding_main">
		<div class="testcoding_mian_left">
			<div class="testcoding_mian_left_title">
				<h1 class="testName3">코딩결과 출력</h1>
				<label><span>${map.sentence_title }</span>문제 과거기록 조회</label>
				<select id="select_his">
						<option value="0">문제풀기 모드</option>
					<c:forEach items="${history }" var="item" >
						<option value="${item.test_result_seq }">${item.test_result } - ${item.test_result_regi }</option>
					</c:forEach>
				</select>
			</div>	
			<div class="testcoding_mian_left_detail">
				<div class="div_result">
					<i class="fas cc fa-user-clock"></i>
					<input type="text" value="대기중" readonly="readonly" class="timer input_result">
				</div>
				<div class="div_result">
					<i class="fas cc fa-ruler"></i>
					<input type="text" value="대기중" readonly="readonly" class="codeLength input_result">
					<i class="fas cc fa-microchip"></i>
					<input type="text" value="대기중" readonly="readonly" class="memory input_result">
				</div>
				<div class="div_result">
					<i class="fas cc fa-tachometer-alt"></i>
					<input type="text" value="대기중" readonly="readonly" class="runningTime input_result">
					<i class="fas cc fa-check-circle"></i>
					<input type="text" value="대기중" readonly="readonly" class="result input_result">
				</div>
			</div>
			<div class="testcoding_mian_left_hashtag">
				<span class="hashtag">#기업평가</span>
				<span class="hashtag">#초고난이도</span>
				<span class="hashtag">#빅데이터</span>
			</div>	
			<div class="testcoding_main_button">
				<div class="test_btn" onclick="submit()">문제제출</div>
				<div class="save_btn" onclick="">임시저장</div>
			</div>
		</div>
		
		<div class="testcoding_main_right">
				<div id="editor" class="edtor"></div>
		</div>
	</div>
	<!-- 문제푸는 영역 & 평가결과 조회 & 이전에 제출했던 내역선택하여 조회하는 창 종료 -->
	
	
	
	<!-- 페이징영역 시작  -->
	<div class="pageing">
		<a><i class="fas fa-angle-double-left"></i></a>
		<a><i class="fas fa-angle-left"></i></a>
		<a>1</a>
		<a>2</a>
		<a>3</a>
		<a>4</a>
		<a>5</a>
		<a>6</a>
		<a>7</a>
		<a>8</a>
		<a>9</a>
		<a>10</a>
		<a><i class="fas fa-angle-right"></i></a>
		<a><i class="fas fa-angle-double-right"></i></a>
	</div>
 	<!-- 페이징영역 종료 -->
</div>





<script>

	// 전역변수 선언
	var currentCode;
	var check = 0;
	
	
	
	// ace edtior 세팅
	var editor = ace.edit("editor");
	editor.setTheme("ace/theme/chrome");
	editor.getSession().setMode("ace/mode/java");
	

	
	// 정답제출
	function submit() {
		
		var code = editor.getValue();
		var timer = $(".timer").val();
		var codeLength = $(".codeLength").val();
		alert(code);
		
		$.ajax({
	        url: 'insertTest',
	        type: 'post',
	        data: { "code" : code, "timer" : timer, "codeLength" : codeLength },
	        dataType: 'json',
	        success: function(data){
	        	$(".timer").val(data.result);
	        	$(".codeLength").val(data.codeLength);
	        	$(".memory").val(data.memory);
	        	$(".runningTime").val(data.runningtime);
	        	$(".result").val(data.result);
	        },
			error:function(request,status,error){
	        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
	    })
	}



	// 과거이력조회
 	$("#select_his").change(function() {	
		var num = $("#select_his option:selected").val();

		var currentTime = $(".timer").val();
			
		if(num == 0) { // 과거이력 조회 -> 문제풀기모드
			editor.setValue(currentCode);
			$(".timer").val(currentTime);
        	$(".codeLength").val("대기중");
        	$(".memory").val("대기중");
        	$(".runningTime").val("대기중");
        	$(".result").val("대기중");
        	currentCode = editor.getValue();
        	editor.setReadOnly(false);
        	startTimer();
        	check = check - 1;
		} else {
			
			if(check == 0) {
				currentCode = editor.getValue();
				check = check + 1;
			}
			
			$.ajax({ // 문제풀기모드 -> 과거이력 조회
		        url: 'gethistory',
		        type: 'post',
		        data: { "num" : num},
		        success: function(data){
		        	$(".timer").val(data.test_result_time);
		        	$(".codeLength").val(data.test_result_codeLength);
		        	$(".memory").val(data.test_result_useMemory);
		        	$(".runningTime").val(data.test_result_runingTime);
		        	$(".result").val(data.test_result);
		        	
		        	editor.setValue(data.test_result_code);
		        	editor.setReadOnly(true);
		        	stopTimer();
		        },
				error:function(request,status,error){
		        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		        }
		    })
		}
	})

	
	
	// 코드길이 측정
	editor.session.on('change', function(delta) {
		var code = editor.getValue();
		var leng = code.length;
		$(".codeLength").val(leng);
	});
	
	
	
	// 타이머
	var time = 0;
	var timerMethod;
	
	function timer() {
		time = time + 1;
		$(".timer").val(time);		
	}
	
	function startTimer() {
		timerMethod = setInterval(timer, 1000);
	}

	function stopTimer() {
		clearInterval(timerMethod);
	}			


</script>
</body>
</html>