<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.UserData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();
	// セッションからユーザー情報の取得
	UserData userData = (UserData)session.getAttribute(SessionNameSet.UserData);

	// 入力情報のチェック
	ArrayList<String> chkList = userData.chkProperties();
	// 無効な値が1つ以上あった場合、無効フラグをオン
	boolean isInvalidProperties = (chkList.size() > 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="bootstrap_head.html" />
<style type="text/css">
.button-layout {
	float: right;
	max-width: 300px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param value="registrationConfirm" name="pageName"/>
	</jsp:include>
	<div class="jumbotron">
	<div class="container">
	<h1>登録確認</h1>
		<p>ユーザー名 : <%=userData.getUserName() %></p>
		<p>パスワード : <%=userData.getPassword() %></p>
		<p>メールアドレス : <%=userData.getEmail() %></p>
		<p>住所 : <%=userData.getAddress() %></p>
	<form action="RegistrationResult" method="POST">
		<div class="button-layout">
		<input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
		<button class="btn btn-lg btn-primary btn-block" type="submit">はい</button>
		</div>
	</form>
	<form action="Registration" method="POST">
		<div class="button-layout">
		<button class="btn btn-lg btn-info btn-block" type="submit">入力画面に戻る</button>
		</div>
	</form>
	</div> <!-- div container -->
	</div> <!-- div jumbotron -->
</body>
</html>