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
	
	LinkedList<DTO_INSUR_DETAIL> dto_ID = (LinkedList<DTO_INSUR_DETAIL>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_INSUR_DETAIL> iterator = dto_ID.iterator();
	while (iterator.hasNext()) {
		DTO_INSUR_DETAIL outer = iterator.next();
%>
{"IN_id" : "<%=outer._ID%>", "TREAT_NAME" : "<%=outer.TREAT_NAME%>", "TREAT_CODE" : "<%=outer.TREAT_CODE%>", "TYPE" : "<%=outer.TYPE%>", "PART" : "<%=outer.PART%>", "ONCE_DOSE" : "<%=outer.ONCE_DOSE%>", "TOTAL_DOSE" : "<%=outer.TOTAL_DOSE%>", "TOTAL_CHARGE" : "<%=outer.TOTAL_CHARGE%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}

