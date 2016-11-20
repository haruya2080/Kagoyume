<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.KagoyumeHelper"%>
<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.UserData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();

	UserData userData = (UserData)session.getAttribute(SessionNameSet.UserData);
	ArrayList<String> chkList = new ArrayList<String>();
	if (userData == null) {
		userData = new UserData();
	} else {
		chkList = userData.chkProperties();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume 新規登録</title>
<jsp:include page="bootstrap_head.html" />
<style type="text/css">
.form-registration {
	max-width: 500px;
	padding: 15px;
	margin: 0;
}

.button-layout {
	float: right;
	max-width: 300px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param value="registration" name="pageName"/>
	</jsp:include>
	<div class="jumbotron">
	<div class="container">
	<h1>新規登録</h1>
	<form action="RegistrationConfirm" method="POST" class="form-registration">
		<div class="form-group">
			<label for="formGroupExampleInput">ユーザー名</label>
			<input type="text" name="userName" value="<%=userData.getUserName() %>"
				class="form-control" id="formGroupExampleInput"
				placeholder="ユーザー名" required>
			<p style="color:red;"><%=helper.chkUserName(chkList) %></p>
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput2">パスワード</label>
			<input type="password" name="password" value="<%=userData.getPassword() %>"
				class="form-control" id="formGroupExampleInput2"
				placeholder="パスワード" required>
			<p style="color:red;"><%=helper.chkPassword(chkList) %></p>
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput2">パスワードの確認</label>
			<input type="password" name="rePassword" value="<%=userData.getPassword() %>"
				class="form-control" id="formGroupExampleInput2"
				placeholder="パスワードの確認" required>
			<p style="color:red;"><%=helper.chkRePassword(chkList) %></p>
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput">メールアドレス</label>
			<input type="email" name="email" value="<%=userData.getEmail() %>"
				class="form-control" id="formGroupExampleInput"
				placeholder="メールアドレス" required>
			<p style="color:red;"><%=helper.chkEmail(chkList) %></p>
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput">住所</label>
			<input type="text" name="address" value="<%=userData.getAddress() %>"
				class="form-control" id="formGroupExampleInput"
				placeholder="住所" required>
			<p style="color:red;"><%=helper.chkAddress(chkList) %></p>
		</div>
		<div class="button-layout">
			<input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
			<button class="btn btn-lg btn-primary btn-block" type="submit">登録</button>
		</div>
	</form>
	</div> <!-- div container -->
	</div> <!-- div jumbotron -->

	<jsp:include page="footer.jsp"/>
</body>
</html>