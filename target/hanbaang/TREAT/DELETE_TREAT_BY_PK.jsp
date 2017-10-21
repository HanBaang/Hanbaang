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
	String TR_id = request.getParameter("TR_id");

	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_TREAT dto_TR = new DTO_TREAT();
	boolean result = dao.DELETE_TREAT_BY_PK(Integer.parseInt(TR_id), conn);
%>
{ "object" : [

{
}
	]
}
<%
	conn.close();
%>
