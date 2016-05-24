<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴</title>
</head>
<body>
	(${loginId})님
	<a href="logout.do">로그아웃</a>
	<hr>
	<h2>메뉴</h2>
	<ol>
		<li><a href="list.do">즐겨찾기 목록</a></li>
		<li><a href="registFavorite.do">즐겨찾기 등록</a></li>
		
	</ol>
</body>
</html>