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
	
	LinkedList<DTO_FREQ_PRESC> dto_FP = (LinkedList<DTO_FREQ_PRESC>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_FREQ_PRESC> iterator = dto_FP.iterator();
	while (iterator.hasNext()) {
		DTO_FREQ_PRESC outer = iterator.next();
%>
{"FP_id" : "<%=outer.FP_ID%>", "PRESC_NAME" : "<%=outer.PRESC_NAME%>", "DRUG_NAME" : "<%=outer.DRUG_NAME%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	%>
