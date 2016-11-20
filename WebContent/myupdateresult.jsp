<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int ac = (Integer)session.getAttribute("ac");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume ユーザー情報更新完了</title>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<div class="jumbotron">
		<h1>ユーザー情報更新完了</h1>
		<p>
		ユーザー情報の更新が完了しました。
		</p>
		<p><a href="MyData?ac=<%=ac%>" class="btn btn-primary">マイページ</a></p>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>