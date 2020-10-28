package com.javalec.spring_pjt_yeram.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

public class Util {
	
	DataSource dataSource;
	
	public void upHit(String bId) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update boardDB set bHit = bHit + 1 where bId = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bId);
			
			int re = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
