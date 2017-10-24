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
	String R_id = request.getParameter("R_id");
	
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_RECEP dto_R = new DTO_RECEP();
	boolean result = dao.INSERT_RECEP(dto_R, conn);
%>

{ "object" : [

{	}

	]
}

<%
	conn.close();
%>
