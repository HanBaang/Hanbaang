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
	DTO_PATNT dto_PA = new DTO_PATNT();
	boolean result = dao.UPDATE_PATNT_BY_PK(dto_PA, conn);
%>


{ "object" : [

{}

	]
}
<%
	conn.close();
%>
