<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.ItemData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ItemData itemData = (ItemData)session.getAttribute(SessionNameSet.SelectItem);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume 追加完了</title>
<jsp:include page="bootstrap_head.html"/>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<div class="jumbotron">
		<h1>追加完了</h1>
		<p>"<%=itemData.getName() %>"を追加しました。</p>
		<p><a href="Cart" class="btn btn-primary">買い物かご</a></p>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>