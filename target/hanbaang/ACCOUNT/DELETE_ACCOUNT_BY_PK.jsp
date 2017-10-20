<%@page import="hanbaang.DBConnection"%>

<%@page import="DTO.DTO_ACCOUNT"%>
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
	String AC_id = request.getParameter("AC_id");
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_ACCOUNT dto_ACC = new DTO_ACCOUNT();
	boolean result = dao.DELETE_ACCOUNT_BY_PK(dto_ACC, conn);
%>
{ "object" : [

{"AC_id" : "<%=dto_ACC.AC_id%>", "ID" : "<%=dto_ACC.ID%>", "PW" : "<%=dto_ACC.PW%>", "HOSPI_NAME" : "<%=dto_ACC.HOSPI_NAME%>", "ORG_NUM" : "<%=dto_ACC.ORG_NUM%>", "COMP_NUM" : "<%=dto_ACC.COMP_NUM%>", "ADDR" : "<%=dto_ACC.ADDR%>" , "ADDR_DETAIL" : "<%=dto_ACC.ADDR_DETAIL%>", "MAIL" : "<%=dto_ACC.MAIL%>", "REG_DATE" : "<%=dto_ACC.REG_DATE%>, "MOD_DATE" : "<%=dto_ACC.MOD_DATE%>"}

	]
}
<%
	conn.close();
%>
