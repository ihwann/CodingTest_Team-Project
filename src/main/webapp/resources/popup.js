
var pop = {
	/*
	 * 팝업 Open
	 * Jquery Dialog를 이용하여 Body에 생성
	 */
	open : function(id, options){
		
		var popParam = {
			popId : "",
			callBackFnc : "",
			closeFnc : ""
		};
		
		var popUrl = options.url || "";
		var popWidth = options.width || 500;
		var popHeight = options.height || 500;
		var popModal;
		var draggable;
		var popLeft = options.left;
		var popTop = options.top;
		
		if(options.modal == undefined){
			popModal = true;
		}else{
			popModal = options.modal;
		}

		if(options.draggable == undefined){
			draggable = false;
		}else{
			draggable = options.draggable;
		}
		
		popParam = options.params;
		popParam.popId = id;
		popParam.callBackFnc = options.callBackFnc || "";
		popParam.closeFnc = options.closeFnc || "";		
		$("body").append("<div id=\""+id+"\" class=\"hide\" title=\"\"></div>");
		
		dialog.create(id, {
			autoOpen:true, 
			width:popWidth, 
			height:popHeight, 
			modal: popModal, 
			draggable : draggable,
			close : function(event, ui){
				dialog.destroy(id);
				$("#"+id).remove();
			},
			open : function(event, ui){
				ajax.load(id, popUrl, popParam, id);
				if(popTop != undefined && popLeft != undefined){
					$("#"+id).parent().css("top", popTop);
					$("#"+id).parent().css("left", popLeft);
				}
			}
		});
		
	},
	title : function(id, title){
		$("#"+id).prev("div.ui-dialog-titlebar").children("span.ui-dialog-title").html(title);
	},
	/*
	 * Open된 팝업을 닫는다.
	 */
	close : function(id, closeFnc){
		dialog.close(id);
	},
	/**
	 * 쿠폰 대상 팝업
	 * @params
	 *    1. cpNo : 쿠폰번호
	 */	
	couponTarget : function(params){
		
		if(params.cpNo == null || params.cpNo == undefined || params.cpNo == ""){
			alert("쿠폰번호 오류입니다.");
			return;
		}
		
		var urlParam = {
			cpNo : params.cpNo
		};

		var options = {
			url : "/event/popupCouponTarget",
			params : urlParam,
			width : 800,
			height: 602,
			callBackFnc : "",
			modal : true
		};
			
		pop.open("popCouponTarget", options);					
	},
	/**
	 * 로그인 팝업
	 * @params loginType 로그인 유형
	 */
	login : function(params){
		
		var urlParam = {
			loginType : params.loginType || ""
		};

		var options = {
			url : "/popupLogin",
			params : urlParam,
			width : 600,
			height: 562,
			callBackFnc : "",
			modal : true
		};
		
		pop.open("popLogin", options);					
	},
	/**
	 * 로그인 정보(아이디/비밀번호 찾기) 팝업
	 * @params
	 */
	loginFind : function(params){
		
		var urlParam = {
		};

		var options = {
			url : "/popupFindInfo",
			params : urlParam,
			width : 600,
			height : 434,
			callBackFnc : "",
			modal : true
		};
		
		pop.open("popLoginFindInfo", options);					
	},	
	/**
	 * 상품평 상세 팝업
	 * @params
	 * 1. goodsEstmNo : 상품평 번호
	 */
	goodsComment : function(params){

		if(params.goodsEstmNo == null || params.goodsEstmNo == undefined || params.goodsEstmNo == ""){
			alert("상품평번호 오류입니다.");
			return;
		}

		var urlParam = {
			goodsEstmNo : params.goodsEstmNo,
			goodsDisp : params.goodsDisp
		};

		var options = {
			url : "/goods/popupGoodsCommentDetail",
			params : urlParam,
			width : 700,
			height: 602,
			callBackFnc : "",
			modal : true
		};
		
		pop.open("popGoodsCommentDetail", options);					
	},
	/**
	 * 옵션 변경 팝업
	 * @params
	 * 1. goodsId : 상품 아이디
	 * 2. callBackFnc : 콜백 함수 명
	 */
	optionChange : function(params){
		
		if(params.cartId == null || params.cartId == undefined || params.cartId == ""){
			alert("잘못된 접근입니다.");
			return;
		}

		if(params.goodsId == null || params.goodsId == undefined || params.goodsId == ""){
			alert("상품아이디 오류입니다.");
			return;
		}

		var urlParam = {
			cartId	: params.cartId,
			goodsId : params.goodsId,
			itemNo	: params.itemNo,
			dlvrcPlcNo : params.dlvrcPlcNo
		};

		var options = {
			url : "/order/popupOptionChange",
			params : urlParam,
			width : 410,
			height: 433,
			callBackFnc : params.callBackFnc,
			modal : true
		};
		
		pop.open("popOptionChange", options);					
	},
	/**
	 * 주문 옵션 변경 팝업
	 * @params
	 * 1. ordNo : 주문 번호
	 * 2. ordDtlSeq : 주문 상세 번호
	 * 3. goodsId : 상품 아이디
	 * 4. itemNo : 단품 번호
	 * 5. callBackFnc : 콜백 함수 명
	 */
	orderOptionChange : function(params){
		if(params.ordNo == null || params.ordNo == undefined || params.ordNo == ""){
			alert("잘못된 접근입니다.");
			return;
		}
		
		if(params.ordDtlSeq == null || params.ordDtlSeq == undefined || params.ordDtlSeq == ""){
			alert("잘못된 접근입니다.");
			return;
		}

		var urlParam = {
			ordNo	: params.ordNo,
			ordDtlSeq : params.ordDtlSeq
		};

		var options = {
			url : "/mypage/order/popupOrderOptionChange",
			params : urlParam,
			width : 410,
			height: 433,
			callBackFnc : params.callBackFnc,
			modal : true
		};
		
		pop.open("popOrderOptionChange", options);					
	},
	/**
	 * 배송지 추가/수정 팝업
	 * @param params
	 * 1. mbrDlvraNo 	배송지 번호
	 * 2. mode	Edit모드(add:추가, update:수정)
	 * 3. callBackFnc	콜백함수
	 */
	addressEdit : function(params){
		var urlParam = {
			mbrDlvraNo : params.mbrDlvraNo,
			mode : params.mode
		};

		var options = {
			url : "/mypage/service/popupAddressEdit",
			params : urlParam,
			width : 585,
			height: 596,
			callBackFnc : params.callBackFnc,
			modal : true
		};
		
		pop.open("popAddressEdit", options);	
	},
	/**
	 * 회원 배송지 목록
	 * @param params
	 */
	addressList : function(params){
		var urlParam = {
		};

		var options = {
			url : "/order/popupAddressList",
			params : urlParam,
			width : 585,
			height: 596,
			callBackFnc : params.callBackFnc,
			modal : true
		};
		
		pop.open("popupAddressList", options);	
	},
	/**
	 * 세금계산서 신청
	 * @param params
	 * 1. ordNo 주문번호
	 * 2. ordDtlSseq 주문상세순번
	 */
	taxInvoiceRequest : function(params){
		var urlParam = {
			ordNo : params.ordNo,
			ordDtlSseq : params.ordDtlSseq
		};

		var options = {
			url : "/mypage/order/popupTaxInvoiceRequest",
			params : urlParam,
			width : 600,
			height: 604,
			callBackFnc : "",
			modal : true
		};
		
		pop.open("popTaxInvoiceRequest", options);			
	},
	/**
	 * 현금영수증 출력
	 * @param params
	 * 1. ordNo 주문번호
	 */
	cashReceipt : function(params){
		var urlParam = {
			ordNo : params.ordNo
		};

		var options = {
			url : "/mypage/order/popupCashReceipt",
			params : urlParam,
			width : 700,
			height: 600,
			callBackFnc : "",
			modal : true
		};
		
		pop.open("popupCashReceipt", options);			
	},
	/**
	 * 현금영수증 신청
	 * @param params
	 * 1. ordNo 주문번호
	 * 2. ordDtlSeq 주문순번
	 */
	cashReceiptRequest : function(params){
		var urlParam = {
			ordNo : params.ordNo,
			ordDtlSeq : params.ordDtlSeq
		};

		var options = {
			url : "/mypage/order/popupCashReceiptRequest",
			params : urlParam,
			width : 370,
			height: 300,
			callBackFnc : "",
			modal : true
		};
		
		pop.open("popCashReceiptRequest", options);			
	},
	/**
	 * 신용카드매출전표 출력
	 * @param params
	 * 1. ordNo 주문번호
	 */
	creditCard : function(params){
		var urlParam = {
			ordNo : params.ordNo
		};

		var options = {
			url : "/mypage/order/popupCreditCard",
			params : urlParam,
			width : 700,
			height: 600,
			callBackFnc : "",
			modal : true
		};
		
		pop.open("popupCreditCard", options);			
	},
	/**
	 * 구매영수증 출력
	 * @param params
	 * 1. ordNo 주문번호
	 */
	purchaseReceipt : function(params){
		var urlParam = {
			ordNo : params.ordNo
		};

		var options = {
			url : "/mypage/order/popupPurchaseReceipt",
			params : urlParam,
			width : 650,
			height: 650,
			modal : true
		};
		
		pop.open("popPurchaseReceipt", options);			
	},
	/**
	 * 회원인증 팝업
	 * @param params
	 */
	popupCertification : function(){
		var urlParam = {};
		var options = {
			url : "/mypage/info/popupCertification",
			params : urlParam,
			width : 500,
			height: 300,
			callBackFnc : "",
			modal : true
		};
		pop.open("popupCertification", options);			
	},
	/**
	 * Nice CheckPlus 인증 팝업
	 * 휴대푠인증만 사용
	 * @param params
	 */
	checkPlus : function(params) {

		var options = {
			url : "/join/popupCheckPlus",
			params : {},
			width : 500,
			height: 696,
			callBackFnc : params.callBackFnc,
			modal : true
		};
		
		pop.open("popCheckPlus", options);			
	},
	/**
	 * Nice Ipin 인증 팝업
	 * @param params
	 */
	ipin : function(params) {

		var options = {
			url : "/join/popupIpin",
			params : {},
			width : 445,
			height: 606,
			callBackFnc : params.callBackFnc,
			modal : true
		};
		
		pop.open("popIpin", options);			
	},
	/**
	 * Daum 우편번호 검색 팝업
	 * @param
	 * 1. callBackFnc	콜백함수
	 */
	post : function(params){

		var options = {
				url : "/post/popupDaumPost",
				params : {},
				width : 500,
				height: 515,
				callBackFnc : params.callBackFnc,
				modal : true
			};
			
			pop.open("popDaumPost", options);	
	},  
	/**
	 * coupon 등록 팝업
	 * @param
	 * 1. callBackFnc	콜백함수
	 */
	couponApply : function(params){
		var urlParam = {
			mbrNo : params.mbrNo
		};

		var options = {
			url : "/mypage/benefit/popupCouponApply",
			params : urlParam,
			width : 370,
			height: 265,  
			callBackFnc : params.callBackFnc,
			modal : true
		};
		
		pop.open("popCouponApply", options);	
	},
	/**
	 *  전시분류번호 대상 팝업
	 * @params
	 *    popupNo
	 */	
	dispClsfPopup : function(params){
		
		var urlParam = {
			popupNo : params.popupNo
		}
		// 새창일 경우
		//var urlParam = "/category/displayCatePopup?seq="+params.seq+"&popupNo="+params.popupNo+",&dispClsfNo="+params.dispClsfNo+"&popId="+params.popupNo;
		//var options = "width="+params.width+",height="+params.height+",left="+params.left+",top="+params.top;
		//window.open(urlParam, "popDispClsfNo"+params.popupNo, options);	
		
		var options = {
				url : "/common/popupCommon",
				params : urlParam,
				width : params.width,
				height: params.height,
				left : params.left,
				top : params.top,
				callBackFnc : "",
				modal : false,
				draggable : true
			};
		pop.open("popDispClsfNo"+params.popupNo, options);	
						
	},
	/**
	 * 배송조회 팝업
	 * @params
	 * 1. ordNo : 주문번호
	 * 2. ordDtlSeq : 주문상세번호
	 * 3. dlvrHopeDt : 배송희망일자
	 */
	deliveryInquire : function(params){

		var urlParam = {
			ordNo	: params.ordNo,
			ordDtlSeq : params.ordDtlSeq,
			clmNo : params.clmNo,
			clmDtlSeq : params.clmDtlSeq,
			dlvrHopeDt : params.dlvrHopeDt
		};

		var options = {
			url : "/mypage/order/popupDeliveryInquire",
			params : urlParam,
			width : 370,
			height: 240,
			modal : true
		};
		
		pop.open("popDeliveryInquire", options);					
	},
	/**
	 *  두닷 벽 고정 설치 필수 상품 안내 팝업
	 * @params
	 *    popupNo
	 */	
	prodeinfoPopup : function(params){
		var urlParam = {
			  bwIstYnGb : params.bwIstYnGb				
		};
		
		var options = {
			url : "/goods/popupGoodsProdeinfo",
			params : urlParam,
			width : 755,
			height: 650,  
			modal : true
		};
		pop.open("popGoodsProdeinfo", options);	
						
	}
};