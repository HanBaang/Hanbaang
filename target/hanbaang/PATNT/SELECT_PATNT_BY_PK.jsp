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
	
	DTO_PATNT dto_PA = (DTO_PATNT)request.getAttribute("result");
%>


{ "object" : [

{"PA_id" : "<%=dto_PA.PA_ID%>", "PATNT_NAME" : "<%=dto_PA.PATNT_NAME%>", "H_INSUR_NUM" : "<%=dto_PA.H_INSUR_NUM%>", "CID" : "<%=dto_PA.CID%>", "GEND" : "<%=dto_PA.GEND%>", "MAIL" : "<%=dto_PA.MAIL%>", "ADDR" : "<%=dto_PA.ADDR%>" , "ADDR_DETAIL" : "<%=dto_PA.ADDR_DETAIL%>", "MDOC" : "<%=dto_PA.MDOC%>", "REG_DATE" : "<%=dto_PA.REG_DATE%>", "MOD_DATE" : "<%=dto_PA.MOD_DATE%>"}

	]
}
