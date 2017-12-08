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
	DTO_TREAT dto_TR = (DTO_TREAT)request.getAttribute("result");%>


{ "object" : [

{"TR_id" : "<%=dto_TR.TR_ID%>", "R_id" : "<%=dto_TR.R_ID%>", "MEMO" : "<%=dto_TR.MEMO%>"}

	]
}
