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

public class DrugAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public static final int CODE_SELECT_BY_FK_PR = 6;
	public String jspPagePath;
	private int code;

	public DrugAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_DRUG dto_DR;
		Boolean result;
		switch (code) {
		case CODE_DELETE:
			String DR_id = request.getParameter("DR_ID");
			dto_DR = new DTO_DRUG();
			result = dao.DELETE_DRUG_BY_PK(Integer.parseInt(DR_id), conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_INSERT:

			String PR_ID = request.getParameter("PR_ID"); // int
			String DRUG_CODE = request.getParameter("DRUG_CODE");
			String DRUG_COMP_NAME = request.getParameter("DRUG_COMP_NAME");
			String DRUG_NAME = request.getParameter("DRUG_NAME");
			String DRUG_WEIGHT = request.getParameter("DRUG_WEIGHT"); // int
			String DRUG_MEMO = request.getParameter("DRUG_MEMO");
			String INSUR = request.getParameter("INSUR"); // boolean
			String TYPE = request.getParameter("TYPE");
			String TYPE_ID = request.getParameter("TYPE_ID");
			dto_DR = new DTO_DRUG(Integer.parseInt(PR_ID), DRUG_CODE, DRUG_COMP_NAME, DRUG_NAME,
					Integer.parseInt(DRUG_WEIGHT), DRUG_MEMO, Boolean.parseBoolean(INSUR), TYPE, TYPE_ID);
			result = dao.INSERT_DRUG(dto_DR, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_SELECT_BY:
			String DR_ID_S = request.getParameter("DR_ID");
			dto_DR = dao.SELECT_DRUG_BY_PK(Integer.parseInt(DR_ID_S), conn);
			request.setAttribute("result", dto_DR);
			break;
		case CODE_SELECT:
			LinkedList<DTO_DRUG> dto_DRL = dao.SELECT_DRUG(conn);
			request.setAttribute("result", dto_DRL);
			break;
		case CODE_UPDATE:

			String DR_ID_U = request.getParameter("DR_ID"); // int
			String PR_ID_U = request.getParameter("PR_ID"); // int
			String DRUG_CODE_U = request.getParameter("DRUG_CODE");
			String DRUG_COMP_NAME_U = request.getParameter("DRUG_COMP_NAME");
			String DRUG_NAME_U = request.getParameter("DRUG_NAME");
			String DRUG_WEIGHT_U = request.getParameter("DRUG_WEIGHT"); // int
			String DRUG_MEMO_U = request.getParameter("DRUG_MEMO");
			String INSUR_U = request.getParameter("INSUR"); // boolean
			String TYPE_U = request.getParameter("TYPE");
			String TYPE_ID_U = request.getParameter("TYPE_ID");

			dto_DR = new DTO_DRUG(Integer.parseInt(DR_ID_U),Integer.parseInt(PR_ID_U), DRUG_CODE_U, DRUG_COMP_NAME_U, DRUG_NAME_U,
					Integer.parseInt(DRUG_WEIGHT_U), DRUG_MEMO_U, Boolean.parseBoolean(INSUR_U), TYPE_U, TYPE_ID_U);
			result = dao.UPDATE_DRUG_BY_PK(dto_DR, conn);
			request.setAttribute("result", result);
			break;
		case CODE_SELECT_BY_FK_PR:
			String DR_ID_S_F = request.getParameter("PR_ID");
			LinkedList<DTO_DRUG> dto_DRL2 = dao.SELECT_DRUG_BY_FK_PR(Integer.parseInt(DR_ID_S_F), conn);
			request.setAttribute("result", dto_DRL2);
			break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}

}
