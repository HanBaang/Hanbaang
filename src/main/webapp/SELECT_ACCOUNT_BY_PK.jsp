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
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_ACCOUNT dao_ACC = dao.SELECT_ACCOUNT_BY_PK(1, conn);
%>


{ "object" : [

{"AC_id" : "<%=dao_ACC.AC_id%>", "ID" : "<%=dao_ACC.ID%>", "PW" : "<%=dao_ACC.PW%>", "HOSPI_NAME" : "<%=dao_ACC.HOSPI_NAME%>", "ORG_NUM" : "<%=dao_ACC.ORG_NUM%>", "COMP_NUM" : "<%=dao_ACC.COMP_NUM%>", "MAIL" : "<%=dao_ACC.MAIL%>", "ADDR" : "<%=dao_ACC.ADDR%>"}

	]
}
<%
	conn.close();
%>
