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
			<td>제목 : </td>
			<td>${board.btitle }</td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td>${board.bwriter }</td>
		</tr>
		<tr>
			<td>작성일시 : </td>
			<td>${board.bwriteDate }</td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td>${board.bcontent }</td>
		</tr>
	</table>
	<c:if test="${board.bwriter eq loginInfo.userId }">
		<a href="${root }/board/remove?bno=${board.bno}">[삭제하기]</a>
	</c:if>
	<br>
	<div>
		<form action="${root }/board/comments" method="post">
			<input type="text" name="comment" placeholder="바르고 고운말을 사용합시다">
			<input type="hidden" name="bno" value="${board.bno }">
			<input type="submit" value="댓글작성">
		</form>
	</div>
	<br>
	<div>
		<c:forEach var="comment" items="${board.comments }">
			<div>
				${comment.userId } : ${comment.content }
			</div>
		</c:forEach>
	</div>
</body>
</html>