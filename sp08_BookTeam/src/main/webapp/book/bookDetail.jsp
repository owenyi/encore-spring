<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<td>도서번호</td><td>${book.isbn}</td>
			</tr>
			<tr>
				<td>도서제목</td><td>${book.title}</td>
			</tr>
			<tr>
				<td>도서종류</td><td>${book.catalogue}</td>
			</tr>
			<tr>
				<td>출판국가</td><td>${book.nation}</td>
			</tr>
			<tr>
				<td>출판일</td><td>${book.publishDate}</td>
			</tr>
			<tr>
				<td>출판사</td><td>${book.publisher}</td>
			</tr>
			<tr>
				<td>저자</td><td>${book.author}</td>
			</tr>
			<tr>
				<td>도서가격</td><td>${book.price}</td>
			</tr>
			<tr>
				<td>요약내용</td><td>${book.description}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>