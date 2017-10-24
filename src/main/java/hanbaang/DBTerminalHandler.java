package hanbaang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

public class DBTerminalHandler {

	DBConnection dbConnection;
	PreparedStatement pstmt;
	Connection conn;
	String sql;

	public DBTerminalHandler() {
		// TODO Auto-generated constructor stub

	}

	public PreparedStatement getPreparedStatement(String sql) {
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pstmt;

	}

	public void end() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
