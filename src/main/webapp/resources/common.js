/**
* @function Name  : valid
* @function Desc  : 유효성 검사용 정규식
* @작성일   : 2016.03.02
* @작성자   : 신남원
* @변경이력  :
*           이름     : 일자            : 근거자료      : 변경내용
*           --------------------------------------------------------------------------------
*           신남원    : 2016. 03. 02  :            : 신규 개발.
*/

var valid = {
	login_id : /^[a-z][a-z0-9A-Z\d]{4,11}$/,
	password : /^(?=.*[a-z]+)(?=.*[0-9]+).{5,12}$/,	//(?=.*[A-Z]+):대문자포함 시 , (?=.*[!@#$%^*+=-]+):특수문자포함시
	orderPswd : /^(?=.*[a-z]+)(?=.*[0-9]+).{4,10}$/,	//(?=.*[A-Z]+):대문자포함 시 , (?=.*[!@#$%^*+=-]+):특수문자포함시
	tel : /^0\d{1,2}-?\d{3,4}-?\d{4}$/,
	mobile : /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/,
	email : /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
	url : /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/,
	onlyNum : /^[0-9\ ]+$/,
	bizNo : /^\d{3}-?\d{2}-?\d{5}$/,
	/**
	 * 입력값을 Byte로 변환
	 * @param targetId
	 * @param valueId
	 * @param maxByte
	 */
	checkByte : function(targetId, valueObj, maxByte){
		var result = 0;
		var strVal = $(valueObj).val(); 
		var strLen = strVal.length;
		var dLen = 0;
		if(strVal != ""){
		    for(var idx=0; idx < strLen; idx++) {
		        var c = escape(strVal.charAt(idx));
		         
		        if( c.length==1 ) result ++;
		        else if( c.indexOf("%u")!=-1 ) result += 2;
		        else if( c.indexOf("%")!=-1 ) result += c.length/3;
		        
		        if(result <= maxByte) dLen = idx + 1;
		    }
		    
		    if(result > maxByte){
		    	alert(maxByte+"Byte를 초과 입력할 수 없습니다.");
		    	strVal = strVal.substr(0,dLen);
		    	$(valueObj).val(strVal);
		    	this.checkByte(targetId, valueObj, maxByte);
		    }else{
				$("#"+targetId).html(result + "/" + maxByte + "Byte");
		    }
		}else{
			$("#"+targetId).html(result + "/" + maxByte + "Byte");
		} 
		
	}
};

/**
* @function Name  : spin
* @function Desc  : Jquery Spin 관련 함수
* @작성일   : 2016.03.02
* @작성자   : 신남원
* @변경이력  :
*           이름     : 일자            : 근거자료      : 변경내용
*           --------------------------------------------------------------------------------
*           신남원    : 2016. 03. 02  :            : 신규 개발.
*/
var waiting = {
	start : function(){
		$.blockUI({ message: '<img src="/_images/common/ajax-loader-white.gif" alt="Loading..." />' });
	}
	, stop : function(){
		$.unblockUI();
	}
	, startId : function(id){
		$.blockUI({ message: $("#" + id) });
	}
	, stopId : function(){
		$.unblockUI();
	}
};


/**
* @function Name  : ajax
* @function Desc  : ajax 관련 함수
* @작성일   : 2016.03.02
* @작성자   : 신남원
* @변경이력  :
*           이름     : 일자            : 근거자료      : 변경내용
*           --------------------------------------------------------------------------------
*           신남원    : 2016. 03. 02  :            : 신규 개발.
*/
var ajax = {
		/**
		* @function Name  : ajax.call
		* @function Desc  : ajax를 이용한 Data 요청
		* @작성일   : 2016.03.02
		* @작성자   : 신남원
		*/
		call : function(options){
			waiting.start();
			
			jQuery.ajaxSettings.traditional = true;
			
			options.contentType = options.contentType || "application/x-www-form-urlencoded;charset=UTF-8";
			options.type = options.type || "POST";
			options.dataType = options.dataType || "json";
			
			$.ajax({
				url : options.url,
				type : options.type,
				dataType : options.dataType,
				contentType : options.contentType,
				data : options.data
			})
			.done(function(data, textStatus, jqXHR){
				if(data.exCode != null && data.exCode != undefined && data.exCode != ""){
					if(options.fail != undefined){
						options.fail();
					}
					alert(data.exMsg);
				}else{
					options.done(data);
				}				
			})
			.fail(function( jqXHR, textStatus, errorThrown ){
				if(options.fail != undefined){
					options.fail();
				}
				ajax.error(jqXHR.status);
			})
			.always(function(){
				waiting.stop();
			})
			.then(function(data, textStatus, jqXHR ) {
			});
			
			
		},
		/**
		* @function Name  : ajax.load
		* @function Desc  : ajax를 이용한 View 요청
		* @작성일   : 2016.03.02
		* @작성자   : 신남원
		*/
		load : function(targetId, url, params, popId, callBackFn){
			waiting.start();
			
			if(params == undefined || params == null){
				params = {};
			}
			$("#"+targetId).load(url, params, function(response, status, xhr){
				waiting.stop();

				if(status == "error"){
					
					if(xhr.status == 1001){

						if(popId != undefined && popId != null && popId != ""){
							dialog.destroy(popId);
							$("#"+popId).remove();
						}
					}
					
					ajax.error(xhr.status);
				}
				if(callBackFn != undefined && callBackFn != null && callBackFn != ""){
					eval(callBackFn+"()");	
				}
			});
		},
		/**
		* @function Name  : ajax.error
		* @function Desc  : ajax를 이용 시 오류 발생 처리
		* @작성일   : 2016.03.02
		* @작성자   : 신남원
		*/
		error : function(status){
			
			if(status == 1000){
				location.href="/indexLogin?loginType=";
			}else if(status == 1011){
				location.href="/indexLogin?loginType=NMOD";
			}else if(status == 1012){
				location.href="/indexLogin?loginType=NMODS";
			}else if(status == 1001){
				pop.login({loginType : ""});
			}else if(status == 1021){
				pop.login({loginType : "NMOD"});
			}else if(status == 1022){
				pop.login({loginType : "NMODS"});
			}else{
				alert("오류가 발생하였습니다. 관리자에게 문의하시기 바랍니다.");
			}
		}		
};

/**
* @function Name  : dialog
* @function Desc  : Jquery UI를 이용한 Dialog 관련 함수
* @작성일   : 2016.03.02
* @작성자   : 신남원
* @변경이력  :
*           이름     : 일자            : 근거자료      : 변경내용
*           --------------------------------------------------------------------------------
*           신남원    : 2016. 03. 02  :            : 신규 개발.
*/
var dialog = {
		/**
		* @function Name  : dialog.create
		* @function Desc  : dialog 생성 함수
		* @작성일   : 2016.03.02
		* @작성자   : 신남원
		* @param targetId
		* @param options
		*/
	create : function(targetId, options){
		var dialogOption = {
			autoOpen: options.autoOpen || false,	
			width: options.width || 500,
			height: options.height || 300,
			draggable : options.draggable || false,
			resizable : options.resizable || false,
			modal : options.modal ,			
			buttons: options.buttons || '',
			
		};
		
		if(options.open != null && options.open != undefined){
			dialogOption.open = options.open;
		}

		if(options.close != null && options.close != undefined){
			dialogOption.close = options.close;
		}
		
		$('#'+targetId).dialog(dialogOption);
		
	},
	/**
	* @function Name  : dialog.open
	* @function Desc  : 생성된 dialog open 함수
	* @작성일   : 2016.03.02
	* @작성자   : 신남원
	* @param targetId
	*/
	open : function(targetId){
		$('#'+targetId).dialog("open");
	},
	/**
	* @function Name  : dialog.close
	* @function Desc  : open된 dialog close 함수
	* @작성일   : 2016.03.02
	* @작성자   : 신남원
	* @param targetId
	*/
	close : function(targetId){
		$('#'+targetId).dialog("close");
	},
	/**
	* @function Name  : dialog.destory
	* @function Desc  : 생성된 dialog 제거 함수
	* @작성일   : 2016.03.02
	* @작성자   : 신남원
	* @param targetId
	*/
	destroy : function(targetId){
		$('#'+targetId).dialog( "destroy" );	
	}
	
};


/**
* @function Name  : calendar
* @function Desc  : Jquery UI를 이용한 Calendar 관련 함수
* @작성일   : 2016.03.02
* @작성자   : 신남원
* @변경이력  :
*           이름     : 일자            : 근거자료      : 변경내용
*           --------------------------------------------------------------------------------
*           신남원    : 2016. 03. 02  :            : 신규 개발.
*/
var calendar = {
	/**
	* @function Name  : calendar.one
	* @function Desc  : 단일 Calendar 생성 함수
	* @작성일   : 2016.03.02
	* @작성자   : 신남원
	* @param targetId
	* @param options
	* 1. showButtonPanel : 하단 버튼영역 활성화 여부(true|false)
	* 2. yearRange : 년도 범위(c-10:c+10)
	*/
	one : function(targetId, options){
		
		$('#'+targetId).datepicker({
		    showButtonPanel: false	//달력의 버튼 영역 활성화(Today, 확인)
		    ,dateFormat: 'yy-mm-dd'
		    ,yearRange : options.yearRange || 'c-10:c+10'
		    ,changeYear: true                 //년도 풀다운메뉴를 넣어 년도변경을 빠르게 도와준다.
		    ,changeMonth : true
		    //달력버튼 이미지
		    ,showOn: "button"
		    ,buttonImage: "/_images/common/common/icon_datepicker.gif"
		    ,buttonImageOnly: true
		    ,buttonText: "Select date"
		});		
	},
	/**
	* @function Name  : calendar.one
	* @function Desc  : 기간 설정이 가능한 Calendar 생성 함수
	* @작성일   : 2016.03.02
	* @작성자   : 신남원
	 * @param fromId	적용할 시작일자 Tag Id
	 * @param toId		적용할 종료일자 Tag Id
	* @param options
	 * 1. showButtonPanel : 하단 버튼영역 활성화 여부(true|false)
	 * 2. yearRange : 년도 범위(c-10:c+10)
	*/	
	range : function(fromId, toId, options){
		$( "#"+fromId ).datepicker({
			showButtonPanel: false	//달력의 버튼 영역 활성화(Today, 확인)
			,defaultDate: "+1w"
			,changeYear: true
			,changeMonth: true
			,dateFormat: 'yy-mm-dd'
			,yearRange : options.yearRange || 'c-10:c+10'
			,showOn: "button"
			,buttonImage: "/_images/common/common/icon_datepicker.gif"
			,buttonImageOnly: true
			,buttonText: "Select date"
			,onClose: function( selectedDate ) {
			  $( "#"+toId ).datepicker( "option", "minDate", selectedDate );
			 }
		});
		
		$( "#"+toId ).datepicker({
			showButtonPanel: false	//달력의 버튼 영역 활성화(Today, 확인)
			,defaultDate: "+1w"
			,changeYear: true
			,changeMonth: true
			,dateFormat: 'yy-mm-dd'
			,yearRange : options.yearRange || 'c-10:c+10'
			,showOn: "button"
			,buttonImage: "/_images/common/common/icon_datepicker.gif"
			,buttonImageOnly: true
			,buttonText: "Select date"
			,onClose: function( selectedDate ) {
			  $( "#"+fromId ).datepicker( "option", "maxDate", selectedDate );
			 }
		});
		
	},
	/**
	* @function Name  : calendar.autoRange
	* @function Desc  : 현재일을 기준으로 지정한 기간만큼의 일자 설정 함수
	* @작성일   : 2016.03.02
	* @작성자   : 신남원
	* @param fromId	적용할 시작일자 Tag Id
	* @param toId		적용할 종료일자 Tag Id
	* @param period	자동생성할 기간
	*/	
	autoRange : function(fromId, toId, period){
		var fromYear, fromMonth, fromDate;
		var toYear, toMonth, toDate;
		
		var today = new Date();
		var fromday = new Date();
		
		fromday.setMonth(today.getMonth() - period);
		fromday.setDate(today.getDate() + 1);
		
		fromYear = fromday.getFullYear();
		fromMonth = fromday.getMonth() + 1;
		fromMonth = (fromMonth < 10) ? "0"+fromMonth : fromMonth;
		fromDate = fromday.getDate();
		fromDate = (fromDate < 10) ? "0"+fromDate : fromDate;

		toYear = today.getFullYear();
		toMonth = today.getMonth() + 1;
		toMonth = (toMonth < 10) ? "0"+toMonth : toMonth;
		toDate = today.getDate();
		toDate = (toDate < 10) ? "0"+toDate : toDate;

		$("#"+fromId).val(fromYear + "-" + fromMonth + "-" + fromDate);
		$("#"+toId).val(toYear + "-" + toMonth + "-" + toDate);
	}
};

var form = {
		clear : function(formId){
			var currentForm = $("#"+formId);
			
			var inputElement = currentForm.find("input").not(".no_clear");
			var selectElement = currentForm.find("select").not(".no_clear");
			var textareaElement = currentForm.find("textarea").not(".no_clear");
			var spanElement = currentForm.find("td > span").not(".no_clear");
			
			for(var i = 0; i < inputElement.length; i++){
				if(inputElement[i].type == "checkbox" || inputElement[i].type == "radio"){
					$(inputElement[i]).attr("checked", false);
				}else{
					$(inputElement[i]).val("");
				}
			}
			
			for(var i = 0; i < selectElement.length; i++){
				$(selectElement[i]).val("");
			}
			
			for(var i = 0; i < textareaElement.length; i++){
				$(textareaElement[i]).val("");
			}
			
			for(var i = 0; i < spanElement.length; i++){
				$(spanElement[i]).html("");
			}
		}
};


var format = {
	tel: function(tel){
		if(tel != "" && tel != undefined && tel != null && tel != 'null'){
			return tel.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");			
		}else{
			return "";
		}
	},	
	fax: function(fax){
		if(fax != "" && fax != undefined && fax != null && fax != 'null'){
			return fax.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");			
		}else{
			return "";
		}
	},	
	mobile: function(no){
		if(no != "" && no != undefined && no != null && no != 'null'){
			return no.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");	
		}else{
			return "";
		}
	},	
	post: function(no) {
		if(no != "" && no != undefined && no != null && no != 'null'){
			return no.replace(/([0-9]{3})([0-9]{3})/,"$1-$2");	
		}
	},	
	bizNo: function(no){
		
		if(no != "" && no != undefined && no != null && no != 'null'){
			return no.replace(/([0-9]{3})([0-9]{2})([0-9]{5})/,"$1-$2-$3");	
		}
	},
	cprNo: function(no){
		
		if(no != "" && no != undefined && no != null && no != 'null'){
			return no.replace(/([0-9]{6})([0-9]{7})/,"$1-$2");	
		}
	},
	num : function(n){
		  var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식
		  n += '';                          // 숫자를 문자열로 변환

		  while (reg.test(n))
		    n = n.replace(reg, '$1' + ',' + '$2');

		  return n;
	}
};

$.fn.serializeJson = function() {
    var o = {};
    //var a = this.serializeArray();
    $(this).find('input[type="hidden"], input[type="text"], input[type="password"], input[type="checkbox"]:checked, input[type="radio"]:checked, select').each(function() {
   if ($(this).attr('type') == 'hidden') { //if checkbox is checked do not take the hidden field
      var $parent = $(this).parent();
      var $chb = $parent.find('input[type="checkbox"][name="' + this.name.replace(/\[/g, '\[').replace(/\]/g, '\]') + '"]');
      if ($chb != null) {
          if ($chb.prop('checked')) return;
      }
  }
  if (this.name === null || this.name === undefined || this.name === '') return;
  var elemValue = null;
  if ($(this).is('select')) elemValue = $(this).find('option:selected').val();
  else elemValue = this.value;
  if (o[this.name] !== undefined) {
      if (!o[this.name].push) {
          o[this.name] = [o[this.name]];
      }
      o[this.name].push(elemValue || '');
  } else {
      o[this.name] = elemValue || '';
  }
});
return o;
}



