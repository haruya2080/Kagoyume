<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.ItemData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ItemData itemData = (ItemData) session.getAttribute(SessionNameSet.SelectItem);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><%=itemData.getName() %></title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのCSS読み込み -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="jumbotron">
		<h1>商品詳細</h1>
		<p><%=itemData.getName() %></p>
		<p>
		<img src="<%=itemData.getImageURI() %>" alt="<%=itemData.getName() %>">
		</p>
		<p>￥<%=itemData.getValue() %></p>
		<p><%=itemData.getDescription() %></p>
		<form action="AddCart" method="POST">
			<input  type="submit" name="btnSubmit" value="カートに追加" class="btn btn-primary">
		</form>

	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>