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

public class InsurDetailAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public InsurDetailAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_INSUR_DETAIL dto_ID;
		boolean result;

		switch (code) {
		case CODE_DELETE:
			String ID_ID = request.getParameter("_ID");
			result = dao.DELETE_INSUR_DETAIL_BY_PK(Integer.parseInt(ID_ID), conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_INSERT:
			String ID_ID_I = request.getParameter("_ID");
			String PR_ID = request.getParameter("PR_ID");
			String TR_ID = request.getParameter("TR_ID");
			String R_ID = request.getParameter("R_ID");
			String TREAT_NAME = request.getParameter("TREAT_NAME");
			String TREAT_CODE = request.getParameter("TREAT_CODE");
			String PART = request.getParameter("PART");
			String ONCE_DOSE = request.getParameter("ONCE_DOSE");
			String TOTAL_DOSE = request.getParameter("TOTAL_DOSE");
			String TOTAL_CHARGE = request.getParameter("TOTAL_CHARGE");

			dto_ID = new DTO_INSUR_DETAIL(Integer.parseInt(ID_ID_I), Integer.parseInt(PR_ID), Integer.parseInt(TR_ID),
					Integer.parseInt(R_ID), TREAT_NAME, TREAT_CODE, PART, Integer.parseInt(ONCE_DOSE),
					Integer.parseInt(TOTAL_DOSE), Integer.parseInt(TOTAL_CHARGE));
			result = dao.INSERT_INSUR_DETAIL(dto_ID, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_SELECT_BY:
			String ID_ID_S = request.getParameter("_ID");
			dto_ID = dao.SELECT_INSUR_DETAIL_BY_PK(Integer.parseInt(ID_ID_S), conn);
			request.setAttribute("result", dto_ID);
			break;
		case CODE_SELECT:
			LinkedList<DTO_INSUR_DETAIL> dto_IDL = dao.SELECT_INSUR_DETAIL(conn);
			request.setAttribute("result", dto_IDL);
			break;
		case CODE_UPDATE:
			String ID_ID_U = request.getParameter("_ID");
			String PR_ID_U = request.getParameter("PR_ID");
			String TR_ID_U = request.getParameter("TR_ID");
			String R_ID_U = request.getParameter("R_ID");
			String TREAT_NAME_U = request.getParameter("TREAT_NAME");
			String TREAT_CODE_U = request.getParameter("TREAT_CODE");
			String PART_U = request.getParameter("PART");
			String ONCE_DOSE_U = request.getParameter("ONCE_DOSE");
			String TOTAL_DOSE_U = request.getParameter("TOTAL_DOSE");
			String TOTAL_CHARGE_U = request.getParameter("TOTAL_CHARGE");

			dto_ID = new DTO_INSUR_DETAIL(Integer.parseInt(ID_ID_U), Integer.parseInt(PR_ID_U), Integer.parseInt(TR_ID_U),
					Integer.parseInt(R_ID_U), TREAT_NAME_U, TREAT_CODE_U, PART_U, Integer.parseInt(ONCE_DOSE_U),
					Integer.parseInt(TOTAL_DOSE_U), Integer.parseInt(TOTAL_CHARGE_U));
			result = dao.UPDATE_INSUR_DETAIL_BY_PK(dto_ID, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}

}
