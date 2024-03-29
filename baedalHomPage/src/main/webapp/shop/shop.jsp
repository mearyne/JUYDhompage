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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
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
	
	.buttonMenu {
	    width: 232.5px;
	    height: 48px;
	    background: white;
	    color: black;
	    border: solid 1px;
	    font-size: 23px;
	}
	
	.submitMenu{
	width: 232.5px;
	    height: 48px;
	    background: white;
	    color: black;
	    border: solid 1px;
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
	
	input:hover {
			background-color: grey;
	}
	


</style>

<title>shop detail</title>
</head>
<body>
	<%
	// 예약하기 업데이트 성공했는지 여부에 따라서 알림창을 띄운다
	Object chkorderObject = request.getAttribute("chkorder");
	if (chkorderObject != null) {
		int chkorder = (int) chkorderObject;
		if (chkorder == 1) {
			%> <script> alert('예약하기 성공');</script> <%
		} else if (chkorder == -1) {
			%> <script> alert('예약하기 실패');</script> <%
		}
	}
	
	// 찜하기 업데이트에 성공했는지 실패했는지에 따라서 알림창을 띄운다
	Object chkfavoObject = request.getAttribute("chkfavo");
	System.out.println("chkfavo : " + chkfavoObject);
	if (chkfavoObject != null) {
		int chkfavo = (int) chkfavoObject;
		if (chkfavo != 1) {
			%> <script> alert('찜 성공');</script> <%
		} else if (chkfavo == -1) {
			%> <script> alert('이미 찜 상태입니다');</script> <%
		}
		
	}
		
	// 가게 코드를 가져옴	
	int shopCode = Integer.parseInt(request.getParameter("shopCode"));
	
	// 가게 데이터를 가져옴
	shopDAO shopdao = shopDAO.getInstance();
	shopDTO shopInfo = shopdao.getshopData(shopCode);
	menuDAO menudao = menuDAO.getInstance();
	reviewDAO reviewdao= reviewDAO.getInstance();
	
	// 유저 코드를 가져옴
	int userCode =-1;
	String user= (String) session.getAttribute("logCode");
	System.out.println("user :"+user);
	
	if(user!=null){
		String tempuser=user.substring(1);
		userCode = Integer.parseInt(tempuser);
		System.out.println("!!!logCode ="+ tempuser);
	} 
	
	System.out.println("userCode=" + userCode);
	System.out.println("!!!user ="+ user);

	
	// 모든 메뉴, 리뷰의 정보를 가져옴
	ArrayList<menuDTO> menuInfo = menudao.menuInfo(shopCode);
	ArrayList<reviewDTO> reviewdto = reviewdao.getshop(shopCode);
	%>

	<jsp:include page="/module/header.jsp"></jsp:include>
	<aside></aside>
	
	<section>
		<!-- form 구간 -->
		<form action="./Service" method="post" >
			<input type="hidden" name="command" value="addfavo">
			<input type="hidden" value="<%=userCode %>" name="usercode">
			<input type="hidden" value="<%=shopCode %>" name="shopcode">
			<input type="hidden" value="<%=user %>" name="user" class="favochk">
			<div id="top">
				<div id="shopPic"><img id="shopPicture" src="<%=shopInfo.getShopPic()%>" ></div>
				<div id="shopInfo">
					<div><h1>가게이름 : <%=shopInfo.getShopName() %></h1></div>
					<div><h3>카테고리 : <%=shopInfo.getShopCategory() %></h3></div>
					<div><h3>주소 : <%=shopInfo.getShopAddress() %></h3></div>
					<div><h3>소개 : <%=shopInfo.getShopContents() %></h3></div>
					<div><h3>별점 : <%=shopInfo.getShopStar() %>점</h3></div>
					<div><h3>리뷰 숫자 : <%=shopInfo.getReviewNum() %>개</h3></div>
					<br> <input type="button" class="buttonMenu" value="예약하기" onclick="location.href='./booking?shopCode=<%=shopCode%>'"><br>
					<input type="submit" class="submitMenu" value="찜하기">
				
				</div>
			</div>
		</form>
		
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