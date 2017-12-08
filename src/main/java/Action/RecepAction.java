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

public class RecepAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public RecepAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_RECEP dto_R;
		boolean result;

		switch (code) {
		case CODE_DELETE:
			String R_ID = request.getParameter("R_ID");
			result = dao.DELETE_RECEP_BY_PK(Integer.parseInt(R_ID), conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_INSERT:
			String PA_ID = request.getParameter("PA_ID");
			String SA_ID = request.getParameter("SA_ID");
			String PATNT_NAME = request.getParameter("PATNT_NAME");
			String RD = request.getParameter("REG_DATE");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date RECEP_DATE = new Date(sdf.parse(RD).getTime());
			String STATE = request.getParameter("STATE");
			String MEMO = request.getParameter("MEMO");
			String MDOC = request.getParameter("MDOC");
			String STAFF_NAME = request.getParameter("STAFF_NAME");

			dto_R = new DTO_RECEP(Integer.parseInt(PA_ID),Integer.parseInt(SA_ID), PATNT_NAME, RECEP_DATE, STATE, MEMO, MDOC, STAFF_NAME);
			result = dao.INSERT_RECEP(dto_R, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_SELECT_BY:
			String R_ID_S = request.getParameter("R_ID");
			dto_R = dao.SELECT_RECEP_BY_PK(Integer.parseInt(R_ID_S), conn);
			request.setAttribute("result", dto_R);
			break;
		case CODE_SELECT:
			LinkedList<DTO_RECEP> dto_RL = dao.SELECT_RECEP(conn);
			request.setAttribute("result", dto_RL);
			break;
		case CODE_UPDATE:
			String R_ID_U = request.getParameter("R_ID");
			String SA_ID_U = request.getParameter("SA_ID");
			String PA_ID_U = request.getParameter("PA_ID");
			String PATNT_NAME_U = request.getParameter("PATNT_NAME");
			String RD_U = request.getParameter("REG_DATE");
			SimpleDateFormat sdf_U = new SimpleDateFormat("yyyy-MM-dd");
			Date RECEP_DATE_U = new Date(sdf_U.parse(RD_U).getTime());
			String STATE_U = request.getParameter("STATE");
			String MEMO_U = request.getParameter("MEMO");
			String MDOC_U = request.getParameter("MDOC");
			String STAFF_NAME_U = request.getParameter("STAFF_NAME");

			dto_R = new DTO_RECEP(Integer.parseInt(R_ID_U), Integer.parseInt(PA_ID_U),  Integer.parseInt(SA_ID_U),PATNT_NAME_U, RECEP_DATE_U,
					STATE_U, MEMO_U, MDOC_U, STAFF_NAME_U);
			result = dao.INSERT_RECEP(dto_R, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}

}
