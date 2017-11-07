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

public class FreqPrescAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public FreqPrescAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_FREQ_PRESC dto_FP;
		boolean result;
		
		switch(code) {
			case CODE_DELETE: 
				String FP_ID = request.getParameter("FP_ID");
				result = dao.DELETE_FREQ_PRESC_BY_PK(Integer.parseInt(FP_ID), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String FP_ID_I = request.getParameter("FP_ID");
				String PRESC_NAME = request.getParameter("PRESC_NAME");
				String DRUG_NAME = request.getParameter("DRUG_NAME");
				dto_FP = new DTO_FREQ_PRESC(Integer.parseInt(FP_ID_I),PRESC_NAME,DRUG_NAME);
				result = dao.INSERT_FREQ_PRESC(dto_FP, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String FP_ID_S = request.getParameter("FP_ID");
				dto_FP = dao.SELECT_FREQ_PRESC_BY_PK(Integer.parseInt(FP_ID_S), conn);
				request.setAttribute("result", dto_FP);
				break;
			case CODE_SELECT :
				LinkedList<DTO_FREQ_PRESC> dto_FPL = dao.SELECT_FREQ_PRESC(conn);
				request.setAttribute("result", dto_FPL);
				break;
			case CODE_UPDATE:
				String FP_ID_U = request.getParameter("FP_ID");
				String PRESC_NAME_U = request.getParameter("PRESC_NAME");
				String DRUG_NAME_U = request.getParameter("DRUG_NAME");
				dto_FP = new DTO_FREQ_PRESC(Integer.parseInt(FP_ID_U),PRESC_NAME_U,DRUG_NAME_U);
				result = dao.UPDATE_FREQ_PRESC_BY_PK(dto_FP, conn);
				request.setAttribute("result", new Boolean(result));
				break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}


}
