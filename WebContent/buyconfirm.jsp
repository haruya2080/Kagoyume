<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.ItemData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();
	ArrayList<ItemData> cartItems = (ArrayList<ItemData>) session.getAttribute(SessionNameSet.CartItems);
	boolean existItems = (cartItems != null);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume 購入確認</title>
<jsp:include page="bootstrap_head.html" />
<link href="css/item-view.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<section class="jumbotron text-xs-center">
	<div class="container">
		<h1 class="jumbotron-heading">購入確認</h1>
		<p class="lead text-muted">数量：<%=cartItems.size() %>件</p>
		<p class="lead text-muted">合計金額：￥<%=helper.calcTotal(cartItems) %></p>
		<p>
		<form action="BuyComplete" method="GET">
			<label class="custom-control custom-radio">
			<input id="radio1" name="type" value="1"
				type="radio" class="custom-control-input">
				<span class="custom-control-indicator"></span>
				<span class="custom-control-description">宅配便</span>
			</label>
			<label class="custom-control custom-radio">
			<input id="radio2" name="type" value="2"
				type="radio" class="custom-control-input">
				<span class="custom-control-indicator"></span>
				<span class="custom-control-description">コンビニ受け取り</span>
			</label>
			<p>
			<input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
			<button type="submit" class="btn btn-primary">
				上記の内容で購入する
			</button>
			</p>
		</form>
		</p>
		<p>
			<a href="Cart" class="btn btn-secondary">カートに戻る</a>
		</p>
	</div>
	</section>

	<% if (existItems) { %>
  	<div class="album text-muted">
     <div class="container">
     <div class="row">
     	<% int id = 0; %>
		<% for(ItemData item : cartItems) { %>
			<div class="card">
				<img src="<%=item.getImageURI() %>" alt="Card image cap">
				<p class="card-text"><%=item.getName() %></p>
				<p>￥<%=item.getValue() %></p>
				<p>個数：1</p>
			</div>
			<% id++; %>
		<% } %>
	</div> <!-- "row" -->
	</div> <!-- "container" -->
	</div> <!-- "album text-muted" -->
	<% } %>

	<jsp:include page="footer.jsp" />
</body>
</html>