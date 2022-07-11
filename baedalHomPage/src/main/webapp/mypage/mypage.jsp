<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/mypage.css">
    <title>mypage</title>
</head>
<body>
    
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

	<section class="mypage">
		<div class="pagelist">
			<a class="userpage" id="mypage" href="mypage">내 정보</a>
           <a class="userpage" id="orederlist" href="ordered">주문 목록</a>
           <a class="userpage" id="favlistlist" href="favoriteList">찜 목록</a>
           <a class="userpage" id="reviewlist" href="review">리뷰 목록</a>
        </div>
        <div class="pagedetail"> 
			<a class="mydetail" id="id">아이디 : 나의 아이디</a>
			<a class="mydetail" id="name">이름 : 나의 이름</a>
			<a class="mydetail" id="contact">전화 번호 : 나의 핸드폰</a>
			<form method="post" action="">
				<input type="submit" value="비밀번호 변경" class="mydetail" id="changpw" >

			</form>
			
        </div>
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