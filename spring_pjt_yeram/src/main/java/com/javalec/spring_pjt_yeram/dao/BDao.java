package com.javalec.spring_pjt_yeram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.spring_pjt_yeram.dto.BDto;
import com.javalec.spring_pjt_yeram.util.Constant;

// **************************************** DB�� ����
public class BDao {

	DataSource dataSource;
	JdbcTemplate template = null;;

	public BDao() {
		template = Constant.template;
	}

	// **************************************** �� ��� ��ȸ
	public ArrayList<BDto> list() {
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from boardDB order by bGroup desc, bStep asc";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	// **************************************** �� �ۼ�
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

	// **************************************** ���� ��ȸ
	public BDto contentView(String strId) {
		// hit �� �ø��� ����
		upHit(strId);
		
		String query = "select * from boardDB where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	// **************************************** �� ����
	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		
		String query = "update boardDB set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});
	}

	// **************************************** �� ����
	public void delete(final String strId) {
		String query = "delete from boardDB where bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, strId);
			}
		});
	}

	
	
	public BDto reply_view(String strId) {
		String query = "select * from boardDB where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	
	
	// **************************************** ��� �Է�
	public void reply(String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent) {

		// �鿩���� �Ǵ� �޼ҵ�
		replyShape(bGroup, bStep);
		
		String query = "insert into boardDB (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) VALUES (boardDB_seq.nextval, ?, ?, ?, ?, ?, ?)";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		});
	}

	// **************************************** ��� �鿩���� �ϴ� �޼ҵ�
	private void replyShape(final String bGroup, final String bStep) {
		
		String query = "update boardDB set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bGroup));
				ps.setInt(2, Integer.parseInt(bStep));
			}
		});
	}

	// **************************************** ��ȸ�� �ø��� �޼ҵ�
	public void upHit(final String bId) {
		
		String query = "update boardDB set bHit = bHit + 1 where bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}

}
