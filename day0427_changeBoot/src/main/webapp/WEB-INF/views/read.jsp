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
			<td>제목 : ${board.btitle }</td>
		</tr>
		<tr>
			<td>작성자 : ${board.bwriter }</td>
		</tr>
		<tr>
			<td>작성일시 : ${board.bwriteDate }</td>
		</tr>
		<tr>
			<td>내용</td>
		</tr>
		<tr>
			<td>${board.bcontent }</td>
		</tr>
	</table>
	<c:if test="${board.bwriter eq loginInfo.userId }">
		<a href="${root }/board/remove?bno=${board.bno}">[글 삭제하기]</a>
	</c:if>

</body>
</html>