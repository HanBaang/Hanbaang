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

public class PrescAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public PrescAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_PRESC dto_PR;
		boolean result;

		switch (code) {
		case CODE_DELETE:
			String PR_ID = request.getParameter("PR_ID");
			result = dao.DELETE_PRESC_BY_PK(Integer.parseInt(PR_ID), conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_INSERT:
			String TR_ID = request.getParameter("TR_ID");
			String R_ID = request.getParameter("R_ID");
			String CHUP = request.getParameter("CHUP");
			String PACK = request.getParameter("PACK");
			String STD_VOL = request.getParameter("PR_ID");
			String WATER_VOL = request.getParameter("PR_ID");
			String INSUR = request.getParameter("PR_ID");
			String REG = request.getParameter("REG_DATE");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date REG_DATE = new Date(sdf.parse(REG).getTime());
			// 날짜 설정
			String MOD = request.getParameter("MOD_DATE");
			Date MOD_DATE = new Date(sdf.parse(MOD).getTime());
			String FREQ = request.getParameter("FREQ");
			dto_PR = new DTO_PRESC(Integer.parseInt(TR_ID), Integer.parseInt(R_ID),
					Integer.parseInt(CHUP), Integer.parseInt(PACK), Integer.parseInt(STD_VOL),
					Integer.parseInt(WATER_VOL), Boolean.valueOf(INSUR), REG_DATE, MOD_DATE, Boolean.valueOf(FREQ));
			result = dao.INSERT_PRESC(dto_PR, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_SELECT_BY:
			String PR_ID_S = request.getParameter("PR_ID");
			dto_PR = dao.SELECT_PRESC_BY_PK(Integer.parseInt(PR_ID_S), conn);
			request.setAttribute("result", dto_PR);
			break;
		case CODE_SELECT:
			LinkedList<DTO_PRESC> dto_PRL = dao.SELECT_PRESC(conn);
			request.setAttribute("result", dto_PRL);
			break;
		case CODE_UPDATE:
			String PR_ID_U = request.getParameter("PR_ID");
			String TR_ID_U = request.getParameter("TR_ID");
			String R_ID_U = request.getParameter("R_ID");
			String CHUP_U = request.getParameter("CHUP");
			String PACK_U = request.getParameter("PACK");
			String STD_VOL_U = request.getParameter("PR_ID");
			String WATER_VOL_U = request.getParameter("PR_ID");
			String INSUR_U = request.getParameter("PR_ID");
			String REG_U = request.getParameter("REG_DATE");
			SimpleDateFormat sdf_U = new SimpleDateFormat("yyyy-MM-dd");
			Date REG_DATE_U = new Date(sdf_U.parse(REG_U).getTime());
			// 날짜 설정
			String MOD_U = request.getParameter("MOD_DATE");
			Date MOD_DATE_U = new Date(sdf_U.parse(MOD_U).getTime());
			String FREQ_U = request.getParameter("FREQ");
			dto_PR = new DTO_PRESC(Integer.parseInt(PR_ID_U), Integer.parseInt(TR_ID_U), Integer.parseInt(R_ID_U),
					Integer.parseInt(CHUP_U), Integer.parseInt(PACK_U), Integer.parseInt(STD_VOL_U),
					Integer.parseInt(WATER_VOL_U), Boolean.valueOf(INSUR_U), REG_DATE_U, MOD_DATE_U, Boolean.valueOf(FREQ_U));
			result = dao.INSERT_PRESC(dto_PR, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}

}
