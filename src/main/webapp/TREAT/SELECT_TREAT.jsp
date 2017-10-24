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
	LinkedList<DTO_TREAT> dto_TR = dao.SELECT_TREAT(conn);
%>


{ "object" : [
<%
	Iterator<DTO_TREAT> iterator = dto_TR.iterator();
	while (iterator.hasNext()) {
		DTO_TREAT outer = iterator.next();
%>
{"TR_id" : "<%=outer.TR_ID%>", "R_id" : "<%=outer.R_ID%>", "SYMP_NAME" : "<%=outer.SYMP_NAME%>", "MEMO" : "<%=outer.MEMO%>"}<%=iterator.hasNext() ? "," : ""%>

<%
	}
%>
	]
}
<%
	conn.close();
%>
