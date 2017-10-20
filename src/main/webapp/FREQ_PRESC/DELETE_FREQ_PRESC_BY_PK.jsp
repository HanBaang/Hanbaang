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
	String FP_id = request.getParameter("FP_id");
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_FREQ_PRESC dto_FP = new DTO_FREQ_PRESC();
	boolean result = dao.DELETE_FREQ_PRESC_BY_PK(Integer.parseInt(FP_id), conn);
%>
{ "object" : [


	]
}
<%
	conn.close();
%>
