<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/testlist.css" rel="stylesheet" type="text/css"> 
<script src="resources/jquery/jquery-1.11.3.min.js"></script>


<script>
$(document).ready(function(){
	$('li').on("click",function(){
		//alert($(this).children().val());
		
		testnoid = $(this).children().val();
		parameter = {'testnoid':testnoid};
		
		//alert(testnoid);
		$.ajax({
			type:'post',
			url:'testListAjax',
			
			data:parameter,
			success:function(data){
				console.log(data);
				$('.testlist_view_flex').empty();
				for(var i=0; i<data.length; i++){
					console.log(data[i].sent_type);
					console.log(data[i].sent_cont);
					
					var $div = $("<div></div><br>");
					
					
					if(data[i].sent_type = 'sentence_title'){
						$div.text(data[i].sent_cont) ;
						$('.testlist_view_flex').append($div); 
					}else if(data[i].sent_type = 'sentence_strong'){
						$div.text(data[i].sent_cont) ;
						$('.testlist_view_flex').append($div); 
					}else if(data[i].sent_type = 'sentence'){
						$div.text(data[i].sent_cont) ;
						$('.testlist_view_flex').append($div); 
					}
					
				}
				

			}
			
		});
	});
	

});

function fn_paging(pagenum){
	console.log(pagenum);
	location.href = "testlist?curpage="+pagenum;
}


</script>

<title>문제 미리보기</title>
</head>
<body>



<div class="testlist_main_flex" >
	<div class="testlist_flex" style="width: 700px">

		<ol>
		<c:forEach var="list" items="${testviewlist}">
			<li id="li_mouseover_id" class="li_mouseover" >
			<input id="testnoid" type="hidden" value="${list.getTest_no()}">
			<c:out value="${list.getTest_cate()}"></c:out>
		    <c:out value="${list.getTest_title()}"></c:out>
		    <!--  	<c:out value="${list.getTest_type()}"></c:out>-->
			
		</li>
			
		</c:forEach>
		</ol>
	
		<div style="display:flex;" >	
          <c:if test="${pagination.curRange ne 1}">
	              <a href="#" onClick="fn_paging(1)">[처음]&nbsp;</a>
	          </c:if>
	          <c:if test="${pagination.curPage ne 1}">
	              <a href="#" onClick="fn_paging('${pagination.prevPage}')">[이전]&nbsp;</a> 
	          </c:if>
	           
	          <c:forEach var="pageNum" begin="${pagination.startPage}" end="${pagination.endPage}">
	              <c:choose>
	                  <c:when test="${pageNum eq  pagination.curPage}">
	                      <span style="font-weight: bold;"><a href="#" onClick="fn_paging('${pageNum}')">${pageNum}&nbsp;</a></span> 
	                  </c:when>
	                  <c:otherwise>
	                      <a href="#" onClick="fn_paging('${pageNum}')">${pageNum}&nbsp;</a> 
	                  </c:otherwise>
	              </c:choose>
	          </c:forEach>
	          <c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
	              <a href="#" onClick="fn_paging('${pagination.nextPage}')">[다음]&nbsp;</a> 
	          </c:if>
	          <c:if test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
	              <a href="#" onClick="fn_paging('${pagination.pageCnt}')">&nbsp;[끝]</a> 
	          </c:if>
	     </div>

	      
	      <div>
	          총 게시글 수 : ${pagination.listCnt } /    총 페이지 수 : ${pagination.pageCnt } / 현재 페이지 : ${pagination.curPage } / 현재 블럭 : ${pagination.curRange } / 총 블럭 수 : ${pagination.rangeCnt }
	      </div>
		
		
		
		
	</div>
	
	
	<div class="testlist_view_flex" style="width: 700px;" >
	<c:forEach var="item" items="${testcontentslist}">
		
			
			<c:choose>
				<c:when test="${sent_type == 'sentence_title'}">
				
					<div>
					
					 ${item.getSent_cont() }
					</div>	
				</c:when>
				<c:when test="${sent_type == 'sentence_strong'}">
					<div>
					
						${item.getSent_cont() }
					</div>	
				</c:when>
				
				<c:otherwise>
				<div>
				
					${item.getSent_cont() }
				</div>
				</c:otherwise>
				
			</c:choose>
			
			<br>
		</c:forEach>
	</div>

</div>
</body>
</html>