package com.javalec.spring_pjt_yeram.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_yeram.dao.IDao;


// 게시판 처리하는 컨트롤러
@Controller
public class BControlloer {
	
//	BService service;
//	BDao dao;
	
//	public JdbcTemplate template;

	
	@Autowired
	private SqlSession sqlSession;
	
	/*
	 * @Autowired public void setDao(BDao dao) { this.dao = dao; }
	 */

//
//	@Autowired
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//		Constant.template = this.template;
//	}


	@RequestMapping("board/list")
	public String list(Model model) {
		
		System.out.println(">>>>>>>list()");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.list());
//		
//		
//		service = new BListService();
//		service.execute(model);
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
	public String write(HttpServletRequest request, Model model) {
		
		System.out.println(">>>>>>>write()");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.write(request.getParameter("bName"), request.getParameter("bTitle"), request.getParameter("bContent"));
		
		return "redirect:list";
	}
	
	// 게시글 조회
	@RequestMapping("board/contentView")
	public String contentView(HttpServletRequest request, Model model) {
		System.out.println(">>>>>>>contentView()");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.upHit(request.getParameter("bId")); // 조회수 증가
		model.addAttribute("contentView", dao.contentView(request.getParameter("bId")));
		
		return "board/contentView";
		
	}
	
	// 게시글 수정
	@RequestMapping(method = RequestMethod.POST, value = "/board/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println(">>>>>>>modify()");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bId = request.getParameter("bId");
		
		dao.modify(bName, bTitle, bContent, Integer.parseInt(bId));
		

		return "redirect:list";
	}
	
	
	
	@RequestMapping("/board/replyView")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println(">>>>>>>replyView()");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("replyView", dao.replyView(request.getParameter("bId")));
		
		return "board/replyView";
	}
	
	@RequestMapping("/board/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println(">>>>>>>reply()");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		dao.replyShape(bGroup, bStep); // 답글 들여쓰기
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
		
		
		return "redirect:list";
	}
	
	@RequestMapping("/board/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println(">>>>>>>delete()");
		
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.delete(request.getParameter("bId"));
		
//		service = new BDeleteService();
//		service.execute(model);
		
		return "redirect:list";
	}
	
	
}
