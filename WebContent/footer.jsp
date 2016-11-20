<%@page import="kagoyume.KagoyumeHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	KagoyumeHelper helper = KagoyumeHelper.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap_head.html"/>
<style type="text/css">
footer {
  padding-top: 3rem;
  padding-bottom: 3rem;
}

footer p {
  margin-bottom: .25rem;
}
</style>
</head>
<body>
	<footer class="text-muted">
      <div class="container">
        <p class="float-xs-right">
          <a href="top.jsp">Back to top</a>
        </p>
        <p>COPYRIGHT © Kagoyume ALL RIGHTS RESERVED.</p>
      </div>
    </footer>
</body>
</html>