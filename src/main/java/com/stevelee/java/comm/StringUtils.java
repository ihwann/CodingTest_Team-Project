package com.stevelee.java.comm;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;



import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 * String 관련 유틸 클래스
 *
 *  == 개정이력(Modification Information) ==
 *
 *    수정일			수정자				수정내용
 *  ---------------------------------------------------------------------------------
 *   2018. 8. 23	KYH     		최초생성
 * </pre>
 *
 * @author KYH
 * @version 1.0.0
 * @since 2018. 8. 23
 */




public class StringUtils {
	/**
	 *  isNulltoString
	 *  return To ""
	 * @param model
	 * @return
	 * @throws Exception
	 */
	
	public static Logger serviceLog = LoggerFactory.getLogger("serviceLog");
	
	public static String isNulltoString (String str) {
		String returnValue = "";
		if(str == null) {
			returnValue= "";
		} else {
			returnValue = str;
		}
		return returnValue;
	}

	/**
	 *  returnToStirng
	 *  return To Stirng
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static String returnToStirng(String str, String rtValue) {
		String returnValue = "";
		if (str == null) {
			returnValue = rtValue;
		} else {
			returnValue = str;
		}
		return returnValue;
	}

	/**
	 * 날짜형식 data 형식 변환하기 yyyy-MM-dd
	 * */
	public static String sDateFormat (Date date,String type) {
		SimpleDateFormat sDateFormat = new SimpleDateFormat(type);
		String formatDate = "";
		if(date != null) {
			formatDate = sDateFormat.format(date);
		}
		return formatDate;
	}

	public static boolean isEmpty(String str) {
		return "null".equals(str) || str == null || "".equals(str);
	}

	/**
	 * 긴 문자열을 줄여서 ... 을 붙인다.
	 * @param value
	 * @param endIndex
	 * @return
	 */
	public static String reduceString( String value , Integer endIndex ) {
		if ( isEmpty(value) ) {
			return value;
		}
		int valueLength = value.length();
		if ( valueLength <= endIndex) {
			return value;
		}

		return value.substring(0, endIndex) + "...";
	}

	/**
     * Html 코드가 들어간 문서를 표시할때 태그에 손상없이 보이기 위한 메서드
     *
     * @param strString
     * @return HTML 태그를 치환한 문자열
     */
	public static String checkHtmlView(String strString) {
		String strNew = "";

		StringBuffer strTxt = new StringBuffer("");

		char chrBuff;
		int len = strString.length();

		for (int i = 0; i < len; i++) {
			chrBuff = strString.charAt(i);

			switch (chrBuff) {
				case '<':
					strTxt.append("&lt;");
					break;
				case '>':
					strTxt.append("&gt;");
					break;
				case '"':
					strTxt.append("&quot;");
					break;
				case 10:
					strTxt.append("<br>");
					break;
				case ' ':
					strTxt.append("&nbsp;");
					break;
				//case '&' :
				//strTxt.append("&amp;");
				//break;
				default:
					strTxt.append(chrBuff);
			}
		}

		strNew = strTxt.toString();
		return strNew;
	}

	/**
     * 특수문자를 웹 브라우저에서 정상적으로 보이기 위해 특수문자를 처리('<' -> & lT)하는 기능이다
     * @param 	srcString 		- '<'
     * @return 	변환문자열('<' -> "&lt"
     * @exception MyException
     * @see
     */
    public static String getSpclStrCnvr(String srcString) {

	String rtnStr = null;

	try {
	    StringBuffer strTxt = new StringBuffer("");

	    char chrBuff;
	    int len = srcString.length();

	    for (int i = 0; i < len; i++) {
		chrBuff = srcString.charAt(i);

		switch (chrBuff) {
		case '<':
		    strTxt.append("&lt;");
		    break;
		case '>':
		    strTxt.append("&gt;");
		    break;
		case '&':
		    strTxt.append("&amp;");
		    break;
		default:
		    strTxt.append(chrBuff);
		}
	    }

	    rtnStr = strTxt.toString();

	} catch (Exception e) {
	}

	return rtnStr;
    }

    /**
     * html의 특수문자를 표현하기 위해
     *
     * @param srcString
     * @return String
     * @exception Exception
     * @see
     */
    public static String getHtmlStrCnvr(String srcString) {

    	String tmpString = srcString;

		tmpString = tmpString.replaceAll("&lt;", "<");
		tmpString = tmpString.replaceAll("&gt;", ">");
		tmpString = tmpString.replaceAll("&amp;", "&");
		tmpString = tmpString.replaceAll("&nbsp;", " ");
		tmpString = tmpString.replaceAll("&apos;", "\'");
		tmpString = tmpString.replaceAll("&quot;", "\"");
		return  tmpString;
	}

    /**
	 * XSS 방지 처리.
	 *
	 * @param data
	 * @return
	 */
    public static String unscript(String data) {
		if (data == null || data.trim().equals("")) {
			return "";
		}

		String ret = data;

		ret = ret.replaceAll("<(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;script");
		ret = ret.replaceAll("</(S|s)(C|c)(R|r)(I|i)(P|p)(T|t)", "&lt;/script");

		ret = ret.replaceAll("<(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;object");
		ret = ret.replaceAll("</(O|o)(B|b)(J|j)(E|e)(C|c)(T|t)", "&lt;/object");

		ret = ret.replaceAll("<(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;applet");
		ret = ret.replaceAll("</(A|a)(P|p)(P|p)(L|l)(E|e)(T|t)", "&lt;/applet");

		ret = ret.replaceAll("<(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;embed");
		ret = ret.replaceAll("</(E|e)(M|m)(B|b)(E|e)(D|d)", "&lt;/embed");

		ret = ret.replaceAll("<(F|f)(O|o)(R|r)(M|m)", "&lt;form");
		ret = ret.replaceAll("</(F|f)(O|o)(R|r)(M|m)", "&lt;/form");

		return ret;
	}

    /**
     * 문자열 태그 제거
     *
     * @param html
     * @return
     * @throws Exception
     */
    public static String removeTag(String html) throws Exception {
    	return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
    }

    /**
     * 문자열 태그 제거
     *
     * @param html
     * @throws Exception
     */
    public static void responceToAjax( Model model
									, Map<String, Object> modelMap
									, HttpServletRequest request
									, HttpServletResponse response
									, Map resultMap
						) throws Exception {
    	
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		String str = "";
		Object jsonDataMap = resultMap;
		ObjectMapper mapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		mapper.setDateFormat(df);
		try {
			str = mapper.writeValueAsString(jsonDataMap);
		} catch (Exception e) {
			serviceLog.info(e.toString());
		}
		
		PrintWriter out = response.getWriter();		

		out.print(str);
		
		out.flush();
		out.close();
    }

}
