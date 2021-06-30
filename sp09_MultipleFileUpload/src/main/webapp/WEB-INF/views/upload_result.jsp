<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>Upload File OK~~~~~</b><p>
	<hr>
	<ul>
		<li>File DownLoad &nbsp; &nbsp; &nbsp; &nbsp;</li>
		<c:forEach items="${uploadfiles}" var="uploadfile">
			<li><a href="fileDown.do?filename=${uploadfile}">
				${uploadfile}
			</a></li>
		</c:forEach>
	</ul>
</body>
</html>