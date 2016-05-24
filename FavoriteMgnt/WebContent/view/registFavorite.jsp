<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 등록</title>
</head>
<body>
	<h2>즐겨찾기 등록</h2>
	<form action="registFavorite.do" method="POST">
	<table>
		<tr>
			<th>URL</th>
			<td><input type="text" name="url"></td>
		</tr>
		<tr>
			<th>Description</th>
			<td><input type="text" name="description"></td>
		</tr>
		<tr>
			<th>Category</th>
			<td>
				<select name="category">
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
	<input type="reset" value="초기화">
	<input type="submit" value="등록">
	</form>
</body>
</html>