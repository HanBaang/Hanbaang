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
	
	DTO_RECEP dto_R = (DTO_RECEP)request.getAttribute("result");%>


{ "object" : [

{"R_id" : "<%=dto_R.R_ID%>", "PA_id" : "<%=dto_R.PA_ID%>", "SA_id" : "<%=dto_R.SA_ID%>", "PATNT_NAME" : "<%=dto_R.PATNT_NAME%>", "RECEP_DATE" : "<%=dto_R.RECEP_DATE%>", "STATE" : "<%=dto_R.STATE%>", "MEMO" : "<%=dto_R.MEMO%>", "MDOC" : "<%=dto_R.MDOC%>", "STAFF_NAME" : "<%=dto_R.STAFF_NAME%>"}

	]
}

