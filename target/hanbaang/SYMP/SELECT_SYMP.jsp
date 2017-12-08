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
	
	LinkedList<DTO_SYMP> dto_SY = (LinkedList<DTO_SYMP>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_SYMP> iterator = dto_SY.iterator();
	while (iterator.hasNext()) {
		DTO_SYMP outer = iterator.next();
%>
{"SY_id" : "<%=outer.SY_ID%>", "TR_id" : "<%=outer.TR_ID%>", "SYMP_CODE" : "<%=outer.SYMP_CODE%>", "SYMP_NAME" : "<%=outer.SYMP_NAME%>",  "INSUR" : "<%=outer.INSUR%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}

