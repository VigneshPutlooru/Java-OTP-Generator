package com.sendOTP;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class RandomGen {
	public String gen(int len) {
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<len;i++) {
			sb.append(Integer.toString(rd.nextInt(10)));
		}
		return sb.toString();
	}
}
