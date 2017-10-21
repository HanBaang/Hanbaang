<%@page import="hanbaang.DBConnection"%>

<%@page import="DTO.*"%>
<%@page import="hanbaang.*"%>
<%@page import="Data.*"%>
<%@page import="DAO.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>


<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	LinkedList<DTO_INSUR_DETAIL> dto_ID = dao.SELECT_INSUR_DETAIL(conn);
%>


{ "object" : [
<%
	Iterator<DTO_INSUR_DETAIL> iterator = dto_ID.iterator();
	while (iterator.hasNext()) {
		DTO_INSUR_DETAIL outer = iterator.next();
%>
{"IN_id" : "<%=outer._ID%>", "PR_id" : "<%=outer.PR_ID%>", "TR_id" : "<%=outer.TR_ID%>", "R_id" : "<%=outer.R_ID%>", "TREAT_NAME" : "<%=outer.TREAT_NAME%>", "TREAT_CODE" : "<%=outer.TREAT_CODE%>", "PART" : "<%=outer.PART%>", "ONCE_DOSE" : "<%=outer.ONCE_DOSE%>", "TOTAL_DOSE" : "<%=outer.TOTAL_DOSE%>", "TOTAL_CHARGE" : "<%=outer.TOTAL_CHARGE%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	conn.close();
%>
