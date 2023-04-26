<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<script type="text/javascript">
		alert('로그인이 필요한 페이지입니다.');
		location.href="${root}";
	</script>
</body>
</html>