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
String SA_id = request.getParameter("SA_id");
Connection conn = DBConnection.getConnection();
DAO dao = DAO.getInstance();
DTO_SUB_ACCOUNT dto_SA = new DTO_SUB_ACCOUNT();
dto_SA = dao.SELECT_SUB_ACCOUNT_BY_PK(Integer.parseInt(SA_id), conn);
%>


{ "object" : [

{"SA_id" : "<%=dto_SA.SA_id%>","AC_id" : "<%=dto_SA.AC_id%>", "ID" : "<%=dto_SA.ID%>", "PW" : "<%=dto_SA.PW%>", "STAFF_NAME" : "<%=dto_SA.STAFF_NAME%>", "ORG_NUM" : "<%=dto_SA.ORG_NUM%>", "COMP_NUM" : "<%=dto_SA.COMP_NUM%>",  "ADDR" : "<%=dto_SA.ADDR%>", "ADDR_DETAIL" : "<%=dto_SA.ADDR_DETAIL%>", "REG_DATE" : "<%=dto_SA.REG_DATE%>", "MOD_DATE" : "<%=dto_SA.MOD_DATE%>"}

	]
}
<%
	conn.close();
%>
