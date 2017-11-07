<%@page import="hanbaang.DBConnection"%>
<%@page import="DTO.*"%>
<%@page import="hanbaang.*"%>
<%@page import="Data.*"%>
<%@page import="DTO.*"%>
<%@page import="DAO.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	Boolean result = (Boolean)request.getAttribute("result");
	if(result==null)
		result=false;
	
	if(result){
		
	} else {
		
%>

{ "object" : [ { "result": "<%=result%>" } ] }

<%
	}

%>
