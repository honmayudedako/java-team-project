<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List,model.entity.UserBean,model.entity.AreaBean"%>
<%
UserBean user = (UserBean) session.getAttribute("user");
List<String> errors = (List<String>) request.getAttribute("errors");
List<AreaBean> areaList = (List<AreaBean>) request.getAttribute("areaList");
String sqlFailed = (String) request.getAttribute("sqlFailed");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客登録フォーム</title>
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
		<h1 class="my-4">顧客登録フォーム</h1>
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
		</div>
		<form action="create" method="post">
			<table class="table align-middle">
				<tr>
					<td>氏名</td>
					<td><input type="text" name="customerName" placeholder="山田太郎"
						required="required" class="form-control"></td>
				</tr>
				<tr>
					<td>かな</td>
					<td><input type="text" name="customerNameKana"
						placeholder="やまだたろう" required="required" class="form-control"></td>
				</tr>
				<tr>
					<td>郵便番号</td>
					<td><input type="text" name="postCode" placeholder="8120011"
						required="required" class="form-control"></td>
				</tr>
				<tr>
					<td>地区</td>
					<td><select type="text" name="areaCode" class="form-select">
							<%
							for (AreaBean area : areaList) {
							%>
							<option value="<%=area.getCode()%>"><%=area.getName()%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
					<td>性別</td>
					<td><input type="radio" name="gender" value="男"
						class="form-check-input mx-1">男 <input type="radio"
						name="gender" value="女" class="form-check-input mx-1">女</td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><input type="text" name="birthday" placeholder="19850101"
						required="required" class="form-control"></td>
				</tr>
				<tr>
					<td>電話番号</td>
					<td><input type="text" name="phoneNumber"
						placeholder="09012345678" required="required" class="form-control"></td>
				</tr>
			</table>
			<div class="d-flex justify-content-end">
				<input type="submit" value="顧客登録確定" class="btn btn-primary">
				<input type="reset" value="クリア" class="btn btn-outline-primary mx-2">
			</div>

		</form>
		<div class="mt-2">
			<a href="menu" class="btn btn-outline-secondary">メニュー画面へ</a>
		</div>
	</main>

</body>
</html>