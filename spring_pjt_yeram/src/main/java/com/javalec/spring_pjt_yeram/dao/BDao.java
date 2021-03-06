package com.javalec.spring_pjt_yeram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.spring_pjt_yeram.dto.BDto;
import com.javalec.spring_pjt_yeram.util.Constant;

// **************************************** DB에 접근
public class BDao implements IDao{

	DataSource dataSource;
	JdbcTemplate template = null;;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public BDao() {
		template = Constant.template;
	}

	// **************************************** 글 목록 조회
	@Override
	public ArrayList<BDto> list() {
		String query = "select * from boardDB order by bGroup desc, bStep asc";
		ArrayList<BDto> dtos = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		return dtos;
	}


	// **************************************** 글 작성
	@Override
	public void write(final String bName, final String bTitle, final String bContent) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into boardDB (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) VALUES (boardDB_seq.nextval, ?, ?, ?, 0, boardDB_seq.currval, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
		});
	}

	// **************************************** 내용 조회
	@Override
	public BDto contentView(String strId) {
		// hit 값 올리는 로직
		upHit(strId);
		
		String query = "select * from boardDB where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	// **************************************** 글 수정
	@Override
	public void modify(final String bName, final String bTitle, final String bContent, final int bId) {
		
		String query = "update boardDB set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, bId);
			}
		});
	}

	// **************************************** 글 삭제
	@Override
	public void delete(final String strId) {
		String query = "delete from boardDB where bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, strId);
			}
		});
	}

	
	@Override
	public BDto replyView(String strId) {
		String query = "select * from boardDB where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	
	
	// **************************************** 답글 입력
	/*
	 * @Override public void reply(String bId, final String bName, final String
	 * bTitle, final String bContent, final String bGroup, final String bStep, final
	 * String bIndent) {
	 * 
	 * // 들여쓰기 되는 메소드 replyShape(bGroup, bStep);
	 * 
	 * String query =
	 * "insert into boardDB (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) VALUES (boardDB_seq.nextval, ?, ?, ?, ?, ?, ?)"
	 * ; template.update(query, new PreparedStatementSetter() {
	 * 
	 * @Override public void setValues(PreparedStatement ps) throws SQLException {
	 * ps.setString(1, bName); ps.setString(2, bTitle); ps.setString(3, bContent);
	 * ps.setInt(4, Integer.parseInt(bGroup)); ps.setInt(5, Integer.parseInt(bStep)
	 * + 1); ps.setInt(6, Integer.parseInt(bIndent) + 1); } }); }
	 */
	// **************************************** 답글 들여쓰기 하는 메소드
	@Override
	public void replyShape(final String bGroup, final String bStep) {
		
		String query = "update boardDB set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bGroup));
				ps.setInt(2, Integer.parseInt(bStep));
			}
		});
	}

	// **************************************** 조회수 올리는 메소드
	public void upHit(final String bId) {
		
		String query = "update boardDB set bHit = bHit + 1 where bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}

	@Override
	public void reply(int bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		// TODO Auto-generated method stub
		
	}



}
