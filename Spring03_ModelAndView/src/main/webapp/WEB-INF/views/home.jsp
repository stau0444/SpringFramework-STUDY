<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/view/home.jsp</title>
<link href=>
</head>
<body>
	<div class="container">
	<h1>인덱스 페이지 입니다.</h1>
	<ul>
		<li><a href="test/play.html">spring 컨트롤러 거치지않는 요청</a></li>
		<li><a href="test/game.jsp">spring 컨트롤러 거치지않는 요청2</a></li>
		<li><a href="friends.do">친구목록</a></li>
		<li><a href="friends2.do">친구목록2 ModelAndView 객체직접생성</a></li>
		<li><a href="friends3.do">친구목록3  스프링이생성한ModelAndView 사용</a></li>
		<li><a href="delete.do">친구정보삭제1</a></li>
		<li><a href="delete2.do">친구정보삭제2</a></li>
		<li><a href="users/signup_form.do">회원가입폼</a></li>
	</ul>
	
	<h2>공지사항</h2>
	<ul>
		<c:forEach var="tmp" items="${noticeList}">
			<li>${tmp}</li>
		</c:forEach>
	</ul>
	</div>
</body>
</html>