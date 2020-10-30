package com.javalec.spring_pjt_yeram.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.javalec.spring_pjt_yeram.util.Constant;

public class UserDao{
	
	DataSource dataSource;
	JdbcTemplate template = null;;

	public UserDao() {
		template = Constant.template;
	}

	public void regist(final String userEmail, final String userPassword, final String userTel) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into userDB (userEmail, userPassword, userTel) values (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, userEmail);
				pstmt.setString(2, userPassword);
				pstmt.setString(3, userTel);
				return null;
			}
		});
	}
	
	public void login(String userEmail, String userPassword) {
		
	}
}
