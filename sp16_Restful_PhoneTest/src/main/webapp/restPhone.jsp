<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(phoneList()); // dom tree ready
	
	function phoneList() {
		$.ajax({
			url: "api/phone",
			type: "get",
			
			error: function(xhr, status, message) {
				alert("error : " + message);
			},
			
			success: function(data) {
				// alert(data[0].num);
				$('#phone-list').empty();
				var temp = "";
				temp += "<table id='phone-list-table'>";
				temp += "<tr> <th>모델번호</th><th>모델이름</th><th>가격</th><th>제조사명</th> </tr>";
				for (var i = 0; i < data.length; i++) {
					var tr = "";
					tr += "<tr>";
					tr += "<td>" + data[i].num + "</td>";
					tr += "<td><a href=javascript:void(0); onclick=phoneInfo('" + data[i].num +"')>" 
						+ data[i].model 
						+ "</a></td>";
					tr += "<td>" + data[i].price + "</td>";
					tr += "<td>" + data[i].company.vendor + "</td>";
					tr += "</tr>";
					temp += tr;
				}
				temp += "</table>";
				$('#phone-list').append(temp);
			} // success
		}); // ajax
	}
	
	function phoneInfo(num) {
		$.ajax({
			url: "api/phone/" + num,
			type: "get",
			
			error: function(xhr, status, message) {
				alert("error : " + message);
			},
			
			success: function(data) {
				// alert(20 == data.vcode);
				$('#phone-info').empty();
				var temp = "";
				temp += "<h2>휴대전화 정보</h2>";
				temp += "<table>";
				temp += "<tr><td>모델번호</td><td><input type='text' name='num' value='" + data.num + "'></td></tr>";
				temp += "<tr><td>모델명</td><td><input type='text' name='model' value='" + data.model + "'></td></tr>";
				temp += "<tr><td>가격</td><td><input type='text' name='price' value='" + data.price + "'></td></tr>";
				temp += "<tr><td>제조사</td><td>";
				temp += "<select name='vendor'>";
				temp += "<option value='10'>삼성</option>";
				temp += "<option value='20'>엘지</option>";
				temp += "<option value='30'>애플</option>";
				temp += "</select>";
				temp += "</td></tr>";
				temp += "</table>";
				temp += "<input type='button' value='추가' onclick=phoneInsert()>";
				temp += "<input type='button' value='수정' onclick=phoneUpdate()>";
				temp += "<input type='button' value='삭제' onclick=phoneDelete('" + num + "')>";
				$('#phone-info').append(temp);
				$('select option[value="' + data.vcode + '"]').attr("selected", true);
			} // success
		}); // ajax
	} // phoneInfo
	
	function phoneInsert() {
		// alert($('select[name=vendor] option:selected').val());
		var data = {
			"num": $('input[name=num]').val(),
			"model": $('input[name=model]').val(),
			"price": $('input[name=price]').val(),
			"vcode": $('select[name=vendor] option:selected').val()
		}
		$.ajax({
			url: "api/phone",
			type: "post",
			data: JSON.stringify(data),
			contentType: "application/json;charset=utf-8",
			
			error: function(xhr, status, message) {
				alert("error : " + message);
			},
			
			success: function(data) {
				alert("폰 추가 완료");
				phoneList();
			} // success
		}); // ajax
	} // phoneInsert
	
	function phoneUpdate() {
		var data = {
			"num": $('input[name=num]').val(),
			"model": $('input[name=model]').val(),
			"price": $('input[name=price]').val(),
			"vcode": $('select[name=vendor] option:selected').val()
		}
		$.ajax({
			url: "api/phone",
			type: "put",
			data: JSON.stringify(data),
			contentType: "application/json;charset=utf-8",
			
			error: function(xhr, status, message) {
				alert("error : " + message);
			},
			
			success: function(data) {
				alert("폰 수정 완료");
				phoneList();
			} // success
		}); // ajax
	} // phoneUpdate
	
	function phoneDelete(num) {
		$.ajax({
			url: "api/phone/" + num,
			type: "delete",
			
			error: function(xhr, status, message) {
				alert("error : " + message);
			},
			
			success: function(data) {
				alert("폰 삭제 완료");
				phoneList();
				$('#phone-info').empty();
			} // success
		}); // ajax
	} // phoneDelete
	
</script>
<style>
	table {
		width: 30%;
	}
	#phone-list-table {
		border: 1px solid #444444;
	}
	#phone-list-table th, #phone-list-table td {
  		border: 1px solid #444444;
	}
</style>
</head>
<body>
	<h2>휴대전화 목록</h2>
	<div id="phone-list"></div>
	
	<br>
	
	<div id="phone-info"></div>
</body>
</html>