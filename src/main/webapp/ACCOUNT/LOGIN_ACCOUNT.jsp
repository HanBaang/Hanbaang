<%@page import="hanbaang.DBConnection"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DTO.DTO_ACCOUNT"%>
<%@page import="hanbaang.*"%>
<%@page import="Data.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>


<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	DTO_ACCOUNT result = (DTO_ACCOUNT) request.getAttribute("ID");
	String ID = (String) request.getSession().getAttribute("userID");
	
	//String ID = (String)session.getAttribute("userID");
	if(result == null){
		%>
		"Fail"
		<%
	}
	 else {
%>

{ "object" : [ { "result": "<%=result.ID%>" }, { "result": "<%=result.HOSPI_NAME%>" }] }


<%
	}
%>