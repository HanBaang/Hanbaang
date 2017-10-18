package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import DTO.DTO_ACCOUNT;
import Data.DefaultValue;
import hanbaang.DBConnection;

public class DAO_J {

	static DTO_ACCOUNT dto_ACC;
	private static DAO_J instance = new DAO_J();

	public static DAO_J getInstance() {
		return instance;
	}

	public static final Boolean INSERT_ACCOUNT(DTO_ACCOUNT dto_ACC, Connection conn) {

		Boolean result;
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_ACCOUNT);
			pstmt.setInt(number++, dto_ACC.AC_id);
			pstmt.setString(number++, dto_ACC.ID);
			pstmt.setString(number++, dto_ACC.PW);
			pstmt.setString(number++, dto_ACC.HOSPI_NAME);
			pstmt.setString(number++, dto_ACC.ORG_NUM);
			pstmt.setString(number++, dto_ACC.COMP_NUM);
			pstmt.setString(number++, dto_ACC.PHONE);
			pstmt.setString(number++, dto_ACC.MAIL);
			pstmt.setString(number++, dto_ACC.ADDR);
			pstmt.setString(number++, dto_ACC.ADDR_DETAIL);
			pstmt.setDate(number++, dto_ACC.REG_DATE);
			pstmt.setDate(number++, dto_ACC.MOD_DATE);
			if (pstmt.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	public DTO_ACCOUNT SELECT_ACCOUNT_BY_PK(int AC_ID, Connection conn) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		DTO_ACCOUNT dto_ACC=null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_ACCOUNT_BY_PK);
			pstmt.setInt(number++, AC_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto_ACC = new DTO_ACCOUNT();
				number = 1;
				dto_ACC.AC_id = rs.getInt(number++);
				dto_ACC.ID = rs.getString(number++);
				dto_ACC.PW = rs.getString(number++);
				dto_ACC.HOSPI_NAME = rs.getString(number++);
				dto_ACC.ORG_NUM = rs.getString(number++);
				dto_ACC.COMP_NUM = rs.getString(number++);
				dto_ACC.PHONE = rs.getString(number++);
				dto_ACC.MAIL = rs.getString(number++);
				dto_ACC.ADDR = rs.getString(number++);
				dto_ACC.ADDR_DETAIL = rs.getString(number++);
				dto_ACC.REG_DATE = rs.getDate(number++);
				dto_ACC.MOD_DATE = rs.getDate(number++);
				return dto_ACC;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	public LinkedList<DTO_ACCOUNT> SELECT_ACCOUNT(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<DTO_ACCOUNT> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_ACCOUNT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				DTO_ACCOUNT dto_ACC = new DTO_ACCOUNT();
				dto_ACC.AC_id = rs.getInt(number++);
				System.out.println(dto_ACC.AC_id);
				dto_ACC.ID = rs.getString(number++);
				dto_ACC.PW = rs.getString(number++);
				dto_ACC.HOSPI_NAME = rs.getString(number++);
				dto_ACC.ORG_NUM = rs.getString(number++);
				dto_ACC.COMP_NUM = rs.getString(number++);
				dto_ACC.PHONE = rs.getString(number++);
				dto_ACC.MAIL = rs.getString(number++);
				dto_ACC.ADDR = rs.getString(number++);
				dto_ACC.ADDR_DETAIL = rs.getString(number++);
				dto_ACC.REG_DATE = rs.getDate(number++);
				dto_ACC.MOD_DATE = rs.getDate(number++);
				result.add(dto_ACC);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}
	/*
	 * public static final Boolean UPDATE_ACCOUNT_BY_PK(DTO_ACCOUNT dto_ACC,
	 * DBConnection dbConnection) { DBTerminalHandler handler =
	 * dbConnection.getDBTerminalHandler(DefaultValue.DB_TIMEOUT); if (handler ==
	 * null) return null; Boolean result = UPDATE_ACCOUNT_BY_PK(dto_ACC, handler);
	 * handler.end(); return result; }
	 * 
	 * public static final Boolean UPDATE_ACCOUNT_BY_PK(DTO_ACCOUNT dto_ACC,
	 * DBTerminalHandler handler) { PreparedStatement pstmt =
	 * handler.getPreparedStatement(DefaultValue.SQL_UPDATE_ACCOUNT_BY_PK); int
	 * number = 1; try { pstmt.setInt(number++, dto_ACC.getAC_id());
	 * pstmt.setString(number++, dto_ACC.getID()); pstmt.setString(number++,
	 * dto_ACC.getPW()); pstmt.setString(number++, dto_ACC.getHOSPI_NAME());
	 * pstmt.setString(number++, dto_ACC.getORG_NUM()); pstmt.setString(number++,
	 * dto_ACC.getCOMP_NUM()); pstmt.setString(number++, dto_ACC.getPHONE());
	 * pstmt.setString(number++, dto_ACC.getMAIL()); pstmt.setString(number++,
	 * dto_ACC.getADDR()); pstmt.setString(number++, dto_ACC.getADDR_DETAIL());
	 * pstmt.setDate(number++, dto_ACC.getREG_DATE()); pstmt.setDate(number++,
	 * dto_ACC.getMOD_DATE());
	 * 
	 * if (pstmt.executeUpdate() > 0) { return true; } else { return false; } }
	 * catch (SQLException e) { e.printStackTrace(); return null; } finally { if
	 * (pstmt != null) try { pstmt.close(); } catch (Exception e) { } } }
	 * 
	 * public static final Boolean DELETE_ACCOUNT_BY_PK(DTO_ACCOUNT dto_ACC,
	 * DBConnection dbConnection) { DBTerminalHandler handler =
	 * dbConnection.getDBTerminalHandler(DefaultValue.DB_TIMEOUT); if (handler ==
	 * null) return null; Boolean result = DELETE_ACCOUNT_BY_PK(dto_ACC, handler);
	 * handler.end(); return result; }
	 * 
	 * public static final Boolean DELETE_ACCOUNT_BY_PK(DTO_ACCOUNT dto_ACC,
	 * DBTerminalHandler handler) { PreparedStatement pstmt =
	 * handler.getPreparedStatement(DefaultValue.SQL_DELETE_ACCOUNT_BY_PK); int
	 * number = 1; try { pstmt.setInt(number++, dto_ACC.AC_id); if
	 * (pstmt.executeUpdate() > 0) { return true; } else { return false; } } catch
	 * (SQLException e) { e.printStackTrace(); return null; } finally { if (pstmt !=
	 * null) try { pstmt.close(); } catch (Exception e) { } } }
	 */
}
