<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>OOPS!</h1>
		<p class="alert alert-danger">
			<strong>${exception.message}</strong>
			<a class="alert-link" href="${pageContext.request.contextPath}/">홈으로</a>
		</p>
	</div>
</body>
</html>