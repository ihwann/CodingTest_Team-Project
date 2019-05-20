
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!--  
<div class="header" style="color:white;font-size: 30px;letter-spacing: 5px;background-color: #263747 ;margin-left: -8px;display:inline;">
STE<p style="font-size: 50px;color:LightCyan;display: inline;font-stretch: 10">V</p>ELEE<p style="font-size: 50px;color:MistyRose;display: inline;font-stretch: 10">J</p>AVA
<p style="display: inline;margin-left: 800px;font-size: 10px;vertical-align:text-top; ;margin-top: 10px">회원가입</p>
<p style="display: inline;margin-left: 20px;font-size: 10px;vertical-align: text-top;margin-top: 10px">로그인</p>
-->
<div class="header" style="color:white;font-size: 30px;letter-spacing: 5px;background-color: #263747 ;margin-left: -8px;display:inline;">
<table>
	<tr>
		<td rowspan="2">STE<p style="font-size: 50px;color:LightCyan;display: inline;font-stretch: 10">V</p>ELEE<p style="font-size: 50px;color:MistyRose;display: inline;font-stretch: 10">J</p>AVA
		</td>
		<td>
			<p style="display: inline;margin-left: 890px;font-size: 10px">회원가입</p>
			<p style="display: inline;margin-left: 20px;font-size: 10px">로그인</p>
		</td>
	</tr>
	<tr>
		<td>
			<p style="display: inline;margin-left: 500px;font-size: 13px; ;margin-top: 10px">코딩테스트</p>
			<p style="display: inline;margin-left: 20px;font-size: 13px;margin-top: 10px">알고리즘문제</p>
			<p style="display: inline;margin-left: 20px;font-size: 13px;margin-top: 10px">기출문제</p>
			<p style="display: inline;margin-left: 20px;font-size: 13px;margin-top: 10px">나의통계</p>
		</td>
	</tr>
		
</table>


</div>



<!-- 
<div class="header no-print">
	<div class="topbar">
		<div class="container">
			<ul class="loginbar pull-right">
				<li><a href = "/register">회원가입</a></li>
				<li class="topbar-devider"></li>
				<li><a href = "/login?next=%2Fworkbook%2Fview%2F1152">로그인</a></li>
			</ul>
		</div>
	</div>
	<div class="navbar navbar-default mega-menu" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="fa fa-bars"></span>
				</button>
				<a class="navbar-brand" href="/"><img id="logo-header" src="https://d2gd6pc034wcta.cloudfront.net/images/logo@2x.png" alt="Logo" data-retina></a>
			</div>
		<div class="collapse navbar-collapse navbar-responsive-collapse">
		<ul class="nav navbar-nav">
			<li class="dropdown mega-menu-fullwidth "><a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">문제</a>
		<ul class="dropdown-menu">
			<li><div class="mega-menu-content"><div class="container"><div class="row equal-height"><div class="col-md-3 equal-height-in"><ul class="list-unstyled equal-height-list"><li><h3>문제</h3></li><li><a href = "/problemset">전체 문제</a></li><li><a href = "/category">문제 출처</a></li><li><a href = "/step">단계별로 풀어보기</a></li><li><a href = "/problem/tags">알고리즘 분류</a></li><li><a href = "/newproblems">새로 추가된 문제</a></li><li><a href = "/newproblems/english">새로 추가된 영어 문제</a></li><li><a href = "/recent/problem/solutions">새로 추가된 문제 풀이</a></li><li><a href = "/problem/ranking">문제 순위</a></li></ul></div><div class="col-md-3 equal-height-in"><ul class="list-unstyled equal-height-list"><li><h3>문제</h3></li><li><a href="/problem/only">푼 사람이 1명인 문제</a></li><li><a href="/problem/nobody">아무도 못 푼 문제</a></li><li><a href="/problem/recent/submit">최근 제출된 문제</a></li><li><a href="/problem/recent/accepted">최근 풀린 문제</a></li><li><a href="/problem/random">랜덤</a></li></ul></div><div class="col-md-3 equal-height-in"><ul class="list-unstyled equal-height-list"><li><h3>출처</h3></li><li><a href = "/category/1">ACM-ICPC</a></li><li><a href = "/category/2">Olympiad</a></li><li><a href = "/category/55">한국정보올림피아드</a></li><li><a href = "/category/57">한국정보올림피아드시․도지역본선</a></li><li><a href = "/category/318">전국 대학생 프로그래밍 대회 동아리 연합</a></li><li><a href = "/category/5">대학교 대회</a></li><li><a href = "/category/428">카카오 코드 페스티벌</a></li><li><a href = "/category/215">Coder's High</a></li></ul></div><div class="col-md-3 equal-height-in"><ul class="list-unstyled equal-height-list"><li><h3>ACM-ICPC</h3></li><li><a href = "/category/7">Regionals</a></li><li><a href = "/category/4">World Finals</a></li><li><a href = "/category/211">Korea Regional</a></li><li><a href = "/category/34">Africa and the Middle East Regionals</a></li><li><a href = "/category/10">Europe Regionals</a></li><li><a href = "/category/103">Latin America Regionals</a></li><li><a href = "/category/8">North America Regionals</a></li><li><a href = "/category/92">South Pacific Regionals</a></li></ul></div></div></div></div></li></ul></li><li class = "active"><a href = "/workbook/verified">문제집</a></li><li><a href = "/contest/list">대회<span class='badge badge-red rounded-2x'>4</span></a></li><li><a href = "/status">채점 현황</a></li><li><a href = "/ranklist">랭킹</a></li><li><a href = "/board">게시판</a></li><li><a href = "/group/list/all">그룹</a></li><li><a href = "/blog/list">블로그</a></li><li><a href = "/lectures">강의</a></li><li class="search"><a href = "#"><i class="fa fa-search search-btn"></i></a></li><li><div class="search-open"><div class="animated fadeInDown"><input type="text" class="st-default-search-input form-control" id="header-search"></div></div></li></ul></div></div></div></div><form action="/logout" method="post" id="logout_form"><input type='hidden' value='%2Fworkbook%2Fview%2F1152' name="next"></form>
 -->
			
		