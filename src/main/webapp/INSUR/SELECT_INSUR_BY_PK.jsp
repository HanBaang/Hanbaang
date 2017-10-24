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
	String IN_id = request.getParameter("IN_id");
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_INSUR dto_IN = dao.SELECT_INSUR_BY_PK(Integer.parseInt(IN_id), conn);
%>


{ "object" : [

{"IN_id" : "<%=dto_IN.IN_ID%>", "PR_id" : "<%=dto_IN.PR_ID%>", "TR_id" : "<%=dto_IN.TR_ID%>", "R_id" : "<%=dto_IN.R_ID%>", "TREAT_DATE" : "<%=dto_IN.TREAT_DATE%>", "PATNT_DATE" : "<%=dto_IN.PATNT_NAME%>", "CID" : "<%=dto_IN.CID%>", "DOC" : "<%=dto_IN.DOC%>", "INSUR" : "<%=dto_IN.INSUR%>", "INSUR_CHARGE" : "<%=dto_IN.INSUR_CHARGE%>", "HANDI_CHARGE" : "<%=dto_IN.HANDI_CHARGE%>" , "SUP" : "<%=dto_IN.SUP%>", "PATNT_CHARGE" : "<%=dto_IN.PATNT_CHARGE%>", "TOTAL_CHARGE" : "<%=dto_IN.TOTAL_CHARGE%>"}

	]
}
<%
	conn.close();
%>
