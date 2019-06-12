<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<title> Upload Job Recruit</title>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
	
<body>
    
    
 <div class="form-style">
    <form>
    <br>
   	
    <div class="main_lang_div">
    언어 &nbsp;
    	<select>
    		<option value="">--언어 선택--</option>
    		<option value="java">Java</option>
    		<option value="ckind">C계열 </option>
    		<option value="asp">ASP</option>
    		<option value="python">파이썬 </option>
    		<option value="etc">기타 </option>
    	
    	</select><br><br>
    </div>
    <div class="field_div">
    분야  &nbsp;
    	<select>
    		<option value="">--분야 선택--</option>
    		<option value="1">금융 </option>
    		<option value="2">제조  </option>
    		<option value="3">병원 </option>
    		<option value="4">공공기관  </option>
    		<option value="5">이커머스  </option>
    		<option value="6">기타   </option>
    	
    	</select><br><br>
    </div>
    <div class="loc_div">
     지역   &nbsp;
    	<select>
    		<option value="">--지역 선택--</option>
    		<option value="seoul">서울  </option>
    		<option value="gyeonggi">경기  </option>
    		<option value="prov">지방  </option>
    		<option value="abraod">해외  </option>
    	</select><br><br>
    </div>
    <div class="smsi_div">
    SM/SI  &nbsp;
    	<select>
    		<option value="">--SM/SI--</option>
    		<option value="sm">SM  </option>
    		<option value="si">SI  </option>
    	</select><br><br>
    </div>
    <input type="text" class="text-style"  style="width:800px;"name="title" placeholder="제목을 입력하세요"><br><br>
    <div class="mes_div">
    <textarea id="message" class="text-style" name="message" rows="20" cols="120" placeholder="내용을 입력해주세요 "></textarea>
    <br><br>
    </div>
 	
 	<div class="submit_div" style="width:900px">
    &nbsp;&nbsp;<input type="submit" class="myButton" value=" 저장 " style="float:right"> 
    &nbsp;&nbsp;<input type="button" class="myButton" value="뒤로" style="float:right">
    
    </div>
    </form>
    </div>
    
 	
</body>
</html>
