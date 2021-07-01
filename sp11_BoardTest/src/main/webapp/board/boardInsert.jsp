<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form method="post"
		action="../boardInsert.do"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="contents"></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="uploadFile"></td>
			</tr>
			<tr>
				<td><input type="submit" value="작성"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>

</body>
</html>