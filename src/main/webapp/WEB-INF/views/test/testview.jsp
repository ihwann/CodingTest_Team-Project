<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
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
			url:'testpreviewAjax',
			
			data:parameter,
			success:function(data){
				console.log(data);
				for(var i=0; i<data.length; i++){
					console.log(data[i].sent_type);
					console.log(data[i].sent_cont);
					$('.testpreview_flex').empty();
					
					var $div = $("<div> </div>	");
					
					
					if(data[i].sent_type = 'sentence_title'){
						$div.text(data[i].sent_cont) ;
						$('.testpreview_flex').append($div); 
					}else if(data[i].sent_type = 'sentence_strong'){
						$div.text(data[i].sent_cont) ;
						$('.testpreview_flex').append($div); 
					}else if(data[i].sent_type = 'sentence'){
						$div.text(data[i].sent_cont) ;
						$('.testpreview_flex').append($div); 
					}
					
				}
				

			}
			
		});
	});
	

});

function fn_paging(pagenum){
	console.log(pagenum);
	location.href = "testview?curpage="+pagenum;
}


</script>
<meta charset="UTF-8">
<title>testview</title>
</head>
<body>

<br>
<div class="testview_main_flex">

	<div class="testlist_flex">
	
		<ol>
		<c:forEach var="list" items="${testviewlist }">
			<li id="li_mouseover_id" class="li_mouseover" ><input id="testnoid" type="hidden" value="${list.getTest_no()}"><c:out value="${list.getTest_cate()}"></c:out><c:out value="${list.getTest_type()}"></c:out><c:out value="${list.getTest_title()}"></c:out></li>
			
		</c:forEach>
		</ol>
		
		
     	   <div>
	          <c:if test="${pagination.curRange ne 1 }">
	              <a href="#" onClick="fn_paging(1)">[처음]</a> 
	          </c:if>
	          <c:if test="${pagination.curPage ne 1}">
	              <a href="#" onClick="fn_paging('${pagination.prevPage }')">[이전]</a> 
	          </c:if>
	          <c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
	              <c:choose>
	                  <c:when test="${pageNum eq  pagination.curPage}">
	                      <span style="font-weight: bold;"><a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a></span> 
	                  </c:when>
	                  <c:otherwise>
	                      <a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a> 
	                  </c:otherwise>
	              </c:choose>
	          </c:forEach>
	          <c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
	              <a href="#" onClick="fn_paging('${pagination.nextPage }')">[다음]</a> 
	          </c:if>
	          <c:if test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
	              <a href="#" onClick="fn_paging('${pagination.pageCnt }')">[끝]</a> 
	          </c:if>
	      </div>
	      
	      <div>
	          총 게시글 수 : ${pagination.listCnt } /    총 페이지 수 : ${pagination.pageCnt } / 현재 페이지 : ${pagination.curPage } / 현재 블럭 : ${pagination.curRange } / 총 블럭 수 : ${pagination.rangeCnt }
	      </div>
		
		
		
		
	</div>

	<div class="testpreview_flex">
		<c:forEach var="item" items="${testcontentslist}">
		
			
			<c:choose>
				<c:when test="${sent_type == 'sentence_title'}">
				
					<div class="testtitle">
					
						문제. ${item.getSent_cont() }
					</div>	
				</c:when>
				<c:when test="${sent_type == 'sentence_strong'}">
					<div class="codehilite">
					
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