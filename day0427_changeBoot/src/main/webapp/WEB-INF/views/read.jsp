<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%@ include file="header.jsp"%>
	제목 : ${board.btitle }
	<br> 작성자 : ${board.bwriter }
	<br> 내용 : ${board.bcontent }
	<br> 첨부된 파일 목록 :


	<c:forEach items="${board.files}" var="f">
	
원래이름 : ${f.original_name} // (저장된 경로:${f.saved_path})<br>
파일 다운로드 하기 : <a href="${root }/board/download?fno=${f.fno}">[파일다운로드하기]</a>
	</c:forEach>


	<c:forEach items="${comment}" var="co">
		<div>${co.cwriter }:${co.ccontent }</div>
	</c:forEach>

	<form action="${root }/comment/wcomment" method="post">
		<input type="text" name="ccontent"> <input type="hidden"
			name="bno" value="${board.bno}"> <input type="submit"
			value="작성">
	</form>



</body>
</html>