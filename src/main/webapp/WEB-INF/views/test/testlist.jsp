<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/testlist.css" rel="stylesheet" type="text/css"> 

<script type="text/javascript">



function testlist_ajax(){
	S.ajax({
	type : "get",
	url : 'testListAjax',
	data:{ "test_list" : "10"		
	},
	success : function (data) {
		console.log(data)
	alert("성공")
	}
	});
	
}

</script>

<title>문제 미리보기</title>
</head>
<body>
<div class="box" >
<div class="testlist_item">

<tr>
<td><a href="">${row.test_title}</a></td>
</tr>
</div>
<div class="testlist_item" >

<div class="testlist_scroll"></div>

</div>
</div>
</body>
</html>