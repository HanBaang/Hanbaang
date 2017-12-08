package Action;

import java.sql.Connection;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.*;
import hanbaang.DBConnection;

public class ChimAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public ChimAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_CHIM dto_C;
		boolean result;
		
		switch(code) {
			case CODE_DELETE: 
				String CH_id = request.getParameter("CH_ID");
				dto_C = new DTO_CHIM();
				result = dao.DELETE_DRUG_BY_PK(Integer.parseInt(CH_id), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String CODE = request.getParameter("CODE");
				String NAME = request.getParameter("NAME");
				String C_NAME = request.getParameter("C_NAME");
				String PART = request.getParameter("PART");
				
				
				dto_C = new DTO_CHIM(CODE,NAME,C_NAME,Integer.parseInt(PART));
				result = dao.INSERT_CHIM(dto_C, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String CH_ID_S= request.getParameter("CH_ID");
				dto_C = dao.SELECT_CHIM_BY_PK(Integer.parseInt(CH_ID_S), conn);
				request.setAttribute("result", dto_C);
				break;
			case CODE_SELECT :
				LinkedList<DTO_CHIM> dto_CL = dao.SELECT_CHIM(conn);
				request.setAttribute("result", dto_CL);
				break;
			case CODE_UPDATE:
				String CH_ID_U= request.getParameter("CH_ID");
				String CODE_U = request.getParameter("CODE");
				String NAME_U = request.getParameter("NAME");
				String C_NAME_U = request.getParameter("C_NAME");
				String PART_U = request.getParameter("PART");
				
				dto_C = new DTO_CHIM(Integer.parseInt(CH_ID_U),CODE_U,NAME_U,C_NAME_U,Integer.parseInt(PART_U));
				result = dao.UPDATE_CHIM_BY_PK(dto_C, conn);
				request.setAttribute("result", result);
				break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}


}
