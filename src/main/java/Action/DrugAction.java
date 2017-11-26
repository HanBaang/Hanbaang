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
		switch(code) {
			case CODE_DELETE: 
				String DR_id = request.getParameter("DR_ID");
				dto_DR = new DTO_DRUG();
				result = dao.DELETE_DRUG_BY_PK(Integer.parseInt(DR_id), conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_INSERT:
				String PR_ID = request.getParameter("PR_ID");
				String TR_ID = request.getParameter("TR_ID");
				String R_ID = request.getParameter("R_ID");
				String DRUG_CODE = request.getParameter("DRUG_CODE");
				String DRUG_BRAND = request.getParameter("DRUG_BRAND");
				String DRUG_WEIGHT = request.getParameter("DRUG_WEIGHT");
				String DRUG_MEMO = request.getParameter("DRUG_MEMO");
				
				
				dto_DR = new DTO_DRUG(Integer.parseInt(PR_ID),Integer.parseInt(TR_ID),Integer.parseInt(R_ID),DRUG_CODE,DRUG_BRAND,Integer.parseInt(DRUG_WEIGHT),DRUG_MEMO);
				result = dao.INSERT_DRUG(dto_DR, conn);
				request.setAttribute("result", new Boolean(result));
				break;
			case CODE_SELECT_BY:
				String DR_ID_S= request.getParameter("DR_ID");
				dto_DR = dao.SELECT_DRUG_BY_PK(Integer.parseInt(DR_ID_S), conn);
				request.setAttribute("result", dto_DR);
				break;
			case CODE_SELECT :
				LinkedList<DTO_DRUG> dto_DRL = dao.SELECT_DRUG(conn);
				request.setAttribute("result", dto_DRL);
				break;
			case CODE_UPDATE:
				String DR_ID_U = request.getParameter("DR_ID");
				String PR_ID_U = request.getParameter("PR_ID");
				String TR_ID_U = request.getParameter("TR_ID");
				String R_ID_U = request.getParameter("R_ID");
				String DRUG_CODE_U = request.getParameter("DRUG_CODE");
				String DRUG_BRAND_U = request.getParameter("DRUG_BRAND");
				String DRUG_WEIGHT_U = request.getParameter("DRUG_WEIGHT");
				String DRUG_MEMO_U = request.getParameter("DRUG_MEMO");

				dto_DR = new DTO_DRUG(Integer.parseInt(DR_ID_U),Integer.parseInt(PR_ID_U),Integer.parseInt(TR_ID_U),Integer.parseInt(R_ID_U),DRUG_CODE_U,DRUG_BRAND_U,Integer.parseInt(DRUG_WEIGHT_U),DRUG_MEMO_U);
				result = dao.UPDATE_DRUG_BY_PK(dto_DR, conn);
				request.setAttribute("result", result);
				break;
			case CODE_SELECT_BY_FK_PR:
				String DR_ID_S_F= request.getParameter("PR_ID");
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
