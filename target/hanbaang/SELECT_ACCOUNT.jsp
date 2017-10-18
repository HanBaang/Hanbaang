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
	Connection conn = DBConnection.getConnection();
	DAO_J dao = DAO_J.getInstance();
	LinkedList<DTO_ACCOUNT> dao_ACC = dao.SELECT_ACCOUNT(conn);
%>


{ "object" : [
<%
	Iterator<DTO_ACCOUNT> iterator = dao_ACC.iterator();
	while (iterator.hasNext()) {
		DTO_ACCOUNT outer = iterator.next();
%>
{"AC_id" : "<%=outer.AC_id%>", "ID" : "<%=outer.ID%>", "PW" : "<%=outer.PW%>", "HOSPI_NAME" : "<%=outer.HOSPI_NAME%>", "ORG_NUM" : "<%=outer.ORG_NUM%>", "COMP_NUM" : "<%=outer.COMP_NUM%>", "MAIL" : "<%=outer.MAIL%>", "ADDR" : "<%=outer.ADDR%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	conn.close();
%>
