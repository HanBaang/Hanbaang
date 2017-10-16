package Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import hanbaang.*;

// Test 테이블과 관련된 DB 로직을 처리하는 DAO 클래스

public class TestDAO {
	String sql;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rset;
	TestDTO dto;
	private static TestDAO instance = new TestDAO();

	public static TestDAO getInstance() {
		return instance;
	}

	// test 테이블의 레코드를 id를 통해 조회하는 메소드
	public TestDTO selectTestById(String id) throws SQLException, NamingException, ClassNotFoundException {
		sql = DefaultValues.SQL_SELECT_TEST_BY_ID;

		try {// try 구문 안에 어디서 exeption이 나도 close 작업은 필요하기 때문에 try/finally 로 나누었다.
			conn = DBConnection.getConnection();
			int num = 1;
			// DB에 쿼리문을 보낸다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(num++, id);
			//(?,?,?...)에 필요한 값을 set으로 담는다.
			//pstmt.setDate(num++, new Date(2017,8,3));
			
			
			
			
			
			// 쿼리문의 결과값을 rs에 담는다.
			rset = pstmt.executeQuery();

			if (rset.next()) {
				dto = new TestDTO(rset.getString(1), rset.getString(2));

			}
		} finally {
			// CP로 반납 (닫아주는 것이 아니다.)
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return dto;
	}

	
	public TestDTO selectAccount() throws SQLException, NamingException, ClassNotFoundException {
		sql = DefaultValues.SQL_SELECT_ACCOUNT;
		
		try {// try 구문 안에 어디서 exeption이 나도 close 작업은 필요하기 때문에 try/finally 로 나누었다.
			conn = DBConnection.getConnection();
			int num = 1;
			// DB에 쿼리문을 보낸다.
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(num++, id);
			
			
			
			// 쿼리문의 결과값을 rs에 담는다.
			rset = pstmt.executeQuery();

			if (rset.next()) {
				dto = new TestDTO(rset.getString(1), rset.getString(2));
			}
		} finally {
			// CP로 반납 (닫아주는 것이 아니다.)
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return dto;
	}
}
