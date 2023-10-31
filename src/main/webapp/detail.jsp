<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="model.entity.CustomerBean"%>
<%
CustomerBean customer = (CustomerBean) request.getAttribute("customer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細画面</title>
<link rel="stylesheet"
	href="./assets/stylesheets/object/projects/detail.css">
</head>
<body>
	<%@ include file="/WEB-INF/include/header.jsp"%>
	<main>
		<div>
			<h2>顧客詳細</h2>
			<table>
				<tr>
					<td>顧客ID</td>
					
				</tr>
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
				<tr>
					<td>
						<form method="post" action="customer-edit">
							<input type="hidden" name="customerId"
								value="<%=customer.getId()%>"> <input type="submit"
								name="button" value="編集">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form method="post" action="customer-delete">
							<input type="hidden" name="customerId"
								value="<%=customer.getId()%>"> <input type="submit"
								name="button" value="削除">
						</form>
					</td>
				</tr>
			</table>
			<form method="post" action="customer-list">
				<input type="submit" name="button" value="顧客一覧">
			</form>
		</div>
	</main>
</body>
</html>