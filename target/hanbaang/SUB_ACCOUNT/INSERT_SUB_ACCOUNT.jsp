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
	String AC_id = request.getParameter("AC_id");
	
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_SUB_ACCOUNT dto_SA = new DTO_SUB_ACCOUNT();
	boolean result = dao.INSERT_SUB_ACCOUNT(dto_SA, conn);
%>

{ "object" : [

{}

	]
}

<%
	conn.close();
%>
