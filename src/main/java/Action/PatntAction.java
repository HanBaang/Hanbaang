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

public class PatntAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public PatntAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_PATNT dto_PA;
		boolean result;
		
		switch(code) {
			case CODE_DELETE: 
				String PA_ID = request.getParameter("PA_ID");
				dto_PA = new DTO_PATNT();
				result = dao.DELETE_PATNT_BY_PK(Integer.parseInt(PA_ID), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String PA_id = request.getParameter("PA_ID");
				String PATNT_NAME = request.getParameter("PATNT_NAME");
				String H_INSUR_NUM = request.getParameter("H_INSUR_NUM");
				String CID = request.getParameter("CID");
				String GEND = request.getParameter("GEND");
				String PHONE = request.getParameter("PHONE");
				String MAIL = request.getParameter("MAIL");
				String ADDR = request.getParameter("ADDR");
				String ADDR_DETAIL = request.getParameter("ADDR_DETAIL");
				String MDOC = request.getParameter("MDOC");

				// 날짜 설정
				String REG = request.getParameter("REG_DATE");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date REG_DATE = new Date(sdf.parse(REG).getTime());
				String MOD = request.getParameter("MOD_DATE");
				Date MOD_DATE = new Date(sdf.parse(MOD).getTime());
				dto_PA = new DTO_PATNT(Integer.parseInt(PA_id), PATNT_NAME, H_INSUR_NUM, CID, Integer.parseInt(GEND), PHONE, MAIL, ADDR, ADDR_DETAIL, MDOC, REG_DATE, MOD_DATE);
				result = dao.INSERT_PATNT(dto_PA, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String PA_ID_S = request.getParameter("PA_ID");
				dto_PA = dao.SELECT_PATNT_BY_PK(Integer.parseInt(PA_ID_S), conn);
				request.setAttribute("result", dto_PA);
				break;
			case CODE_SELECT :
				LinkedList<DTO_PATNT> dto_PAL = dao.SELECT_PATNT(conn);
				request.setAttribute("result", dto_PAL);
				break;
			case CODE_UPDATE:
				String PA_id_U = request.getParameter("PA_ID");
				String PATNT_NAME_U = request.getParameter("PATNT_NAME");
				String H_INSUR_NUM_U = request.getParameter("H_INSUR_NUM");
				String CID_U = request.getParameter("CID");
				String GEND_U = request.getParameter("GEND");
				String PHONE_U = request.getParameter("PHONE");
				String MAIL_U = request.getParameter("MAIL");
				String ADDR_U = request.getParameter("ADDR");
				String ADDR_DETAIL_U = request.getParameter("ADDR_DETAIL");
				String MDOC_U = request.getParameter("MDOC");

				// 날짜 설정
				String REG_U = request.getParameter("REG_DATE");
				SimpleDateFormat sdf_U = new SimpleDateFormat("yyyy-MM-dd");
				Date REG_DATE_U = new Date(sdf_U.parse(REG_U).getTime());
				String MOD_U = request.getParameter("MOD_DATE");
				Date MOD_DATE_U = new Date(sdf_U.parse(MOD_U).getTime());
				dto_PA = new DTO_PATNT(Integer.parseInt(PA_id_U), PATNT_NAME_U, H_INSUR_NUM_U, CID_U, Integer.parseInt(GEND_U), PHONE_U, MAIL_U, ADDR_U, ADDR_DETAIL_U, MDOC_U, REG_DATE_U, MOD_DATE_U);
				result = dao.UPDATE_PATNT_BY_PK(dto_PA, conn);
				request.setAttribute("result", new Boolean(result));
				break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}


}
