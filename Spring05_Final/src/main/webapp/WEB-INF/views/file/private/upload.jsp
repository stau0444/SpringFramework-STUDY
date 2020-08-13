
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>/file/private/upload.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h3>파일이 성공적으로 업로드 되었습니다.</h3>
		<a class="alert-link" href="${pageContext.request.contextPath}/file/list.do">파일 목록으로</a>
		<table class="table table-light">
			<thead>
				<tr>
					<th>작성자</th>
					<th>파일크기</th>
					<th>파일명</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${id}</td>
					<td>${dto.fileSize/1000} KB</td>
					<td>${dto.orgFileName}</td>
					<td>${dto.regdate}</td>
				</tr>
			</tbody>
		</table>
		
	</div>
</body>
</html>
