<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="model.entity.CustomerBean"%>
<%@page import="model.entity.UserBean"%>
<%
CustomerBean customer = (CustomerBean) request.getAttribute("customer");
%>
<%
UserBean user = (UserBean) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細画面</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/stylesheets/app.css" type="text/css">
<link rel="stylesheet"
	href="./assets/stylesheets/object/projects/detail.css">
</head>
<body>
	<%@ include file="/WEB-INF/include/header.jsp"%>
	<main>
		<div>
			<h2>顧客詳細</h2>
			<table class="detaile-table">
				<tr>
					<td>顧客ID</td>
					<td>氏名</td>
					<td>かな</td>
					<td>郵便番号</td>
					<td>地区</td>
					<td>性別</td>
					<td>生年月日</td>
					<td>電話番号</td>
					<td>登録日時</td>
					<td>更新日時</td>
				</tr>
				<tr>
					<td><%=customer.getId()%></td>
					<td><%=customer.getName()%></td>
					<td><%=customer.getNameKana()%></td>
					<td><%=customer.getPostCode()%></td>
					<td><%=customer.getAreaCode()%></td>
					<td><%=customer.getGender()%></td>
					<td><%=customer.getBirthday()%></td>
					<td><%=customer.getPhoneNumber()%></td>
					<td><%=customer.getInsertDateTime()%></td>
					<td><%=customer.getUpdateDateTime()%></td>

					<%if ("A1".equals(user.getAuthorityCode()) || "A2".equals(user.getAuthorityCode())) { %>
					<td>
						
						<form action="customer-edit" method="get">
						<input type="hidden" name="id" value="<%=customer.getId()%>"
							action="customer-detail">
						<button type="submit" name="button" value="edit"
							class="btn btn-outline-success">編集</button>
						
					</form> 
						
					</td>
					<td>
						<form method="get" action="customer-delete">
							<input type="hidden" name="id"
								value="<%=customer.getId()%>"> <input type="submit"
								name="button" value="削除">
						</form>
					</td>
					<% } %>
				</tr>
			</table>
			<form method="post" action="customer-list">
				<input type="submit" name="button" class="btn btn-outline-secondary"
					value="顧客一覧">
			</form>
		</div>
	</main>
</body>
</html>