<%@page import="hanbaang.DBConnection"%>

<%@page import="DTO.*"%>
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
	DAO dao = DAO.getInstance();
	LinkedList<DTO_PHYSIC> dto_PH = dao.SELECT_PHYSIC(conn);
%>


{ "object" : [
<%
	Iterator<DTO_PHYSIC> iterator = dto_PH.iterator();
	while (iterator.hasNext()) {
		DTO_PHYSIC outer = iterator.next();
%>
{"PH_id" : "<%=outer.PH_ID%>", "PR_id" : "<%=outer.PR_ID%>", "TR_id" : "<%=outer.TR_ID%>", "R_id" : "<%=outer.R_ID%>", "PH_TYPE" : "<%=outer.PH_TYPE%>", "PART_CODE" : "<%=outer.PART_CODE%>", "INSUR" : "<%=outer.INSUR%>"}<%=iterator.hasNext() ? "," : ""%>
<%
	}
%>
	]
}
<%
	conn.close();
%>
