<%@page import="com.encore.spring.domain.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%-- 로그아웃 로직..
 1, 세션에 바인딩된 정보가 있다면(로그인된상태라면) 로그아웃
 2. 세션을 죽인다
 3. 다시 홈으로 --%>
    
   <% UserVO vo = (UserVO)session.getAttribute("vo");
   if(vo ==null){
	  %>
	  <b><a href="../../login.jsp">로그인</a></b>
	 <% 
   }else{
	   session.invalidate();
   }%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function logoutpop(){
	alert("logout");
}
</script>
</head>
<body onload="return logoutpop()">
	<b>로그아웃 되셨습니다</b><br/>
	<a href="../../login.jsp">home...</a>
</body>
</html>






