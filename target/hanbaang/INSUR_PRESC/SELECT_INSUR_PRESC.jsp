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
	
	LinkedList<DTO_INSUR_PRESC> dto_IP = (LinkedList<DTO_INSUR_PRESC>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_INSUR_PRESC> iterator = dto_IP.iterator();
	while (iterator.hasNext()) {
		DTO_INSUR_PRESC outer = iterator.next();
%>
{"IP_id" : "<%=outer.IP_ID%>", "IP_CODE" : "<%=outer.IP_CODE%>", "IP_NAME" : "<%=outer.IP_NAME%>", "SUB_NAME" : "<%=outer.SUB_NAME%>", "IP_COMP_NAME" : "<%=outer.IP_COMP_NAME%>", "IP_WEIGHT" : "<%=outer.IP_WEIGHT%>", "IP_PRICE" : "<%=outer.IP_PRICE%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	
%>
