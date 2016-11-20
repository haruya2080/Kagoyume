<%@page import="kagoyume.KagoyumeHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume 購入完了</title>
<jsp:include page="bootstrap_head.html"/>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="jumbotron">
		<h1 class="jumbotron-heading">購入完了</h1>
		<p>購入が完了しました。</p>
		<p><a href="top.jsp" class="btn btn-primary">トップに戻る</a></p>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>