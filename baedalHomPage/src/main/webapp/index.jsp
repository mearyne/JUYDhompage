<%@page import="shop.shopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.shopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/index.css">
<link rel="stylesheet" href="./css/searchMap.css">

<!-- kakao map을 불러오기 위한 코드입니다 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c74772d00f549d2606dc566151ba1cd&libraries=services"></script>
<title>mainpage</title>
</head>
<body>
	<%
	// 로그인에 성공하면 알림창을 띄웁니다
	Object chkLoginObject = request.getAttribute("chkLogin");
	if (chkLoginObject != null) {
		String chkLogin = (String) chkLoginObject;
		if (chkLogin.equals("1")) {
			%> <script> alert('로그인에 성공했습니다'); </script> <%
		}
		
	}
	
	// 메인 페이지입니다.
	shopDAO shopdao = shopDAO.getInstance();
	ArrayList<shopDTO> shopArr = shopdao.bringShopArr();

	// 로그인 코드를 session에서 가져옴 
	String chk = "-1";
	if (session.getAttribute("logCode") != null) {
		chk = (String) session.getAttribute("logCode"); // u1111
		chk = String.format("`%s`", chk); // `u1111` 
	}
	%>

	<jsp:include page="/header"></jsp:include>
	<aside></aside>

	<section>
		<!-- 맵이 들어설 공간 -->
		<div id="map"></div>
		<!--  검색 키워드 -->
		<div id="menu_wrap" class="bg_white">
			<div class="option">
				<div>
					<form onsubmit="searchPlaces(); return false;">
						키워드 : <input type="text" value="강남역 맛집" id="keyword" size="15">
						<button type="submit">검색하기</button>
					</form>
				</div>
			</div>
			<hr>
			<ul id="placesList"></ul>
			<div id="pagination"></div>
		</div>
		
		<script src="./js/index.js"></script>
		<script src="./js/searchMap.js"></script>
		
		<div id="info">
			<button id="shopInfo" style="background-color: rgb(176, 176, 176);" onclick='location.href=`./index`'>가게</button>
			<button id="favoriteInfo" onclick='viewFavoriteList(<%=chk%>)'>찜가게</button>
			<div id="articleList">

				<%
				for (int i = 0; i < shopArr.size(); i++) {
					shopDTO shopInfo = shopArr.get(i);

					int shopCode = shopInfo.getShopCode();
					String shopPic = shopInfo.getShopPic();
					String shopName = shopInfo.getShopName();
					String shopCategory = shopInfo.getShopCategory();
					int shopStar = shopInfo.getShopStar();

					double shopX = shopInfo.getShopX();
					double shopY = shopInfo.getShopY();

					System.out.println(i + "번째 shopX : " + shopX);
					System.out.println(i + "번째 shopY : " + shopY);
				%>

				<script> makeMarker(<%=shopX%>, <%=shopY%>, <%=shopCode%>, `<%=shopPic%>`, `<%=shopName%>`, `<%=shopCategory%>`, <%=shopStar%>);</script>
				<%
				}
				%>
			</div>
		</div>
	</section>
	<aside></aside>
	<jsp:include page="/footer"></jsp:include>

</body>
</html>