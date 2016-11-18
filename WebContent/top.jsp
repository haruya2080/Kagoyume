<%@page import="kagoyume.SessionNameSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// ログインから戻る際にアクセスするページをセッションに保存
	session.setAttribute(SessionNameSet.PageURI, "/search.jsp");
%>
<!DOCTYPE html>
<html lang="jp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>かごいっぱいのゆめ</title>
<style type="text/css">
/* main1-app 背景画像の設定 */
.main1-app {
	background-image: url(img/bg_main1.jpg);
	background-position: 35% 50%;
	background-size: cover;
	color: #fff;
	text-shadow: 1px 1px 3px #000;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp"/>

	<div class="jumbotron">
		<h1>かごいっぱいのゆめ</h1>
		<p>ショッピングサイトを使っている時、こんな経験ありませんか？<br>
		「あれいいな」「これいいな」「あっ、関連商品のこれもいい」「20%オフセールだって！？　買わなきゃ！」<br>
		・・・そしていざ『買い物かご』を開いたとき、その合計金額に愕然とします。「こんなに買ってたのか・・・しょうがない。いくつか減らそう・・・」
　仕方がありません。無駄遣いは厳禁です。<br>
		でも、一度買うと決めたものを諦めるなんて、ストレスじゃあありませんか？　できればお金の事なんか考えずに好きなだけ買い物がしたい・・・。<br>
		このサービスは、そんなフラストレーションを解消するために生まれた『金銭取引が絶対に発生しない』『いくらでも、どんなものでも購入できる(気分になれる)』『ECサイト』です
		</p>
		<form action="Search" method="GET" class="form-inline">
			<input type="text" name="keyword" class="form-control" id="extampleField" required>
			<input type="submit" value="検索" class="btn btn-primary">
		</form>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
</html>