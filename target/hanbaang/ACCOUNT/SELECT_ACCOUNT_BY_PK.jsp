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
	String AC_ID = request.getParameter("AC_ID");
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_ACCOUNT dto_ACC = dao.SELECT_ACCOUNT_BY_PK(Integer.parseInt(AC_ID), conn);
%>


{ "object" : [

{"AC_id" : "<%=dto_ACC.AC_id%>", "ID" : "<%=dto_ACC.ID%>", "PW" : "<%=dto_ACC.PW%>", "HOSPI_NAME" : "<%=dto_ACC.HOSPI_NAME%>", "ORG_NUM" : "<%=dto_ACC.ORG_NUM%>", "COMP_NUM" : "<%=dto_ACC.COMP_NUM%>", "MAIL" : "<%=dto_ACC.MAIL%>", "ADDR" : "<%=dto_ACC.ADDR%>", "ADDR_DETAIL" : "<%=dto_ACC.ADDR_DETAIL%>", "REG_DATE" : "<%=dto_ACC.REG_DATE%>", "MOD_DATE" : "<%=dto_ACC.MOD_DATE%>"}

	]
}
<%
	conn.close();
%>
