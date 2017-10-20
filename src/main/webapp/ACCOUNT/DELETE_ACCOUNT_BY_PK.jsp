<%@page import="hanbaang.DBConnection"%>

<%@page import="DTO.DTO_ACCOUNT"%>
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
	DTO_ACCOUNT dto_ACC = new DTO_ACCOUNT();
	boolean result = dao.DELETE_ACCOUNT_BY_PK(Integer.parseInt(AC_id), conn);
%>
{ "object" : [

{}
	]
}
<%
	conn.close();
%>
