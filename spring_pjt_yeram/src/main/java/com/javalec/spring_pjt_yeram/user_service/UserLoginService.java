package com.javalec.spring_pjt_yeram.user_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_yeram.dao.UserDao;

public class UserLoginCommand implements UserCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		
		UserDao dao = new UserDao();
		dao.login(userEmail, userPassword);
		
	}

}
