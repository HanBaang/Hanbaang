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
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_TREAT dto_TR = new DTO_TREAT();
	boolean result = dao.UPDATE_TREAT_BY_PK(dto_TR, conn);
%>


{ "object" : [

{}

	]
}
<%
	conn.close();
%>
