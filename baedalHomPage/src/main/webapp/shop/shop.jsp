<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/shopdetail.css">
<title>shop detail</title>
</head>
<body>
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

	<aside></aside>
	<section>
		<div class="total_div">
			<div class="top_div">
				<!-- 가게 사진 -->
				<div class="img_div">
					<img id="pic" src="https://bit.ly/3AGXFmB" >
				</div>
				<!-- 가게정보 테이블 -->
				<div class="info"> 
					<table>
						<tr>
							<td>가게명</td>
							<td>한식당</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>강남 어딘가</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>010-0000-0000</td>
						</tr>
						<tr>
							<td>영업시간</td>
							<td>10시부터 10시까지</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="bottom_div">
				<div class="menu_div">
					<div id="menu_list_div">
						<div class="food_div">
							<img src="https://bit.ly/3NZivAJ"> <p>비빔밥 <br> 가격 : 10000원</p>
						</div>
						<div class="food_div">
							<img src="https://bit.ly/3NZivAJ">
							<p>비빔밥 <br> 가격 : 10000원</p>
						</div>
						<div class="food_div">
							<img src="https://bit.ly/3NZivAJ">
							<p>비빔밥 <br> 가격 : 10000원</p>
						</div>
						
					</div>
				</div>

				<div class="select_div">
					<div class="option">옵션 선택</div>
					<div class="dropdown">
						<select>
							<option value="메뉴1">메뉴1</option>
							<option value="메뉴2">메뉴2</option>
							<option value="메뉴3">메뉴3</option>
						</select>
					</div>
					<div class="btn">
						<button id="cart">장바구니</button>
						<button id="book">예약</button>
					</div>
				</div>
			</div>

		</div>
	</section>
	<aside>
	</aside>
	<footer>
		<p class="footerfont">
			정의형 이정목 송윤주 우다영 <br> 이건 footer
		</p>
	</footer>
</body>
</html>