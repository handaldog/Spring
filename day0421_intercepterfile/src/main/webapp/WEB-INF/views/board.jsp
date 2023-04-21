<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 싸피 대전 5반 게시판입니다.</h1>
	<c:if test="${empty loginInfo}">
		<form action="${root }/user/login" method="post">
			ID : <input type="text" name="userId"><br> 
			PW : <input type="text" name="userPw"><br>
			 <input type="submit" value="LOGIN">

		</form>
	</c:if>
	
	

</body>
</html>