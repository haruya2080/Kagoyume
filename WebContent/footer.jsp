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
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
        <p>New to Bootstrap? <a href="../../">Visit the homepage</a> or read our <a href="../../getting-started/">getting started guide</a>.</p>
      </div>
    </footer>
</body>
</html>