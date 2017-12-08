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
	
	LinkedList<DTO_DRUG> dto_DR = (LinkedList<DTO_DRUG>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_DRUG> iterator = dto_DR.iterator();
	while (iterator.hasNext()) {
		DTO_DRUG outer = iterator.next();
%>
{"DR_id" : "<%=outer.DR_ID%>", "PR_id" : "<%=outer.PR_ID%>", "DRUG_CODE" : "<%=outer.DRUG_CODE%>", "DRUG_COMP_NAME" : "<%=outer.DRUG_COMP_NAME%>", "DRUG_NAME" : "<%=outer.DRUG_NAME%>", "DRUG_WEIGHT" : "<%=outer.DRUG_WEIGHT%>", "DRUG_MEMO" : "<%=outer.DRUG_MEMO%>", "INSUR" : "<%=outer.INSUR%>", "TYPE" : "<%=outer.TYPE%>", "TYPE_ID" : "<%=outer.TYPE_ID%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	
%>
