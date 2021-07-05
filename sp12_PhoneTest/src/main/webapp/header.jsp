<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="css/basic.css" rel="stylesheet" type="text/css">
<c:if test="${!empty loginUser}">
	<div>
		
	</div>
</c:if>

<style>
td.header {
	background-color: #f4f4f4;
	height: "22";
	font-weight: bold;
}
td.header>a{
	color:red;
}
</style>

<table width=30% border=0 cellpadding=0 cellspacing=0>
	<tr>
		<td class="header">&nbsp;&nbsp;${title}</td>
		<c:if test="${!empty loginUser}">
			<td class="header">${loginUser.id} 님 로그인 &nbsp;&nbsp;&nbsp; <a href="logout.do">로그아웃</a></td>
		</c:if>
	</tr>
</table> 
<c:url value="/js/jquery-3.3.1.js" var="jquery" />
<script src="${jquery}"></script>