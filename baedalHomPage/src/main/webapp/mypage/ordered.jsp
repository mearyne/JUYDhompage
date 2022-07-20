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

	<style>
		img {
			height: 150px;
		    width: 150px;
		    object-fit: contain;
		}
		
		#pagedetail {
			display: flex;
		}
		
		article {
			background-color: grey;
		}
		
		article.contentsList {
			display: flex;
		}
		
		input {
			background: white;
		}
	
	</style>

    <link rel="stylesheet" href="./css/mypage.css">
<title>orderd</title>
</head>
<body>

	<%
	// 유저 코드를 받아옴
	String userCode = (String) session.getAttribute("logCode");
	userCode = userCode.substring(1);
	int code = Integer.parseInt(userCode);
	
	orderDAO odao = orderDAO.getInstance();
	shopDAO sdao = shopDAO.getInstance();

	// 주문 목록을 배열에 저장함
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
			<h1 style="text-align: center;"> 주문 목록 </h1>
			
			<%for(int i=0; i < orderdata.size(); i++){
				orderDTO order = orderdata.get(i);
				shopDTO shop = sdao.getshopData(order.getShopCode());
				
				
				String shopname = shop.getShopName();
				String shopadd = shop.getShopAddress();
				String shopcontact = shop.getShopPhone();
				String shoppic = shop.getShopPic();
			
				%>
				<article id="order<%=i+1 %>" class="contentsList" onclick="location.href='shop?shopCode=<%=shop.getShopCode()%>'">
					<div id="shoppic"><img src="<%=shoppic %>" style="margin: 10px;"></div>
					<div style="margin: 30px;">
						<div id="shopname"><%=shopname %></div>
						<div id="shopadd"><%=shopadd %></div>
						<div id="shopcontact"><%=shopcontact %></div>
					</div>
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