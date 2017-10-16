<%@page import="hanbaang.DBConnection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedList"%>

<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
				// 쿼리문
				String query = "select id, pw from Test";

				// 커넥션 연결
				Connection conn = DBConnection.getConnection();

				// DB에 쿼리문을 보낸다.
				PreparedStatement pstmt = conn.prepareStatement(query);

				// 쿼리문의 결과값을 rs에 담는다.
				ResultSet rs = pstmt.executeQuery();
				
				// 결과값을 출력한다.
				LinkedList<String[]> result = new LinkedList<String[]>();
				while (rs.next()) {
					String[] temp = new String[2];
					temp[0] = rs.getString("id");
					temp[1] = rs.getString("pw");
					result.add(temp);
				}
			%>
{
"object" : [
	<%
	Iterator<String[]> iterator = result.iterator();
	while(iterator.hasNext()){
	String[] outer = iterator.next();
	%>
	{"id" : "<%=outer[0]%>", "password" : "<%=outer[1]%>"}<%=iterator.hasNext()?",":"" %>
	<%} %>
	]
}