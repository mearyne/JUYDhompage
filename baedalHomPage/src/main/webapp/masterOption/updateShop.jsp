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
   
   div#main {
   		display: flex;
   		flex-direction: column;
   		align-items: center;
   }
</style>

<title>Insert title here</title>

</head>
<body>
	<%
	// 로그인 된 master의 코드를 불러옴
	String masterCodeString = (String) session.getAttribute("logCode");
	masterCodeString = masterCodeString.substring(1);
	int masterCode = Integer.parseInt(masterCodeString);
	
	double x = 0;
	double y = 0;
	int shopCode = -1;
	String shopName = "";
	String shopCategory = "";
	String shopPic = "";
	String shopPhone = "";
	String shopContents = "";
	boolean chkDupl = false;
	
	// shop데이터가 있다면 가져옴
	System.out.println("masterCodemasterCodemasterCodemasterCode: "+ masterCode);
	shopDTO shopData = shopDAO.getInstance().getShopOfMasterCode(masterCode);
	
	if (shopData != null) {
		x = shopData.getShopX();
		y = shopData.getShopY();
		shopCode = shopData.getShopCode();
		shopName = shopData.getShopName();
		shopCategory = shopData.getShopCategory();
		shopPic = shopData.getShopPic();
		shopPhone = shopData.getShopPhone();
		shopContents = shopData.getShopContents();
		chkDupl = true;
	// 없다면 안가져옴
	} else {
		shopCode = shopDAO.getInstance().rCode();
		shopName = "비어있음";
		shopCategory = "비어있음";
		shopPic = "비어있음";
		shopPhone = "비어있음";
		shopContents = "비어있음";
		
	}
	
	// 가게를 등록하는데 필요한 정보
	// 1. 좌표(x, y)값 -> 이걸 맵을 불러올때 중심으로 마크를 세긴다?
	// 2. 가게 주소? -> 차라리 사장님 계정을 등록할때 가게를 등록하게 할까? 아니 그냥 여기서 수정하자..
	// ㄴ 그러면 가게 위치만 수정하게 하는게 좋을 듯 싶다.
	%>
	

	<jsp:include page="/module/header.jsp"></jsp:include>
	<aside></aside>	
	<div id="main">
		<h1 style="text-align: center;">가게 정보 수정하기</h1>
		<h3>상점의 위치를 클릭하세요</h3>
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
					<input type="hidden" name="shopCode" value="<%=shopCode %>">
					<input type="hidden" name="masterCode" value="<%=masterCode %>">
					<input type="hidden" name="chkDupl" value="<%=chkDupl %>">
					
					가게 이름 : <input type="text" name="shopName" value="<%=shopName %>" required><br>
					카테고리 : <input type="text" name="shopCategory" value="<%=shopCategory %>" required><br>
					사진 링크 : <input type="text" name="shopPic" value="<%=shopPic %>" required><br>
					가게 전화번호 : <input type="text" name="shopPhone" value="<%=shopPhone %>" required><br>
					가게 설명 : <input type="text" name="shopContents" value="<%=shopContents %>" required><br>
			
				<input type="button" value="취소" onclick="location.href=`index`">
				<input type="submit" value="수정하기" onclick="alert('위치가 수정되었습니다')">
			</form>
		</div>
	</div>
	<aside></aside>
	<jsp:include page="/module/footer.jsp"></jsp:include>

	<script src=js/updateShop.js></script>

</body>
</html>