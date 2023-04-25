<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 페이지</title>
</head>
<body>
	<h2>상품목록</h2>
	<table>
		<tr>
			<td>상품코드</td>
			<td>상품명</td>
			<td>상품가격</td>
		</tr>

		<c:forEach items="${productlist}" var="p">
			<tr>
				<td>${p.code}</td>
				<td>${p.model}</td>
				<td>${p.price}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>