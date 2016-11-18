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
<title>Insert title here</title>
</head>
<body>
	<h1>追加完了</h1>
	<%=itemData.getName() %><br>
	を追加しました。
</body>
</html>