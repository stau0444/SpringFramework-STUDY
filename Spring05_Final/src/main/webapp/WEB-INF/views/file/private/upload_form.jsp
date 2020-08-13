<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<h1>파일 업로드 폼 입니다.</h1>
		<%-- 
			[파일 업로드 폼 작성법] 
			1.method="post"
			2.enctype="multipart/form-data 속성 추가"
			3.<input type="file" /> 을 이용
		--%>
		<form action="upload.do" method="post" enctype="multipart/form-data" >
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" name="title" id="title" class="form-control"/><br />
			</div>
			<div class="form-group">
				<label for="myFile">첨부파일</label>
				<input type="file" name="myFile" id="myFile" class="form-control"/><br />
			</div>
			<button type="submit" class="btn btn-outline-primary"> 업로드</button>
		</form>
	</div>
</body>
</html>