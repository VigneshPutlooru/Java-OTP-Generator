package com.sendOTP;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class OtpGeneratorApplication {
	
	@Autowired
	private sendEmail senderService; 
	@Autowired
	private RandomGen rdn;
	
	public static void main(String[] args) {
		SpringApplication.run(OtpGeneratorApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
		String auth = rdn.gen(6);
		senderService.send("lputluru@gitam.in", "Otp Tesing", auth);
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter the OTP");
		String s = inp.next();
		if(s.equals(auth)) System.out.println("Authentication succesfull");
		else System.out.println("Authentication failed");
		
	}

}
