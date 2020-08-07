<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 폼 1 </h1>
	<form action="signup2.do" method="post">
		<input type="text" name="id"/>	
		<input type="text" name="pwd"/>	
		<button type="submit">가입</button>
	</form>
	
	<h1>회원가입 폼 2 dto사용</h1>
	<form action="signup3.do" method="post">
		<input type="text" name="id"/>	
		<input type="text" name="pwd"/>	
		<button type="submit">가입</button>
	</form>
</body>
</html>