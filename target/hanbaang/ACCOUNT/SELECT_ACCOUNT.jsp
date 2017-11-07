<%@page import="hanbaang.DBConnection"%>

<%@page import="DTO.DTO_ACCOUNT"%>
<%@page import="hanbaang.*"%>
<%@page import="Data.*"%>
<%@page import="DAO.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>


<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%

	LinkedList<DTO_ACCOUNT> dto_ACC = (LinkedList<DTO_ACCOUNT>)request.getAttribute("result");
%>


{ "object" : [
<%
	Iterator<DTO_ACCOUNT> iterator = dto_ACC.iterator();
	while (iterator.hasNext()) {
		DTO_ACCOUNT outer = iterator.next();
%>
{"AC_id" : "<%=outer.AC_id%>", "ID" : "<%=outer.ID%>", "PW" : "<%=outer.PW%>", "HOSPI_NAME" : "<%=outer.HOSPI_NAME%>", "ORG_NUM" : "<%=outer.ORG_NUM%>", "COMP_NUM" : "<%=outer.COMP_NUM%>", "MAIL" : "<%=outer.MAIL%>", "ADDR" : "<%=outer.ADDR%>", "ADDR_DETAIL" : "<%=outer.ADDR_DETAIL%>", "REG_DATE" : "<%=outer.REG_DATE%>", "MOD_DATE" : "<%=outer.MOD_DATE%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
