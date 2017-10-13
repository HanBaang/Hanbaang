<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");
	String str = request.getParameter("id");

	if(str!=null){
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>
아이디: <%=str %>

</body>
</html>
<%}else {%>
아이디: 없옹
<%}%>