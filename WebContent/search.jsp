<%@page import="kagoyume.SessionNameSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kagoyume.ItemData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<ItemData> items =
		(ArrayList<ItemData>)session.getAttribute(SessionNameSet.SearchItems);

	boolean existItems = (items != null);
%>
<!DOCTYPE html>
<html lang="jp">
<head>
	<title>商品一覧</title>
	<jsp:include page="bootstrap_head.html"/>
<style type="text/css">
body {
  min-height: 75rem; /* Can be removed; just added for demo purposes */
}

.about {
  float: left;
  max-width: 30rem;
  margin-right: 3rem;
}

.social a {
  font-weight: 500;
  color: #eceeef;
}
.social a:hover {
  color: #fff;
}

.jumbotron {
  padding-top: 6rem;
  padding-bottom: 6rem;
  margin-bottom: 0;
  background-color: #fff;
}

.jumbotron p:last-child {
  margin-bottom: 0;
}

.jumbotron-heading {
  font-weight: 300;
}

.jumbotron .container {
  max-width: 40rem;
}

.album {
  min-height: 50rem; /* Can be removed; just added for demo purposes */
  padding-top: 3rem;
  padding-bottom: 3rem;
  background-color: #f7f7f7;
}

.card {
  float: left;
  width: 33.333%;
  min-height : 25rem;
  padding: .75rem;
  margin-bottom: 2rem;
  border: 0;
}

.card > img {
  margin-bottom: .75rem;
}

.card-text {
  font-size: 85%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<section class="jumbotron text-xs-center">
		<div class="container">
      	<h1 class="jumbotron-heading">検索結果</h1>
      	<p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don't simply skip over it entirely.</p>
      	<p>
      	<a href="#" class="btn btn-primary">Main call to action</a>
      	<a href="#" class="btn btn-secondary">Secondary action</a>
      	</p>
      </div>
    </section>
	<% if (existItems) { %>
   	<div class="album text-muted">
      <div class="container">
      <div class="row">
      	<% int id = 0; %>
			<% for(ItemData item : items) { %>
				<div class="card">
					<img src="<%=item.getImageURI() %>" alt="Card image cap">
					<p><a href="Item?id=<%=id %>" class="card-text">
						<%=item.getName() %><br>
					</a></p>
					<p>￥<%=item.getValue() %></p>
				</div>
				<% id++; %>
			<% } %>
    </div> <!-- "row" -->
    </div> <!-- "container" -->
    </div> <!-- "album text-muted" -->
    <% } %>

    <jsp:include page="footer.jsp"/>
</body>
</html>