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
	String R_ID = request.getParameter("R_ID");
	
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_RECEP dto_R = dao.SELECT_RECEP_BY_PK(Integer.parseInt(R_ID), conn);
%>


{ "object" : [

{"R_id" : "<%=dto_R.R_ID%>", "PA_id" : "<%=dto_R.PA_ID%>", "PATNT_NAME" : "<%=dto_R.PATNT_NAME%>", "RECEP_DATE" : "<%=dto_R.RECEP_DATE%>", "STATE" : "<%=dto_R.STATE%>", "MEMO" : "<%=dto_R.MEMO%>", "MDOC" : "<%=dto_R.MDOC%>", "STAFF_NAME" : "<%=dto_R.STAFF_NAME%>"}

	]
}
<%
	conn.close();
%>
