<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 수정</title>
</head>
<body>
	<form action="${root }/modify" method="POST">
	<table>
		<tr>
			<td>제목 : </td>
			<td>${book.bno }</td>
		</tr>
		<tr>
			<td>제목 : </td>
			<td><input value=${book.title } name="title"></td>
		</tr>
		<tr>
			<td>저자 : </td>
			<td>${book.writer }</td>
		</tr>
		<tr>
			<td>가격 : </td>
			<td><input type="number" name="price" value="${book.price }"></td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td><textarea cols="50" rows="50" name="summary">${book.summary }</textarea></td>
		</tr>
	</table>
	<input type="hidden" name="bno" value="${book.bno }">
	<input type="hidden" name="writer" value="${book.writer }">
	<input type="submit" value="저장">
	<a href="${root}/detail?bno=${book.bno}">[취소]</a>
	</form>
</body>
</html>