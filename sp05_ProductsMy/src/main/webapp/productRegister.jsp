<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Product Register Form...</h2>
	<form action="myProduct.do" method="post">
		상품명 : <input type="text" name="name"><br><br>
		제조사 : <input type="text" name="maker"><br><br>
		가  격 : <input type="text" name="price"><br><br>
		<input type="submit" value="상품등록">
	</form>
	+++++++++++++++++++++++++++++++++++++++++++++++++
	<form action="mySearch.do" method="post">
		상품검색 : <input type="text" name="word"><br><br>
		<input type="submit" value="상품찾기">
	</form>
</body>
</html>