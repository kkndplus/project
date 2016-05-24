<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 수정</title>
<script>
	window.onload = function() {
		document.getElementById("selCategory").value =
			document.getElementById("oldCategoryCode").value;
	};
</script>
</head>
<body>
	<h2>즐겨찾기 수정</h2>
	<form action="modify.do" method="POST">
	<table>
		<tr>
			<th>URL</th>
			<td><input type="text" name="url" value="${favor.url }"></td>
		</tr>
		<tr>
			<th>Description</th>
			<td><input type="text" name="description" value="${favor.description }"></td>
		</tr>
		<tr>
			<th>Category</th>
			<td>
				<select name="category" disabled="disabled">
					<option value="01" <c:if test="${cat eq '01'}">selected</c:if> >Dev</option>
					<option value="02" <c:if test="${cat eq '02'}">selected</c:if>>Private</option>
					<option value="03" <c:if test="${cat eq '03'}">selected</c:if>>Beauty</option>
					<option value="04" <c:if test="${cat eq '04'}">selected</c:if>>Shopping</option>
					<option value="05" <c:if test="${cat eq '05'}">selected</c:if>>Finance</option>
				</select>
				<select name="selCategory" id="selCategory">
					<option value="01">Dev</option>
					<option value="02">Private</option>
					<option value="03">Beauty</option>
					<option value="04">Shopping</option>
					<option value="05">Finance</option>
				</select>
			</td>
		</tr>
	</table>
	<br><br>
	<input type="hidden" name="id" value="${favor.id}">
	<input type="hidden" id="oldCategoryCode" value="${cat}">
	<input type="submit" value="저장">
	</form>
</body>
</html>











