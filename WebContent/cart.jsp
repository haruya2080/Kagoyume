<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.ItemData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.SessionNameSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();
	// カート情報をセッションから取得
	ArrayList<ItemData> cartItems =
		(ArrayList<ItemData>)session.getAttribute(SessionNameSet.CartItems);
	boolean existItems = (cartItems != null);
	// ログインしているか確認
	boolean isLogin = (session.getAttribute(SessionNameSet.LoginUser) != null);

	int ac = (Integer)session.getAttribute("ac");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume 買い物かご</title>
<jsp:include page="bootstrap_head.html"/>
<link href="css/item-view.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<section class="jumbotron text-xs-center">
		<div class="container">
      	<h1 class="jumbotron-heading">買い物かご</h1>
      	<% if (existItems) { %>
				<p class="lead text-muted">数量：<%=cartItems.size() %>件</p>
				<p class="lead text-muted">合計金額：￥<%=helper.calcTotal(cartItems) %></p>
				<p>
				<% if (isLogin) { %>
      		<a href="BuyConfirm?ac=<%=ac%>" class="btn btn-primary">購入</a>
      		<% } else { %>
      		<a href="Login" class="btn btn-secondary">ログインが必要です</a>
      		<% } %>
      		<a href="Cart?action=allDelete" class="btn btn-danger">全削除</a>
      		</p>
      	<% } else { %>
				買い物かごに商品はありません。
      	<% } %>
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
					<p>
					<a href="Item?id=<%=id %>" class="card-text">
						<%=item.getName() %><br>
					</a>
					</p>
					<p>￥<%=item.getValue() %></p>
					<p>個数：1</p>
      			<a href="Cart?action=delete&id=<%=id %>" class="btn btn-danger">削除</a>
				</div>
				<% id++; %>
			<% } %>
    </div> <!-- "row" -->
    </div> <!-- "container" -->
    </div> <!-- "album text-muted" -->
    <% } %>

    <jsp:include page="footer.jsp"/>
</body>
</html>