<%@page import="menu.menuDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="menu.menuDAO"%>
<%@page import="shop.shopDTO"%>
<%@page import="shop.shopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  <link rel="stylesheet" href="./css/shopdetail.css">  -->
<title>shop detail</title>
</head>
<body>
	<%
	// 가게 상세페이지 입니다.
	
	//int shopCode = Integer.parseInt(request.getParameter("shopCode"));
	shopDAO shopdao = shopDAO.getInstance();
	shopDTO shopInfo = shopdao.getshopData(1);
	menuDAO menudao = menuDAO.getInstance();

	// 모든 메뉴의 정보를 가져옴
	ArrayList<menuDTO> menuInfo = menudao.menuInfo(1);
	%>
	<header>
		<div class="headerButton">
			<div class="mainButton" id="loginButton">로그인</div>
			<div class="mainButton" id="mypageButton">마이페이지</div>
		</div>
		<div class="logo">음식예약 사이트</div>
	</header>

	<aside></aside>
	<section>

		<div id="top">
			<div id="shopPic">사진이 들어올 자리입니다 <%=shopInfo.getShopPic()%></div>
			<div id="shopInfo">
				<div><h1>가게이름 : <%=shopInfo.getShopName() %></h1></div>
				<div><h3>카테고리 : <%=shopInfo.getShopCategory() %></h3></div>
				<div><h3>주소 : <%=shopInfo.getShopAddress() %></h3></div>
				<div><h3>소개 : <%=shopInfo.getShopContents() %></h3></div>
				<div><h3>별점 : <%=shopInfo.getShopStar() %></h3></div>
				<div><h3>리뷰 숫자 : <%=shopInfo.getReviewNum() %></h3></div>
			
			</div>
		</div>
		<div id="bottom">
			<div>
				<input type="button" value="메뉴"> <input type="button" value="리뷰">
			</div>
			<div id="menuList">
				<%
				for (int i = 0; i < menuInfo.size(); i++) {
					menuDTO menu = menuInfo.get(i);
					
					// menu 정보들을 변수에 저장함
					String menuPicture = menu.getMenuPicture();
					String menuName = menu.getMenuName();
					int menuPrice = menu.getMenuPrice();
					String menuContents = menu.getMenuContents();
					
					%>
					<div id=menu<%=i+1 %> class="menuBlock">
						<div id="menuPic">사진 : <%=menuPicture %></div>
						<div id="menuName">이름 : <%=menuName %></div>
						<div id="menuPrice">가격 : <%=menuPrice %></div>
						<div id="menuContents">내용 : <%=menuContents %></div>
					</div>
					<%
				}
				%>

			</div>
			<div id="reviewList">
				<div id="review1"></div>
				<div id="review2"></div>
				<div id="review3"></div>
				<div id="review4"></div>
				<div id="review5"></div>
			</div>
		</div>


	</section>
	<aside></aside>
	<footer>
		<p class="footerfont">
			정의형 이정목 송윤주 우다영 <br> 이건 footer
		</p>
	</footer>
</body>
</html>