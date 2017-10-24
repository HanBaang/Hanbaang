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
	String PA_id = request.getParameter("PA_id");

	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_PATNT dto_PA = new DTO_PATNT();
	boolean result = dao.DELETE_PATNT_BY_PK(Integer.parseInt(PA_id), conn);
%>
{ "object" : [

{
}
	]
}
<%
	conn.close();
%>
