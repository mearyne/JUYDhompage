<%@page import="review.reviewDTO"%>
<%@page import="review.reviewDAO"%>
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
<link rel="stylesheet" href="./css/shopdetail.css">

<style>

	* {
	    margin: 0;
	    padding: 0;
	}
	
	#top {
		display: flex;
		margin: 5px;
	}
	
	
	
	section {
	    float: right;
	    width: 70%;
	    height: 90vh;
	    
	    text-align: center;
	}
	
	<!-- img{
		width: 300px;
		height: 300px;
	} -->
	
	
	#reviewList{
		display: flex;
		flex-direction: column;
	}
		
	#shopInfo, #shopPic {
		width: 49%;
		height: auto;
	}
	
	button {
		width: 232.5px;
	    height: 48px;
	    background: white;
	    color: black;
	    border: solid 1px;
	}
	
	button.buttonMenu {
		font-size: 23px;
	}
	
	img#shopPicture {
		height: 300px;
		width: 300px;
	}
	
	.menuBlock {
		display: flex;
	}
	
	#shopPicture {
		width: 150px;
		height: 150px;
	}
	
	#menuPic, #menuInfo {
		width: 49%;
		margin: 50px;
		height: auto;
	}
	
	.reviewBlock {
		display: flex;
		margin: 50px;
	}
	
	section{
	  height: auto;
	  min-height: 100%;
	  padding-bottom: 100px;
	}
	
	footer{
	  height: 100px;
	  position : relative;
	}
	


</style>

<title>shop detail</title>
</head>
<body>
	<%
	// 가게 상세페이지 입니다.
	
	int shopCode = Integer.parseInt(request.getParameter("shopCode"));
	shopDAO shopdao = shopDAO.getInstance();
	shopDTO shopInfo = shopdao.getshopData(shopCode);
	menuDAO menudao = menuDAO.getInstance();
	reviewDAO reviewdao= reviewDAO.getInstance();
	

	// 모든 메뉴, 리뷰의 정보를 가져옴
	ArrayList<menuDTO> menuInfo = menudao.menuInfo(shopCode);
	ArrayList<reviewDTO> reviewdto = reviewdao.getshop(shopCode);
	%>

	<jsp:include page="/module/header.jsp"></jsp:include>
	<aside></aside>
	<section>
		<div id="top">
			<div id="shopPic"> <img id="shopPicture" src="<%=shopInfo.getShopPic()%>" ></div>
			<div id="shopInfo">
				<div><h1>가게이름 : <%=shopInfo.getShopName() %></h1></div>
				<div><h3>카테고리 : <%=shopInfo.getShopCategory() %></h3></div>
				<div><h3>주소 : <%=shopInfo.getShopAddress() %></h3></div>
				<div><h3>소개 : <%=shopInfo.getShopContents() %></h3></div>
				<div><h3>별점 : <%=shopInfo.getShopStar() %></h3></div>
				<div><h3>리뷰 숫자 : <%=shopInfo.getReviewNum() %></h3></div>
				<button class="buttonMenu">예약하기</button>
			
			</div>
		</div>
		<div id="bottom">
			<div>
				<hr><br>
				<button class="buttonMenu" onclick="location.href=`#menuText`">메뉴</button>
				<button class="buttonMenu" onclick="location.href=`#reviewText`">리뷰</button>
			</div>
			<div id="menuList">
			<br><hr id="menuText">
			<br><h1>메뉴</h1>
			<br><hr><br>
				<%
				for (int i = 0; i < menuInfo.size(); i++) {
					menuDTO menu = menuInfo.get(i);
					
					// menu 정보들을 변수에 저장함
					String menuPicture = menu.getMenuPicture();
					String menuName = menu.getMenuName();
					int menuPrice = menu.getMenuPrice();
					String menuContents = menu.getMenuContents();
					
					System.out.println(menuPicture);
					%>
					<div id=menu<%=i+1 %> class="menuBlock">
						<div id="menuPic"><img src="<%=menuPicture %>"></div>
						<div id="menuInfo">
							<div id="menuName"><h2>이름 : <%=menuName %></h2></div>
							<div id="menuPrice">가격 : <%=menuPrice %> 원</div>
							<div id="menuContents">내용 : <%=menuContents %></div>
						</div>
					</div>
				<br><hr>
					<%
				}
				%>

			</div>
			<hr style="height:5px; background-color:grey;">
			<div id="reviewList"> 
			<br id="reviewText"><h1 >리뷰</h1>
				<%for(int i=0; i<reviewdto.size(); i++) {
					int reivewStar = reviewdto.get(i).getReviewStar();
					String reviewContents = reviewdto.get(i).getReviewContents();
					String reviewPic = reviewdto.get(i).getReviewPicture();
					
					System.out.println(reviewPic);

					%>
					<br><hr>
						<div id="review<%=i+1%>" class="reviewBlock">
							<div id="menuInfo">
								<div><h3>별점 : <%=reivewStar %> 점</h3></div>
								<div><%=reviewContents %></div>
							</div>
							<div><img src="<%=reviewPic %>"></div>
						</div>
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