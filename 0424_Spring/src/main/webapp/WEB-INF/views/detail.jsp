<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style>
form>label {
	display: inline-block;
	width: 100px;
}

form>:input {
	display: inline-block;
	width: 100px;
}
</style>
</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h1 id="head">출결 관리 - 이슈 조회</h1>
	<form>
		<label for="ano" class="inputtitle">이슈 번호</label>
		<input type="text" name="ano" id="ano" value=${detailattend.ano }> <!-- 이렇게 폼에   value 값으로 넣어주면 된다.  -->
		<br>
		<label for="userid" class="inputtitle">아이디</label>
		<input type="text" name="userid" id="userid" value=${detailattend.userid }>
		<br>
		<label for="name" class="inputtitle">교육생명</label>
		<input type="text" name="name" id="name" value=${detailattend.name }>
		<br>
		<label for="rclass" class="inputtitle">반</label>
		<input type="number" name="rclass" id="rclass" >
		<br>
		<label for="rname" class="inputtitle">지역</label>
		<input type="text" name="rname" id="rname">
		<br>
		<label for="issuedate" class="inputtitle">날짜</label>
		<input type="text" name="issuedate" id="issuedate">
		<br>
		<label for="issue" class="inputtitle">사유</label>
		<input type="text" name="issue" id="issue">
		<br>

		<%@ include file="/WEB-INF/views/footer.jsp"%>

	</form>
</body>
<script>
	
</script>
</html>