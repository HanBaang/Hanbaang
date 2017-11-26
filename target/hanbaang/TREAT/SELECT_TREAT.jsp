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
	
	LinkedList<DTO_TREAT> dto_TR = (LinkedList<DTO_TREAT>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_TREAT> iterator = dto_TR.iterator();
	while (iterator.hasNext()) {
		DTO_TREAT outer = iterator.next();
%>
{"TR_id" : "<%=outer.TR_ID%>", "R_id" : "<%=outer.R_ID%>", "SYMP_NAME" : "<%=outer.SYMP_NAME%>", "MEMO" : "<%=outer.MEMO%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}

