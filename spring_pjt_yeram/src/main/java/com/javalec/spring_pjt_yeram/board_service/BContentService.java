package com.javalec.spring_pjt_yeram.board_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_yeram.dao.BDao;
import com.javalec.spring_pjt_yeram.dto.BDto;

public class BContentService implements BService {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId); 
		
		model.addAttribute("content_view", dto); 
		
	}

}
