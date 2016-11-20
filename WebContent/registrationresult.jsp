<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String)request.getAttribute("userName");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume 登録完了</title>
<jsp:include page="bootstrap_head.html"/>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<div class="jumbotron">
		<h1>ようこそ！<%=userName %>さん！</h1>
		<p>
		Kagoyumeへのユーザー登録が完了しました！<br>
		ショッピングをお楽しみください！<br>
		</p>
		<form action="Search" method="GET" class="form-inline">
			<input type="text" name="keyword" class="form-control" id="extampleField" required>
			<input type="submit" value="検索" class="btn btn-primary">
		</form>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>