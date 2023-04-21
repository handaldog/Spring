<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기 부분</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<form action="${root}/board/write" method="post"enctype="multipart/form-data">
		제목 : <input type="text" name="btitle"><br>	
		 내용 : <textarea rows="10" cols="10" name="bcontent"></textarea>
		 첨부 파일 : <input type="file" name="yangfile"><br>
		<input type="submit" value="작성완료">
	</form>
</body>
</html>