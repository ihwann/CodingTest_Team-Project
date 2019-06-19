<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>



<div class="headerMain">

	<div class="headerMain_left">
		<img class="header_logo" src="resources/images/top_logo.png">
	</div>

	<div class="headerMain_right">
		<div class="headerMain_right_top"><span class="login_menu">로그인 </span><span class="login_menu">|</span><span class="login_menu regi">회원가입</span></div>
		<div class="headerMain_right_bottom">
			<ul>
				<li class="mainMenu"><a class="menu_a" href="/">메인화면</a></li>
				<li class="mainMenu"><a class="menu_a" href="/introduce">교육소개</a></li>
				<li class="dropdown mainMenu"><a class="menu_a" href="">커뮤니티</a>
					<ul class="subMenu">
						<li><a class="menu_a" href="review">기업코딩테스트 후기</a></li>
						<li><a class="menu_a" href="/jobs">구인공고</a></li>
					</ul>
				</li>
				<li class="mainMenu"><a class="menu_a" href="/testmake">문제작성</a></li>
				<li class="mainMenu"><a class="menu_a" href="/testlist">문제보기</a></li>
				<li class="mainMenu"><a class="menu_a" href="/overview">나의통계</a></li>
			</ul>
		</div>	
	</div>
</div>


<script>

$(".regi").click(function(){
	window.location = "TermsConditions";
});

$(".header_logo").click(function(){
	window.location = "/java";
});

</script>