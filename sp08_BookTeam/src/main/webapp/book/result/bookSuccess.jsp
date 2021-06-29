<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		h2 {
			text-align: center;
			margin-top: 20px;
		}
		p {
			text-align: center;
		}
		p span {
			color: orange;
		}
		a {
			margin: 5px;
		}
	</style>
</head>
<body>
	<h2>결과 페이지</h2>
	<p><span> ${bvo.title}</span>
		정상적으로 저장 되었습니다</p>
	<a href="book/Book.jsp">추가 등록</a>
	<a href="booklist.do">도서 목록</a>	
</body>
</html>