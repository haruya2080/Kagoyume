<%@page import="kagoyume.SearchResultData"%>
<%@page import="kagoyume.SessionNameSet"%>
<%@page import="kagoyume.ItemData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SearchResultData resultData =
		(SearchResultData)session.getAttribute(SessionNameSet.SearchResult);
	// 検索結果がない場合、インスタンス作成
	if (resultData == null) { resultData = new SearchResultData(); }
	boolean existItems = (resultData.getCount() > 0);
	int pageNum = resultData.getPage();
%>
<!DOCTYPE html>
<html lang="jp">
<head>
	<title>商品一覧</title>
	<jsp:include page="bootstrap_head.html"/>
<link href="css/item-view.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"/>

	<section class="jumbotron text-xs-center">
		<div class="container">
      	<h1 class="jumbotron-heading">
	      	"<%=resultData.getKeyword() %>"の検索結果
      	</h1>
      	<p class="lead text-muted">
      		検索結果：<%=resultData.getCountTxt() %>件
      	</p>

      	<p class="lead text-muted">
      		ページ：<%=resultData.getPage() + 1 %> / <%=resultData.getTotalPage() %>
      	</p>

      	<p>
      		<% if (pageNum > 0) { %>
      		<a href="Search?keyword=<%=resultData.getKeyword() %>&page=<%=resultData.getPage()-1 %>" class="btn btn-secondary">戻る</a>
      		<% } %>

				<% if (pageNum < resultData.getTotalPage() - 1) { %>
      		<a href="Search?keyword=<%=resultData.getKeyword() %>&page=<%=resultData.getPage()+1 %>" class="btn btn-primary">次へ</a>
      		<% } %>
      	</p>
      </div>
   </section>
	<% if (existItems) { %>
   	<div class="album text-muted">
      <div class="container">
      <div class="row">
			<% int id = 0; %>
			<% for(ItemData item : resultData.getItems()) { %>
				<div class="card">
					<img src="<%=item.getImageURI() %>" alt="Card image cap">
					<p>
					<a href="Item?id=<%=id %>" class="card-text">
						<%=item.getName() %><br>
					</a>

					</p>
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