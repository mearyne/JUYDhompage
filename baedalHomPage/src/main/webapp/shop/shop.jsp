<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="./css/shopdetail.css">
<title>shop</title>
</head> 
<body>

	<%
	// 가게 페이지입니다.
	// 가게 정보, 사진, 가게에서 예약할 수 있는 메뉴를 볼 수 있습니다.
	%>
	
	<!--
	// 가게 상세페이지 입니다.
	-->
	<header>
		<div class="headerButton">
			<div class="mainButton" id="loginButton">로그인</div>
			<div class="mainButton" id="mypageButton">마이페이지</div>
		</div>
		<div class="logo">음식예약 사이트</div>
	</header>

	<aside>
		<h2>사이드바</h2>
	</aside>

	<section>
		<div class="img_div">
			
		</div>
		<div class="info">
			가게명 : 
			주소 : 
			전화번호 : 
			영업시간 : 
		</div>
		<div class="menu_div">
			메뉴 이미지와 설명,가격
		</div>
		<div class="menu_select">
			옵션선택
			<div class="dropdown">
				<select>
					<option value="메뉴1">메뉴1</option>
					<option value="메뉴2">메뉴2</option>
					<option value="메뉴3">메뉴3</option>
				</select>
			</div>
		</div>

		<input type="button" value="장바구니">
		<input type="button" value="예약">

	</section>

	<aside>
		<h2>사이드바</h2>
	</aside>

	<footer>
		<p class="footerfont">
			정의형 이정목 송윤주 우다영 <br> 이건 footer
		</p>
	</footer>

</body>
</html>