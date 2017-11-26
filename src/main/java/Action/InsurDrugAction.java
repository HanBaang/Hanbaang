package Action;

import java.sql.Connection;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.*;
import hanbaang.DBConnection;

public class InsurDrugAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public InsurDrugAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_INSUR_DRUG dto_IDR;
		boolean result;

		switch (code) {
		case CODE_DELETE:
			String IDR_id = request.getParameter("IDR_ID");
			dto_IDR = new DTO_INSUR_DRUG();
			result = dao.DELETE_DRUG_BY_PK(Integer.parseInt(IDR_id), conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_INSERT:
			String IDR_ID = request.getParameter("IDR_ID");
			String IDR_CODE = request.getParameter("IDR_CODE");
			String IDR_NAME = request.getParameter("IDR_NAME");
			String IDR_COMP_NAME = request.getParameter("IDR_COMP_NAME");
			String IDR_WEIGHT = request.getParameter("IDR_WEIGHT");
			String IDR_PRICE = request.getParameter("IDR_PRICE");

			dto_IDR = new DTO_INSUR_DRUG(Integer.parseInt(IDR_ID), IDR_CODE, IDR_NAME, IDR_COMP_NAME,
					Double.parseDouble(IDR_WEIGHT), Integer.parseInt(IDR_PRICE));
			result = dao.INSERT_INSUR_DRUG(dto_IDR, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_SELECT_BY:
			String IDR_ID_S = request.getParameter("IDR_ID");
			dto_IDR = dao.SELECT_INSUR_DRUG_BY_PK(Integer.parseInt(IDR_ID_S), conn);
			request.setAttribute("result", dto_IDR);
			break;
		case CODE_SELECT:
			LinkedList<DTO_INSUR_DRUG> dto_IDRL = dao.SELECT_INSUR_DRUG(conn);
			request.setAttribute("result", dto_IDRL);
			break;
		case CODE_UPDATE:
			String IDR_ID_U = request.getParameter("IDR__ID");
			String IDR_CODE_U = request.getParameter("IDR_CODE");
			String IDR_NAME_U = request.getParameter("IDR_NAME");
			String IDR_COMP_NAME_U = request.getParameter("IDR_COMP_NAME");
			String IDR_WEIGHT_U = request.getParameter("IDR_WEIGHT");
			String IDR_PRICE_U = request.getParameter("IDR_PRICE");

			dto_IDR = new DTO_INSUR_DRUG(Integer.parseInt(IDR_ID_U), IDR_CODE_U, IDR_NAME_U, IDR_COMP_NAME_U,
					Double.parseDouble(IDR_WEIGHT_U), Integer.parseInt(IDR_PRICE_U));
			result = dao.UPDATE_INSUR_DRUG_BY_PK(dto_IDR, conn);
			request.setAttribute("result", result);
			break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}

}
