package Action;

import java.sql.Connection;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO;
import DTO.*;
import hanbaang.DBConnection;

public class SympAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public SympAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_SYMP dto_SY;
		boolean result;
		
		switch(code) {
			case CODE_DELETE: 
				String SY_id = request.getParameter("SY_ID");
				dto_SY = new DTO_SYMP();
				result = dao.DELETE_DRUG_BY_PK(Integer.parseInt(SY_id), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String TR_ID = request.getParameter("TR_ID");
				String SYMP_CODE = request.getParameter("SYMP_CODE");
				String SYMP_NAME = request.getParameter("SYMP_NAME");
				String INSUR = request.getParameter("INSUR");
				
				dto_SY = new DTO_SYMP(Integer.parseInt(TR_ID),SYMP_CODE,SYMP_NAME,Boolean.parseBoolean(INSUR));
				result = dao.INSERT_SYMP(dto_SY, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String SY_ID_S= request.getParameter("SY_ID");
				dto_SY = dao.SELECT_SYMP_BY_PK(Integer.parseInt(SY_ID_S), conn);
				request.setAttribute("result", dto_SY);
				break;
			case CODE_SELECT :
				LinkedList<DTO_SYMP> dto_SYL = dao.SELECT_SYMP(conn);
				request.setAttribute("result", dto_SYL);
				break;
			case CODE_UPDATE:
				String SY_ID_U= request.getParameter("SY_ID");
				String TR_ID_U = request.getParameter("TR_ID");
				String SYMP_CODE_U = request.getParameter("SYMP_CODE");
				String SYMP_NAME_U = request.getParameter("SYMP_NAME");
				String INSUR_U = request.getParameter("INSUR");
				
				dto_SY = new DTO_SYMP(Integer.parseInt(SY_ID_U),Integer.parseInt(TR_ID_U),SYMP_CODE_U,SYMP_NAME_U,Boolean.parseBoolean(INSUR_U));
				result = dao.UPDATE_SYMP_BY_PK(dto_SY, conn);
				request.setAttribute("result", result);
				break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}


}
