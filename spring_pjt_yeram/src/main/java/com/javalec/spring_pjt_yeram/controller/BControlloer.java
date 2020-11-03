package com.javalec.spring_pjt_yeram.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_yeram.board_service.BService;
import com.javalec.spring_pjt_yeram.board_service.BContentService;
import com.javalec.spring_pjt_yeram.board_service.BDeleteService;
import com.javalec.spring_pjt_yeram.board_service.BListService;
import com.javalec.spring_pjt_yeram.board_service.BModifyService;
import com.javalec.spring_pjt_yeram.board_service.BReplyService;
import com.javalec.spring_pjt_yeram.board_service.BReplyViewService;
import com.javalec.spring_pjt_yeram.board_service.BWriteService;
import com.javalec.spring_pjt_yeram.util.Constant;


// 게시판 처리하는 컨트롤러
@Controller
public class BControlloer {
	
	BService command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	

	@RequestMapping("board/list")
	public String list(Model model) {
		
		System.out.println(">>>>>>>list()");
		
		command = new BListService();
		command.execute(model);
		return "board/list";
	}
	
	
	// 작성 화면(폼만 있는 곳)
	@RequestMapping("board/write_view")
	public String write_view(Model model) {
		
		System.out.println(">>>>>>>write_view()");
		
		return "board/write_view";
	}
	
	// 작성 처리
	@RequestMapping("board/write")
	public String write(HttpServletRequest httpServletRequest, Model model) {
		
		System.out.println(">>>>>>>write()");
		
		model.addAttribute("request", httpServletRequest);
		
		command = new BWriteService();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("board/content_view")
	public String content_view(HttpServletRequest httpServletRequest, Model model) {
		System.out.println(">>>>>>>content_view()");
		
		model.addAttribute("request", httpServletRequest);
		command = new BContentService();
		command.execute(model);
		
		return "board/content_view";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/board/modify")
	public String modify(HttpServletRequest httpServletRequest, Model model) {
		System.out.println(">>>>>>>modify()");
		
		model.addAttribute("request", httpServletRequest);
		command = new BModifyService();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/board/reply_view")
	public String reply_view(HttpServletRequest httpServletRequest, Model model) {
		System.out.println(">>>>>>>reply_view()");
		
		model.addAttribute("request", httpServletRequest);
		command = new BReplyViewService();
		command.execute(model);
		
		return "board/reply_view";
	}
	
	@RequestMapping("/board/reply")
	public String reply(HttpServletRequest httpServletRequest, Model model) {
		System.out.println(">>>>>>>reply()");
		
		model.addAttribute("request", httpServletRequest);
		
		command = new BReplyService();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/board/delete")
	public String delete(HttpServletRequest httpServletRequest, Model model) {
		System.out.println(">>>>>>>delete()");
		
		model.addAttribute("request", httpServletRequest);
		
		command = new BDeleteService();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
}
