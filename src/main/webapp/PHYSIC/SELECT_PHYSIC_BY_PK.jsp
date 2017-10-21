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
	String PH_ID = request.getParameter("PH_ID");
	
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_PHYSIC dto_PH = dao.SELECT_PHYSIC_BY_PK(Integer.parseInt(PH_ID), conn);
%>


{ "object" : [

{"PH_id" : "<%=dto_PH.PH_ID%>", "PR_id" : "<%=dto_PH.PR_ID%>", "TR_id" : "<%=dto_PH.TR_ID%>", "R_id" : "<%=dto_PH.R_ID%>", "PH_TYPE" : "<%=dto_PH.PH_TYPE%>", "PART_CODE" : "<%=dto_PH.PART_CODE%>", "INSUR" : "<%=dto_PH.INSUR%>"}

	]
}
<%
	conn.close();
%>
