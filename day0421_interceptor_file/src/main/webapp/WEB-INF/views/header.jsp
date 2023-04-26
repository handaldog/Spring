<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>여기는 싸피 대전 5반 게시판 입니다</h1>
		<c:if test="${empty sessionScope.loginInfo }" >
			<form action="${root }/user/login" method="POST">
				ID : <input type="text" name="userId"><br>
				PW : <input type="text" name="userPw"><br>
				<input type="submit" value="로그인">
			</form>
		</c:if>
		
		<c:if test="${not empty sessionScope.loginInfo }">
			안녕하세요 ${loginInfo.userName}(${loginInfo.userId})님 반갑습니다!
			<a href="${root }/user/logout">[로그아웃]</a>
		</c:if>
		<br>
		<a href="${root }/board/write">[게시글작성]</a>
		<a href="${root }/board/list">[게시글목록]</a>
		<a href="${root }/download">[가오나시 다운로드]</a>
	</div>
</body>
</html>