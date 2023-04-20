<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${boardList}" var="b">
			<tr>
				<td><a href="${root}/board/detail?bno=${b.bno}">${b.bno}</a></td>
				<td>${b.btitle}</td>
				<td>${b.bwriter}</td>
				<td>${b.bwriteDate}</td>
				<c:if test="${b.bwriter eq loginInfo.userId}">
					<td><a href="${root }/board/delete?bno=${b.bno}">[삭제]</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>