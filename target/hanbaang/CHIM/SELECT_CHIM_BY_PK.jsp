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
	
	DTO_CHIM dto_C = (DTO_CHIM)request.getAttribute("result");%>


{ "object" : [

{"CH_id" : "<%=dto_C.CH_ID%>", "CODE" : "<%=dto_C.CODE%>", "NAME" : "<%=dto_C.NAME%>", "C_NAME" : "<%=dto_C.C_NAME%>", "PART" : "<%=dto_C.PART%>"}

	]
}

