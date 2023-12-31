<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<CustomerBean> customerList = (List<CustomerBean>) request.getAttribute("customerList");
%>
<%@ page import="java.util.List,model.entity.CustomerBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客一覧</title>
<link rel="stylesheet" href="assets/stylesheets/app.css" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/WEB-INF/include/header.jsp"%>
	<div class="container">
		<h1>顧客一覧</h1>
		<form action="customer-list" method="post"
			class="d-flex w-50 justify-content-center mx-auto mb-4">
			<input type="text" name="searchWord" class="form-control w-75 mx-2">
			<button type="submit" name="button" value="検索"
				class="btn btn-primary">検索</button>
		</form>


		<%
		if (customerList != null && customerList.size() > 0) {
		%>

		<table class="table">
			<!-- <tbody class="table"> -->

			<tr>
				<td>顧客ID</td>
				<td>氏名</td>
				<td>かな</td>
				<td>性別</td>
				<td></td>
				<td></td>
			</tr>

			<%
			for (CustomerBean customer : customerList) {
			%>
			<tr class="align-middle">
				<td><%=customer.getId()%></td>
				<td><%=customer.getName()%></td>
				<td><%=customer.getNameKana()%></td>

				<td><%=customer.getGender()%></td>

				<td class="">
					<form action="customer-detail" method="get">
						<input type="hidden" name="id" value="<%=customer.getId()%>"
							action="customer-detail">
						<button type="submit" name="button" value="edit"
							class="btn btn-outline-success">詳細</button>
					</form>
				</td>
			</tr>
			<%
			}
			%>
			<!-- </tbody> -->
		</table>

		<%
		} else {
			%>
			<p style="color: red; font-size: 20px">該当する顧客は存在しません</p>
			<%
			}
			%>

		<a href="menu" class="btn btn-outline-secondary">メニュー画面へ</a>

	</div>


</body>
</html>