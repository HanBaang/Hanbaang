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
	String DR_id = request.getParameter("DR_id");

	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_DRUG dto_DR = new DTO_DRUG();
	boolean result = dao.DELETE_DRUG_BY_PK(Integer.parseInt(DR_id), conn);
%>
{ "object" : [

{
}
	]
}
<%
	conn.close();
%>
