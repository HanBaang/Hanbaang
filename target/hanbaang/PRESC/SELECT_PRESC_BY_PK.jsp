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
	
	DTO_PRESC dto_PR = (DTO_PRESC)request.getAttribute("result");%>


{ "object" : [

{"PR_id" : "<%=dto_PR.PR_ID%>", "TR_id" : "<%=dto_PR.TR_ID%>", "R_id" : "<%=dto_PR.R_ID%>", "CHUP" : "<%=dto_PR.CHUP%>", "PACK" : "<%=dto_PR.PACK%>", "STD_VOL" : "<%=dto_PR.STD_VOL%>", "WATER_VOL" : "<%=dto_PR.WATER_VOL%>", "INSUR" : "<%=dto_PR.INSUR%>", "REG_DATE" : "<%=dto_PR.REG_DATE%>", "MOD_DATE" : "<%=dto_PR.MOD_DATE%>" , "FREQ" : "<%=dto_PR.FREQ%>"}

	]
}
<%
	
%>
