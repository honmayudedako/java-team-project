<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細画面</title>
<link rel="stylesheet"
	href="./assets/stylesheets/object/projects/detail.css">
</head>
<body>
	<div>
		<h2>顧客詳細</h2>
		<table>
			<thead>
				<tr>
					<th scope="col">顧客ID</th>
					<th scope="col">氏名</th>
					<th scope="col">かな</th>
					<th scope="col">郵便番号</th>
					<th scope="col">地区</th>
					<th scope="col">性別</th>
					<th scope="col">生年月日</th>
					<th scope="col">電話番号</th>
					<th scope="col">登録日時</th>
					<th scope="col">更新日時</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (CustomerBean customer : customerList) {
				%>
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
					<td><%=customer.getUpdateTime()%></td>
					<td>
						<form method="post" action="customer-edit">
							<input type="submit" name="button" value="編集">
							<input type="hidden" name="customerId" value="<%=customer.getCustomerId() %>">
						</form>
					</td>
					<td>
						<form method="post" action="customer-delete">
							<input type="submit" name="button" value="削除">
							<input type="hidden" name="customerId" value="<%=customer.getCustomerId() %>">
						</form>
					</td>
					<td>
						<form method="post" action="customer-list">
							<input type="submit" name="button" value="顧客一覧">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</body>
</html>