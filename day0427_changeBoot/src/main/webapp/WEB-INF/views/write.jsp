<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<form action="${root}/board/write" method="post"
		enctype="multipart/form-data">
		제목 : <input type="text" name="btitle"><br> 내용 :
		<textarea rows="10" cols="10" name="bcontent"></textarea>
		<button id="addFile">파일추가</button>
		<div id="fileArea"></div>
		<input type="submit" value="작성완료">
	</form>

	<script type="text/javascript">
		document.getElementById('addFile').onclick = function() {
			let f = '<input type="file" name="uploadedFiles">';
			document.getElementById('fileArea').innerHTML += f;
			return false; // button이 기본적으로 submit이 같이 걸려있어서 그거 취소시키는  false;
		}
	</script>
</body>
</html>