<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>곡 소개</title>
<link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/resources/css/style.css" rel="stylesheet">
<style>
body {
	padding: 10% 30%;
}

td {
	padding: 10px;
}

#musicDetail {
	width: 100%;
}
</style>
</head>
<body>
	<div style="text-align: right;">
	<c:choose>
		<c:when test="${loginedUser ne null}">
			<form action="myList.do" method="post">
				<input hidden="hidden" name="id" value="${song.id}">
				<input class="btn btn-xs btn-info btnPlay" type="submit" value="담기">
				<a class="btn btn-xs btn-default" href="list.do">뮤직차트</a>
			</form>
		</c:when>
		<c:otherwise>
		<a class="btn btn-xs btn-default" href="list.do">뮤직차트</a>
		</c:otherwise>
		</c:choose>
	</div>
	<h2>${song.name}</h2>
	<hr>
	<table id="musicDetail">
		<colgroup>
			<col width="200px">
			<col width="*">
		</colgroup>
		<tr>
			<td><img src="resources/img/${song.image}" width="180px"></td>
			<td>
				<table class="table">
					<colgroup>
						<col width="150">
						<col width="*">
					</colgroup>
					<tr>
						<th>곡명</th>
						<td>${song.name}</td>
					</tr>
					<tr>
						<th>앨범명</th>
						<td>${song.album}</td>
					</tr>
					<tr>
						<th>아티스트</th>
						<td>${song.artist}</td>
					</tr>
					<tr>
						<th>기획사</th>
						<td>${song.agent}</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>

</body>
</html>
