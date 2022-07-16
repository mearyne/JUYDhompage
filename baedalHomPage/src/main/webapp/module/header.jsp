<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap')
	;
	
a { text-decoration: none; color: black; }
a:visited { text-decoration: none; }
a:hover { text-decoration: none; }
a:focus { text-decoration: none; }
a:hover, a:active { text-decoration: none; }
    
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
	display: flex;
	justify-content: center;
	
}

/* 마우스를 올려놓았을때 색깔이 변함 */
button:hover {
	background-color: grey;
	transition: 0.2s;
}


body {
    margin: 0; /* 리셋을 하지 않은 경우 추가 */
}

article:hover {
	background: grey;
}

</style>

<title>header</title>
</head>
<body>
	<header>
		<div class="headerButton">
			<%
			String chk = "-1";
			if (session.getAttribute("logCode") != null) {
				chk = (String) session.getAttribute("logCode"); // u1111
				chk = String.format("`%s`", chk); // `u1111` 
			}
			System.out.println(chk);
			
			%>
			<!-- 로그인이 된다면 로그아웃으로 변경된다 -->
			<%
			if (chk.equals("-1")) {
			%>
			<button class="mainButton" id="loginButton" onclick="location.href=`loginUser`">로그인</button>
			<%
			} else {
			%><!-- 일반유저, 매니저에 따라서 마이페이지로 이동하는 곳이 달라진다 -->
			<button class="mainButton" id="loginButton" onclick="alert('로그아웃이 되었습니다.'); location.href='./Service?command=logOut'">로그아웃</button>
			<%
			}
			%>
			<button class="mainButton" id="mypageButton" onclick="goToMyPage(<%=chk%>)">마이페이지</button>
			<button class="mainButton" onclick="goToQA">QA</button>
		</div>
		<div class="logo">
			<img src="https://img.freepik.com/premium-vector/chef-cook-vector-line-sketch-hand-drawn-illustration_77430-45.jpg" style="width: 100px; height: 100px;">
			<a href="index">예약의 민족</a>
			<img src="https://img.freepik.com/premium-vector/chef-cook-vector-line-sketch-hand-drawn-illustration_77430-45.jpg" style="width: 100px; height: 100px;">
		</div>

		<script src='../js/index.js'></script>
	</header>
</body>
</html>