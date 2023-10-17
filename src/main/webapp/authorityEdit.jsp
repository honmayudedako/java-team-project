<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="editBox" style=display:flex>
				<div>
					<p>ユーザー名</p>
					<input type="select" name="userd">
				</div>
				<div>	
					<p>権限</p>
					<input type="select" name="authorityCode">
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