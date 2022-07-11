<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype HTML>
<head>
	<meta charset="UTF-8">
	<title>네이버 로그인</title>
	<link rel="stylesheet" href="style.css">
	<script src="index.js"></script>
	<style>
	
@import
	url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap')
	;

* {
	margin: 0;
	padding: 0;
}

#wrapper {
	height: auto;
	min-height: 100%;
	/* padding-bottom: px; */
}

header {
	height: 130px;
	display: flex;
	flex-direction: column;
	margin: 5px;
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

.main-container{
	width:100%;
	display:flex;
	flex-direction:column;
	align-items:center;
	margin-top: 21px;
}

.login-input-section-wrap{
	padding-top: 60px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.login-input-wrap{
	width: 465px;
	height :48px;
	border: solid 1px;
	background: white;
}
.password-wrap{
	margin-top: 13px;
}
.login-input-wrap input{
	border: none;
	width:430px;
	margin-top: 10px;
	font-size: 14px;
	margin-left: 10px;
	height:30px;
}
.login-button-wrap {
	padding-top: 13px;
}
.login-button button{
	width: 232.5px;
	height :48px;
	font-size: 18px;
	background: white;
	color: black;
	border: solid 1px;
}
.login-button-wrap button{
	width: 465px;
	height :48px;
	font-size: 18px;
	background: black;
	color: white;
	border: solid 1px;
}
.login-stay-sign-in{
	width: 465px;
	height: 52px;
	
	display: flex;
	font-size: 15px;
	color: #4e4e4e;
	align-items: center;
	justify-content: flex-start;
	border-bottom: solid 1px;
}


	</style>
</head>
<body>
  <header>
		<div class="logo">음식예약 사이트</div>
	</header>
	<div class="main-container">
		<div class="main-wrap">
		<div class="login-button">
			<button>개인</button>
			<button>사업자</button>
		</div>
		<section class="login-input-section-wrap">
			<div class="login-input-wrap">	
				<input placeholder="ID" type="text"></input>
			</div>
			<div class="login-input-wrap password-wrap">	
				<input placeholder="Password" type="password"></input>
			</div>
			<div class="login-button-wrap">
				<button>로그인</button>
			</div>
			<div class="login-button-wrap">
				<button>회원가입</button>
			</div>
			
		</section>
		</div>
	</div>
</body>