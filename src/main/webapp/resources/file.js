var fileUpload = {
	file : function(callback) {
		fileUpload.callBack = callback;
		fileUpload.fileForm("file");
	}
	, xls : function(callback) {
		fileUpload.callBack = callback;
		fileUpload.fileForm("xls");
	}
	, image : function(callback){
		fileUpload.callBack = callback;
		fileUpload.fileForm("image");
	}
	, goodsImage : function (callback, objId ) {
		fileUpload.callBack = callback;
		fileUpload.objId = objId;
		fileUpload.fileForm("image");
	}
	, fileForm : function(type){
		$("#fileUploadForm").remove();
		var html = new Array();
		html.push("<form name=\"fileUploadForm\" id=\"fileUploadForm\" method=\"post\" enctype=\"multipart/form-data\">");
		html.push("	<div style=\"display:none;\">");
		html.push("		<input type=\"file\" name=\"uploadFile\" id=\"uploadFile\" />");
		html.push("		<input type=\"hidden\" name=\"uploadType\" value=\"" + type + "\">");
		html.push("	</div>");
		html.push("</form>");
		$("body").append(html.join(''));
		$("#uploadFile").click();
	}
	, callBack : null
	, objId : null
}
$(document).on("change", "#uploadFile", function(){
	waiting.start();
	
	$('#fileUploadForm').ajaxSubmit({
		url : '/common/fileUploadResult'
		, dataType : 'json'
		, success : function(result){
			$("#fileUploadForm").remove();
			waiting.stop();
			if(result.exCode != null && result.exCode != undefined && result.exCode != ""){
				alert(result.exMsg);
			} else {
				if(fileUpload.objId != null ) {
					// 상품 이미지 등록 부분을 위한 처리..
					fileUpload.callBack(result.file, fileUpload.objId );
				} else {
					fileUpload.callBack(result.file);
				}
			}
		}
		, error : function(xhr, status, error) {
			waiting.stop();
			if(xhr.status == 1000) {
				location.replace("/login/noSessionView.do");
			} else {
				alert("오류가 발생되었습니다. 관리자에게 문의하십시요.["+xhr.status+"]["+error+"]");
			}
		}
	});
	
});