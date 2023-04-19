<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>저자</th>
			<th>가격</th>
			<th>내용</th>

		</tr>


		<tr>
			<td>${book.bno}</td>
			<td>${book.title}</td>
			<td>${book.writer}</td>
			<td>${book.price}</td>
			<td>${book.summary}</td>


		</tr>


	</table>

	<a href="${root}/list">[책 목록으로 돌아가기]</a>
</body>
</html>