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
<link rel="stylesheet" href="./assets/stylesheets/app.css">
</head>
<body>
	<%-- <%@ include file="header.jsp"%> --%>
	<div class="main">
		<main>
			<h1>権限編集フォーム</h1>
			<form action="authority-edit" method="post">
				<div class="editBox" style="display: flex">
					<div>
						<label for="userd">ユーザー名</label>
						<select id="userd" name="userd">
							<option value=""></option>
							<option value=""></option>
							<option value=""></option>
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