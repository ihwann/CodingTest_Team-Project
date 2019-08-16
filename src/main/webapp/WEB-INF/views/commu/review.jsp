<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/jquery/jquery-1.11.3.min.js"></script>
<script>




$(document).ready(function(){
	
	var rtn = '${rtn}';
	if(rtn == 1) {
		alert('게시글 삭제 완료 되었습니다.');
	}
	
});

function search() {
	
	var catVal=$(".cate").val();
	var textVal=$(".keyword").val();
	var compVal=$(".company").val();
	
	

	$.ajax({
		type : "post",
		url : 'searchReviewKeywordAjax',
	    
	    data:{
	    	"categoryName" : catVal,
	    	"keywordName" : textVal,
	    	"compName" : compVal
	    },
	    	
		success : function (data) {
			$('#selectedtable').empty();
			console.log("success");
			
			var $tr = $("<tr> </tr>	");
			var $td = $("<td> </td>	");
			
			for(var i=0;i<data.length;i++) {
				$('#selectedtable').append("<tr>");
				$('#selectedtable').append("<td>"+(i+1)+"</td>");
				$('#selectedtable').append("<td><a href='showReview?id="+data[i].jno+"'>"+data[i].jtitle+"</a></td>");
				$('#selectedtable').append("<td>"+data[i].juser+"</td>");
				$('#selectedtable').append("<td>"+data[i].jdate+"</td>");
				$('#selectedtable').append("</tr>");
			
			}
		}
		});
	
}

function fn_paging(pagenum){
	console.log(pagenum);
	location.href = "review?curpage="+pagenum;
}
   	

</script>
<title>Review</title>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">
<% int reviewNo=1; %>
</head>
<body>




	<div style="width:70%;margin-left: 60px;">
	<div>
		<form style="display: inline; margin-left: 550px">
			<select id="selbox" class="company" >
				<option value="">--기업 선택-- </option>
				<c:forEach items="${compList}" var="val">
				<option value="${val}">
				 <c:out value = "${val}" />
				</option>
				</c:forEach>
				
			</select>       
			&nbsp; &nbsp;&nbsp; 
			<select id="selbox" class="cate" style="width:100px">
				<option value="review_title"> 제목 </option>
				<option value="review_content"> 내용 </option>
				<option value="review_user"> 작성자 </option>
			</select>
			&nbsp;&nbsp;
			<input class="keyword" name="keyword" type="text" placeholder="Search..">
			&nbsp;
			<input type="button" class="large blue button" value="조회" onclick="search()">
		</form>
	</div>
	
	<br><br>
	
	<div style="width:1400px">
	
	
	<table class="type09" style="margin-left: 20px">
    <thead>
    <tr>
    	<th style="width:8%">번호</th>
        <th style="width:60%">제목 </th>
        <th style="width:20%">작성자 </th>
        <th style="width:20%">작성일 </th>
    </tr>
    </thead>
    <tbody id="selectedtable">
    <c:forEach items="${reviewList}" var="val">
    <tr style="height:80px;">
    	<td style="vertical-align:middle"><%= reviewNo++ %></td>
    	<td style="vertical-align:middle"><a href="showReview?id=${val.getReview_num()}"><c:out value = "${val.review_title}" /></a></td>
    	<td style="vertical-align:middle"><c:out value = "${val.review_user}" /></td>
    	<td style="vertical-align:middle"><c:out value = "${val.review_date}" /></td>
    </tr>
    </c:forEach>
    
    	
  
    </tbody>
	</table>
	<br>
	<input type="button" class="large blue button" value="작성" onClick="location='uploadReview'" style="margin-left:1350px;">
	</div>

</div>	
	
</body>
</html>