<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css">

<meta charset="UTF-8">

<title>Jobs</title>

<script>

    // html dom 이 다 로딩된 후 실행된다.
    $(document).ready(function(){
        
        $(".menu>div>button").click(function(){
            var submenu = $(this).next("div");
 
            if( submenu.is(":visible") ){
                submenu.slideUp();
            }else{
                submenu.slideDown();
            }
        });
    });
</script>
</head>
<body>

<div>
    
        <div class="menu">
			<div style="margin-left:900px">
            <button class="myButton" style="height:40px;width:450px" >조건 검색 열기 </button>&nbsp;&nbsp;&nbsp;
            
            <div class="hide" >
                <form>
                <div class="choice_box">
                <br>
             	언어 
                	<input type="checkbox" name="main_lang_sel" value="java"/>자바 
                	<input type="checkbox" name="main_lang_sel" value="ckind"/>c계열  
                	<input type="checkbox" name="main_lang_sel" value="asp"/>ASP
                	<input type="checkbox" name="main_lang_sel" value="py"/>파이썬 
                	<input type="checkbox" name="main_lang_sel" value="etc"/>기타
                	
                	<br><br>
              
                 분야 <input type="checkbox" name="field_sel" value="fin"/>금융  
                	<input type="checkbox" name="field_sel" value="prod"/>제조 
                	<input type="checkbox" name="field_sel" value="hosp"/>병원 
                	<input type="checkbox" name="field_sel" value="publicInst"/>공공기관  
                	<input type="checkbox" name="field_sel" value="ecomm"/>이커머스 
                	<input type="checkbox" name="field_sel" value="etx"/>기타
                	
                	<br><br>
                 위치 <input type="checkbox" name="loc_sel" value="seoul"/>서울 
                	<input type="checkbox" name="loc_sel" value="gyeonggi"/>경기 
                	<input type="checkbox" name="loc_sel" value="province"/>지방 
                	<input type="checkbox" name="loc_sel" value="abroad"/>해외 
                	
                	<br><br>
               	SM/SI
               		<input type="checkbox" name="smsi_sel" value="sm"/>SM
                	<input type="checkbox" name="smsi_sel" value="sm"/>SI
                </div>
                
                	<br><br>
                	<input type="submit" class='myButton' value="조회">
                </form>
            </div>
            </div>
        </div>
 
 
 <br>
 
 <div style="width:1300px;">
	
	<table class="type09" style="margin-left: 40px">
    <thead>
    <tr>
        <th scope="cols" style="width:60%">제목 </th>
        <th scope="cols" style="width:20%">위치  </th>
        <th scope="cols" style="width:10%">작성 </th>
        <th scope="cols" style="width:10%">작성일 </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><a href="">내용이 들어갑니다.</a></td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>

    </tr>
    <tr>
        <td><a href="">내용이 들어갑니다.</a></td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>
    </tr>
    <tr>
        <td><a href="">내용이 들어갑니다.</a></td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>
        <td>내용이 들어갑니다.</td>
    </tr>
    </tbody>
</table>
	</div>
</div>


</body>
</html>