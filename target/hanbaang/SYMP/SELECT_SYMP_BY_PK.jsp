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
	
	DTO_SYMP dto_SY = (DTO_SYMP)request.getAttribute("result");%>


{ "object" : [

{"SY_id" : "<%=dto_SY.SY_ID%>", "TR_id" : "<%=dto_SY.TR_ID%>", "SYMP_CODE" : "<%=dto_SY.SYMP_CODE%>", "SYMP_NAME" : "<%=dto_SY.SYMP_NAME%>",  "INSUR" : "<%=dto_SY.INSUR%>"}
	]
}

