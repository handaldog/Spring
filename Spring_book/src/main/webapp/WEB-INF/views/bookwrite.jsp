<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="head.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 추가 하는 화면</title>
</head>
<body>
	<form action="${root}/write" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>

			<tr>
				<td>가격</td>
				<td><input type="text" name="price"></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><input type="text" name="summary"></td>
				<!-- 아이디 쓰면 안됨. -->
			</tr>
		</table>
		<input type="submit" value="작성완료">
	</form>
</body>
</html>