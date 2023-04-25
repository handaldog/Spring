<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	제목 : ${board.btitle }<br>
	작성자 : ${board.bwriter }<br>
	내용 : ${board.bcontent }<br>
	
	첨부된 파일 목록 :
	<c:forEach items="${board.files }" var="f">
		원래이름 : ${f.orginalName } // 저장된 경로:${f.savedPath })<br>
	</c:forEach>
	
</body>
</html>