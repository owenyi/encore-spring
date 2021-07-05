<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#selectedDel').click(function() {
			var checked = $('.checkbox:checked');
			if (checked.length == 0) {
				alert("삭제할 항목을 체크해주세요.")
				return;
			}
			// get으로 요청 보내기
			/* let url = "delete.do?"
			$(':checkbox:checked').each(function(index, item) {
					url += "num" + $(item).val() + "&";
			}); */
			
			var nums = new Array();
			for (var i = 0; i < checked.length; i++)
				nums.push(checked[i].value);
			data = new Object();
			data.nums = nums.toString();
			$.ajax({
				type: "post",
				url: "delPhone.do",
				data: data,
				
				success: function(result) {
					location.reload();
				},
				
				error: function(xhr, status, message) { // error callback fct.
					alert("error : " + message);
				}
			});
		});
	});
</script>
</head>

<style type="text/css">
	table {
		  margin : auto auto;
	      border-collapse: collapse;
	      border-top: 2px solid #168;
	      width: 30%;
	    }  
    table th {
      color: #168;
      background: #f0f6f9;
      text-align: center;
    }
    table th, table td {
      padding: 5px;
      border: 0.5px solid #ddd;
      border-left: 0;
      border-right: 0;
      text-align: center;
    }
  </style>
</head>
<body>	
	<jsp:include page="/header.jsp"/>
	<br>
	<table>
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>	
		<c:forEach items="${phones}" var="phone">
			<tr>
				<td><a href="detail.do?num=${phone.num}">${phone.num}</a></td>
				<td>${phone.model}</td>
				<td>${phone.price}</td>
				<td>${phone.company.vendor}</td> <!-- 제조사 코드가 아닌 제조사이름으로 받아온다.  -->
				<td><input type="checkbox" class="checkbox" value="${phone.num}"></td>
			</tr>
		</c:forEach>	
	</table>
	<div align="center">
		<a href="regPhone.do">추가 등록</a>&nbsp;
		<a href="javascript:void(0);" id="selectedDel">선택항목삭제</a>
	</div>
</body>
</html>