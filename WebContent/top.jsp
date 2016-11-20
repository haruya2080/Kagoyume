<%@page import="kagoyume.SessionNameSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// ログインから戻る際にアクセスするページをセッションに保存
	session.setAttribute(SessionNameSet.PageURI, "/top.jsp");
	// header用、アクセスルートチェック
	session.setAttribute("ac", (int) (Math.random() * 1000));
%>
<!DOCTYPE html>
<html lang="jp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kagoyume かごいっぱいのゆめ</title>
<jsp:include page="bootstrap_head.html"/>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div class="jumbotron">
		<h1 class="jumbotron-heading">かごいっぱいのゆめ</h1>
		<p>ショッピングサイトを使っている時、こんな経験ありませんか？<br>
		「あれいいな」「これいいな」「あっ、関連商品のこれもいい」「20%オフセールだって！？　買わなきゃ！」<br>
		・・・そしていざ『買い物かご』を開いたとき、その合計金額に愕然とします。「こんなに買ってたのか・・・しょうがない。いくつか減らそう・・・」
　仕方がありません。無駄遣いは厳禁です。<br>
		でも、一度買うと決めたものを諦めるなんて、ストレスじゃあありませんか？　できればお金の事なんか考えずに好きなだけ買い物がしたい・・・。<br>
		このサービスは、そんなフラストレーションを解消するために生まれた『金銭取引が絶対に発生しない』『いくらでも、どんなものでも購入できる(気分になれる)』『ECサイト』です
		</p>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>