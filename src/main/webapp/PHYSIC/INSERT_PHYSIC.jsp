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
	String PH_id = request.getParameter("PH_id");
	
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_PHYSIC dto_PH = new DTO_PHYSIC();
	boolean result = dao.INSERT_PHYSIC(dto_PH, conn);
%>

{ "object" : [

{	}

	]
}

<%
	conn.close();
%>
