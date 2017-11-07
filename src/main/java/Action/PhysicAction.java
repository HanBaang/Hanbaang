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

public class PhysicAction implements Action {
	public static final int CODE_DELETE = 1;
	public static final int CODE_INSERT = 2;
	public static final int CODE_SELECT_BY = 3;
	public static final int CODE_SELECT = 4;
	public static final int CODE_UPDATE = 5;
	public String jspPagePath;
	private int code;

	public PhysicAction(String jspPagePath, int code) {
		this.jspPagePath = jspPagePath;
		this.code = code;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = DBConnection.getConnection();
		DAO dao = DAO.getInstance();
		DTO_PHYSIC dto_PH;
		boolean result;
		
		switch(code) {
			case CODE_DELETE: 
				String PH_ID = request.getParameter("PH_ID");
				result = dao.DELETE_PHYSIC_BY_PK(Integer.parseInt(PH_ID), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String PH_ID_I = request.getParameter("PH_ID");
				String PR_ID = request.getParameter("PR_ID");
				String TR_ID = request.getParameter("TR_ID");
				String R_ID = request.getParameter("R_ID");
				String PH_TYPE = request.getParameter("PH_TYPE");
				String PART_CODE = request.getParameter("PART_CODE");
				String INSUR = request.getParameter("INSUR");
				dto_PH = new DTO_PHYSIC(Integer.parseInt(PH_ID_I),Integer.parseInt(PR_ID),Integer.parseInt(TR_ID),Integer.parseInt(R_ID),PH_TYPE,PART_CODE,Boolean.valueOf(INSUR));
				result = dao.INSERT_PHYSIC(dto_PH, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String PH_ID_S = request.getParameter("PH_ID");
				dto_PH = dao.SELECT_PHYSIC_BY_PK(Integer.parseInt(PH_ID_S), conn);
				request.setAttribute("result", dto_PH);
				break;
			case CODE_SELECT :
				LinkedList<DTO_PHYSIC> dto_PHL = dao.SELECT_PHYSIC(conn);
				request.setAttribute("result", dto_PHL);
				break;
			case CODE_UPDATE:
				String PH_ID_U = request.getParameter("PH_ID");
				String PR_ID_U = request.getParameter("PR_ID");
				String TR_ID_U = request.getParameter("TR_ID");
				String R_ID_U = request.getParameter("R_ID");
				String PH_TYPE_U = request.getParameter("PH_TYPE");
				String PART_CODE_U = request.getParameter("PART_CODE");
				String INSUR_U = request.getParameter("INSUR");
				dto_PH = new DTO_PHYSIC(Integer.parseInt(PH_ID_U),Integer.parseInt(PR_ID_U),Integer.parseInt(TR_ID_U),Integer.parseInt(R_ID_U),PH_TYPE_U,PART_CODE_U,Boolean.valueOf(INSUR_U));
				result = dao.INSERT_PHYSIC(dto_PH, conn);
				request.setAttribute("result", new Boolean(result));
				break;
		}
		conn.close();
		ActionForward forward = new ActionForward();
		forward.setNextPath(jspPagePath);
		return forward;
	}


}
