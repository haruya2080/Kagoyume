<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.ItemDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();
	ArrayList<ItemDataDTO> items = (ArrayList<ItemDataDTO>)request.getAttribute("items");
	int ac = (Integer)session.getAttribute("ac");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume 購入履歴</title>
<jsp:include page="bootstrap_head.html"/>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<div class="jumbotron">
		<h1 class="jumbotron-heading">購入履歴</h1>
		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>アイテムコード</th>
					<th>配送方法</th>
					<th>購入日時</th>
				</tr>
			</thead>
			<tbody>
				<% for (ItemDataDTO item : items) { %>
				<tr>
					<td><%=item.getItemCode() %></td>
					<td><%=helper.exShippingType(item.getType()) %></td>
					<td><%=item.getBuyDate().toString() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<p><a href="MyData?ac=<%=ac%>" class="btn btn-primary">マイページ</a></p>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>