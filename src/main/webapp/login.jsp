<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.entity.UserBean,java.net.*"%>
<%
String loginError = (String) request.getAttribute("loginError");
String logoutMessage = request.getParameter("logoutMessage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<!-- reset.css modern-css-reset -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<!-- <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/destyle.css@1.0.15/destyle.css" /> 
<link rel="stylesheet" type="text/css" href="assets/stylesheets/app.css" /> -->
</head>
<body class="login">
	<div class="pt-4 container">
		<main class="">
			<div class="text-center">
				<img class="image" src="assets/images/seassist_logo.png" alt="ロゴ"
					style="width: 160px;">
			</div>
			<h1 class="text-center mt-4 mb-4">顧客管理システム</h1>
			
			<form action="login" method="post" class="login_form p-5 bg-light w-50 m-auto">
			<h2 class="fs-5 text-center mt-2">ログイン</h2>
				<%
				if (logoutMessage != null) {
				%><p class="my-2" style="color: red;">ログアウトしました</p>
				<%
				}
				%>

				<%
				if (loginError != null) {
				%><p class="my-2" style="color: red;"><%=loginError%></p>
				<%
				}
				%>

				<input type="text" name="id" placeholder="ユーザーID" class=" mt-4 form-control">
				<input type="password" name="password" placeholder="パスワード" class=" mt-4 form-control">
				<br> <input type="submit" value="ログイン" class="d-block mx-auto btn btn-primary">
			</form>
		</main>
	</div>
</body>
</html>
