<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<meta charset="UTF-8">
<title>상품 관리 사이트</title>
<%-- 부트스트랩 사용을 위한 코드 --%>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>

<c:if test="${empty logininfo}">
	<form action="${root}/user/login" method="post">
		ID : <input type="text" name="userId" value="ssafy"><br>
		PW : <input type="text" name="userPw" value="1234"><br> 
		<input
			type="submit" value="LOGIN">
	</form>
</c:if>

<c:if test="${not empty logininfo}">
		안녕하세요*^^* ${logininfo.username}(${logininfo.userid}) 님 반갑습니다!!
		<a href="${root}/user/logout">[로그아웃]</a>
</c:if>
