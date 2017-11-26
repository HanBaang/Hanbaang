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
	
	LinkedList<DTO_INSUR_DRUG> dto_IDR = (LinkedList<DTO_INSUR_DRUG>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_INSUR_DRUG> iterator = dto_IDR.iterator();
	while (iterator.hasNext()) {
		DTO_INSUR_DRUG outer = iterator.next();
%>
{"IDR_id" : "<%=outer.IDR_ID%>", "IDR_CODE" : "<%=outer.IDR_CODE%>", "IDR_NAME" : "<%=outer.IDR_NAME%>", "IDR_COMP_NAME" : "<%=outer.IDR_COMP_NAME%>", "IDR_WEIGHT" : "<%=outer.IDR_WEIGHT%>", "IDR_PRICE" : "<%=outer.IDR_PRICE%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	
%>
