package com.javalec.spring_pjt_yeram.board_service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_yeram.dao.BDao;
import com.javalec.spring_pjt_yeram.dto.BDto;

public class BListService implements BService {

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
		
	}

}
