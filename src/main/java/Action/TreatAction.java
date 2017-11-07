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

public class TreatAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public TreatAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_TREAT dto_TR;
		boolean result;

		switch (code) {
		case CODE_DELETE:
			String TR_ID = request.getParameter("TR_ID");
			result = dao.DELETE_PRESC_BY_PK(Integer.parseInt(TR_ID), conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_INSERT:
			String TR_ID_I = request.getParameter("TR_ID");
			String R_ID = request.getParameter("R_ID");
			String SYMP_NAME = request.getParameter("SYMP_NAME");
			String MEMO = request.getParameter("MEMO");
			dto_TR = new DTO_TREAT(Integer.parseInt(TR_ID_I), Integer.parseInt(R_ID),
					SYMP_NAME, MEMO);
			result = dao.INSERT_TREAT(dto_TR, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_SELECT_BY:
			String TR_ID_S = request.getParameter("TR_ID");
			dto_TR = dao.SELECT_TREAT_BY_PK(Integer.parseInt(TR_ID_S), conn);
			request.setAttribute("result", dto_TR);
			break;
		case CODE_SELECT:
			LinkedList<DTO_PRESC> dto_PRL = dao.SELECT_PRESC(conn);
			request.setAttribute("result", dto_PRL);
			break;
		case CODE_UPDATE:
			String TR_ID_U = request.getParameter("TR_ID");
			String R_ID_U = request.getParameter("R_ID");
			String SYMP_NAME_U = request.getParameter("SYMP_NAME");
			String MEMO_U = request.getParameter("MEMO");
			dto_TR = new DTO_TREAT(Integer.parseInt(TR_ID_U), Integer.parseInt(R_ID_U),
					SYMP_NAME_U, MEMO_U);
			result = dao.UPDATE_TREAT_BY_PK(dto_TR, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}

}
