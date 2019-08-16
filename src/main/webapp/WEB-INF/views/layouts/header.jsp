<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="headerMain">

	<div class="headerMain_left">
		<img class="header_logo" src="resources/images/top_logo.png">
	</div>

	<div class="headerMain_right">
		<div class="headerMain_right_top">
		${sessionScope.email}
			<c:if test="${sessionScope.email eq null}">
				<a class="a" href="login"><span class="login_menu">로그인 </span></a><span class="login_menu">|</span><a class="a"><span class="login_menu regi">회원가입</span></a>
			</c:if>
			<c:if test="${sessionScope.email ne null}">
				<a class="a" href="logout"><span class="login_menu">로그아웃 </span></a>
			</c:if>
		</div>		
		<div class="headerMain_right_bottom">
			<ul>
				<li class="mainMenu"><a class="menu_a" href="/">메인화면</a></li>
				<!--  <li class="mainMenu"><a class="menu_a" href="/introduce">교육소개</a></li> -->
				<li class="dropdown mainMenu"><a class="menu_a" href="/review">커뮤니티</a>
					<ul class="subMenu">
						<li><a class="menu_a" href="review">기업코딩테스트 후기</a></li>
						<li><a class="menu_a" href="/jobs">구인공고</a></li>
					</ul>
				</li>
				<c:if test="${sessionScope.email eq 'leebigtree92@gmail.com'}">
					<li class="mainMenu"><a class="menu_a" href="/testmake">문제작성</a></li>
				</c:if>
				<li class="dropdown mainMenu"><a class="menu_a" href="/testlist">코딩테스트</a>
					<ul class="subMenu">
						<li><a class="menu_a" href="/testlist">문제리스트</a></li>
						<li><a class="menu_a" href="codingtest">테스트시작</a></li>
					</ul>
				</li>
				<li class="mainMenu"><a class="menu_a" href="/overview">나의통계</a></li>
			</ul>
		</div>	
	</div>
</div>


<script>

$(".login_menu").click(function(){
	window.location = "login";
});

$(".regi").click(function(){
	window.location = "TermsConditions";
});

$(".header_logo").click(function(){
	window.location = "/";
});

</script>