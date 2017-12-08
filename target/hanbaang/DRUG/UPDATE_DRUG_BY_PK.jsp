<%@page import="hanbaang.DBConnection"%>
<%@page import="DTO.*"%>
<%@page import="hanbaang.*"%>
<%@page import="Data.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>


<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	boolean result = (Boolean) request.getAttribute("result");

	if(result == false){
		%>
		"Fail"
		<%
	}
	else{
%>


{ "object" : [ { "result" : "<%=result%>" } ] }
<%
	}
%>


