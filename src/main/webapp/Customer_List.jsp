<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.entity.CustomerBean"%>
<%
List<CustomerBean> customerList = (List<CustomerBean>) request.getAttribute("customerList");
System.out.println(customerList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer_List</title>
<link rel="stylesheet" href="style.css" type="text/css">

</head>
<body>
	<h1>顧客一覧</h1>
	<form action="customer-list" method="post">
		<input type="text" name="searchWord">
		<button type="submit" name="button" value="検索">検索</button>
	</form>
	<button class="back" value="メニュー画面へ" method="post">
		<a href="menu.jsp">メニュー画面へ</a>
	</button>

	<%
	if (false) {
	%>



	<table>
		<tbody>

			<tr>
				<td>顧客ID</td>
				<td>氏名</td>
				<td>かな</td>
				<td>性別</td>
				<td></td>
			</tr>

			<%
			for (CustomerBean customer : customerList) {
			%>
			<tr>
				<td><%=customer.getId()%></td>
				<td><%=customer.getName()%></td>
				<td><%=customer.getNameKana()%></td>
				<td><%=customer.getgender()%></td>
				<input type="hidden" name="customerId" value="<%=customer.getId()%>"
					action="customer-detail">
				<td><button type="submit" name="button" value="詳細">詳細</button></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<%
	}
	%>

</body>
</html>