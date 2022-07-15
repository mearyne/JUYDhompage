<%@page import="favorite.favoriteDTO"%>
<%@page import="favorite.favoriteDAO"%>
<%@page import="shop.shopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.shopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/index.css">

<!-- kakao map을 불러오기 위한 코드입니다 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c74772d00f549d2606dc566151ba1cd"></script>
<title>mainpage</title>
</head>
<body>
	<%
	System.out.println("logCode :: " + ((String) session.getAttribute("logCode")));
	shopDAO shopdao = shopDAO.getInstance();
	
	ArrayList<shopDTO> shopArr = shopdao.bringShopArr();
	
	// 즐겨찾기 목록을 불러온다
	String userCode = (String) session.getAttribute("logCode");
	userCode = userCode.substring(1);
	int code = Integer.parseInt(userCode);
		
	favoriteDAO fdao = favoriteDAO.getInstance();
	shopDAO sdao= shopDAO.getInstance();
	
	// 즐겨찾기 목록이 favdata 안에 저장됨
	ArrayList<favoriteDTO> favdata = fdao.getuserfavorite(code);
	
	%>
	<jsp:include page="/header"></jsp:include>
	
	<aside></aside>
	<section>
		<div id="map"></div>
		<div id="info">
			<button id="shopInfo" onclick='location.href=`./index`'>가게</button>
			<button id="favoriteInfo" style="background-color: rgb(176, 176, 176);" onclick='viewFavoriteList()'>찜가게</button>
			<div id="articleList">
				<script src="./js/index.js"></script>
				<%
				// 지도에 마커를 뿌린다
				for(int i = 0; i < shopArr.size(); i++) {
					shopDTO shopInfo = shopArr.get(i);
					
					int shopCode = shopInfo.getShopCode();
					String shopPic = shopInfo.getShopPic();
					String shopName = shopInfo.getShopName();
					String shopCategory = shopInfo.getShopCategory();
					int shopStar = shopInfo.getShopStar();
					
					double shopX = shopInfo.getShopX();
					double shopY = shopInfo.getShopY();
					
					System.out.println(i+"번째 shopX : " + shopX);
					System.out.println(i+"번째 shopY : " + shopY);
					%> 
					<script> makeMarker(<%=shopX%>, <%=shopY%>, <%=shopCode%>, `<%=shopPic%>`, `<%=shopName%>`, `<%=shopCategory%>`, <%=shopStar%>);</script>
				<%
				} 
				// 오른쪽에 찜목록을 띄운다
				for(int i = 0; i < favdata.size(); i++) {
					int shopCode = favdata.get(i).getShopCode();
					shopDTO shopInfo = shopdao.getshopData(shopCode);
					String shopPic = shopInfo.getShopPic();
					String shopName = shopInfo.getShopName();
					String shopCategory = shopInfo.getShopCategory();
					int shopStar = shopInfo.getShopStar();
					%> 
					<article onclick='location.href="shop?shopCode=<%=shopCode%>"'> 
						<div class="articleBlock" id="subArticle1">
							<div id="menuPicture1"><img src="<%=shopPic %>"></div>
						</div>
						<div class="articleBlock" id="subArticle2">
							<div id="shopName"><h1>[<%=shopName %>]</h1></div>
							<div id="shopCategory"><h3><%=shopName %></h3></div>
							<div id="shopStar"><h1>별점 : <%=shopStar %></h1></div>
						</div>
					</article>
			<% } %>
			</div>
		</div>
	</section>
	<aside></aside>
	<jsp:include page="/footer"></jsp:include>

</body>
</html>