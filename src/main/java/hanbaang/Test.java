package hanbaang;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Test {
	// 쿼리문
	String query;
	//쿼리 결과
	ResultSet resultSet;

	public ResultSet sql(String query) throws SQLException, NamingException, ClassNotFoundException {
		this.query = query;

		// 커넥션 연결
		Connection conn = DBConnection.getConnection();

		// DB에 쿼리문을 보낸다.
		PreparedStatement pstmt = conn.prepareStatement(query);

		// 쿼리문의 결과값을 rs에 담는다.
		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public JSONObject JSONBuild(ResultSet resultSet) {
		this.resultSet = resultSet;
		JSONObject jobj= new JSONObject();
		return jobj;
	}
}
