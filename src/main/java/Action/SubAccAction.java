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

public class SubAccAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public SubAccAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_SUB_ACCOUNT dto_SA;
		boolean result;
		
		switch(code) {
			case CODE_DELETE: 
				String SA_id = request.getParameter("SA_id");
				dto_SA = new DTO_SUB_ACCOUNT();
				result = dao.DELETE_SUB_ACCOUNT_BY_PK(Integer.parseInt(SA_id), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String SA_id_I = request.getParameter("SA_id");
				String AC_id = request.getParameter("AC_id");
				String ID = request.getParameter("ID");
				String PW = request.getParameter("PW");
				String STAFF_NAME = request.getParameter("STAFF_NAME");
				String ORG_NUM = request.getParameter("ORG_NUM");
				String COMP_NUM = request.getParameter("COMP_NUM");
				String PHONE = request.getParameter("PHONE");
				String MAIL = request.getParameter("MAIL");
				String ADDR = request.getParameter("ADDR");
				String ADDR_DETAIL = request.getParameter("ADDR_DETAIL");

				// 날짜 설정
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String REG = request.getParameter("REG_DATE");
				Date REG_DATE = new Date(sdf.parse(REG).getTime());
				String MOD = request.getParameter("MOD_DATE");
				Date MOD_DATE = new Date(sdf.parse(MOD).getTime());

			
				dto_SA = new DTO_SUB_ACCOUNT(Integer.parseInt(SA_id_I), Integer.parseInt(AC_id), ID, PW,
						STAFF_NAME, ORG_NUM, COMP_NUM, PHONE, MAIL, ADDR, ADDR_DETAIL, REG_DATE, MOD_DATE);
				result = dao.INSERT_SUB_ACCOUNT(dto_SA, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String SA_id_S = request.getParameter("SA_id");	
				dto_SA = dao.SELECT_SUB_ACCOUNT_BY_PK(Integer.parseInt(SA_id_S), conn);
				request.setAttribute("result", dto_SA);
				break;
			case CODE_SELECT :
				LinkedList<DTO_SUB_ACCOUNT> dto_SAL = dao.SELECT_SUB_ACCOUNT(conn);
				request.setAttribute("result", dto_SAL);
				break;
			case CODE_UPDATE:
				String SA_id_U = request.getParameter("SA_id");
				String AC_id_U = request.getParameter("AC_id");
				String ID_U = request.getParameter("ID");
				String PW_U = request.getParameter("PW");
				String STAFF_NAME_U = request.getParameter("STAFF_NAME");
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
				dto_SA = new DTO_SUB_ACCOUNT(Integer.parseInt(SA_id_U), Integer.parseInt(AC_id_U), ID_U, PW_U,
						STAFF_NAME_U, ORG_NUM_U, COMP_NUM_U, PHONE_U, MAIL_U, ADDR_U, ADDR_DETAIL_U, REG_DATE_U, MOD_DATE_U);
				result = dao.UPDATE_SUB_ACCOUNT_BY_PK(dto_SA, conn);
				request.setAttribute("result", new Boolean(result));
				break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}


}
