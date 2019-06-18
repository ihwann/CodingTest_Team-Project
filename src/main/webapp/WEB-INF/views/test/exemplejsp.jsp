<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<script src="resources/jquery/jquery-1.11.3.min.js"></script>
<script>
/*
$(document).ready({
	console.log(11);
});
*/
/* var testtypeitem_select_basic;
var testtypeitem_select_ss;
$(document).ready(function(){
	//alert(11);
	console.log(11);
	for(var cnt = 0; cnt < "${testtypebasic.size()}"; cnt++){
		console.log(24);
		

	}
	
	$('#testtypebasic_select_id').hide();
	$('#testtypess_select_id').hide();
	
});

	$('#testcateitem_select_id').change(function(){
		alert(1);
	});
	
	function test(){
		var testtype = $("#testcateitem_select_id").val();
		console.log(testtype);
		if(testtype == 'basic'){
			$('#testtypebasic_select_id').show();
			$('#testtypess_select_id').hide();
		}else if(testtype == 'samsung'){
			$('#testtypebasic_select_id').hide();
			$('#testtypess_select_id').show();
		}else{
			$('#testtypebasic_select_id').hide();
			$('#testtypess_select_id').hide();
		}
		//alert(11);
	}
	
	 */
	//ajax 사용 예제 1
	//String 컨트롤러로 보내기	

	function test1_stringajax(){
		$.ajax({
			type : "GET",
			url : 'test1Ajax',
		    /* dataType: "json", */
		    data:{"test_no" : "5"
		    	},
			success : function (data) {
				
				console.log(data);
			
			}
		});
	}	
	
	//ajax 사용 예제 2
	//JSONArray 컨트롤러로 보내기
	function test2_arrayajax(){
		mytable = document.getElementById('serviceTbody');  // 1. 행을 추가할 테이블 body
		//getElemntById(); html에 id값을 가져오기
		var dataArray = new Array();
		
		for(var i=0; i<mytable.rows.length; i++){
			
			//2. mytable.rows.length <tr></tr>  body 안에 tr 갯수
		    var row = mytable.rows.item(i);
		    //rows 컬렉션은 테이블에 있는 모든 <tr> 요소의 컬렉션을 반환함.
		    //item 지정된 인덱스(0에서 시작)를 가진 콜렉션에서<tr>요소를 리턴함
		    var dataObj = new Object();
            //var col0 = row.cells.item(0);   
            var col1 = row.cells.item(1); 
            //rows.cells.length td 또는th 갯수
            
            //dataObj.type = col0.firstChild.value;
            dataObj.contents = col1.firstChild.value;

		      
		    dataArray.push(JSON.stringify(dataObj));   //데이터를 json 형식으로 만들어줌 stringify
		}		
		

		
		$.ajax({
			type : "POST",
			url : 'test2Ajax',
		    dataType: "json", 
		    contentType: "application/json; charset=utf-8;",
		    //data:JSON.stringify(obj),
		    data:JSON.stringify(dataArray),
			success : function (data) {
				
				 console.log(data);
				
			 	for(var i=0; i<data.length; i++){
					console.log(data[i].sent_type);
					console.log(data[i].sent_type_name); 
				}
			
			}
		});
	}
	
</script>
<meta charset="UTF-8">
<title>testmake</title>
</head>
<body>
<!--  <img src="resources/img/submit1.png">-->


<!--  
<c:forEach var="testcateitem" items="${testcatelist}">
	<c:out value="${testcateitem}" />
</c:forEach>
-->
<!--  

<input type="text" name="test_title" placeholder="문제제목">
<select name="testcateitem_select" id="testcateitem_select_id" style="width:140px" onchange="test()">
	<option>문제유형</option>
	<c:forEach var="testcateitem" items="${testcatelist2}">
		<option value=<c:out value="${testcateitem.getTest_cate()}" />> <c:out value="${testcateitem.getTest_cate_name()}" /> </option>
	</c:forEach>
</select>

<select name="testtypeitem_select" id="testtypebasic_select_id" style="width:80px">
	<option>문제타입</option>
	<c:forEach var="testtypeitem" items="${testtypebasic}">
		<option value=<c:out value="${testtypeitem.getTest_type()}" />> <c:out value="${testtypeitem.getTest_type_name()}" /> </option>
	</c:forEach>
</select>

<select name="testtypeitem_select" id="testtypess_select_id" style="width:80px">
	<option>문제타입</option>
	<c:forEach var="testtypeitem" items="${testtypess}">
		<option value=<c:out value="${testtypeitem.getTest_type()}" />> <c:out value="${testtypeitem.getTest_type_name()}" /> </option>
	</c:forEach>
</select>

<br>

<select name="testtypeitem_select" id="testtypess_select_id" style="width:80px">
	<option>문제타입</option>
	<c:forEach var="testtypeitem" items="${testtypess}">
		<option value=<c:out value="${testtypeitem.getTest_type()}" />> <c:out value="${testtypeitem.getTest_type_name()}" /> </option>
	</c:forEach>
</select>
-->

<input type="button" value="test1_stringajax" onclick="test1_stringajax()">
<input type="button" value="test2_arrayajax" onclick="test2_arrayajax()">

<br><br>
	<div style="color:white">
		<table class="resch_list" border="1" style="border-color: white; margin-left: 200px;" width="900px">
		    <colgroup>
		        <col width="10%"/>
		        <col />
		    </colgroup>
		    <thead>
		        <tr>
		            <th width="10%">문장타입</th>
		            <th>문장내용</th>
		        </tr>
		    </thead>
		    <tbody id="serviceTbody">
		    	<tr>
		    		<td>
					   <select name='testtypeitem_select' id='testtypeitem_select_id' style='width:80px;vertical-align: top;'>
								<option value='test1'> 문제내용 </option>
								<option value='test2'> 문제조건 </option>
						</select>
			 		  </td>
				   <td><textarea id='test_sent_id' name='test_sent' rows='5' cols='100' placeholder='내용'> </textarea></td>
				</tr>
				<tr>
		    		<td>
					   <select name='testtypeitem_select' id='testtypeitem_select_id' style='width:80px;vertical-align: top;'>
								<option value='test1'> 문제내용 </option>
								<option value='test2'> 문제조건 </option>
						</select>
			 		  </td>
				   <td><textarea id='test_sent_id' name='test_sent' rows='5' cols='100' placeholder='내용'> </textarea></td>
				</tr>
		   
		</tbody>
		
		</table>
	</div>

</body>
</html>