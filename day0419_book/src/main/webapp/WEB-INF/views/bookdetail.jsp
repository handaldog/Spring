<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Detail</title>
</head>
<body>
	<table>
		<tr>
			<td>제목 : </td>
			<td>${book.bno }</td>
		</tr>
		<tr>
			<td>제목 : </td>
			<td>${book.title }</td>
		</tr>
		<tr>
			<td>저자 : </td>
			<td>${book.writer }</td>
		</tr>
		<tr>
			<td>가격 : </td>
			<td>${book.price }</td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td>${book.summary }</td>
		</tr>
	</table>
	<a href="${root}/modify?bno=${book.bno}">[수정]</a>
	<a href="${root}/delete?bno=${book.bno}">[삭제]</a>
	<a href="${root}/list">[뒤로가기]</a>
</body>
</html>