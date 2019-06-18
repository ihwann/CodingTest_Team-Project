package com.stevelee.java.service;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.PasswordAuthentication;

import org.springframework.stereotype.Service;

@Service
public class regi_sendEmailService {
	
	public void send_Email(String email_addr, String authNum) {
		String host ="smtp.gmail.com"; // smtp 서버
		String subject ="SteveleeJAVA 인증번호 입니다."; // 제목
		String fromName ="스티브리자바"; // 보내는 사람
		String from ="pl20g@gmail.com"; // 보내는 메일
		String toUser = email_addr;
		String content = "인증번호는 [" + authNum + "] 입니다.";
		//System.out.println("받는사람 : " + toUser);
		
		try {
			Properties props = new Properties(); // gmail
			
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smpt.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", "587"); // or 465
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.auth", "true");
			
			Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("pl20hg@gmail.com", "ehdqhr12");
				}
			});
			
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B")));
			
			InternetAddress[] address = {new InternetAddress(toUser)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject); // 제목설정
			msg.setSentDate(new java.util.Date()); // 보내는 날짜
			msg.setContent(content, "text/html;charset=euc-kr"); // 인코딩
			
			Transport.send(msg);
		}catch(MessagingException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
