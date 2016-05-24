<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="POST">
	<table>
		<tr>
			<th colspan="2">로그인</th>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="loginId" placeholder="아이디를 입력하세요"></td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><input type="password" name="password" placeholder="패스워드를 입력하세요"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="reset" value="취소">
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>







