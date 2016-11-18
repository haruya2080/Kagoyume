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

	<div class="card">
	<img class="card-img-top" src="<%=itemData.getImageURI() %>" alt="Card image cap">
	<div class="card-block">
		<h4 class="card-title"><%=itemData.getValue() %>円></h4>
		<p class="card-text" style="width:30em"><%=itemData.getName() %></p>
		<form action="AddCart" method="POST">
			<input  type="submit" name="btnSubmit" value="カートに追加" class="btn btn-primary">
		</form>
	</div>
</div>
</body>
</html>