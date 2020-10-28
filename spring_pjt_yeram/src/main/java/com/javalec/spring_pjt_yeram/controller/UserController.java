package com.javalec.spring_pjt_yeram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
		
	@RequestMapping("/member/login_resist_form")
	public String loginResistForm(String userEmail, String userPassword) {
		return "member/login_resist_form";
	}
	@RequestMapping(value = "/member/login_ok", method = RequestMethod.POST)
	public String loginOk(String userEmail, String userPassword) {
		System.out.println("userEmail >> " + userEmail);
		System.out.println("userPassword >> " + userPassword);

		return "member/login_ok";
	}
	
	
}
