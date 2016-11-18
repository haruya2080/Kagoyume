<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();
	String loginUser = (String) session.getAttribute(SessionNameSet.LoginUser);
	String pageName = request.getParameter("pageName");
	String pageURI = request.getParameter("pageURI");
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
	<% if (loginUser != null) { %>
		<div class="pull-xs-right">
		<a class="nav-item nav-link active" href="#"><span class="sr-only">(current)</span></a>
		<ul style="list-style : none; padding : 0;">
			<li class="nav-item">
				ようこそ！<%=loginUser%>さん！
			</li>
			<li class="nav-item">
				<a class="btn btn-primary btn-block" href="#">買い物かご</a>
			</li>
			<li class="nav-item" style="margin-left: 2px;">
				<a class="btn btn-primary btn-block" href="Login?action=logout">ログアウト</a>
			</li>

			</ul>
		</div>
	<% } else { %>
		<div class="pull-xs-right">
			<ul style="list-style : none; padding : 0;">
			<% if (helper.checkHeaderLoginBtn(pageName)) { %>
			<li class="nav-item">
				<a class="btn btn-primary btn-block" href="Login?action=login">ログイン</a>
			</li>
			<% } %>

			<% if (helper.checkHeaderRegistrationBtn(pageName)) { %>
			<li class="nav-item" style="margin-left: 2px;">
				<a class="btn btn-primary btn-block" href="Registration">新規登録</a>
			</li>
			<% } %>
			</ul>
		</div>
	<% } %>
	</div>
</nav>
</body>
</html>