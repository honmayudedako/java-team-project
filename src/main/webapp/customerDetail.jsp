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
	<divl>
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
			<tr>
				<%-- <td><%=request.getArrribute("id")%></td>
				<td><%=request.getArrribute("name")%></td>
				<td><%=request.getArrribute("nameKana")%></td>
				<td><%=request.getArrribute("postCode")%></td>
				<td><%=request.getArrribute("areaCode")%></td>
				<td><%=request.getArrribute("gender")%></td>
				<td><%=request.getArrribute("birthday")%></td>
				<td><%=request.getArrribute("phoneNumber")%></td>
				<td><%=request.getArrribute("insertDatetime")%></td>
				<td><%=request.getArrribute("updateDatetime")%></td> --%>
			</tr>
		</tbody>
	</table>
	<form action=".jsp" method="post">
		<input type="submit" value="編集">
	</form>
	<form action=".jsp" method="post">
		<input type="submit" value="削除">
	</form>
	<form action=".jsp" method="post">
		<input type="submit" value="顧客一覧">
	</form>
	</div>
</body>
</body>
</html>