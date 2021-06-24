<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width = "500" align = 'center'>
		<tr  bgcolor = "#D8D8D8">
			<th>품  번</th><th>상품명</th><th>제조사</th><th>가  격</th>
		</tr>
		<c:forEach items="${list}" var="myproduct">
			<tr align = 'center'>
				<td>${myproduct.id}</td>
				<td>${myproduct.name}</td>
				<td>${myproduct.maker}</td>
				<td>${myproduct.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>