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
	DTO_SUB_ACCOUNT dto_SA = new DTO_SUB_ACCOUNT();
	boolean result = dao.DELETE_SUB_ACCOUNT_BY_PK(dto_SA, conn);
%>
{ "object" : [

{"SA_id" : "<%=dto_SA.SA_id%>","AC_id" : "<%=dto_SA.AC_id%>", "ID" : "<%=dto_SA.ID%>", "PW" : "<%=dto_SA.PW%>", "STAFF_NAME" : "<%=dto_SA.STAFF_NAME%>", "ORG_NUM" : "<%=dto_SA.ORG_NUM%>", "COMP_NUM" : "<%=dto_SA.COMP_NUM%>",  "ADDR" : "<%=dto_SA.ADDR%>"C

	]
}
<%
	conn.close();
%>
