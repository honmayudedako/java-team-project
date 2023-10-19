<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@page import="model.entity.UserBean"%>
<% UserBean user = (UserBean)session.getAttribute("user"); 
List<String> errors = (List<String>)request.getAttribute("errors"); 
String sqlFailed = (String)request.getAttribute("sqlFailed");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>顧客登録フォーム</title>
</head>
<body>
<%@ include file="/WEB-INF/include/header.jsp" %>
<h1>顧客登録フォーム</h1>
<%-- <%= user.getUserId() %>ログイン --%>

<%if (errors != null) {
	for(String error : errors) {%>
	<p><%= error %></p>
<% }
}%>
<%if (sqlFailed != null) {%>
<%= sqlFailed %>
<%} %>
<form action="create" method="post">
	<table>
		<tr>
			<td>氏名</td>
			<td><input type="text" name="customerName"></td>
		</tr>
		<tr>
			<td>かな</td>
			<td><input type="text" name="customerNameKana"></td>
		</tr>
		<tr>
			<td>郵便番号</td>
			<td><input type="text" name="postCode"></td>
		</tr>
		<tr>
			<td>地区</td>
			<td>
				<select type="text" name="areaCode">
					<option value="A000">未設定</option>
					<option value="A001">北海道</option>
					<option value="A002">東北</option>
					<option value="A003">関東</option>
					<option value="A004">中部</option>
					<option value="A005">近畿</option>
					<option value="A006">中国</option>
					<option value="A007">四国</option>
					<option value="A008">九州沖縄</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>性別</td>
			<td>
				<input type="radio" name="gender" value="男">男
				<input type="radio" name="gender" value="女">女
			</td>
		</tr>
		<tr>
			<td>生年月日</td>
			<td><input type="text" name="birthday"></td>
		</tr>
		<tr>
			<td>電話番号</td>
			<td><input type="text" name="phoneNumber"></td>
		</tr>
	</table>
	<input type="submit" value="顧客登録確定">
	<input type="reset" value="クリア">
</form>
<a href="menu.jsp">メニュー画面へ</a>

</body>
</html>