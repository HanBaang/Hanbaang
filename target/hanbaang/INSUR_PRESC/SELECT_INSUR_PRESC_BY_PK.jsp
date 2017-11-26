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
DTO_INSUR_PRESC dto_IP = (DTO_INSUR_PRESC)request.getAttribute("result");
%>


{ "object" : [

{"IP_id" : "<%=dto_IP.IP_ID%>", "IP_CODE" : "<%=dto_IP.IP_CODE%>", "IP_NAME" : "<%=dto_IP.IP_NAME%>", "SUB_NAME" : "<%=dto_IP.SUB_NAME%>", "IP_COMP_NAME" : "<%=dto_IP.IP_COMP_NAME%>", "IP_WEIGHT" : "<%=dto_IP.IP_WEIGHT%>", "IP_PRICE" : "<%=dto_IP.IP_PRICE%>"}

	]
}
<%

%>
