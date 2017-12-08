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
	
	LinkedList<DTO_CHIM> dto_C = (LinkedList<DTO_CHIM>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_CHIM> iterator = dto_C.iterator();
	while (iterator.hasNext()) {
		DTO_CHIM outer = iterator.next();
%>
{"CH_id" : "<%=outer.CH_ID%>", "CODE" : "<%=outer.CODE%>", "NAME" : "<%=outer.NAME%>", "C_NAME" : "<%=outer.C_NAME%>", "PART" : "<%=outer.PART%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}

