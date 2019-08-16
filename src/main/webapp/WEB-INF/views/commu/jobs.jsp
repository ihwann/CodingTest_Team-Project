<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">

<meta charset="UTF-8">

<title>Jobs</title>


<script>


    $(document).ready(function(){
    	
    	var rtn = '${rtn}';
    	if(rtn == 1) {
    		alert('게시글 삭제 완료 되었습니다.');
    	}
        
        $(".menu>div>button").click(function(){
            var submenu = $(this).next("div");
 
            if( submenu.is(":visible") ){
                submenu.slideUp();
            }else{
                submenu.slideDown();
            }
        });
    });
    
    function search() {
    	
    	var lang_items = [];
    	$('input:checkbox[name=main_lang_sel]:checked').each(function () {
    		lang_items.push($(this).val());
    	});
    	
    	var field_items = [];
    	$('input:checkbox[name=field_sel]:checked').each(function () {
    		field_items.push($(this).val());
    	});
    	
    	var loc_items = [];
    	$('input:checkbox[name=loc_sel]:checked').each(function () {
    		loc_items.push($(this).val());
    	});
    	
    	var smsi_items = [];
    	$('input:checkbox[name=smsi_sel]:checked').each(function () {
    		smsi_items.push($(this).val());
    	});
   
    	var dataArray = new Array();
    	dataArray.push(JSON.stringify(lang_items));
    	dataArray.push(JSON.stringify(field_items));
    	dataArray.push(JSON.stringify(loc_items));
    	dataArray.push(JSON.stringify(smsi_items));
    
    	
    	
    	$.ajax({
    		type : "post",
    		url : 'searchJobKeywordAjax',
    		dataType: "json",
    		contentType: "application/json; charset=utf-8;",
    		data: JSON.stringify(dataArray),
    		success : function (data) {
    			$('#selectedtable').empty();
    			alert(data);
   
    		}
    		});
    	
    }
</script>
</head>
<body>


<div style="width:70%;margin-left: 60px;">
<div>
    
        <div class="menu">
			<div style="margin-left:1000px;width:800px">
            <button class="myButton" style="height:40px;width:250px" >조건 검색 열기 </button>&nbsp;&nbsp;&nbsp;
            
            <div class="hide" >
                <form>
                <div id="choice_box">
                <br>
             	언어 &nbsp;&nbsp;
             		<c:forEach items="${job_main_lang_list}" var="val">
             			<input type="checkbox" name="main_lang_sel" value="${val}"/><c:out value = "${val}" />
             		</c:forEach>
                	
                	
                	
                	<br><br>
              
                분야 &nbsp;
                 	<c:forEach items="${job_field_list}" var="val">
             			<input type="checkbox"   name="field_sel" value="${val}"/><c:out value = "${val}" />
             		</c:forEach>
         
                	<br><br>
                	
                위치 &nbsp;&nbsp;
                 	<c:forEach items="${job_loc_list}" var="val">
             			<input type="checkbox" name="loc_sel" value="${val}"/><c:out value = "${val}" />
             		</c:forEach>
                	
                	<br><br>
               	SM/SI &nbsp;&nbsp;
               		<input type="checkbox" name="smsi_sel" value="sm"/>SM
                	<input type="checkbox" name="smsi_sel" value="sm"/>SI
                	
                	<input type="button" style="margin-left:200px;" class="small blue button" value="조회" onclick="search()">
                </div>
                
                </form>
            </div>
            </div>
        </div>
 
 
 <br>
 <% int jobNum=1; %>
 <div style="width:1400px;">
	
	<table class="type09" style="margin-left: 40px">
    <thead>
    <tr>
        <th style="width:8%">번호</th>
        <th style="width:52%">제목 </th>
        <th style="width:20%">위치  </th>
        <th style="width:10%">작성자 </th>
        <th style="width:10%">작성일 </th>
    </tr>
    </thead>
    <tbody id="selectedtable">
    <c:forEach items="${jobList}" var="val">
    <tr style="height:80px;">
    	<td style="vertical-align:middle"><%= jobNum++ %></td>
    	<td style="vertical-align:middle"><a href="showJob?id=${val.getJob_num()}">${val.job_title}</a></td>
	    <td style="vertical-align:middle">${val.job_loc}</td>
	    <td style="vertical-align:middle">${val.job_user}</td>
	    <td style="vertical-align:middle">${val.job_date}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
	<br>
	<input type="button" class="small blue button" value="작성" onClick="location='uploadJob'"	style="margin-left:1350px;">
	</div>
</div>
</div>

</body>
</html>