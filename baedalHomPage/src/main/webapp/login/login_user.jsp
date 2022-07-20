<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype HTML>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
	<%
	// 로그인 실패했을때 알림창 띄움
	Object logCode = session.getAttribute("logCode");
	if (logCode != null) {
		int logCodeInt = (int) logCode;
		if (logCodeInt == -1) {
			%> <script>alert('로그인 실패');</script> <%
			session.removeAttribute("logCode");
		}
	}
	
	// 회원가입 성공했을때 알림창 띄움
	Object chkJoin = request.getAttribute("chkJoin");
	if (chkJoin != null) {
		String chkJoinString = (String) chkJoin;
		if (chkJoinString.equals("true")) {
			%> <script>alert('회원가입 성공');</script> <%
		}
	}
	
	%>

	<jsp:include page="/headerNobutton"></jsp:include>
	
	<div class="main-container">
		<div class="main-wrap">
			<div class="login-button">
				<button type="button" style="background-color: rgb(176, 176, 176);" onclick="location.href='./loginUser'">개인</button>
				<button type="button" onclick="location.href='loginMaster'">사업자</button>
			</div>
			<section class="login-input-section-wrap">
				<form action="./Service" method="post">
					<input type="hidden" name="command" value="loginUser">
					<div class="login-input-wrap">
						<input type="text" name="inputId" placeholder="ID"></input>
					</div>
					<div class="login-input-wrap password-wrap">
						<input type="password" name="inputPw" placeholder="Password"></input>
					</div>
					<div class="login-button-wrap">
						<input type="submit" value="로그인" style="width: 465px; height: 48px; font-size: 18px; background: black; color: white; border: solid 1px;">
					</div>
				</form>
				<div class="login-button-wrap">
					<button type="button" onclick="location.href=`./agree`">회원가입</button>
				</div>
			</section>
		</div>
	</div>

</body>