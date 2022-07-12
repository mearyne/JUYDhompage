<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="../css/join.css">

</head>
<body>
	<!-- header -->
	<header>
		<div class="headerButton"></div>
		<div class="logo">음식예약 사이트</div>
	</header>

	<form method="post" action="../Service" >
	<input type="hidden" name="command" value="joinuser">
		<!-- wrapper -->
		<div id="wrapper">

			<!-- content-->
			<div id="content">

				<!-- ID -->
				<div>
					<h3 class="join_title">
						<label for="id">ID</label>
					</h3>
					<span class="box int_id"> <input type="text" id="id"
						name="id" class="int" maxlength="20"> <span
						class="step_url"></span>
					</span> <span class="error_next_box">필수 입력</span>
				</div>

				<!-- PW1 -->
				<div>
					<h3 class="join_title">
						<label for="pswd1">Password</label>
					</h3>
					<span class="box int_pass"> <input type="text" id="pswd1"
						name="pw" class="int" maxlength="20"> <span id="alertTxt">사용불가</span>
					</span> <span class="error_next_box">필수 입력</span>
				</div>

				<!-- PW2 -->
				<div>
					<h3 class="join_title">
						<label for="pswd2">Reconfirm password</label>
					</h3>
					<span class="box int_pass_check"> <input type="text"
						id="pswd2" name="pw2" class="int" maxlength="20">
					</span> <span class="error_next_box">필수 입력</span>
				</div>

				<!-- NAME -->
				<div>
					<h3 class="join_title">
						<label for="name">Name</label>
					</h3>
					<span class="box int_name"> <input type="text" id="name"
						name="name" class="int" maxlength="20">
					</span> <span class="error_next_box">필수 입력</span>
				</div>


				<!-- 
                <div>
                    <h3 class="join_title"><label for="email">E-mail<span class="optional">(선택)</span></label></h3>
                    <span class="box int_email">
                        <input type="text" id="email" class="int" maxlength="100" placeholder="선택입력">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>
                <!-- EMAIL -->

				<!-- MOBILE -->
				<div>
					<h3 class="join_title">
						<label for="phoneNo">Mobile</label>
					</h3>
					<span class="box int_mobile"> <input type="tel" id="mobile"
						name="mobile" class="int" maxlength="16" placeholder="전화번호 입력">

					</span> <span class="error_next_box">필수 입력</span>
				</div>

				<!-- JOIN BTN-->
				<div class="btn_area">
					<input type="button" id="btnJoin" onclick="checkJoinVal(form)"
						value="JOIN">
				</div>

			</div>

		</div>
	</form>
	<script src="../js/join.js"></script>
    </body>
    
</html>