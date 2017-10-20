<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//코드테이블
//관리자 : 1
//일반사용자 : 2
//실패 : 3 
String id = request.getParameter("usrname");
String pwd = request.getParameter("psw");
//디비 접속후 id, pw값이 일치한다면 
session.setAttribute("id", id); 

%>
<%=id%>
