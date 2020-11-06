package com.javalec.spring_pjt_yeram.dao;

import java.util.ArrayList;

import com.javalec.spring_pjt_yeram.dto.BDto;

public interface IDao {

	public ArrayList<BDto> list(); // 게시글 목록

	public void write(String bName, String bTitle, String bContent); // 글작성

	public BDto contentView(String strId); // 게시글 내용 조회

	public void modify(String bName, String bTitle, String bContent, int bId); // 게시글 수정

	public void delete(String strId); // 게시글 삭제

	public BDto replyView(String strId); // 답글 출력

	public void reply(int bId, String bName, String bTitle,String bContent, String bGroup,
			String bStep, String bIndent); // 답글 입력

	
	public void replyShape(String bGroup, String bStep); // 답글 들여쓰기
	
	public void upHit(String bId); // 조회수 증가
}
