<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login site</title>
 <link rel="stylesheet" href="ex02.css">
 <style>
    @import
	url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap');
	
#wrapper {
	height: auto;
	min-height: 100%;
	/* padding-bottom: px; */
}

header {
	height: 130px;
	display: flex;
	flex-direction: column;
}

.headerButton {
	display: flex;
	justify-content: flex-end;
}

.mainButton {
	width: 70px;
	height: 25px;
	/* 수정을 요함 */
	font-family: 'Nanum Gothic';
	text-align: center;
	color: white;
	background: black;
	border: solid 2px grey;
	border-radius: 12px;
}

#mypageButton {
	width: 90px;
}

.logo {
	font-family: 'Black Han Sans', sans-serif;
	font-size: 65px;
	text-align: center;
}
</style>

</head>
<body>
	<%
	// 로그인 페이지입니다.
	// 아이디, 비밀번호를 입력해서 로그인을 할 수 있습니다
	// 상단에 일반유저, master를 선택해서 로그인할 수 있습니다
	%>
	<div id ="wrap" class="wrap">
	<header>
		<div class="headerButton">
			<div class="mainButton" id="loginButton">로그인</div>
			<div class="mainButton" id="mypageButton">마이페이지</div>
		</div>
		<div class="logo">음식예약 사이트</div>
	</header>
	<div id="container">
	<ul class="menu_wrap">
	<li class="munu_item">
	<a href="#none" role="tab">
	<span class="menu_text">
	
	</span>
	</a>
	</li>
	<li class="munu_item"></li>
	<li class="munu_item"></li>
	</ul>
	</div>
	
	
	</div>
	

</body>
</html>