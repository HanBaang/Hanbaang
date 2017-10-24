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
	DTO_FREQ_PRESC dto_FP = new DTO_FREQ_PRESC();
	boolean result = dao.UPDATE_FREQ_PRESC_BY_PK(dto_FP, conn);
%>


{ "object" : [

{}

	]
}
<%
	conn.close();
%>
