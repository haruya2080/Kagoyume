<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();
	String loginUser = (String) session.getAttribute(SessionNameSet.LoginUser);
	String pageName = request.getParameter("pageName");
	String pageURI = request.getParameter("pageURI");
	int ac = (Integer)session.getAttribute("ac");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap_head.html"/>
<style type="text/css">
.navbar-brand {
	background: url("img/kagoyume_logo.png") no-repeat left center;
	background-size: cover;
	height: 38px;
	width: 150px;
}
</style>
</head>
<body>
<nav class="navbar navbar-dark bg-inverse">
	<div class="nav navbar-nav">
	<a class="navbar-brand" href="top.jsp"></a>

	<div class="pull-xs-right">
	<a class="nav-item nav-link active" href="#"><span class="sr-only">(current)</span></a>
	<ul style="list-style : none; padding : 0;">

	<% if (loginUser != null) { %>
		<li class="nav-item"> ようこそ！<%=loginUser%>さん！ </li>
	<% } %>

	<li class="nav-item">
		<a class="btn btn-info btn-block" href="Cart">買い物かご</a>
	</li>

	<% if (loginUser != null) { %>
		<li class="nav-item">
			<a class="btn btn-info btn-block" href="MyData?ac=<%=ac%>">マイページ</a>
		</li>
		<li class="nav-item" style="margin-left: 2px;">
			<a class="btn btn-primary btn-block" href="Login">ログアウト</a>
		</li>
	<% } else { %>
		<% if (helper.checkHeaderLoginBtn(pageName)) { %>
		<li class="nav-item">
			<a class="btn btn-primary btn-block" href="Login">ログイン</a>
		</li>
		<% } %>

		<% if (helper.checkHeaderRegistrationBtn(pageName)) { %>
		<li class="nav-item" style="margin-left: 2px;">
			<a class="btn btn-primary btn-block" href="Registration">新規登録</a>
		</li>
		<% } %>
	<% } %>
	</ul>
	</div>

	<a>
	<form action="Search" method="GET" class="form-inline">
		<input type="text" name="keyword" class="form-control" id="extampleField" required>
		<input type="submit" value="検索" class="btn btn-primary">
	</form>
	</a>
	</div>
</nav>
</body>
</html>