<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycom.mydb.dto.EmpDto" %>
<%
	EmpDto dto = (EmpDto) request.getAttribute("dto");
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Employee Detail
</h1>

<P> <%= dto.getLastName() + " " + dto.getFirstName() %> </P>
</body>
</html>
