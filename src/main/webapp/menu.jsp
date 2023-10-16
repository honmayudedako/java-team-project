<%@page import="model.entity.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%UserBean user = (UserBean)session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
  <%-- <%@ include file="header.jsp"%> --%>
  
  <%=user.getUserId() %>さん、こんにちは！
  <div class="main">
    <main>
      <h2>顧客管理システム</h2>
      <form action="menu" method="post">
        <input type="submit" name="button" value="顧客一覧"><br>
        <input type="submit" name="button" value="顧客登録"><br>
        <input type="submit" name="button" value="権限編集">
      </form>
    </main>
  </div>
</body>
</html>
