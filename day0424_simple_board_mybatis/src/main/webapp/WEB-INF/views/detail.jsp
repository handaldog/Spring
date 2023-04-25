<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 디테일</title>
</head>
<body>
	제목 : ${board.btitle }<br>
	 작성자 : ${board.bwriter }<br>
	 내용 : ${board.bcontent }<br>
	 첨부된 파일 목록 :
	
	<c:forEach items="${board.files}" var="f">
원래이름 : ${f.original_name} // (저장된 경로:${f.saved_path})<br>
	</c:forEach>


</body>
</html>