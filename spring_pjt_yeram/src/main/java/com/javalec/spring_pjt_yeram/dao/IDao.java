package com.javalec.spring_pjt_yeram.dao;

import java.util.ArrayList;

import com.javalec.spring_pjt_yeram.dto.BDto;

public interface IDao {

	public ArrayList<BDto> list(); // �Խñ� ���

	public void write(String bName, String bTitle, String bContent); // ���ۼ�

	public BDto contentView(String strId); // �Խñ� ���� ��ȸ

	public void modify(String bName, String bTitle, String bContent, int bId); // �Խñ� ����

	public void delete(String strId); // �Խñ� ����

	public BDto replyView(String strId); // ��� ���

	public void reply(int bId, String bName, String bTitle,String bContent, String bGroup,
			String bStep, String bIndent); // ��� �Է�

	
	public void replyShape(String bGroup, String bStep); // ��� �鿩����
	
	public void upHit(String bId); // ��ȸ�� ����
}
