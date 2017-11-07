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
	
	LinkedList<DTO_PRESC> dto_PR = (LinkedList<DTO_PRESC>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_PRESC> iterator = dto_PR.iterator();
	while (iterator.hasNext()) {
		DTO_PRESC outer = iterator.next();
%>
{"PR_id" : "<%=outer.PR_ID%>", "TR_id" : "<%=outer.TR_ID%>", "R_id" : "<%=outer.R_ID%>", "CHUP" : "<%=outer.CHUP%>", "PACK" : "<%=outer.PACK%>", "STD_VOL" : "<%=outer.STD_VOL%>", "WATER_VOL" : "<%=outer.WATER_VOL%>", "INSUR" : "<%=outer.INSUR%>", "REG_DATE" : "<%=outer.REG_DATE%>", "MOD_DATE" : "<%=outer.MOD_DATE%>" , "FREQ" : "<%=outer.FREQ%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}

