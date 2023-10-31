<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.entity.UserBean"%>
<%UserBean user = (UserBean)session.getAttribute("user"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>
<% if (user != null){ %> 
<p class="text-secondary mb-2"><%= user.getUserId()  %>さん、こんにちは！</p>
<% } %>
  <div class="main">
    <main>
      <h2 class="mb-5">顧客管理システム</h2>
      <form action="menu" method="post">
      	<div class="d-flex justify-content-around w-50 mx-auto">
      		<input type="submit" name="button" value="顧客一覧" class="btn btn-primary fs-5">
      		
      		<% if(user.getAuthorityCode().equals("A2") || user.getAuthorityCode().equals("A1") ) { %>
        	<input type="submit" name="button" value="顧客登録" class="btn btn-primary fs-5">
        	<% } %>
        	<% if(user.getAuthorityCode().equals("A2")) { %>
        	<input type="submit" name="button" value="権限編集" class="btn btn-primary fs-5">
        	<% } %>
      	</div>
        
      </form>
    </main>
  </div>
</body>
</html>
