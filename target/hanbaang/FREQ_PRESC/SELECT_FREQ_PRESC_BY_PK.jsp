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
	String FP_ID =request.getParameter("FP_id");
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_FREQ_PRESC dto_PR = dao.SELECT_FREQ_PRESC_BY_PK(Integer.parseInt(FP_ID), conn);
%>


{ "object" : [

{"FP_id" : "<%=dto_PR.FP_ID%>", "PRESC_NAME" : "<%=dto_PR.PRESC_NAME%>", "DRUG_NAME" : "<%=dto_PR.DRUG_NAME%>"}

	]
}
<%
	conn.close();
%>
