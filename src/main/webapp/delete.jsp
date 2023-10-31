<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List,model.entity.CustomerBean,model.entity.AreaBean"%>
<%
CustomerBean customer = (CustomerBean) request.getAttribute("customer");
List<String> errors = (List<String>) request.getAttribute("errors");
String success = (String) request.getAttribute("success");
List<AreaBean> areaList = (List<AreaBean>) request.getAttribute("areaList");
String sqlFailed = (String) request.getAttribute("sqlFailed");
String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報削除</title>
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

	<main class="container pb-4">
		<h1 class="my-4">顧客情報削除</h1>
		<p class="text-danger">顧客情報を削除してよろしいですか？</p>
		<div>
			<%
			if (errors != null) {
				for (String error : errors) {
			%>
			<p style="color: red;"><%=error%></p>
			<%
			}
			}
			%>
			<%if (sqlFailed != null) {%>
			<%=sqlFailed%>
			<%
			}
			%>
			<%if (success != null) {%>
			<p class="text-success border border-success p-2"><%=success%></p>
			<%
			}
			%>
		</div>

		<table class="table align-middle">
			<tr>
				<td>氏名</td>
				<td><%=customer.getName()%></td>
			</tr>
			<tr>
				<td>かな</td>
				<td><%=customer.getNameKana()%></td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td><%=customer.getPostCode()%></td>
			</tr>
			<tr>
				<td>地区</td>
				<td><%=customer.getAreaCode()%></td>
			</tr>
			<tr>

				<td>性別</td>
				<td><%=customer.getGender()%></td>
			</tr>

			<tr>
				<%
				String birthday = customer.getBirthday();
				String birthdayFormat = birthday.replace("-", "");
				%> 
				<td>生年月日</td>
				<td><%=birthdayFormat%></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><%=customer.getPhoneNumber()%></td>
			</tr>
		</table>
		<form action="customer-delete" method="post">
			<div class="d-flex justify-content-end">
				<input type="submit" value="顧客情報削除" class="btn btn-danger">
			</div>
			<input type="hidden" name="customerId" value="<%=id%>">
		</form>
		<div class="mt-2 d-flex">
			<form action="customer-detail" method="get" class="mx-2">
				<input type="hidden" name="id" value="<%=customer.getId()%>"
					action="customer-detail">
				<button type="submit" name="button" value="edit"
					class="btn btn-outline-secondary">前の画面へ戻る</button>
			</form>
			<a href="menu.jsp" class="btn btn-outline-secondary">メニュー画面へ</a>
		</div>
	</main>

</body>
</html>