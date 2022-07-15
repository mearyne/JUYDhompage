<%@page import="shop.shopDTO"%>
<%@page import="shop.shopDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="review.reviewDAO"%>
<%@page import="review.reviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/mypage.css">
<title>review</title>
</head>
<body>

	<%
	// 내가 작성했던 리뷰들을 볼 수 있는 장소입니다.
	// 내가 작성했던 리뷰들을 수정, 삭제 할 수 있습니다.
	String userCode = (String) session.getAttribute("logCode");
	userCode = userCode.substring(1);
	int code = Integer.parseInt(userCode);
	//int code = 1;
	reviewDAO rdao = reviewDAO.getInstance();
	shopDAO sdao = shopDAO.getInstance();
	
	
	ArrayList<reviewDTO> reviewdata = rdao.getuser(code);
	
	
	%>
	<jsp:include page="/header"></jsp:include>
	<aside></aside>

	<section class="mypage">
		<div class="pagelist">
			<a class="userpage" id="mypage" href="mypage">내 정보</a>
           <a class="userpage" id="orederlist" href="ordered">주문 목록</a>
           <a class="userpage" id="favlistlist" href="favoriteList">찜 목록</a>
           <a class="userpage" id="reviewlist" href="review">리뷰 목록</a>
        </div>
      
        
          <div class="pagedetail">
          <%for(int i =0; i<reviewdata.size(); i++){
        	  reviewDTO review = reviewdata.get(i);
        	  shopDTO shop = sdao.getshopData(review.getShopCode());
        	  
        	  String shopname = shop.getShopName();
        	  String reviewPic = review.getReviewPicture();
        	  int reviewStar = review.getReviewStar();
        	  String reviewContents  = review.getReviewContents();
        	  
        	  %> 
			<article id="review<%=i+1%>">
			<div id="shopname"><%=shopname %></div>
			<div id="reviewpic"><img src="<%=reviewPic %>"></div>
			<div id="reviewstar"><%=reviewStar %></div>
			<div id="reviewcon"><%=reviewContents %></div>
			</article>
          <%} %>
        </div>
	</section>

	<aside></aside>
	<jsp:include page="/footer"></jsp:include>

</body>
</html> 