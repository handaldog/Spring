<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 디테일</title>
</head>
<body>
	제목 : ${board.btitle }
	<br> 작성자 : ${board.bwriter }
	<br> 내용 : ${board.bcontent }
	<br> 첨부된 파일 목록 :


	<c:forEach items="${board.files}" var="f">
	
원래이름 : ${f.original_name} // (저장된 경로:${f.saved_path})<br>
파일 다운로드 하기 : <a href="${root }/board/download?fno=${f.fno}">[파일다운로드하기]</a>
	</c:forEach>


	<hr>
	<div id=areaComent></div>

	<input type="text" id="content" placeholder="댓글을 작성해주세요.">
	<button id="btncoment">[댓글 작성]</button>

	<script type="text/javascript">
		function getComentList() {
			fetch('${root}/wcomment?bno=${board.bno}')
			.then(function (resp) {
				return resp.json();
			})
			.then(function (data) {
				console.log('백엔드가 준 댓글 목록', data);
				let cdtos = '';
				for(let i=0;i<data.length; i++){
					cdtos += '작성자 : ' + data[i].cwriter + "내용 :" + data[i].ccontent + '<br>'; 
				}
				document.getElementById('areaComent').innerHTML = cdtos;
			})
		}
		
		getComentList();
		
		let btncoment = document.getElementById('btncoment');
		btncoment.onclick = function(){
			let content = document.getElementById('content').value;
			
			let sendInfo = {
					method:'POST',
				body : JSON.stringify({
					'bno' : '${board.bno}',
					'ccontent' : content
				}),
				headers:{
					'Content-Type' : 'application/json'
				}
			}
			fetch('${root}/wcomment', sendInfo)
			.then(function (resp) {
				return resp.text();
			})
			.then(function (data) {
				console.log('백엔드가 응답한 데이터 :' + data);
				getComentList();
			})
		}
	
	</script>






</body>
</html>