<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="b" items="${boardList }">
			<tr>
				<td>${b.bno }</td>
				<td><a href="${root }/board/read?bno=${b.bno}">${b.btitle }</a></td>
				<td>${b.bwriter }</td>
				<td>${b.bwriteDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>