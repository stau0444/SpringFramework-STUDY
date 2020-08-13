<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<div class="container my-4">
		<a href="private/upload_form.do" class="btn btn-primary mb-2 float-right">파일 업로드</a>
		<h1 class="text-center"><a href="list.do">파일 목록</a></h1>
		<table class="table table-striped">
			<thead class="thead thead-dark">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>파일명</th>
					<th>파일크기</th>
					<th>등록일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
			
			<%--JSTL 사용한 코드 --%>
			<c:forEach var="tmp" items="${list}">
				<tr>
					<td>${tmp.num}</td>
					<td>${tmp.writer}</td>
					<td>${tmp.title}</td>
					<td><a href="download.do?num=${tmp.num}">${tmp.orgFileName}</a></td>
					<td><fmt:formatNumber value="${tmp.fileSize}" pattern="#,###"/></td>
					<td>${tmp.regdate}</td>
					<td>
						<c:if test="${tmp.writer eq id }">
							<a href="private/delete.do?num=${tmp.num}">삭제</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="page-display">
			<ul class="pagination justify-content-center">
				<%--JSTL --%>
				<c:if test="${startPageNum ne 1}">
					<li class="page-item"><a class="page-link" href="list.do?pageNum=${condition}&condition=${startPageNum-1}&keyword=${encodedK}">prev</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum}" end="${endPageNum}" step="1">
					<c:choose >
						<c:when test="${i eq pageNum}">
							<li class="page-item active"><a class="page-link" href="list.do?pageNum=${i}&condition=${condition }&keyword=${encodedK}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="list.do?pageNum=${i}&condition=${condition }&keyword=${encodedK}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${endPageNum lt totalPageNum }">
					<li class="page-item" ><a class="page-link" href="list.do?pageNum="${endPageNum+1}&condition=${condition }&keyword=${encodedK}">next</a></li>
				</c:if>
			</ul>
		</div>
		<hr/>
		<form action="list.do" method="get" class="float-right mt-3">
			<label for="condition">검색조건</label>
			<select name="condition" id="condition" >
				<option value="title_filename" <c:if test="${condition eq 'title_filename' }">selected</c:if>>제목+파일명</option>
				<option value="title" <c:if test="${condition eq 'title' }">selected</c:if>>제목</option>
				<option value="writer" <c:if test="${condition eq 'writer' }">selected</c:if>>작성자</option>
			</select>
			<input type="text" name="keyword" value="${keyword}"placeholder="검색중"/>
			<button type="submit" id="btn">검색</button>
		</form>
	</div>
</body>
</html>