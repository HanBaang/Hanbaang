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
	private static DAO instance = new DAO();

	public static DAO getInstance() {
		return instance;
	}

	// ACCOUNT TABLE SQL

	public Boolean INSERT_ACCOUNT(DTO_ACCOUNT dto_ACC, Connection conn) {

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
		DTO_ACCOUNT dto_ACC = null;
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

	public Boolean UPDATE_ACCOUNT_BY_PK(DTO_ACCOUNT dto_ACC, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_UPDATE_ACCOUNT_BY_PK);
			pstmt.setInt(number++, dto_ACC.getAC_id());
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

	public Boolean DELETE_ACCOUNT_BY_PK(DTO_ACCOUNT dto_ACC, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_ACCOUNT_BY_PK);
			pstmt.setInt(number++, dto_ACC.AC_id);
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
			pstmt.setInt(number++, dto_SA.SA_id);
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

	public Boolean DELETE_SUB_ACCOUNT_BY_PK(DTO_SUB_ACCOUNT dto_SA, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_SUB_ACCOUNT_BY_PK);
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
			pstmt.setInt(number++, dto_PA.PA_ID);
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

	public Boolean DELETE_PATNT_BY_PK(DTO_PATNT dto_PA, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_PATNT_BY_PK);
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

	// RECEP TABLE SQL

	public Boolean INSERT_RECEP(DTO_RECEP dto_R, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_RECEP);
			pstmt.setInt(number++, dto_R.R_ID);
			pstmt.setInt(number++, dto_R.PA_ID);
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
			pstmt.setInt(number++, dto_R.R_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				dto_R = new DTO_RECEP();
				dto_R.R_ID = rs.getInt(number++);
				dto_R.PA_ID = rs.getInt(number++);
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

	public Boolean DELETE_RECEP_BY_PK(DTO_RECEP dto_R, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_RECEP_BY_PK);
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

	// TREAT TABLE SQL

	public Boolean INSERT_TREAT(DTO_TREAT dto_TR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_INSERT_TREAT);
			pstmt.setInt(number++, dto_TR.TR_ID);
			pstmt.setInt(number++, dto_TR.R_ID);
			pstmt.setString(number++, dto_TR.SYMP_NAME);
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
			pstmt.setInt(number++, dto_TR.TR_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = 1;
				DTO_TREAT dto_TR = new DTO_TREAT();
				dto_TR.TR_ID = rs.getInt(number++);
				dto_TR.R_ID = rs.getInt(number++);
				dto_TR.SYMP_NAME = rs.getString(number++);
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
				dto_TR.SYMP_NAME = rs.getString(number++);
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
			pstmt.setString(number++, dto_TR.SYMP_NAME);
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

	public Boolean DELETE_TREAT_BY_PK(DTO_TREAT dto_TR, Connection conn) {
		PreparedStatement pstmt = null;
		int number = 1;
		try {
			pstmt = conn.prepareStatement(DefaultValue.SQL_DELETE_TREAT_BY_PK);
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

}
