<%@page import="hanbaang.DBConnection"%>

<%@page import="DTO.*"%>
<%@page import="hanbaang.*"%>
<%@page import="Data.*"%>
<%@page import="Data.JsonHelper"%>
<%@page import="DAO.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>


<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	
	LinkedList<DTO_PATNT> dto_PA = (LinkedList<DTO_PATNT>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_PATNT> iterator = dto_PA.iterator();
	while (iterator.hasNext()) {
		DTO_PATNT outer = iterator.next();
%>
{"PA_id" : "<%=outer.PA_ID%>", "PATNT_NAME" : "<%=outer.PATNT_NAME%>", "H_INSUR_NUM" : "<%=outer.H_INSUR_NUM%>", "CID" : "<%=outer.CID%>", "GEND" : "<%=outer.GEND%>", "MAIL" : "<%=outer.MAIL%>", "ADDR" : "<%=outer.ADDR%>" , "ADDR_DETAIL" : "<%=outer.ADDR_DETAIL%>", "MDOC" : "<%=outer.MDOC%>", "REG_DATE" : "<%=outer.REG_DATE%>", "MOD_DATE" : "<%=outer.MOD_DATE%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
