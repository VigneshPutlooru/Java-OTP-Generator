package com.sendOTP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class sendEmail {

	@Autowired
	private JavaMailSender sender;
	
	public void send(String toEmail, String subject, String message) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("vigneshroyal817@gmail.com");
		smm.setTo(toEmail);
		smm.setSubject(subject);
		smm.setText(message);
		sender.send(smm);
	}
}
