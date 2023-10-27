<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="model.entity.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細画面</title>
<link rel="stylesheet"
	href="./assets/stylesheets/object/projects/detail.css">
</head>
<body>
	<%-- <%@ include file="/WEB-INF/include/header.jsp"%> --%>
	<div>
		<h2>顧客詳細</h2>
		<table>
			<thead>
				<tr>
					<th>顧客ID</th>
					<th>氏名</th>
					<th>かな</th>
					<th>性別</th>
					<th>郵便番号</th>
					<th>地区</th>
					<th>性別</th>
					<th>生年月日</th>
					<th>電話番号</th>
					<th>登録日時</th>
					<th>更新日時</th>
				</tr>
			</thead>
			<tbody>
				<% List<CustomerBean> customerDetailList = (List<CustomerBean>)request.getAttribute("customerDetailList"); %>
				<%
            for (CustomerBean customerDetail : customerDetailList) {
        	%>
				<tr>
					<td><%=customerDetail.getId()%></td>
					<td><%=customerDetail.getName()%></td>
					<td><%=customerDetail.getNameKana()%></td>
					<td><%=customerDetail.getPostCode()%></td>
					<td><%=customerDetail.getAreaCode()%></td>
					<td><%=customerDetail.getGender()%></td>
					<td><%=customerDetail.getBirthday()%></td>
					<td><%=customerDetail.getPhoneNumber()%></td>
					<td><%=customerDetail.getInsertDateTime()%></td>
					<td><%=customerDetail.getUpdateDateTime()%></td>
					<td>
						<form method="post" action="customer-edit">
							<input type="submit" name="button" value="編集"> <input
								type="hidden" name="customerId"
								value="">
						</form>
					</td>
					<td>
						<form method="post" action="customer-delete">
							<input type="submit" name="button" value="削除"> <input
								type="hidden" name="customerId"
								value="">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		<form method="post" action="customer-list">
			<input type="submit" name="button" value="顧客一覧">
		</form>
	</div>
</body>
</body>
</html>