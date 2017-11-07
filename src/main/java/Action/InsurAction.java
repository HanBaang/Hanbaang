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

public class InsurAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public InsurAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_INSUR dto_IN;
		boolean result;
		
		switch(code) {
			case CODE_DELETE: 
				String IN_id = request.getParameter("IN_id");
				dto_IN = new DTO_INSUR();
				result = dao.DELETE_INSUR_BY_PK(Integer.parseInt(IN_id), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String IN_ID = request.getParameter("IN_ID");
				String PR_ID = request.getParameter("PR_ID");
				String TR_ID = request.getParameter("TR_ID");
				String R_ID = request.getParameter("R_ID");
				String TD = request.getParameter("TREAT_DATE");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date TREAT_DATE = new Date(sdf.parse(TD).getTime());
				String PATNT_NAME = request.getParameter("PATNT_NAME");
				String CID = request.getParameter("CID");
				String DOC = request.getParameter("DOC");
				String INSUR = request.getParameter("INSUR");
				String INSUR_CHARGE = request.getParameter("INSUR_CHARGE");
				String HANDI_CHARGE = request.getParameter("HANDI_CHARGE");
				String SUP = request.getParameter("SUP");
				String PATNT_CHARGE = request.getParameter("PATNT_CHARGE");
				String TOTAL_CHARGE = request.getParameter("TOTAL_CHARGE");
				dto_IN = new DTO_INSUR(Integer.parseInt(IN_ID) , Integer.parseInt(PR_ID), Integer.parseInt(TR_ID), Integer.parseInt(R_ID), TREAT_DATE, PATNT_NAME, CID, DOC, Boolean.valueOf(INSUR),
						Integer.parseInt(INSUR_CHARGE), Integer.parseInt(HANDI_CHARGE), Integer.parseInt(SUP), Integer.parseInt(PATNT_CHARGE), Integer.parseInt(TOTAL_CHARGE));
				 result = dao.UPDATE_INSUR_BY_PK(dto_IN, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String IN_ID_S = request.getParameter("IN_ID");
				dto_IN = dao.SELECT_INSUR_BY_PK(Integer.parseInt(IN_ID_S), conn);
				request.setAttribute("result", dto_IN);
				break;
			case CODE_SELECT :
				LinkedList<DTO_INSUR> dto_INL = dao.SELECT_INSUR(conn);
				request.setAttribute("result", dto_INL);
				break;
			case CODE_UPDATE:
				String IN_ID_U = request.getParameter("IN_ID");
				String PR_ID_U = request.getParameter("PR_ID");
				String TR_ID_U = request.getParameter("TR_ID");
				String R_ID_U = request.getParameter("R_ID");
				String TD_U = request.getParameter("TREAT_DATE");
				SimpleDateFormat sdf_U = new SimpleDateFormat("yyyy-MM-dd");
				Date TREAT_DATE_U = new Date(sdf_U.parse(TD_U).getTime());
				String PATNT_NAME_U = request.getParameter("PATNT_NAME");
				String CID_U = request.getParameter("CID");
				String DOC_U = request.getParameter("DOC");
				String INSUR_U = request.getParameter("INSUR");
				String INSUR_CHARGE_U = request.getParameter("INSUR_CHARGE");
				String HANDI_CHARGE_U = request.getParameter("HANDI_CHARGE");
				String SUP_U = request.getParameter("SUP");
				String PATNT_CHARGE_U = request.getParameter("PATNT_CHARGE");
				String TOTAL_CHARGE_U = request.getParameter("TOTAL_CHARGE");
				dto_IN = new DTO_INSUR(Integer.parseInt(IN_ID_U) , Integer.parseInt(PR_ID_U), Integer.parseInt(TR_ID_U), Integer.parseInt(R_ID_U), TREAT_DATE_U, PATNT_NAME_U, CID_U, DOC_U, Boolean.valueOf(INSUR_U),
						Integer.parseInt(INSUR_CHARGE_U), Integer.parseInt(HANDI_CHARGE_U), Integer.parseInt(SUP_U), Integer.parseInt(PATNT_CHARGE_U), Integer.parseInt(TOTAL_CHARGE_U));
				 result = dao.UPDATE_INSUR_BY_PK(dto_IN, conn);
				request.setAttribute("result", new Boolean(result));
				break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}


}
