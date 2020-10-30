package com.javalec.spring_pjt_yeram.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_yeram.user_command.UserCommand;
import com.javalec.spring_pjt_yeram.user_command.UserLoginCommand;
import com.javalec.spring_pjt_yeram.util.Constant;

@Controller
public class UserController {
		
	UserCommand command;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	// 로그인 창
	@RequestMapping("/member/loginForm")
	public String loginForm(String userEmail, String userPassword) {
		
		System.out.println(">>>>>> loginForm");
		
			return "member/loginForm";
	}
	
	// 로그인
	@RequestMapping(value = "/member/login_ok", method = RequestMethod.POST)
	public String loginOk(HttpServletRequest httpServletRequest, Model model) {
		
		System.out.println(">>>>>> loginOk");
		
		model.addAttribute("request", httpServletRequest);
		
		command = new UserLoginCommand();
		command.execute(model);

		return "redirect:../home";
	}
	
	@RequestMapping(value = "/member/regist_ok", method = RequestMethod.POST)
	public String registOk(HttpServletRequest httpServletRequest, Model model) {
		


		return "member/login_ok";
	}
	
	
}
