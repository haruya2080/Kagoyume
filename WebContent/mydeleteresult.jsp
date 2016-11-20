<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume 削除完了</title>
<jsp:include page="bootstrap_head.html"/>
<style type="text/css">
.button-layout {
	float: right;
	max-width: 300px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<div class="jumbotron">
		<h1>削除完了</h1>
		<p>削除しました。</p>
		<div class="button-layout">
		<p><a class="btn btn-primary btn-block" href="top.jsp">トップに戻る</a></p>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>