package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import DTO.*;
import Data.DefaultValue;

public class DAO {

	static DTO_ACCOUNT dto_ACC;
	static DTO_SUB_ACCOUNT dto_SA;
	static DTO_PATNT dto_PA;
	static DTO_RECEP dto_R;
	static DTO_TREAT dto_TR;
	static DTO_DRUG dto_DR;
	static DTO_PRESC dto_PR;
	static DTO_FREQ_PRESC dto_FP;
	static DTO_INSUR dto_IN;
	static DTO_INSUR_DETAIL dto_ID;
	static DTO_PHYSIC dto_PH;
	static DTO_INSUR_DRUG dto_IDR;
	static DTO_INSUR_PRESC dto_IR;
	static DTO_CHIM dto_C;
	static DTO_SYMP dto_SY;
	private static DAO instance = new DAO();

	public static DAO getInstance() {
		return instance;
	}

	// ACCOUNT TABLE SQL

	public DTO_ACCOUNT LOGIN_ACCOUNT(DTO_ACCOUNT dto_ACC, Connection conn) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_LOGIN_ACCOUNT);
			pstmt.setString(number++, dto_ACC.ID);
			pstmt.setString(number++, dto_ACC.PW);
			rs = pstmt.executeQuery();
			dto_ACC = new DTO_ACCOUNT();
			if (rs.next()) {
				dto_ACC.ID = rs.getString(1);
				dto_ACC.HOSPI_NAME = rs.getString(2);
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

	public Boolean INSERT_ACCOUNT(DTO_ACCOUNT dto_ACC, Connection conn) {

		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_ACCOUNT);
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
		DTO_ACCOUNT dto_ACC = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_ACCOUNT_BY_PK);
			pstmt.setInt(number++, AC_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto_ACC = new DTO_ACCOUNT();
				number = 1;
				dto_ACC.AC_ID = rs.getInt(number++);
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
				dto_ACC.AC_ID = rs.getInt(number++);
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

	public Boolean UPDATE_ACCOUNT_BY_PK(DTO_ACCOUNT dto_ACC, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_ACCOUNT_BY_PK);
			pstmt.setInt(number++, dto_ACC.getAC_ID());
			pstmt.setString(number++, dto_ACC.getID());
			pstmt.setString(number++, dto_ACC.getPW());
			pstmt.setString(number++, dto_ACC.getHOSPI_NAME());
			pstmt.setString(number++, dto_ACC.getORG_NUM());
			pstmt.setString(number++, dto_ACC.getCOMP_NUM());
			pstmt.setString(number++, dto_ACC.getPHONE());
			pstmt.setString(number++, dto_ACC.getMAIL());
			pstmt.setString(number++, dto_ACC.getADDR());
			pstmt.setString(number++, dto_ACC.getADDR_DETAIL());
			pstmt.setDate(number++, dto_ACC.getREG_DATE());
			pstmt.setDate(number++, dto_ACC.getMOD_DATE());

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

	public Boolean DELETE_ACCOUNT_BY_PK(int AC_id, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_ACCOUNT_BY_PK);
			pstmt.setInt(number++, AC_id);
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

	// SUB_ACCOUNT TABLE SQL

	public Boolean INSERT_SUB_ACCOUNT(DTO_SUB_ACCOUNT dto_SA, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_SUB_ACCOUNT);
			pstmt.setInt(number++, dto_SA.SA_id);
			pstmt.setInt(number++, dto_SA.AC_id);
			pstmt.setString(number++, dto_SA.ID);
			pstmt.setString(number++, dto_SA.PW);
			pstmt.setString(number++, dto_SA.STAFF_NAME);
			pstmt.setString(number++, dto_SA.PHONE);
			pstmt.setString(number++, dto_SA.ORG_NUM);
			pstmt.setString(number++, dto_SA.COMP_NUM);
			pstmt.setString(number++, dto_SA.ADDR);
			pstmt.setString(number++, dto_SA.ADDR_DETAIL);
			pstmt.setString(number++, dto_SA.MAIL);
			pstmt.setDate(number++, dto_SA.REG_DATE);
			pstmt.setDate(number++, dto_SA.MOD_DATE);
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

	public DTO_SUB_ACCOUNT SELECT_SUB_ACCOUNT_BY_PK(int SA_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_SUB_ACCOUNT dto_SA = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_SUB_ACCOUNT_BY_PK);
			pstmt.setInt(number++, SA_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_SA = new DTO_SUB_ACCOUNT();
				dto_SA.SA_id = rs.getInt(number++);
				dto_SA.AC_id = rs.getInt(number++);
				dto_SA.ID = rs.getString(number++);
				dto_SA.PW = rs.getString(number++);
				dto_SA.STAFF_NAME = rs.getString(number++);
				dto_SA.PHONE = rs.getString(number++);
				dto_SA.ORG_NUM = rs.getString(number++);
				dto_SA.COMP_NUM = rs.getString(number++);
				dto_SA.ADDR = rs.getString(number++);
				dto_SA.ADDR_DETAIL = rs.getString(number++);
				dto_SA.MAIL = rs.getString(number++);
				dto_SA.REG_DATE = rs.getDate(number++);
				dto_SA.MOD_DATE = rs.getDate(number++);
				return dto_SA;
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

	public LinkedList<DTO_SUB_ACCOUNT> SELECT_SUB_ACCOUNT(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<DTO_SUB_ACCOUNT> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_SUB_ACCOUNT);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				DTO_SUB_ACCOUNT dto_SA = new DTO_SUB_ACCOUNT();
				dto_SA.SA_id = rs.getInt(number++);
				dto_SA.AC_id = rs.getInt(number++);
				dto_SA.ID = rs.getString(number++);
				dto_SA.PW = rs.getString(number++);
				dto_SA.STAFF_NAME = rs.getString(number++);
				dto_SA.PHONE = rs.getString(number++);
				dto_SA.ORG_NUM = rs.getString(number++);
				dto_SA.COMP_NUM = rs.getString(number++);
				dto_SA.ADDR = rs.getString(number++);
				dto_SA.ADDR_DETAIL = rs.getString(number++);
				dto_SA.MAIL = rs.getString(number++);
				dto_SA.REG_DATE = rs.getDate(number++);
				dto_SA.MOD_DATE = rs.getDate(number++);
				result.add(dto_SA);
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

	public Boolean UPDATE_SUB_ACCOUNT_BY_PK(DTO_SUB_ACCOUNT dto_SA, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_SUB_ACCOUNT_BY_PK);
			pstmt.setInt(number++, dto_SA.AC_id);
			pstmt.setString(number++, dto_SA.ID);
			pstmt.setString(number++, dto_SA.PW);
			pstmt.setString(number++, dto_SA.STAFF_NAME);
			pstmt.setString(number++, dto_SA.PHONE);
			pstmt.setString(number++, dto_SA.ORG_NUM);
			pstmt.setString(number++, dto_SA.COMP_NUM);
			pstmt.setString(number++, dto_SA.ADDR);
			pstmt.setString(number++, dto_SA.ADDR_DETAIL);
			pstmt.setString(number++, dto_SA.MAIL);
			pstmt.setDate(number++, dto_SA.REG_DATE);
			pstmt.setDate(number++, dto_SA.MOD_DATE);
			pstmt.setInt(number++, dto_SA.SA_id);
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

	public Boolean DELETE_SUB_ACCOUNT_BY_PK(int SA_id, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_SUB_ACCOUNT_BY_PK);
			pstmt.setInt(number++, SA_id);
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

	// PATNT TABLE SQL

	public Boolean INSERT_PATNT(DTO_PATNT dto_PA, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_PATNT);
			pstmt.setInt(number++, dto_PA.PA_ID);
			pstmt.setString(number++, dto_PA.PATNT_NAME);
			pstmt.setString(number++, dto_PA.H_INSUR_NUM);
			pstmt.setString(number++, dto_PA.CID);
			pstmt.setInt(number++, dto_PA.GEND);
			pstmt.setString(number++, dto_PA.MAIL);
			pstmt.setString(number++, dto_PA.ADDR);
			pstmt.setString(number++, dto_PA.ADDR_DETAIL);
			pstmt.setString(number++, dto_PA.PHONE);
			pstmt.setString(number++, dto_PA.MDOC);
			pstmt.setDate(number++, dto_PA.REG_DATE);
			pstmt.setDate(number++, dto_PA.MOD_DATE);
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

	public DTO_PATNT SELECT_PATNT_BY_PK(int PA_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_PATNT dto_PA = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_PATNT_BY_PK);
			pstmt.setInt(number++, PA_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_PA = new DTO_PATNT();
				dto_PA.PA_ID = rs.getInt(number++);
				dto_PA.PATNT_NAME = rs.getString(number++);
				dto_PA.H_INSUR_NUM = rs.getString(number++);
				dto_PA.CID = rs.getString(number++);
				dto_PA.GEND = rs.getInt(number++);
				dto_PA.MAIL = rs.getString(number++);
				dto_PA.ADDR = rs.getString(number++);
				dto_PA.ADDR_DETAIL = rs.getString(number++);
				dto_PA.PHONE = rs.getString(number++);
				dto_PA.MDOC = rs.getString(number++);
				dto_PA.REG_DATE = rs.getDate(number++);
				dto_PA.MOD_DATE = rs.getDate(number++);
				return dto_PA;
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

	public LinkedList<DTO_PATNT> SELECT_PATNT(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<DTO_PATNT> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_PATNT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				DTO_PATNT dto_PA = new DTO_PATNT();
				dto_PA.PA_ID = rs.getInt(number++);
				dto_PA.PATNT_NAME = rs.getString(number++);
				dto_PA.H_INSUR_NUM = rs.getString(number++);
				dto_PA.CID = rs.getString(number++);
				dto_PA.GEND = rs.getInt(number++);
				dto_PA.MAIL = rs.getString(number++);
				dto_PA.ADDR = rs.getString(number++);
				dto_PA.ADDR_DETAIL = rs.getString(number++);
				dto_PA.PHONE = rs.getString(number++);
				dto_PA.MDOC = rs.getString(number++);
				dto_PA.REG_DATE = rs.getDate(number++);
				dto_PA.MOD_DATE = rs.getDate(number++);
				result.add(dto_PA);
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

	public Boolean UPDATE_PATNT_BY_PK(DTO_PATNT dto_PA, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_PATNT_BY_PK);
			pstmt.setString(number++, dto_PA.PATNT_NAME);
			pstmt.setString(number++, dto_PA.H_INSUR_NUM);
			pstmt.setString(number++, dto_PA.CID);
			pstmt.setInt(number++, dto_PA.GEND);
			pstmt.setString(number++, dto_PA.MAIL);
			pstmt.setString(number++, dto_PA.ADDR);
			pstmt.setString(number++, dto_PA.ADDR_DETAIL);
			pstmt.setString(number++, dto_PA.PHONE);
			pstmt.setString(number++, dto_PA.MDOC);
			pstmt.setDate(number++, dto_PA.REG_DATE);
			pstmt.setDate(number++, dto_PA.MOD_DATE);
			pstmt.setInt(number++, dto_PA.PA_ID);
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

	public Boolean DELETE_PATNT_BY_PK(int PA_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_PATNT_BY_PK);
			pstmt.setInt(number++, PA_ID);
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

	// 1 TABLE SQL

	public Boolean INSERT_RECEP(DTO_RECEP dto_R, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_RECEP);
			pstmt.setInt(number++, dto_R.PA_ID);
			pstmt.setInt(number++, dto_R.SA_ID);
			pstmt.setString(number++, dto_R.PATNT_NAME);
			pstmt.setDate(number++, dto_R.RECEP_DATE);
			pstmt.setString(number++, dto_R.STATE);
			pstmt.setString(number++, dto_R.MEMO);
			pstmt.setString(number++, dto_R.MDOC);
			pstmt.setString(number++, dto_R.STAFF_NAME);
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

	public DTO_RECEP SELECT_RECEP_BY_PK(int R_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_RECEP dto_R = null;

		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_RECEP_BY_PK);
			pstmt.setInt(number++, R_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_R = new DTO_RECEP();
				dto_R.R_ID = rs.getInt(number++);
				dto_R.PA_ID = rs.getInt(number++);
				dto_R.SA_ID = rs.getInt(number++);
				dto_R.PATNT_NAME = rs.getString(number++);
				dto_R.RECEP_DATE = rs.getDate(number++);
				dto_R.STATE = rs.getString(number++);
				dto_R.MEMO = rs.getString(number++);
				dto_R.MDOC = rs.getString(number++);
				dto_R.STAFF_NAME = rs.getString(number++);
				return dto_R;
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

	public LinkedList<DTO_RECEP> SELECT_RECEP(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<DTO_RECEP> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_RECEP);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				DTO_RECEP dto_R = new DTO_RECEP();
				dto_R.R_ID = rs.getInt(number++);
				dto_R.PA_ID = rs.getInt(number++);
				dto_R.SA_ID = rs.getInt(number++);
				dto_R.PATNT_NAME = rs.getString(number++);
				dto_R.RECEP_DATE = rs.getDate(number++);
				dto_R.STATE = rs.getString(number++);
				dto_R.MEMO = rs.getString(number++);
				dto_R.MDOC = rs.getString(number++);
				dto_R.STAFF_NAME = rs.getString(number++);
				result.add(dto_R);
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

	public Boolean UPDATE_RECEP_BY_PK(DTO_RECEP dto_R, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_RECEP_BY_PK);
			pstmt.setInt(number++, dto_R.PA_ID);
			pstmt.setInt(number++, dto_R.SA_ID);
			pstmt.setString(number++, dto_R.PATNT_NAME);
			pstmt.setDate(number++, dto_R.RECEP_DATE);
			pstmt.setString(number++, dto_R.STATE);
			pstmt.setString(number++, dto_R.MEMO);
			pstmt.setString(number++, dto_R.MDOC);
			pstmt.setString(number++, dto_R.STAFF_NAME);
			pstmt.setInt(number++, dto_R.R_ID);
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

	public Boolean DELETE_RECEP_BY_PK(int R_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_RECEP_BY_PK);
			pstmt.setInt(number++, R_ID);
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

	// TREAT TABLE SQL

	public Boolean INSERT_TREAT(DTO_TREAT dto_TR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_TREAT);
			pstmt.setInt(number++, dto_TR.R_ID);
			pstmt.setString(number++, dto_TR.MEMO);
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

	public DTO_TREAT SELECT_TREAT_BY_PK(int TR_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_TREAT_BY_PK);
			pstmt.setInt(number++, TR_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				DTO_TREAT dto_TR = new DTO_TREAT();
				dto_TR.TR_ID = rs.getInt(number++);
				dto_TR.R_ID = rs.getInt(number++);
				dto_TR.MEMO = rs.getString(number++);
				return dto_TR;
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

	public LinkedList<DTO_TREAT> SELECT_TREAT(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<DTO_TREAT> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_TREAT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				DTO_TREAT dto_TR = new DTO_TREAT();
				dto_TR.TR_ID = rs.getInt(number++);
				dto_TR.R_ID = rs.getInt(number++);
				dto_TR.MEMO = rs.getString(number++);
				result.add(dto_TR);
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

	public Boolean UPDATE_TREAT_BY_PK(DTO_TREAT dto_TR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_TREAT_BY_PK);
			pstmt.setInt(number++, dto_TR.R_ID);
			pstmt.setString(number++, dto_TR.MEMO);
			pstmt.setInt(number++, dto_TR.TR_ID);
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

	public Boolean DELETE_TREAT_BY_PK(int TR_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_TREAT_BY_PK);
			pstmt.setInt(number++, TR_ID);
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

	// DRUG TABLE SQL

	public Boolean INSERT_DRUG(DTO_DRUG dto_DR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_DRUG);
			pstmt.setInt(number++, dto_DR.PR_ID);
			pstmt.setString(number++, dto_DR.DRUG_CODE);
			pstmt.setString(number++, dto_DR.DRUG_COMP_NAME);
			pstmt.setString(number++, dto_DR.DRUG_NAME);
			pstmt.setInt(number++, dto_DR.DRUG_WEIGHT);
			pstmt.setString(number++, dto_DR.DRUG_MEMO);
			pstmt.setBoolean(number++, dto_DR.INSUR);
			pstmt.setString(number++, dto_DR.TYPE);
			pstmt.setString(number++, dto_DR.TYPE_ID);
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

	public DTO_DRUG SELECT_DRUG_BY_PK(int DR_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_DRUG dto_DR = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_DRUG_BY_PK);
			pstmt.setInt(number++, DR_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_DR = new DTO_DRUG();
				dto_DR.DR_ID = rs.getInt(number++);
				dto_DR.PR_ID = rs.getInt(number++);
				dto_DR.DRUG_CODE = rs.getString(number++);
				dto_DR.DRUG_COMP_NAME = rs.getString(number++);
				dto_DR.DRUG_NAME = rs.getString(number++);
				dto_DR.DRUG_WEIGHT = rs.getInt(number++);
				dto_DR.DRUG_MEMO = rs.getString(number++);
				dto_DR.INSUR = rs.getBoolean(number++);
				dto_DR.TYPE = rs.getString(number++);
				dto_DR.TYPE_ID = rs.getString(number++);
				return dto_DR;
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

	public LinkedList<DTO_DRUG> SELECT_DRUG(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_DRUG dto_DR = null;
		LinkedList<DTO_DRUG> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_DRUG);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_DR = new DTO_DRUG();
				dto_DR.DR_ID = rs.getInt(number++);
				dto_DR.PR_ID = rs.getInt(number++);
				dto_DR.DRUG_CODE = rs.getString(number++);
				dto_DR.DRUG_COMP_NAME = rs.getString(number++);
				dto_DR.DRUG_NAME = rs.getString(number++);
				dto_DR.DRUG_WEIGHT = rs.getInt(number++);
				dto_DR.DRUG_MEMO = rs.getString(number++);
				dto_DR.INSUR = rs.getBoolean(number++);
				dto_DR.TYPE = rs.getString(number++);
				dto_DR.TYPE_ID = rs.getString(number++);
				result.add(dto_DR);
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

	public LinkedList<DTO_DRUG> SELECT_DRUG_BY_FK_PR(int PR_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_DRUG dto_DR = null;
		LinkedList<DTO_DRUG> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_DRUG_BY_FK_PR);
			pstmt.setInt(number++, PR_ID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_DR = new DTO_DRUG();
				dto_DR.DR_ID = rs.getInt(number++);
				dto_DR.PR_ID = rs.getInt(number++);
				dto_DR.DRUG_CODE = rs.getString(number++);
				dto_DR.DRUG_COMP_NAME = rs.getString(number++);
				dto_DR.DRUG_NAME = rs.getString(number++);
				dto_DR.DRUG_WEIGHT = rs.getInt(number++);
				dto_DR.DRUG_MEMO = rs.getString(number++);
				dto_DR.INSUR = rs.getBoolean(number++);
				dto_DR.TYPE = rs.getString(number++);
				dto_DR.TYPE_ID = rs.getString(number++);
				result.add(dto_DR);
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

	public Boolean UPDATE_DRUG_BY_PK(DTO_DRUG dto_DR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_DRUG_BY_PK);
			pstmt.setInt(number++, dto_DR.PR_ID);
			pstmt.setString(number++, dto_DR.DRUG_CODE);
			pstmt.setString(number++, dto_DR.DRUG_COMP_NAME);
			pstmt.setString(number++, dto_DR.DRUG_NAME);
			pstmt.setInt(number++, dto_DR.DRUG_WEIGHT);
			pstmt.setString(number++, dto_DR.DRUG_MEMO);
			pstmt.setBoolean(number++, dto_DR.INSUR);
			pstmt.setString(number++, dto_DR.TYPE);
			pstmt.setString(number++, dto_DR.TYPE_ID);
			pstmt.setInt(number++, dto_DR.DR_ID);
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

	public Boolean DELETE_DRUG_BY_PK(int DR_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_DRUG_BY_PK);
			pstmt.setInt(number++, DR_ID);
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

	// PRESC TABLE SQL

	public Boolean INSERT_PRESC(DTO_PRESC dto_PR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_PRESC);
			pstmt.setInt(number++, dto_PR.TR_ID);
			pstmt.setInt(number++, dto_PR.R_ID);
			pstmt.setInt(number++, dto_PR.CHUP);
			pstmt.setInt(number++, dto_PR.PACK);
			pstmt.setInt(number++, dto_PR.STD_VOL);
			pstmt.setInt(number++, dto_PR.WATER_VOL);
			pstmt.setBoolean(number++, dto_PR.INSUR);
			pstmt.setDate(number++, dto_PR.REG_DATE);
			pstmt.setDate(number++, dto_PR.MOD_DATE);
			pstmt.setBoolean(number++, dto_PR.FREQ);
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

	public DTO_PRESC SELECT_PRESC_BY_PK(int PR_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_PRESC dto_PR = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_PRESC_BY_PK);
			pstmt.setInt(number++, PR_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_PR = new DTO_PRESC();
				dto_PR.PR_ID = rs.getInt(number++);
				dto_PR.TR_ID = rs.getInt(number++);
				dto_PR.R_ID = rs.getInt(number++);
				dto_PR.CHUP = rs.getInt(number++);
				dto_PR.PACK = rs.getInt(number++);
				dto_PR.STD_VOL = rs.getInt(number++);
				dto_PR.WATER_VOL = rs.getInt(number++);
				dto_PR.INSUR = rs.getBoolean(number++);
				dto_PR.REG_DATE = rs.getDate(number++);
				dto_PR.MOD_DATE = rs.getDate(number++);
				dto_PR.FREQ = rs.getBoolean(number++);
				return dto_PR;
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

	public LinkedList<DTO_PRESC> SELECT_PRESC(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_PRESC dto_PR = null;
		LinkedList<DTO_PRESC> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_PRESC);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_PR = new DTO_PRESC();
				dto_PR.PR_ID = rs.getInt(number++);
				dto_PR.TR_ID = rs.getInt(number++);
				dto_PR.R_ID = rs.getInt(number++);
				dto_PR.CHUP = rs.getInt(number++);
				dto_PR.PACK = rs.getInt(number++);
				dto_PR.STD_VOL = rs.getInt(number++);
				dto_PR.WATER_VOL = rs.getInt(number++);
				dto_PR.INSUR = rs.getBoolean(number++);
				dto_PR.REG_DATE = rs.getDate(number++);
				dto_PR.MOD_DATE = rs.getDate(number++);
				dto_PR.FREQ = rs.getBoolean(number++);
				result.add(dto_PR);
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

	public Boolean UPDATE_PRESC_BY_PK(DTO_PRESC dto_PR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_PRESC_BY_PK);
			pstmt.setInt(number++, dto_PR.TR_ID);
			pstmt.setInt(number++, dto_PR.R_ID);
			pstmt.setInt(number++, dto_PR.CHUP);
			pstmt.setInt(number++, dto_PR.PACK);
			pstmt.setInt(number++, dto_PR.STD_VOL);
			pstmt.setInt(number++, dto_PR.WATER_VOL);
			pstmt.setBoolean(number++, dto_PR.INSUR);
			pstmt.setDate(number++, dto_PR.REG_DATE);
			pstmt.setDate(number++, dto_PR.MOD_DATE);
			pstmt.setBoolean(number++, dto_PR.FREQ);
			pstmt.setInt(number++, dto_PR.PR_ID);
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

	public Boolean DELETE_PRESC_BY_PK(int PR_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_PRESC_BY_PK);
			pstmt.setInt(number++, PR_ID);
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
/*
	// FREQ_PRESC TABLE SQL

	public Boolean INSERT_FREQ_PRESC(DTO_FREQ_PRESC dto_FP, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_FREQ_PRESC);
			pstmt.setInt(number++, dto_FP.FP_ID);
			pstmt.setString(number++, dto_FP.PRESC_NAME);
			pstmt.setString(number++, dto_FP.DRUG_NAME);
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

	public DTO_FREQ_PRESC SELECT_FREQ_PRESC_BY_PK(int FP_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_FREQ_PRESC dto_FP = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_FREQ_PRESC_BY_PK);
			pstmt.setInt(number++, FP_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_FP = new DTO_FREQ_PRESC();
				dto_FP.FP_ID = rs.getInt(number++);
				dto_FP.PRESC_NAME = rs.getString(number++);
				dto_FP.DRUG_NAME = rs.getString(number++);
				return dto_FP;
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

	public LinkedList<DTO_FREQ_PRESC> SELECT_FREQ_PRESC(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_FREQ_PRESC dto_FP = null;
		LinkedList<DTO_FREQ_PRESC> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_FREQ_PRESC);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_FP = new DTO_FREQ_PRESC();
				dto_FP.FP_ID = rs.getInt(number++);
				dto_FP.PRESC_NAME = rs.getString(number++);
				dto_FP.DRUG_NAME = rs.getString(number++);
				result.add(dto_FP);
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

	public Boolean UPDATE_FREQ_PRESC_BY_PK(DTO_FREQ_PRESC dto_FP, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_FREQ_PRESC_BY_PK);
			pstmt.setString(number++, dto_FP.PRESC_NAME);
			pstmt.setString(number++, dto_FP.DRUG_NAME);
			pstmt.setInt(number++, dto_FP.FP_ID);
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

	public Boolean DELETE_FREQ_PRESC_BY_PK(int FP_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_FREQ_PRESC_BY_PK);
			pstmt.setInt(number++, FP_ID);
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
*/
	// INSUR TABLE SQL

	public Boolean INSERT_INSUR(DTO_INSUR dto_IN, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_INSUR);
			pstmt.setInt(number++, dto_IN.PR_ID);
			pstmt.setDate(number++, dto_IN.TREAT_DATE);
			pstmt.setString(number++, dto_IN.PATNT_NAME);
			pstmt.setString(number++, dto_IN.CID);
			pstmt.setString(number++, dto_IN.DOC);
			pstmt.setBoolean(number++, dto_IN.INSUR);
			pstmt.setInt(number++, dto_IN.INSUR_CHARGE);
			pstmt.setInt(number++, dto_IN.HANDI_CHARGE);
			pstmt.setInt(number++, dto_IN.SUP);
			pstmt.setInt(number++, dto_IN.PATNT_CHARGE);
			pstmt.setInt(number++, dto_IN.TOTAL_CHARGE);
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

	public DTO_INSUR SELECT_INSUR_BY_PK(int IN_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_INSUR dto_IN = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_INSUR_BY_PK);
			pstmt.setInt(number++, IN_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_IN = new DTO_INSUR();
				dto_IN.IN_ID = rs.getInt(number++);
				dto_IN.PR_ID = rs.getInt(number++);
				dto_IN.TREAT_DATE = rs.getDate(number++);
				dto_IN.PATNT_NAME = rs.getString(number++);
				dto_IN.CID = rs.getString(number++);
				dto_IN.DOC = rs.getString(number++);
				dto_IN.INSUR = rs.getBoolean(number++);
				dto_IN.INSUR_CHARGE = rs.getInt(number++);
				dto_IN.HANDI_CHARGE = rs.getInt(number++);
				dto_IN.SUP = rs.getInt(number++);
				dto_IN.PATNT_CHARGE = rs.getInt(number++);
				dto_IN.TOTAL_CHARGE = rs.getInt(number++);
				return dto_IN;
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

	public LinkedList<DTO_INSUR> SELECT_INSUR(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_INSUR dto_IN = null;
		LinkedList<DTO_INSUR> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_INSUR);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_IN = new DTO_INSUR();
				dto_IN.IN_ID = rs.getInt(number++);
				dto_IN.PR_ID = rs.getInt(number++);
				dto_IN.TREAT_DATE = rs.getDate(number++);
				dto_IN.PATNT_NAME = rs.getString(number++);
				dto_IN.CID = rs.getString(number++);
				dto_IN.DOC = rs.getString(number++);
				dto_IN.INSUR = rs.getBoolean(number++);
				dto_IN.INSUR_CHARGE = rs.getInt(number++);
				dto_IN.HANDI_CHARGE = rs.getInt(number++);
				dto_IN.SUP = rs.getInt(number++);
				dto_IN.PATNT_CHARGE = rs.getInt(number++);
				dto_IN.TOTAL_CHARGE = rs.getInt(number++);
				result.add(dto_IN);
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

	public Boolean UPDATE_INSUR_BY_PK(DTO_INSUR dto_IN, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_INSUR_BY_PK);
			pstmt.setDate(number++, dto_IN.TREAT_DATE);
			pstmt.setString(number++, dto_IN.PATNT_NAME);
			pstmt.setString(number++, dto_IN.CID);
			pstmt.setString(number++, dto_IN.DOC);
			pstmt.setBoolean(number++, dto_IN.INSUR);
			pstmt.setInt(number++, dto_IN.INSUR_CHARGE);
			pstmt.setInt(number++, dto_IN.HANDI_CHARGE);
			pstmt.setInt(number++, dto_IN.SUP);
			pstmt.setInt(number++, dto_IN.PATNT_CHARGE);
			pstmt.setInt(number++, dto_IN.TOTAL_CHARGE);
			pstmt.setInt(number++, dto_IN.IN_ID);
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

	public Boolean DELETE_INSUR_BY_PK(int IN_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_INSUR_BY_PK);
			pstmt.setInt(number++, IN_ID);
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

	// INSUR_DETAIL TABLE SQL

	public Boolean INSERT_INSUR_DETAIL(DTO_INSUR_DETAIL dto_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_INSUR_DETAIL);

			pstmt.setString(number++, dto_ID.TREAT_NAME);
			pstmt.setString(number++, dto_ID.TREAT_CODE);
			pstmt.setString(number++, dto_ID.PART);
			pstmt.setInt(number++, dto_ID.TYPE);
			pstmt.setInt(number++, dto_ID.ONCE_DOSE);
			pstmt.setInt(number++, dto_ID.TOTAL_DOSE);
			pstmt.setInt(number++, dto_ID.TOTAL_CHARGE);
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

	public DTO_INSUR_DETAIL SELECT_INSUR_DETAIL_BY_PK(int _ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_INSUR_DETAIL dto_ID = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_INSUR_DETAIL_BY_PK);
			pstmt.setInt(number++, _ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_ID = new DTO_INSUR_DETAIL();
				dto_ID._ID = rs.getInt(number++);
				dto_ID.TREAT_NAME = rs.getString(number++);
				dto_ID.TREAT_CODE = rs.getString(number++);
				dto_ID.TYPE = rs.getInt(number++);
				dto_ID.PART = rs.getString(number++);
				dto_ID.ONCE_DOSE = rs.getInt(number++);
				dto_ID.TOTAL_DOSE = rs.getInt(number++);
				dto_ID.TOTAL_CHARGE = rs.getInt(number++);
				return dto_ID;
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

	public LinkedList<DTO_INSUR_DETAIL> SELECT_INSUR_DETAIL(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_INSUR_DETAIL dto_ID = null;
		LinkedList<DTO_INSUR_DETAIL> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_INSUR_DETAIL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_ID = new DTO_INSUR_DETAIL();
				dto_ID._ID = rs.getInt(number++);
				dto_ID.TREAT_NAME = rs.getString(number++);
				dto_ID.TREAT_CODE = rs.getString(number++);
				dto_ID.TYPE = rs.getInt(number++);
				dto_ID.PART = rs.getString(number++);
				dto_ID.ONCE_DOSE = rs.getInt(number++);
				dto_ID.TOTAL_DOSE = rs.getInt(number++);
				dto_ID.TOTAL_CHARGE = rs.getInt(number++);
				result.add(dto_ID);
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

	public Boolean UPDATE_INSUR_DETAIL_BY_PK(DTO_INSUR_DETAIL dto_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_INSUR_DETAIL_BY_PK);
			pstmt.setString(number++, dto_ID.TREAT_NAME);
			pstmt.setString(number++, dto_ID.TREAT_CODE);
			pstmt.setString(number++, dto_ID.PART);
			pstmt.setInt(number++, dto_ID.ONCE_DOSE);
			pstmt.setInt(number++, dto_ID.TOTAL_DOSE);
			pstmt.setInt(number++, dto_ID.TOTAL_CHARGE);
			pstmt.setInt(number++, dto_ID._ID);
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

	public Boolean DELETE_INSUR_DETAIL_BY_PK(int _ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_INSUR_DETAIL_BY_PK);
			pstmt.setInt(number++, _ID);
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

	// PHYSIC TABLE SQL

	public Boolean INSERT_PHYSIC(DTO_PHYSIC dto_PH, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_PHYSIC);
			pstmt.setInt(number++, dto_PH.PH_ID);
			pstmt.setInt(number++, dto_PH.CH_ID);
			pstmt.setInt(number++, dto_PH.TR_ID);
			pstmt.setString(number++, dto_PH.PH_TYPE);
			pstmt.setString(number++, dto_PH.NAME);
			pstmt.setString(number++, dto_PH.PART_CODE);
			pstmt.setBoolean(number++, dto_PH.INSUR);
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

	public DTO_PHYSIC SELECT_PHYSIC_BY_PK(int PH_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_PHYSIC dto_PH = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_PHYSIC_BY_PK);
			pstmt.setInt(number++, PH_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_PH = new DTO_PHYSIC();
				dto_PH.PH_ID = rs.getInt(number++);
				dto_PH.CH_ID = rs.getInt(number++);
				dto_PH.TR_ID = rs.getInt(number++);
				dto_PH.PH_TYPE = rs.getString(number++);
				dto_PH.NAME = rs.getString(number++);
				dto_PH.PART_CODE = rs.getString(number++);
				dto_PH.INSUR = rs.getBoolean(number++);

				return dto_PH;
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

	public LinkedList<DTO_PHYSIC> SELECT_PHYSIC(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_PHYSIC dto_PH = null;
		LinkedList<DTO_PHYSIC> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_PHYSIC);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_PH = new DTO_PHYSIC();
				dto_PH.PH_ID = rs.getInt(number++);
				dto_PH.CH_ID = rs.getInt(number++);
				dto_PH.TR_ID = rs.getInt(number++);
				dto_PH.PH_TYPE = rs.getString(number++);
				dto_PH.NAME = rs.getString(number++);
				dto_PH.PART_CODE = rs.getString(number++);
				dto_PH.INSUR = rs.getBoolean(number++);

				result.add(dto_PH);
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

	public Boolean UPDATE_PHYSIC_BY_PK(DTO_PHYSIC dto_PH, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_PHYSIC_BY_PK);
			pstmt.setInt(number++, dto_PH.CH_ID);
			pstmt.setInt(number++, dto_PH.TR_ID);
			pstmt.setString(number++, dto_PH.PH_TYPE);
			pstmt.setString(number++, dto_PH.NAME);
			pstmt.setString(number++, dto_PH.PART_CODE);
			pstmt.setBoolean(number++, dto_PH.INSUR);
			pstmt.setInt(number++, dto_PH.PH_ID);
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

	public Boolean DELETE_PHYSIC_BY_PK(int PH_ID, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_PHYSIC_BY_PK);
			pstmt.setInt(number++, PH_ID);
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

	// INSUR_DRUG TABLE SQL

	public static final Boolean INSERT_INSUR_DRUG(DTO_INSUR_DRUG dto_IDR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_INSUR_DRUG);
			pstmt.setString(number++, dto_IDR.IDR_CODE);
			pstmt.setString(number++, dto_IDR.IDR_NAME);
			pstmt.setString(number++, dto_IDR.IDR_COMP_NAME);
			pstmt.setDouble(number++, dto_IDR.IDR_WEIGHT);
			pstmt.setInt(number++, dto_IDR.IDR_PRICE);
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

	public static final DTO_INSUR_DRUG SELECT_INSUR_DRUG_BY_PK(int IDR_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_INSUR_DRUG dto_IDR = new DTO_INSUR_DRUG();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_INSUR_DRUG_BY_PK);
			pstmt.setInt(number++, dto_IDR.IDR_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_IDR = new DTO_INSUR_DRUG();
				dto_IDR.IDR_ID = rs.getInt(number++);
				dto_IDR.IDR_CODE = rs.getString(number++);
				dto_IDR.IDR_NAME = rs.getString(number++);
				dto_IDR.IDR_COMP_NAME = rs.getString(number++);
				dto_IDR.IDR_WEIGHT = rs.getDouble(number++);
				dto_IDR.IDR_PRICE = rs.getInt(number++);
				return dto_IDR;
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

	public static final LinkedList<DTO_INSUR_DRUG> SELECT_INSUR_DRUG(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<DTO_INSUR_DRUG> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_INSUR_DRUG);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				DTO_INSUR_DRUG dto_IDR = new DTO_INSUR_DRUG();
				dto_IDR.IDR_ID = rs.getInt(number++);
				dto_IDR.IDR_CODE = rs.getString(number++);
				dto_IDR.IDR_NAME = rs.getString(number++);
				dto_IDR.IDR_COMP_NAME = rs.getString(number++);
				dto_IDR.IDR_WEIGHT = rs.getDouble(number++);
				dto_IDR.IDR_PRICE = rs.getInt(number++);
				result.add(dto_IDR);
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

	public static final Boolean UPDATE_INSUR_DRUG_BY_PK(DTO_INSUR_DRUG dto_IDR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_INSUR_DRUG_BY_PK);
			pstmt.setString(number++, dto_IDR.IDR_CODE);
			pstmt.setString(number++, dto_IDR.IDR_NAME);
			pstmt.setString(number++, dto_IDR.IDR_COMP_NAME);
			pstmt.setDouble(number++, dto_IDR.IDR_WEIGHT);
			pstmt.setInt(number++, dto_IDR.IDR_PRICE);
			pstmt.setInt(number++, dto_IDR.IDR_ID);
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

	public static final Boolean DELETE_INSUR_DRUG_BY_PK(DTO_INSUR_DRUG dto_IDR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_INSUR_DRUG_BY_PK);
			pstmt.setInt(number++, dto_IDR.IDR_ID);
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

	// INSUR_PRESC TABLE SQL

	public static final Boolean INSERT_INSUR_PRESC(DTO_INSUR_PRESC dto_IP, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_INSUR_PRESC);
			pstmt.setString(number++, dto_IP.IP_CODE);
			pstmt.setString(number++, dto_IP.IP_NAME);
			pstmt.setString(number++, dto_IP.SUB_NAME);
			pstmt.setString(number++, dto_IP.IP_COMP_NAME);
			pstmt.setDouble(number++, dto_IP.IP_WEIGHT);
			pstmt.setInt(number++, dto_IP.IP_PRICE);
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

	public static final DTO_INSUR_PRESC SELECT_INSUR_PRESC_BY_PK(int IP_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int number = 1;
		DTO_INSUR_PRESC dto_IP = new DTO_INSUR_PRESC();
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_INSUR_PRESC_BY_PK);
			pstmt.setInt(number++, dto_IP.IP_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_IP = new DTO_INSUR_PRESC();
				dto_IP.IP_ID = rs.getInt(number++);
				dto_IP.IP_CODE = rs.getString(number++);
				dto_IP.IP_NAME = rs.getString(number++);
				dto_IP.SUB_NAME = rs.getString(number++);
				dto_IP.IP_COMP_NAME = rs.getString(number++);
				dto_IP.IP_WEIGHT = rs.getDouble(number++);
				dto_IP.IP_PRICE = rs.getInt(number++);
				return dto_IP;
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

	public static final LinkedList<DTO_INSUR_PRESC> SELECT_INSUR_PRESC(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_INSUR_PRESC dto_IP = null;
		LinkedList<DTO_INSUR_PRESC> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_INSUR_PRESC);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_IP = new DTO_INSUR_PRESC();
				dto_IP.IP_ID = rs.getInt(number++);
				dto_IP.IP_CODE = rs.getString(number++);
				dto_IP.IP_NAME = rs.getString(number++);
				dto_IP.SUB_NAME = rs.getString(number++);
				dto_IP.IP_COMP_NAME = rs.getString(number++);
				dto_IP.IP_WEIGHT = rs.getDouble(number++);
				dto_IP.IP_PRICE = rs.getInt(number++);
				result.add(dto_IP);
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

	public static final Boolean UPDATE_INSUR_PRESC_BY_PK(DTO_INSUR_PRESC dto_IP, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_INSUR_PRESC_BY_PK);
			pstmt.setString(number++, dto_IP.IP_CODE);
			pstmt.setString(number++, dto_IP.IP_NAME);
			pstmt.setString(number++, dto_IP.SUB_NAME);
			pstmt.setString(number++, dto_IP.IP_COMP_NAME);
			pstmt.setDouble(number++, dto_IP.IP_WEIGHT);
			pstmt.setInt(number++, dto_IP.IP_PRICE);
			pstmt.setInt(number++, dto_IP.IP_ID);
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

	public static final Boolean DELETE_INSUR_PRESC_BY_PK(DTO_INSUR_PRESC dto_IP, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_INSUR_PRESC_BY_PK);
			pstmt.setInt(number++, dto_IP.IP_ID);
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

	// CHIM TABLE SQL
	public static final Boolean INSERT_CHIM(DTO_CHIM dto_C, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_CHIM);
			pstmt.setString(number++, dto_C.CODE);
			pstmt.setString(number++, dto_C.NAME);
			pstmt.setString(number++, dto_C.C_NAME);
			pstmt.setInt(number++, dto_C.PART);
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

	public static final DTO_CHIM SELECT_CHIM_BY_PK(int CH_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_CHIM_BY_PK);
			pstmt.setInt(number++, CH_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				DTO_CHIM dto_C = new DTO_CHIM();
				dto_C.CH_ID = rs.getInt(number++);
				dto_C.CODE = rs.getString(number++);
				dto_C.NAME = rs.getString(number++);
				dto_C.C_NAME = rs.getString(number++);
				dto_C.PART = rs.getInt(number++);
				return dto_C;
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

	public static final LinkedList<DTO_CHIM> SELECT_CHIM(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<DTO_CHIM> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_CHIM);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				DTO_CHIM dto_C = new DTO_CHIM();
				dto_C.CH_ID = rs.getInt(number++);
				dto_C.CODE = rs.getString(number++);
				dto_C.NAME = rs.getString(number++);
				dto_C.C_NAME = rs.getString(number++);
				dto_C.PART = rs.getInt(number++);
				result.add(dto_C);
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

	public static final Boolean UPDATE_CHIM_BY_PK(DTO_CHIM dto_C, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_CHIM_BY_PK);
			pstmt.setString(number++, dto_C.CODE);
			pstmt.setString(number++, dto_C.NAME);
			pstmt.setString(number++, dto_C.C_NAME);
			pstmt.setInt(number++, dto_C.PART);
			pstmt.setInt(number++, dto_C.CH_ID);
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

	public static final Boolean DELETE_CHIM_BY_PK(DTO_CHIM dto_C, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_CHIM_BY_PK);
			pstmt.setInt(number++, dto_C.CH_ID);
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

	// SYMP TABLE

	public static final Boolean INSERT_SYMP(DTO_SYMP dto_SY, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_SYMP);
			pstmt.setInt(number++, dto_SY.TR_ID);
			pstmt.setString(number++, dto_SY.SYMP_CODE);
			pstmt.setString(number++, dto_SY.SYMP_NAME);
			pstmt.setBoolean(number++, dto_SY.INSUR);
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

	public static final DTO_SYMP SELECT_SYMP_BY_PK(int SY_ID, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_SYMP dto_SY =null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_SYMP_BY_PK);
			pstmt.setInt(number++, SY_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_SY = new DTO_SYMP();
				dto_SY.SY_ID = rs.getInt(number++);
				dto_SY.TR_ID = rs.getInt(number++);
				dto_SY.SYMP_CODE = rs.getString(number++);
				dto_SY.SYMP_NAME = rs.getString(number++);
				dto_SY.INSUR = rs.getBoolean(number++);
				return dto_SY;
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

	public static final LinkedList<DTO_SYMP> SELECT_SYMP(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_SYMP dto_SY = null;
		LinkedList<DTO_SYMP> result = new LinkedList<>();
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_SELECT_SYMP);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				number = 1;
				dto_SY = new DTO_SYMP();
				dto_SY.SY_ID = rs.getInt(number++);
				dto_SY.TR_ID = rs.getInt(number++);
				dto_SY.SYMP_CODE = rs.getString(number++);
				dto_SY.SYMP_NAME = rs.getString(number++);
				dto_SY.INSUR = rs.getBoolean(number++);
				result.add(dto_SY);
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

	public static final Boolean UPDATE_SYMP_BY_PK(DTO_SYMP dto_SY, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_SYMP_BY_PK);
			pstmt.setInt(number++, dto_SY.TR_ID);
			pstmt.setString(number++, dto_SY.SYMP_CODE);
			pstmt.setString(number++, dto_SY.SYMP_NAME);
			pstmt.setBoolean(number++, dto_SY.INSUR);
			pstmt.setInt(number++, dto_SY.SY_ID);
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

	public static final Boolean DELETE_SYMP_BY_PK(DTO_SYMP dto_SY, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_SYMP_BY_PK);
			pstmt.setInt(number++, dto_SY.SY_ID);
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

}
