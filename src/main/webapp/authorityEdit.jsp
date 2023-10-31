<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.entity.UserBean"%>
<%
UserBean user = (UserBean) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>権限編集画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/WEB-INF/include/header.jsp" %>
	<div class="main">
		<main>
			<h1>権限編集フォーム</h1>
			<form action="authority-edit" method="post">
				<div class="editBox" style="text-align: center;">
					<div>
						<label for="userId">ユーザー名</label>
						<select id="userId" name="userId">
							<option value="readerU">readerU</option>
							<option value="editU">editU</option>
							<option value="managerU">managerU</option>
						</select>
					</div>
					<div>
						<label for="authorityCode">権限</label>
						<select id="authorityCode" name="authorityCode">
							<option value="A0">閲覧者</option>
							<option value="A1">編集者</option>
							<option value="A2">管理者</option>
						</select>
					</div>
				</div>
				<div class="edit-submitBox">
					<input type="submit" name="button" value="権限編集確定">
				</div>
				<a href="menu.jsp">メニュー画面へ</a>
			</form>
		</main>
	</div>
</body>
</html>