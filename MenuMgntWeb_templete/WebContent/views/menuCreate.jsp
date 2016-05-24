<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/menuCreate.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.js"></script>
<script>
	var validate = function() {
		// 유효성 검사
		if ($("#iptCode").value == ""){
			alert("메뉴코드를 입력해주세요.");
			document.getElementById("iptCode")focus();
			return false;
		}
	}
</script>
<title>메뉴등록</title>
</head>
<body>
	<div id="container">
		<h1>메뉴등록</h1>
		<form action="${pageContext.request.contextPath}/menu/create.do" onSubmit="return validate();">
			<dl>
				<dt>메뉴코드</dt>
				<dd>
					<input type="text" size="10" name="code" id="iptCode">
				</dd>
				<dt>메뉴명</dt>
				<dd>
					<input type="text" size="20" name="name" id="iptName">
				</dd>
				<dt>화면표시순서</dt>
				<dd>
					<input type="text" size="10" name="displaySeq" id="iptDisplaySeq">
				</dd>
				<dt>URL</dt>
				<dd>
					<input type="text" size="50" name="url" id="iptUrl">
				</dd>
			</dl>
			<p>
				<input type="submit" value="저장">
			</p>
		</form>
	</div>
</body>
</html>