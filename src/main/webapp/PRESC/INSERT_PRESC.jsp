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
	String PR_id = request.getParameter("PR_id");
	
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_PRESC dto_PR = new DTO_PRESC();
	boolean result = dao.INSERT_PRESC(dto_PR, conn);
%>

{ "object" : [

{	}

	]
}

<%
	conn.close();
%>
