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
		<h1 class="testName">삼성역량평가</h1>
		<h3 class="testDetail">k번째 수열을 나타내는 N개의 수를 출력하거나, 몇 번째 수열인지를 출력하면 된다.</h3>
	</div>
	
	
	
	
	<!-- 문제 detail 시작 -->
	<div class="testInfo">
		<div class="testInfo_top">
        	<div class="testInfo_top_top">
          		<h3 class="testName2">집합</h3>
          		<span class="testDetail2">비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.</span>
<pre class="testPre">
add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다.
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다. 
</pre>

				<span class="testDetail2">입력</span>
<pre class="testPre">
첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.
둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.              
</pre>

				<span class="testDetail2">출력</span>
<pre class="testPre">
check 연산이 주어질때마다, 결과를 출력한다.              
</pre>
			</div>

		<div class="testInfo_top_bottom">
			<div class="div_pre">
            	<span class="testDetail2">입력예시</span>
<pre class="testType">
26
add 1
add 2
check 1
check 2
check 3
remove 2
check 1
check 2
toggle 3
check 1
check 2
check 3
check 4
all
check 10
check 20
toggle 10
remove 20
check 10
check 20
empty
check 1
toggle 1
check 1
toggle 1
check 1
</pre>
			</div>
			<div class="div_pre">
			<span class="testDetail2">출력예시</span>
<pre class="testType">
1
1
0
1
0
1
0
1
0
1
1
0
0
0
1
0
</pre>
				</div>
			</div>
		</div>
    </div>
    <!-- 문제 detial 종료 -->
    
    
    	
	<div class="result">
		<div class="div_result">
			<i class="fas cc fa-user-clock"></i>
			<input type="text" value="대기중" readonly="readonly" class="timer input_result">
			<i class="fas cc fa-ruler"></i>
			<input type="text" value="대기중" readonly="readonly" class="codeLength input_result">
			<i class="fas cc fa-microchip"></i>
			<input type="text" value="대기중" readonly="readonly" class="memory input_result">
			<i class="fas cc fa-tachometer-alt"></i>
			<input type="text" value="대기중" readonly="readonly" class="runningTime input_result">
			<i class="fas cc fa-check-circle"></i>
			<input type="text" value="대기중" readonly="readonly" class="result input_result_last">
		</div>
	</div>



	<!-- 문제푸는 영역 & 이전에 제출했던 내역조회 시작 -->
	<div class="testcoding_main">
		<div class="testcoding_mian_left">
			<div class="testcoding_mian_left_title">
				<h1 class="testName2">삼성역량평가</h1>
				<h3 class="testDetail2">삼성전자에 도전한다면 필수!!</h3>
			</div>	
			<div class="testcoding_mian_left_detail">
				<span class="testDetail3">${map.sentence_strong }</span><br><br><br>
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
	<!-- 문제푸는 영역종료 -->
	
	
	
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
	
	// ace edtior 세팅
	var editor = ace.edit("editor");
	editor.setTheme("ace/theme/chrome");
	editor.getSession().setMode("ace/mode/java");
	

	
	// 정답제출
	function submit() {
		
		alert("실행11");
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
	

	
	// 코드길이 측정
	editor.session.on('change', function(delta) {
		var code = editor.getValue();
		var leng = code.length;
		$(".codeLength").val(leng);
	});
	
	
	
	// 타이머
	var time = 0;
	
	function timer() {
		time = time + 1;
		$(".timer").val(time);		
	}

	setInterval(timer, 1000);				


</script>
</body>
</html>