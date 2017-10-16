<%@page import="hanbaang.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>

<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
    String id = "111";
    TestDAO dao = TestDAO.getInstance();
    DTO dto = dao.selectTestById(id);
    if(dto==null){
%>
    조회결과가 없습니다.
<%}else{ %>
    조회결과
    ID:<%=dto.getId() %>
    PW : <%=dto.getNum() %>
<%} %>
