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
	String ID_id = request.getParameter("ID_id");
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_INSUR_DETAIL dto_ID = new DTO_INSUR_DETAIL();
	boolean result = dao.DELETE_INSUR_DETAIL_BY_PK(Integer.parseInt(ID_id), conn);
%>
{ "object" : [


	]
}
<%
	conn.close();
%>
