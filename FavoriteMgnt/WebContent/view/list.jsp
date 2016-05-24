<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>
<html>
<head>
	<meta charset="UTF-8">
	<title>즐겨찾기 목록</title>
	<style>
		table, tr, td, th {
			border : 1px solid black;
			border-collapse: collapse;
		}
	</style>
</head>
<body>
	<h2>즐겨찾기 목록</h2>
	<table>
		<tr>
			<th>NO</th>
			<th>URL</th>
			<th>Description</th>
			<th>Category</th>
			<th>편집</th>
		</tr>
			<c:forEach items="${list}" var="list">
			
			<tr>
				<td>${list.id}</td>
				<td><a href="http://${list.url}">${list.url}</a></td>
				<td>${list.description}</td>
				<td>${list.category}</td>
				<td>
					<a href="modify.do?id=${list.id}">수정</a>
					&nbsp;
					<a href="remove.do?id=${list.id}">삭제</a>
				</td>
			</tr>
			
			</c:forEach>
	</table>
	<br><br><br>
	<a href="${ctx}"><button>메뉴</button></a>
	<a href="registFavorite.do"><button>등록</button></a>
</body>
</html>