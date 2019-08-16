<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="${pageContext.request.contextPath}/resources/jquery/jquery-1.11.3.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="//cdn.jsdelivr.net/chartist.js/latest/chartist.min.css">
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
	
	<!--  Light Bootstrap Dashboard core CSS    -->
	<link href="${pageContext.request.contextPath}/resources/cssTest/light-bootstrap-dashboard.css" rel="stylesheet"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">	
	<style>
		.ct-label {
			font-size: 15px;
		}
		
		a.a {
   			text-decoration: none;
   			color: grey;
   			display: block;
   			font-weight: 1000;
		}
	</style>	
</head>
<body>
	
	<div class="container-fluid">
		<div class="row">    	
	        <div class="col-md-12">
	           	<div class="card">
	               	<div class="header" style="padding-bottom:15px;">
	               		<h3 class="title">나의 테스트 목록</h3>
	               		<div class="row">
	               			<div class="col-md-12">
	               				<div style="text-align:right;">
		               				전체 문제 : <span id="totalTest">50</span> &nbsp; &nbsp;
									맞은 갯수 : <span id="successNum">40</span> &nbsp; &nbsp;
									틀린 갯수 : <span id="failNum">10</span>
								</div>
	               			</div>
	               		</div>
	               	</div>
	               	
	               	<div class="content table-responsive table-full-width">
	                   	<table class="table table-hover table-striped">
	                       	<thead>
	                           	<th>문제번호</th> 
	                       		<th>문제유형</th>
	                       		<th>문제타입</th>
	                       		<th>문제제목</th>
	                       		<th>통과여부</th>
	                       	</thead>
	                       	<tbody>
	                       		
	                         	<c:forEach items="${analyticsList}" var="analyticsList">
	                          		<tr>
		                           		<td><c:out value="${analyticsList.test_no}"/></td>
		                           		<td><c:out value="${analyticsList.test_cate}"/></td>
		                           		<td><c:out value="${analyticsList.test_type}"/></td>
		                           		<td><c:out value="${analyticsList.test_title}"/></td>
		                           		<td><c:out value="${analyticsList.test_result}"/></td>
		                           	</tr>
	                          	</c:forEach>
	                          	
	                       	</tbody>
	                   	</table>
	               	</div>
	           	</div>
	       	</div>
   		</div>
   		<div class="row">
   			<div class="col-md-12">
				<div class="card">
					<div class="header">
						내가 푼 문제유형
					</div>
					<div class="content">
						<div id="chartPreferences" class="ct-chart "></div>
					</div>
					<div class="footer">
						
		                <h6>전체문제 중 유형별 푼문제 비율</h6>
		                <i class="fa fa-circle text-info"></i>
		                <i class="fa fa-circle text-danger"></i>
		                
					</div>
				</div>
			</div>
   		</div>
	</div>
	
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//cdn.jsdelivr.net/chartist.js/latest/chartist.min.js"></script>
	<script type="text/javascript">
		var analyJson = ${analyticsJson};
		var analyCateSuccJson = ${analyticsCateSuccJson};
		var totalSuccess = 0;
		
		var analy = {
			initLoad : function() {
				this.totalTest();
				this.testResultNum();
			},
			totalTest : function() { /* 전체 문제 메소드 */
				var totalCnt = analyJson.length;
				$('#totalTest').html(totalCnt);
			},
			testResultNum : function() { /* 맞은 갯수, 틀린 갯수 메소드 */
				var totalFail = 0; 
				$.each(analyJson, function(index, item) {
					if (item.test_result === "pass")
						totalSuccess++; /* 각각의 item의 test_result 키값이 success일 경우 맞은 갯수 증가 */
					else
						totalFail++; /* fail일 경우 틀린 갯수 증가 */
				});
				$('#successNum').html(totalSuccess);
				$('#failNum').html(totalFail);
			}
		}
		
		
		$(function() {
			analy.initLoad();
			
			var dataPreferences = {
					
				    series: [
				        [25, 30, 20, 25]
				    ]
				};

				var optionsPreferences = {
						
				    donut: true,
				    donutWidth: 40,
				    startAngle: 0,
				    height: "245px",
				    total: 100,
				    showLabel: false,
				    axisX: {
				        showGrid: false
				    }
				};

				Chartist.Pie('#chartPreferences', dataPreferences, optionsPreferences);

			 	var testCate = new Array();
				var percent = new Array();			

				$.each(analyCateSuccJson, function(index, item) {
					testCate[index] = item.cate;
					percent[index] = (item.cnt / totalSuccess) * 100;
				});
				
				
				/*
			 	<c:forEach items="${hanqPieList}" var="pieChartList" varStatus="status"> // varStatus는 index 번호(0부터 시작)
			 		contry[<c:out value="${status.index}"/>] = ('<c:out value="${pieChartList.country}"/>');
					percent[<c:out value="${status.index}"/>] = ('<c:out value="${pieChartList.percent}"/>');
				</c:forEach> 
				*/
				
				Chartist.Pie('#chartPreferences', {
				  labels: testCate,
				  series: percent
				});
				
				// 선택한 요소 뒤에 값을 추가합니다.
				
				$(".text-info").after(testCate[0] + ' : ' + percent[0] + '%');
				$(".text-danger").after(testCate[1] + ' : ' + percent[1] + '%');
		});
		
	</script>
</body>
</html>