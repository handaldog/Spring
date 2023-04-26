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
		<a href="${root }/board/remove?bno=${board.bno}">[글 삭제하기]</a>
	</c:if>
	<br>
	<br>
	첨부된 파일 목록 <br>
	<c:forEach items="${board.files }" var="f">
		<div>${f.originalName } <a href="${root }/board/download?fno=${f.fno}">[다운로드]</a></div>
	</c:forEach>
	<br>
	<br>
	<form action="${root }/board/addComment" method="post">
		<input type="text" name="comment" placeholder="바르고 고운말을 쓰자!">
		<input type="hidden" name="bno" value="${board.bno }">
		<input type="submit" value="작성">
	</form>
	<br>
	<div>
		댓글 목록
		<c:forEach var="comment" items="${comments }">
			<div>${comment.cwriter } : ${comment.ccontent }</div>
		</c:forEach>
	</div>
</body>
</html>