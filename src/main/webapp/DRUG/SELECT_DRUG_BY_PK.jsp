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
DTO_DRUG dto_DR = (DTO_DRUG)request.getAttribute("result");
%>


{ "object" : [

{"DR_id" : "<%=dto_DR.DR_ID%>", "PR_id" : "<%=dto_DR.PR_ID%>", "DRUG_CODE" : "<%=dto_DR.DRUG_CODE%>", "DRUG_COMP_NAME" : "<%=dto_DR.DRUG_COMP_NAME%>", "DRUG_NAME" : "<%=dto_DR.DRUG_NAME%>", "DRUG_WEIGHT" : "<%=dto_DR.DRUG_WEIGHT%>", "DRUG_MEMO" : "<%=dto_DR.DRUG_MEMO%>", "INSUR" : "<%=dto_DR.INSUR%>", "TYPE" : "<%=dto_DR.TYPE%>", "TYPE_ID" : "<%=dto_DR.TYPE_ID%>"}
	]
}
<%

%>
