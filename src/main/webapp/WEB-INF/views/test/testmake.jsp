<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/>
<script src="resources/jquery/jquery-1.11.3.min.js"></script>
<script>
/*
$(document).ready({
	console.log(11);
});
*/
var testtypeitem_select_basic;
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
	
	/*
	function saveajaxex1(){
		
		var test_title_id = $("#test_title_id").val();
		
		var testcateitem_select_id = $("#testcateitem_select_id option:selected").val();
		var testtypebasic_select_id = $("#testtypebasic_select_id option:selected").val();
		var testtypess_select_id = $("#testtypess_select_id option:selected").val();
		
		var testtypeitem_select_id = $("#testtypeitem_select_id option:selected").val();
		var test_sent_id = $("#test_sent_id").val();
		
		
		
		console.log(test_title_id);
		console.log(testcateitem_select_id);
		console.log(test_sent_id);
		
		$.ajax({
			type : "GET",
			url : 'saveAjax',
		    // dataType: "json", 
		    data:{"test_title_id" :test_title_id
		    	, "testcateitem_select_id" :testcateitem_select_id
		    	, "testtypebasic_select_id" :testtypebasic_select_id
		    	, "testtypess_select_id" :testtypess_select_id
		    	, "testtypeitem_select_id" :testtypeitem_select_id
		    	, "test_sent_id" :test_sent_id
		    	},
			success : function (data) {
				
				console.log(data);
				
				for(var i=0; i<data.length; i++){
					console.log(data[i].sent_type);
					console.log(data[i].sent_type_name);
				}
				
			
			}
		});
		
	}
	
*/


	function saveajax(){
		
		
		
		var test_title_id = $("#test_title_id").val();
		
		var testcateitem_select_id = $("#testcateitem_select_id option:selected").val();
		var testtypebasic_select_id = $("#testtypebasic_select_id option:selected").val();
		var testtypess_select_id = $("#testtypess_select_id option:selected").val();

		
		console.log(test_title_id);
		console.log(testcateitem_select_id);
		
		
		mytable = document.getElementById('serviceTbody');  //행을 추가할 테이블
		var dataArray = new Array();
		
		for(var i=0; i<mytable.rows.length; i++){
		    var row = mytable.rows.item(i);
		    var dataObj = new Object();
            var col0 = row.cells.item(0);   
            var col1 = row.cells.item(1); 
            dataObj.type = col0.firstChild.value;
            dataObj.contents = col1.firstChild.value;

		      
		    dataArray.push(JSON.stringify(dataObj));   //데이터를 json 형식으로 만들어줌 stringify
		}		
		
		var obj ={
		"test_title_id" :test_title_id
    	, "testcateitem_select_id" :testcateitem_select_id
    	, "testtypebasic_select_id" :testtypebasic_select_id
    	, "testtypess_select_id" :testtypess_select_id
    	, "dataArray" :dataArray
		};
		
		
		console.log(obj);

		//var jsonData = JSON.stringify(obj);
		
		$.ajax({
			type : "POST",
			url : 'saveAjax',
		    dataType: "json", 
		    contentType: "application/json; charset=utf-8;",
		    data:JSON.stringify(obj),
		    //data:JSON.stringify(dataArray),
			success : function (data) {
				
				console.log(data);
				/*
				for(var i=0; i<data.length; i++){
					console.log(data[i].sent_type);
					console.log(data[i].sent_type_name);
				}
				*/
			
			}
		});
		
	}
	
	function savetestajax(){
		mytable = document.getElementById('serviceTbody');  //행을 추가할 테이블
		var dataArray = new Array();
		
		for(var i=0; i<mytable.rows.length; i++){
		    var row = mytable.rows.item(i);
		    var dataObj = new Object();
            var col0 = row.cells.item(0);   
            var col1 = row.cells.item(1); 
            dataObj.type = col0.firstChild.value;
            dataObj.contents = col1.firstChild.value;

		      
		    dataArray.push(JSON.stringify(dataObj));   //데이터를 json 형식으로 만들어줌 stringify
		}

		console.log(dataArray);
		$('#testtypeitem_select_id').remove();
		$('#test_sent_id').remove();

	}
	
	
	function addrow(){
		 
		   mytable = document.getElementById('serviceTbody');  //행을 추가할 테이블
		   row = mytable.insertRow(mytable.rows.length);  //추가할 행

		   
		   cell1 = row.insertCell(0);  //실제 행 추가 여기서의 숫자는 컬럼 수
		   cell2 = row.insertCell(1);

		   //cell1.innerHTML = "<td class='al fontB'><input type='text' name='title' size='80'></td>"; //추가한 행에 원하는  요소추가
		   
		   cell1.innerHTML = "<select name='testtypeitem_select' id='testtypeitem_select_id' style='width:80px;vertical-align: top;'>"
			   					+"<c:forEach var='testtypeitem' items='${senttype}'>"
									+"<option value=<c:out value='${testtypeitem.getSent_type()}' />> <c:out value='${testtypeitem.getSent_type_name()}' /> </option>"
								+"</c:forEach>"
							+"</select>";
			   
		   //cell2.innerHTML = "<td><input type='checkbox' name='service'/></td>";
		   cell2.innerHTML = "<textarea id='test_sent_id' name='test_sent' rows='5' cols='100' placeholder='내용'> </textarea>";
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

<br>

<div>

	<div style="margin-left: 600px">
	
		<input type="text" id="test_title_id" name="test_title" placeholder="문제제목" style="vertical-align: top;">
		
		
		<select name="testcateitem_select" id="testcateitem_select_id" style="width:140px" onchange="test()">
			<option value="basic">문제유형</option>
			<c:forEach var="testcateitem" items="${testcatelist2}">
				<option value=<c:out value="${testcateitem.getTest_cate()}" />> <c:out value="${testcateitem.getTest_cate_name()}" /> </option>
			</c:forEach>
		</select>
		
		<select name="testtypeitem_select" id="testtypebasic_select_id" style="width:80px">
			<option value="basic">문제타입</option>
			<c:forEach var="testtypeitem" items="${testtypebasic}">
				<option value=<c:out value="${testtypeitem.getTest_type()}" />> <c:out value="${testtypeitem.getTest_type_name()}" /> </option>
			</c:forEach>
		</select>
		
		<select name="testtypeitem_select" id="testtypess_select_id" style="width:80px">
			<option value="basic">문제타입</option>
			<c:forEach var="testtypeitem" items="${testtypess}">
				<option value=<c:out value="${testtypeitem.getTest_type()}" />> <c:out value="${testtypeitem.getTest_type_name()}" /> </option>
			</c:forEach>
		</select>
	</div>
	
	<br>
		
	<div style="margin-left: 950px">
		<input type="button" value="추가" onclick="addrow()">
		<input type="button" value="저장" onclick="saveajax()">
		<!--  <input type="button" value="저장2" onclick="saveajax2()">
		<input type="button" value="저장테스트" onclick="savetestajax()">
		-->
	</div>
	
	<br>
	<br>
	
	<!--  
	<div style="margin-left: 200px;vertical-align: top; ">
	
	
		<select name="testtypeitem_select" id="testtypeitem_select_id" style="width:80px;vertical-align: top;">
			<c:forEach var="testtypeitem" items="${senttype}">
				<option value=<c:out value="${testtypeitem.getSent_type()}" />> <c:out value="${testtypeitem.getSent_type_name()}" /> </option>
			</c:forEach>
		</select>
		<textarea id="test_sent_id" name="test_sent" rows="5" cols="100" placeholder="내용"> </textarea>
		<input type="text" id="test_sent_id" name="test_sent" placeholder="내용" style="width:500px"> 
	
	</div>
	-->
	
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
		
		</tbody>
		
		</table>
	</div>


</div>

</body>
</html>