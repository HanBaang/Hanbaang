package Action;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.*;
import hanbaang.DBConnection;

public class AccountAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public AccountAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_ACCOUNT dto_ACC;
		boolean result;
		
		switch(code) {
			case CODE_DELETE: 
				String AC_ID = request.getParameter("AC_ID");
				dto_ACC = new DTO_ACCOUNT();
				result = dao.DELETE_ACCOUNT_BY_PK(Integer.parseInt(AC_ID), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String AC_ID_I = request.getParameter("AC_ID");
				String ID = request.getParameter("ID");
				String PW = request.getParameter("PW");
				String HOSPI_NAME = request.getParameter("HOSPI_NAME");
				String ORG_NUM = request.getParameter("ORG_NUM");
				String COMP_NUM = request.getParameter("COMP_NUM");
				String PHONE = request.getParameter("PHONE");
				String MAIL = request.getParameter("MAIL");
				String ADDR = request.getParameter("ADDR");
				String ADDR_DETAIL = request.getParameter("ADDR_DETAIL");

				String REG = request.getParameter("REG_DATE");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date REG_DATE = new Date(sdf.parse(REG).getTime());
				// 날짜 설정
				String MOD = request.getParameter("MOD_DATE");
				Date MOD_DATE = new Date(sdf.parse(MOD).getTime());
				dto_ACC = new DTO_ACCOUNT(Integer.parseInt(AC_ID_I), ID, PW, HOSPI_NAME, ORG_NUM, COMP_NUM, PHONE,
						MAIL, ADDR, ADDR_DETAIL, REG_DATE, MOD_DATE);
				result = dao.INSERT_ACCOUNT(dto_ACC, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String AC_ID_S = request.getParameter("AC_ID");
				dto_ACC = dao.SELECT_ACCOUNT_BY_PK(Integer.parseInt(AC_ID_S), conn);
				request.setAttribute("result", dto_ACC);
				break;
			case CODE_SELECT :
				LinkedList<DTO_ACCOUNT> dto_ACCL = dao.SELECT_ACCOUNT(conn);
				request.setAttribute("result", dto_ACCL);
				break;
			case CODE_UPDATE:
				String AC_ID_U = request.getParameter("AC_ID");
				String ID_U = request.getParameter("ID");
				String PW_U = request.getParameter("PW");
				String HOSPI_NAME_U = request.getParameter("HOSPI_NAME");
				String ORG_NUM_U = request.getParameter("ORG_NUM");
				String COMP_NUM_U = request.getParameter("COMP_NUM");
				String PHONE_U = request.getParameter("PHONE");
				String MAIL_U = request.getParameter("MAIL");
				String ADDR_U = request.getParameter("ADDR");
				String ADDR_DETAIL_U = request.getParameter("ADDR_DETAIL");
				
				// 날짜 설정
				SimpleDateFormat sdf_U = new SimpleDateFormat("yyyy-MM-dd");
				String REG_U = request.getParameter("REG_DATE");
				Date REG_DATE_U = new Date(sdf_U.parse(REG_U).getTime());
				String MOD_U = request.getParameter("MOD_DATE");
				Date MOD_DATE_U = new Date(sdf_U.parse(MOD_U).getTime());
				dto_ACC = new DTO_ACCOUNT(Integer.parseInt(AC_ID_U), ID_U, PW_U, HOSPI_NAME_U, ORG_NUM_U, COMP_NUM_U, PHONE_U,
						MAIL_U, ADDR_U, ADDR_DETAIL_U, REG_DATE_U, MOD_DATE_U);
				result = dao.UPDATE_ACCOUNT_BY_PK(dto_ACC, conn);
				request.setAttribute("result", new Boolean(result));
				break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}


}
