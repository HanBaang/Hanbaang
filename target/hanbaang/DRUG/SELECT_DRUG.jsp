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
	LinkedList<DTO_DRUG> dto_DR = dao.SELECT_DRUG(conn);
%>


{ "object" : [
<%
	Iterator<DTO_DRUG> iterator = dto_DR.iterator();
	while (iterator.hasNext()) {
		DTO_DRUG outer = iterator.next();
%>
{"DR_id" : "<%=outer.DR_ID%>", "PR_id" : "<%=outer.PR_ID%>", "TR_id" : "<%=outer.TR_ID%>", "R_id" : "<%=outer.R_ID%>", "DRUG_CODE" : "<%=outer.DRUG_CODE%>", "DRUG_BRAND" : "<%=outer.DRUG_BRAND%>", "DRUG_WEIGHT" : "<%=outer.DRUG_WEIGHT%>", "DRUG_MEMO" : "<%=outer.DRUG_MEMO%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	conn.close();
%>
