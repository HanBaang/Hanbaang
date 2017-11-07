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
	DTO_FREQ_PRESC dto_PR = (DTO_FREQ_PRESC)request.getAttribute("result");
	%>


{ "object" : [

{"FP_id" : "<%=dto_PR.FP_ID%>", "PRESC_NAME" : "<%=dto_PR.PRESC_NAME%>", "DRUG_NAME" : "<%=dto_PR.DRUG_NAME%>"}

	]
}
<%
	
%>
