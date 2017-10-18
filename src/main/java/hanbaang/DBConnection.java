package hanbaang;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	static DBTerminalHandler dbTerminalHandler;
	static Connection conn;
	public static Connection getConnection() throws SQLException, NamingException, ClassNotFoundException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/hanbaang");
		Connection conn = ds.getConnection();
		return conn;
	}

	public static DBTerminalHandler getDBTerminalHandler(int timeOut) {
		
		return dbTerminalHandler;
	}

}
