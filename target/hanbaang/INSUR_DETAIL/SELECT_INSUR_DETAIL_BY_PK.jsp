<%@page import="hanbaang.*"%>
<%@page import="DTO.*"%>
<%@page import="Data.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>


<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%
	String ID_id = request.getParameter("ID_id");
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_INSUR_DETAIL dto_ID = dao.SELECT_INSUR_DETAIL_BY_PK(Integer.parseInt(ID_id), conn);
%>


{ "object" : [

{"IN_id" : "<%=dto_ID._ID%>", "PR_id" : "<%=dto_ID.PR_ID%>", "TR_id" : "<%=dto_ID.TR_ID%>", "R_id" : "<%=dto_ID.R_ID%>", "TREAT_NAME" : "<%=dto_ID.TREAT_NAME%>", "TREAT_CODE" : "<%=dto_ID.TREAT_CODE%>", "PART" : "<%=dto_ID.PART%>", "ONCE_DOSE" : "<%=dto_ID.ONCE_DOSE%>", "TOTAL_DOSE" : "<%=dto_ID.TOTAL_DOSE%>", "TOTAL_CHARGE" : "<%=dto_ID.TOTAL_CHARGE%>"}
	]
}
<%
	conn.close();
%>
