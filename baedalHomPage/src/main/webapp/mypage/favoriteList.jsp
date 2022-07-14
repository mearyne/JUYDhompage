<%@page import="shop.shopDTO"%>
<%@page import="favorite.favoriteDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.shopDAO"%>
<%@page import="user.userDTO"%>
<%@page import="favorite.favoriteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/mypage.css">
<title>favoriteShop list</title>
</head>
<body>
	<%
	String userCode = (String) session.getAttribute("logCode");
	userCode = userCode.substring(1);
	int code = Integer.parseInt(userCode);
		
		//int code = 1;
		
		favoriteDAO fdao = favoriteDAO.getInstance();
		shopDAO sdao= shopDAO.getInstance();
		
		ArrayList<favoriteDTO> favdata = fdao.getuserfavorite(code);
	%>
	<%
	// 찜목록 가게입니다		
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
          <%for(int i=0; i<favdata.size(); i++){
        	  favoriteDTO fav = favdata.get(i);
        	  shopDTO shop = sdao.getshopData(fav.getShopCode());
        	  
        	  String shopname = shop.getShopName();
        	  String shopadd = shop.getShopAddress();
        	  String shopcategory = shop.getShopCategory();
        	  String shopcontact = shop.getShopPhone();        	  
        	  %>
			<article id="favorite<%=i+1%>">
			<div id="shopname"><%=shopname %></div>
			<div id="shopadd"><%=shopadd %></div>
			<div id="shopcategory"><%=shopcategory %></div>
			<div id="shopcontact"><%=shopcontact %></div>
			
			
			</article>
          <% 
          }
          %>
        </div>
	</section>

	<aside></aside>
	<jsp:include page="/footer"></jsp:include>
	
</body>
</html>