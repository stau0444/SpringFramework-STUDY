<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/private/insert.jsp</title>
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${isSuccess}">
			<script>
			alert("저장 하였습니다.");
			location.href="${pageContext.request.contextPath }/cafe/list.do";
		</script>
		</c:when>
		<c:otherwise>
			<h1>Alert</h1>
			<p>
				글 정보 저장 실패!
				<a href="insertform.do">다시 작성 하기</a>
			</p>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>





