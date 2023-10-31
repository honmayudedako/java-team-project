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
<title>顧客情報編集</title>
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
		<h1 class="my-4">顧客情報編集</h1>
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
		<form action="customer-edit" method="post">
			<table class="table align-middle">
				<tr>
					<td>氏名</td>
					<td><input type="text" name="customerName" placeholder="山田太郎"
						required="required" class="form-control" value="<%=customer.getName() %>"></td>
				</tr>
				<tr>
					<td>かな</td>
					<td><input type="text" name="customerNameKana"
						placeholder="やまだたろう" required="required" class="form-control" value="<%=customer.getNameKana() %>"></td>
				</tr>
				<tr>
					<td>郵便番号</td>
					<td><input type="text" name="postCode" placeholder="8120011"
						required="required" class="form-control" value="<%=customer.getPostCode() %>"></td>
				</tr>
				<tr>
					<td>地区</td>
					<td><select type="text" name="areaCode" class="form-select">
							<%
							for (AreaBean area : areaList) {
							String selected = area.getCode().equals(customer.getAreaCode()) ? "selected" : ""; 
							%>
							<option value="<%=area.getCode()%>" <%=selected %>><%=area.getName()%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
				<% 
				String gender = customer.getGender();
				if ( gender != null) {
					String manChecked = gender.equals("男") ? "checked" : "";
					String womanChecked = gender.equals("女") ? "checked" : "";
				
				%>
					<td>性別</td>
					<td><input type="radio" name="gender" value="男"
						class="form-check-input mx-1" <%= manChecked %>>男 
						<input type="radio"
						name="gender" value="女" class="form-check-input mx-1" <%= womanChecked %>>女</td>
				</tr>
				<% } %>
				<tr>
				<% String birthday = customer.getBirthday();
				String birthdayFormat = birthday.replace("-", ""); %>
					<td>生年月日</td>
					<td><input type="text" name="birthday" placeholder="19850101"
						required="required" class="form-control" value="<%=birthdayFormat %>"></td>
				</tr>
				<tr>
					<td>電話番号</td>
					<td><input type="text" name="phoneNumber"
						placeholder="09012345678" required="required" class="form-control" value="<%=customer.getPhoneNumber() %>"></td>
				</tr>
			</table>
			<div class="d-flex justify-content-end">
				<input type="submit" value="編集完了" class="btn btn-success">
				<input type="reset" value="クリア" class="btn btn-outline-primary mx-2">
			</div>
			<input type="hidden" name="customerId" value="<%= customer.getId() %>">
		</form>
		<div class="mt-2">
			<a href="/EmployeeManager_practice/customer-list" class="btn btn-outline-secondary">顧客一覧画面へ</a>
			<a href="menu.jsp" class="btn btn-outline-secondary">メニュー画面へ</a>
		</div>
	</main>

</body>
</html>