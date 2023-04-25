<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: gray;
}

th, td {
	border: 1px dotted black;
	text-align: center;
}

#selectedDel {
	text-align: right;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h1 id="head">출결 관리 - 리스트</h1>


	<form method="post" action="${root }/attend/deleteAll">
		<table>
			<tr>
				<th>이슈번호</th>
				<th>아이디</th>
				<th>날짜</th>
				<th>사유</th>
				<th>삭제</th>
			</tr>



			<c:forEach items="${attendlist}" var="a">

				<c:if test="${logininfo.position eq admin}">
					<tr>

						<td><a href="${root }/attend/detail?ano=${a.ano}">${a.ano}</a></td>
						<td>${a.userid}</td>
						<td>${a.issuedate}</td>
						<td>${a.issue}</td>
						<td><input type="checkbox" name="ano" value="${a.ano}"></td>

					</tr>



				</c:if>

				<c:if test="${logininfo.position eq stu}">
					<c:if test="${logininfo.userid eq a.userid }">
						<td><a href="${root }/attend/detail?ano=${a.ano}">${a.ano}</a></td>
						<td>${a.userid}</td>
						<td>${a.issuedate}</td>
						<td>${a.issue}</td>
						<td><input type="checkbox" name="ano" value="${a.ano}"></td>
					</c:if>
				</c:if>


			</c:forEach>



		</table>

		<input type="submit" value="선택항목삭제">
	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>