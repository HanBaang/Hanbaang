<%@page import="hanbaang.*"%>
<%@page import="DTO.*"%>
<%@page import="Data.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%
	String PA_id = request.getParameter("PA_id");
	String PATNT_NAME = request.getParameter("PATNT_NAME");
	String H_INSUR_NUM = request.getParameter("H_INSUR_NUM");
	String CID = request.getParameter("CID");
	String GEND = request.getParameter("GEND");
	String PHONE = request.getParameter("PHONE");
	String MAIL = request.getParameter("MAIL");
	String ADDR = request.getParameter("ADDR");
	String ADDR_DETAIL = request.getParameter("ADDR_DETAIL");
	String MDOC = request.getParameter("MDOC");

// 날짜 설정
	String REG = request.getParameter("REG_DATE");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date REG_DATE = new Date(sdf.parse(REG).getTime());
	String MOD = request.getParameter("MOD_DATE");
	Date MOD_DATE = new Date(sdf.parse(MOD).getTime());
	Connection conn = DBConnection.getConnection();
	DAO dao = DAO.getInstance();
	DTO_PATNT dto_PA = new DTO_PATNT(Integer.parseInt(PA_id), PATNT_NAME, H_INSUR_NUM, CID, Integer.parseInt(GEND), PHONE, MAIL, ADDR, ADDR_DETAIL, MDOC, REG_DATE, MOD_DATE);
	boolean result = dao.UPDATE_PATNT_BY_PK(dto_PA, conn);
%>


{ "object" : [

{}

	]
}
<%
	conn.close();
%>
