<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.entity.UserBean"%>
<%String loginError = (String)request.getAttribute("loginError"); %>
<%-- <% String loginError = "ログイン失敗"; %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
  <div class="main">
    <main>
      <div class="imageWrap">
        <img class="image" src="assets/images/seassist_logo.png" alt="ロゴ" style="width: 160px;">
      </div>
      <h1>ログイン画面</h1>
      <h2>顧客管理システム</h2>
      <p><% if(loginError != null) { %><%= loginError %><% } %></p>
      <form action="login" method="post">
        <input type="text" name="id" placeholder="userId"><br>
        <input type="password" name="password" placeholder="password"><br>
        <br>
        <input type="submit" value="ログイン">
      </form> 
    </main>
  </div>
</body>
</html>
