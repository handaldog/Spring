<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 내용 작성</title>
</head>
<body>
	<form action="${root }/write" method="POST">
		<table>
		<tr>
			<td>제목 : </td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td>가격 : </td>
			<td><input type="text" name="price"></td>
		</tr>
		<tr>
			<td>요약정보 : </td>
			<td><input type="text" name="summary"></td>
		</tr>

		</table>
		<input type="submit" value="작성완료">
	</form>

</body>
</html>