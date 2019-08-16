<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.stevelee.java.dto.JobDto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job</title>
<style>
 #type01 {
 background-color:#EEF7FF;width:10%;vertical-align: middle;
 	}
</style>
</head>
<body>
<div style="width:65%;margin:auto;">
<span style="margin-left:50px;font-size:30pt;"> 구인 </span>
<br><br>
<% JobDto job = (JobDto)request.getAttribute("job");%>
<form action='modifyJob?id=<%=job.getJob_num()%>' >


	
	<table class="type09" style="margin-left: 40px">
    <tbody>
    <tr>
    	<th id="type01">작성자</th>
    	<td style="text-align:left;vertical-align: middle;height:25px;"><%= job.getJob_user() %></td>
    </tr>
    <tr>
    	<th id="type01">작성일</th>
        <td style="text-align:left;vertical-align: middle;height:20px;"><%= job.getJob_date() %></td>
    </tr>
   
    <tr>
    	<th id="type01">메인 언어 </th>
    	<td style="text-align:left;vertical-align: middle;"><%= job.getJob_main_lang() %></td>
    </tr>
    <tr>
    	<th id="type01">분야 </th>
    	<td style="text-align:left;vertical-align: middle;height:20px;"><%=job.getJob_field() %></td>
    </tr>
    <tr>
    	<th id="type01">지역 </th>
    	<td style="text-align:left;vertical-align: middle;height:20px;"><%=job.getJob_loc() %></td>
    </tr>
    <tr>
    	<th id="type01">SM/SI</th>
    	<td style="text-align:left;vertical-align: middle;height:20px;"><%=job.getJob_smsi() %></td>
    </tr>
    <tr>
    	<th id="type01" style="height:100px;vertical-align: middle;">제목 </th>
    	<td style="text-align:left;vertical-align: middle;"><%=job.getJob_title() %></td>
    </tr>
    <tr>
    	<td colspan="2" id="textbox01"><%=job.getJob_content() %></td>
    </tr>
    
    </tbody>
    
</table>
<br>

<!-- <input type="submit" class="small blue button" value="수정" style="float: right"> -->
<input type="button" onClick="location='deleteJob?id=<%=job.getJob_num() %>'" value="삭제" class="small red button"style="float:right" >

</form>
</div>
</body>
</html>