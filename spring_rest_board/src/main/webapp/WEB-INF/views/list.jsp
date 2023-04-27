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
		<c:forEach var="b" items="${boardPage.boardList }">
			<tr>
				<td>${b.bno }</td>
				<td><a href="${root }/board/read?bno=${b.bno}">${b.btitle }</a></td>
				<td>${b.bwriter }</td>
				<td>${b.bwriteDate }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${root }/board/list?page=1">
			[처음]
	</a>
	<c:if test="${boardPage.startPage > 1 }">
		<a href="${root }/board/list?page=${boardPage.startPage-1 }">
			[이전]
		</a>
	</c:if>
	
	<c:forEach begin="${boardPage.startPage }" end="${boardPage.endPage }" var="i" >
		<a href="${root }/board/list?page=${i }">[${i }]</a>
	</c:forEach>
	
	<c:if test="${boardPage.endPage < boardPage.totalPage }">
		<a href="${root }/board/list?page=${boardPage.endPage + 1 }">
			[다음]
		</a>
	</c:if>
	<a href="${root }/board/list?page=${boardPage.totalPage}">
			[마지막]
	</a>
	
</body>
</html>