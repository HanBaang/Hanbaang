<%@page import="hanbaang.DBConnection"%>

<%@page import="DTO.*"%>
<%@page import="hanbaang.*"%>
<%@page import="Data.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>


<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	LinkedList<DTO_INSUR> dto_IN = dao.SELECT_INSUR(conn);
%>


{ "object" : [
<%
	Iterator<DTO_INSUR> iterator = dto_IN.iterator();
	while (iterator.hasNext()) {
		DTO_INSUR outer = iterator.next();
%>
{"IN_id" : "<%=outer.IN_ID%>", "PR_id" : "<%=outer.PR_ID%>", "TR_id" : "<%=outer.TR_ID%>", "R_id" : "<%=outer.R_ID%>", "TREAT_DATE" : "<%=outer.TREAT_DATE%>", "PATNT_DATE" : "<%=outer.PATNT_NAME%>", "CID" : "<%=outer.CID%>", "DOC" : "<%=outer.DOC%>", "INSUR" : "<%=outer.INSUR%>", "INSUR_CHARGE" : "<%=outer.INSUR_CHARGE%>", "HANDI_CHARGE" : "<%=outer.HANDI_CHARGE%>" , "SUP" : "<%=outer.SUP%>", "PATNT_CHARGE" : "<%=outer.PATNT_CHARGE%>", "TOTAL_CHARGE" : "<%=outer.TOTAL_CHARGE%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	conn.close();
%>
