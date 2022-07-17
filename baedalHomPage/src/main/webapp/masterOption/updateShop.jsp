<%@page import="shop.shopDTO"%>
<%@page import="shop.shopDAO"%>
<%@page import="user.masterDTO"%>
<%@page import="user.masterDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c74772d00f549d2606dc566151ba1cd&libraries=services"></script>
<style>
   .map_wrap {position:relative;width:100%;height:350px;}
   .title {font-weight:bold;display:block;}
   .hAddr {position:absolute;left:10px;top:10px;border-radius: 2px;background:#fff;background:rgba(255,255,255,0.8);z-index:1;padding:5px;}
   #centerAddr {display:block;margin-top:2px;font-weight: normal;}
   .bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
</style>

<title>Insert title here</title>

</head>
<body>
	<%
	// 로그인 된 master의 코드를 불러옴
	String masterCodeString = (String) session.getAttribute("logCode");
	masterCodeString = masterCodeString.substring(1);
	int masterCode = Integer.parseInt(masterCodeString);
	
	// shop데이터를 가져옴
	System.out.println("masterCodemasterCodemasterCodemasterCode: "+ masterCode);
	shopDTO shopData = shopDAO.getInstance().getShopOfMasterCode(masterCode);
	double x = shopData.getShopX();
	double y = shopData.getShopY();
	
	// 가게를 등록하는데 필요한 정보
	// 1. 좌표(x, y)값
	// 2. 가게 주소? -> 차라리 사장님 계정을 등록할때 가게를 등록하게 할까? 
	// ㄴ 그러면 가게 위치만 수정하게 하는게 좋을 듯 싶다.
	%>
	

	<jsp:include page="/module/header.jsp"></jsp:include>
	<aside></aside>	
	
	<h1 style="text-align: center;">가게 위치 수정하기</h1>
	<h3>수정할 위치를 클릭하세요</h3>
	
	<div id="MapBlock">
		<div class="map_wrap">
		    <div id="map" style="width:350px;height:350px;"></div>
		    <div class="hAddr">
		        <span class="title">지도중심기준 행정동 주소정보</span>
		        <span id="centerAddr"></span>
		    </div>
		</div>
	</div>
	
	<div id="buttom">
		<form method="post" action="./Service">
			<!-- 여기에 좌표, 주소가 표시된다 -->
			<div id="clickAddress"></div>
			<div id="clickLatlng"></div>
			<input type="hidden" name="command" value="updateShopAction">
			<input type="hidden" name="shopCode" value="<%=shopData.getShopCode() %>">
			<input type="button" value="취소" onclick="location.href=`index`">
			<input type="submit" value="수정하기" onclick="alert('위치가 수정되었습니다')">
		</form>
	</div>
	
	<aside></aside>
	<jsp:include page="/module/footer.jsp"></jsp:include>

	<script src=js/updateShop.js></script>

</body>
</html>