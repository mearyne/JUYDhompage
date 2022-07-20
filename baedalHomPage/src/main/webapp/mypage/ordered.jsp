<%@page import="shop.shopDTO"%>
<%@page import="order.orderDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.shopDAO"%>
<%@page import="order.orderDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/mypage.css">
<title>orderd</title>
</head>
<body>

	<%
	String userCode = (String) session.getAttribute("logCode");
	userCode = userCode.substring(1);
	int code = Integer.parseInt(userCode);
	
	orderDAO odao = orderDAO.getInstance();
	shopDAO sdao = shopDAO.getInstance();
	
	ArrayList<orderDTO> orderdata = odao.getuserlist(code);
	
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
          <%for(int i=0; i<orderdata.size(); i++){
        	  orderDTO order = orderdata.get(i);
        	  shopDTO shop = sdao.getshopData(order.getShopCode());
        	  
        	  
        	  String shopname = shop.getShopName();
        	  String shopadd = shop.getShopAddress();
        	  String shopcontact = shop.getShopPhone();
        	  String shoppic = shop.getShopPic();
        	  
        	  %>

			<article id="order<%=i+1 %>">
			<div id="shoppic"><img src="<%=shoppic %>" style=""></div>
			<div id="shopname"><%=shopname %></div>
			<div id="shopadd"><%=shopadd %></div>
			<div id="shopcontact"><%=shopcontact %></div>
			<input type="button" onclick="location.href=''">
			
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