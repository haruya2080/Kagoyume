<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume ログイン</title>
<jsp:include page="bootstrap_head.html" />
<style type="text/css">
.login-body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param value="login" name="pageName"/>
	</jsp:include>
	<div class="login-body">
	<div class="container">
		<form action="Login" method="POST" class="form-signin">
			<h2 class="form-signin-heading">ログイン</h2>
			<label for="inputEmail" class="sr-only">ユーザー名</label>
			<input type="text" name="userName"
				id="inputEmail" class="form-control"
				placeholder="ユーザー名" required autofocus>
			<label for="inputPassword" class="sr-only">パスワード</label>
			<input type="password" name="password"
				id="inputPassword" class="form-control"
				placeholder="パスワード" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me"> Remember me </label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">ログイン</button>
		</form>

		<form action="Registration" method="POST" class="form-signin">
			<button class="btn btn-lg btn-primary btn-block" type="submit">新規登録</button>
		</form>
	</div><!-- container -->
	</div><!-- login-body -->

	<jsp:include page="footer.jsp"/>
</body>
</html>