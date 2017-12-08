package Action;

import java.sql.Connection;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.*;
import hanbaang.DBConnection;

public class InsurPrescAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public InsurPrescAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_INSUR_PRESC dto_IP;
		boolean result;

		switch (code) {
		case CODE_DELETE:
			String IP_id = request.getParameter("IP_ID");
			dto_IP = new DTO_INSUR_PRESC();
			result = dao.DELETE_PRESC_BY_PK(Integer.parseInt(IP_id), conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_INSERT:
			String IP_ID = request.getParameter("IP_ID");
			String IP_CODE = request.getParameter("IP_CODE");
			String IP_NAME = request.getParameter("IP_NAME");
			String SUB_NAME = request.getParameter("SUB_NAME");
			String IP_COMP_NAME = request.getParameter("IP_COMP_NAME");
			String IP_WEIGHT = request.getParameter("IP_WEIGHT");
			String IP_PRICE = request.getParameter("IP_PRICE");

			dto_IP = new DTO_INSUR_PRESC(Integer.parseInt(IP_ID), IP_CODE, IP_NAME, SUB_NAME, IP_COMP_NAME,
					Double.parseDouble(IP_WEIGHT), Integer.parseInt(IP_PRICE));
			result = dao.INSERT_INSUR_PRESC(dto_IP, conn);
			request.setAttribute("result", new Boolean(result));
			break;
		case CODE_SELECT_BY:
			String IP_ID_S = request.getParameter("IP_ID");
			dto_IP = dao.SELECT_INSUR_PRESC_BY_PK(Integer.parseInt(IP_ID_S), conn);
			request.setAttribute("result", dto_IP);
			break;
		case CODE_SELECT:
			LinkedList<DTO_INSUR_PRESC> dto_IPL = dao.SELECT_INSUR_PRESC(conn);
			request.setAttribute("result", dto_IPL);
			break;
		case CODE_UPDATE:
			String IP_ID_U = request.getParameter("IP_ID");
			String IP_CODE_U = request.getParameter("IP_CODE");
			String IP_NAME_U = request.getParameter("IP_NAME");
			String SUB_NAME_U = request.getParameter("SUB_NAME");
			String IP_COMP_NAME_U = request.getParameter("IP_COMP_NAME");
			String IP_WEIGHT_U = request.getParameter("IP_WEIGHT");
			String IP_PRICE_U = request.getParameter("IP_PRICE");

			dto_IP = new DTO_INSUR_PRESC(Integer.parseInt(IP_ID_U), IP_CODE_U, IP_NAME_U, SUB_NAME_U, IP_COMP_NAME_U,
					Double.parseDouble(IP_WEIGHT_U), Integer.parseInt(IP_PRICE_U));
			result = dao.UPDATE_INSUR_PRESC_BY_PK(dto_IP, conn);
			request.setAttribute("result", result);
			break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}

}
