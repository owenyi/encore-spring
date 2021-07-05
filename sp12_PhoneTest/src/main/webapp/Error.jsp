<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<table width="30%" border=0 cellpadding=0 cellspacing=0>
		<tr><td align="center" bgcolor="DBE8DC"><b>처리 중 문제가 발생하였습니다.</b></td></tr>
		<tr><td align="center" bgcolor="A4A4A4"><b>message</b></td></tr>
		<tr><td align="center" bgcolor="A4A4A4"><b>${message}</b></td></tr>
	</table>
</body>
</html>