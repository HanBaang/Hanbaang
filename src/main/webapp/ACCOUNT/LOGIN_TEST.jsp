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
	
	String ID = (String) request.getSession().getAttribute("userID");
	if(ID == null){
		%>
		{ "object" : [ { "result" : "success" } ] }
		<%
	}
	else{
%>
{ "object" : [ { "result" : "<%=ID%>" } ] }
<%
	}
%>


