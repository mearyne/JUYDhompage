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
<title>main page</title>
</head>
<body>
	<%
	// 메인 페이지입니다.
//	if (session.getAttribute("chkLog") == null) {
//		session.setAttribute("chkLog", 0);
//	}
	System.out.println("logCode :: " + ((String) session.getAttribute("logCode")));
	shopDAO shopdao = shopDAO.getInstance();
	
	ArrayList<shopDTO> shopArr = shopdao.bringShopArr();
	
	%>
	<jsp:include page="/header"></jsp:include>

	<aside></aside>
	
	

	<section>
		<div id="map"></div>
		<div id="info">
			<button id="shopInfo">가게</button>
			<button id="favoriteInfo">찜가게</button>
			<div id="articleList">
			<script src="./js/index.js"></script>
			
			<%
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
			%>
			</div>
		</div>
	</section>
	<aside></aside>
	<jsp:include page="/footer"></jsp:include>
<!-- 	<script src="./js/index.js"></script> -->

	<!-- 맵을 불러오는 자바스크립트 -->

</body>
</html>