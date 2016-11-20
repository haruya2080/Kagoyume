<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserDataDTO user = (UserDataDTO)session.getAttribute(SessionNameSet.UserDataDTO);
	int userID = (Integer)session.getAttribute(SessionNameSet.LoginUserID);
	int ac = (Integer)session.getAttribute("ac");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume マイページ</title>
<jsp:include page="bootstrap_head.html" />
<style type="text/css">
.button-layout {
	float: right;
	max-width: 300px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<section class="jumbotron text-xs-center">
	<div class="container">
		<h1 class="jumbotron-heading">マイページ</h1>
		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>ユーザー名</th>
					<th>パスワード</th>
					<th>メールアドレス</th>
					<th>住所</th>
					<th>購入金額</th>
					<th>登録日時</th>
					<th>削除</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=user.getName() %></td>
					<td><%=user.getPassword() %></td>
					<td><%=user.getMail() %></td>
					<td><%=user.getAddress() %></td>
					<td><%=user.getTotal() %></td>
					<td><%=user.getNewDate().toString() %></td>
					<td><%=user.isDeleteFlag() ? "yes" : "no" %></td>
				</tr>
			</tbody>
		</table>

		<div class="button-layout">
		<div class="row">
		<a class="btn btn-info btn-block" href="MyHistory?ac=<%=ac%>">購入履歴</a>
		<a class="btn btn-primary btn-block" href="MyUpdate?ac=<%=ac%>">登録情報の更新</a>
		<a class="btn btn-danger btn-block" href="MyDelete?ac=<%=ac%>&userID=<%=userID%>">削除する</a>
		</div>
		</div>

	</div>
	</section>

	<jsp:include page="footer.jsp" />
</body>
</html>