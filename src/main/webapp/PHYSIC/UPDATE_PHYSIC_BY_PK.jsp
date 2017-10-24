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
	DTO_PHYSIC dto_PH = new DTO_PHYSIC();
	boolean result = dao.UPDATE_PHYSIC_BY_PK(dto_PH, conn);
%>


{ "object" : [

{}

	]
}
<%
	conn.close();
%>
