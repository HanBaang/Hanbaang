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
DTO_INSUR_DRUG dto_IDR = (DTO_INSUR_DRUG)request.getAttribute("result");
%>


{ "object" : [

{"IDR_id" : "<%=dto_IDR.IDR_ID%>", "IDR_CODE" : "<%=dto_IDR.IDR_CODE%>", "IDR_NAME" : "<%=dto_IDR.IDR_NAME%>", "IDR_COMP_NAME" : "<%=dto_IDR.IDR_COMP_NAME%>", "IDR_WEIGHT" : "<%=dto_IDR.IDR_WEIGHT%>", "IDR_PRICE" : "<%=dto_IDR.IDR_PRICE%>"}

	]
}
<%

%>
