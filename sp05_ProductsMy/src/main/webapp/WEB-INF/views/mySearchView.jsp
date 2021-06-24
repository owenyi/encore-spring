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
	<c:choose>
		<c:when test="${myproduct != null}">
			품  번 : ${myproduct.id}<br>
			상품명 : ${myproduct.name}<br>
			제조사 : ${myproduct.maker}<br>
			가  격 : ${myproduct.price}
		</c:when>
		<c:otherwise>
			찾으시는 상품이 없습니다.
		</c:otherwise>
	</c:choose>
</body>
</html>