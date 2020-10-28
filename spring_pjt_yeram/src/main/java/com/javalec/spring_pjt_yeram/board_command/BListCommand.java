package com.javalec.spring_pjt_yeram.board_command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_yeram.dao.BDao;
import com.javalec.spring_pjt_yeram.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
		
	}

}
