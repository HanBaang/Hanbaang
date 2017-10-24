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
String DR_ID = request.getParameter("DR_ID");
String PR_ID = request.getParameter("PR_ID");
String TR_ID = request.getParameter("TR_ID");
String R_ID = request.getParameter("R_ID");
String DRUG_CODE = request.getParameter("DRUG_CODE");
String DRUG_BRAND = request.getParameter("DRUG_BRAND");
String DRUG_WEIGHT = request.getParameter("DRUG_WEIGHT");
String DRUG_MEMO = request.getParameter("DRUG_MEMO");


	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_DRUG dto_DR = new DTO_DRUG(Integer.parseInt(DR_ID),Integer.parseInt(PR_ID),Integer.parseInt(TR_ID),Integer.parseInt(R_ID),DRUG_CODE,DRUG_BRAND,Integer.parseInt(DRUG_WEIGHT),DRUG_MEMO);
	boolean result = dao.UPDATE_DRUG_BY_PK(dto_DR, conn);
%>


{ "object" : [

{}

	]
}
<%
	conn.close();
%>
