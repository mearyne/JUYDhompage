<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/index.css">

<!-- kakao map을 불러오기 위한 코드입니다 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c74772d00f549d2606dc566151ba1cd"></script>

<title>main page</title>
</head>
<body>
	<%
	// 메인 페이지입니다.
	%>
	<header>
		<div class="headerButton">
			<!-- 로그인이 된다면 로그아웃으로 변경된다 -->
			<button class="mainButton" id="loginButton">로그인</button> 
			 <!-- 일반유저, 매니저에 따라서 마이페이지로 이동하는 곳이 달라진다 -->
			<button class="mainButton" id="mypageButton">마이페이지</button>
		</div>
	<div class="logo"><a href="./index">가게 예약 사이트</a></div>
	</header>

	<aside></aside>
	<section>
		<div id="map"></div>
		<div id="info">
			<button id="shopInfo">가게</button>
			<button id="favoriteInfo">찜가게</button>
			<article>정보1</article>
			<article>정보2</article>
			<article>정보3</article>
			<article>정보4</article>
			<article>정보5</article>
			<article>정보6</article>
			<article>정보7</article>
			<article>정보8</article>
		</div>
	</section>
	<aside></aside>

	<footer>
		<p class="footerfont"></p>
	</footer>

	<script src="./js/index.js"></script>

</body>
</html>