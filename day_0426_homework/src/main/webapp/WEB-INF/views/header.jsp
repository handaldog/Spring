<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더 페이지</title>
</head>
<body>
	<c:if test="${empty userInfo }">
		<form action="${root }/user/login" method="post">
			ID : <input type="text" name="userId" value="yangyu"><br>
			PW : <input type="text" name="userPw" value="1234"><br>
			<input type="submit" value="Login">
		</form>

	</c:if>

	<c:if test="${not empty userInfo }">
		안녕하세요 ${userInfo.user_id }(${userInfo.user_pw })님 반갑습니다.
		<a href="${root }/user/logout">[로그아웃]</a>
	</c:if>
</body>
</html>