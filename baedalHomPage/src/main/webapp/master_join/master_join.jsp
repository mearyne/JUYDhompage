<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
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


#content {
    position: absolute;
    left: 50%;
    transform: translate(-50%);
    width: 460px;
}


/* 입력폼 */


h3 {
    margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
}


.box {
    display: block;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 14px 10px 14px;
    box-sizing: border-box;
    background: #fff;
    position: relative;
}

.int {
    display: block;
    position: relative;
    width: 100%;
    height: 29px;
    border: none;
    background: #fff;
    font-size: 15px;
}

input {
    font-family: 'Black Han Sans', sans-serif;   
}

.box.int_id {
    padding-right: 110px;
}

.box.int_pass {
    padding-right: 40px;
}

.box.int_pass_check {
    padding-right: 40px;
}

.step_url {
    position: absolute;
    top: 16px;
    right: 13px;
    font-size: 15px;
    color: #8e8e8e;
}



select {
    width: 100%;
    height: 29px;
    font-size: 15px;
    -webkit-appearance: none;
    display: inline-block;
    text-align: start;
    border: none;
    cursor: default;
   font-family: 'Black Han Sans', sans-serif;
}

/* 에러메세지 */

.error_next_box {
    margin-top: 9px;
    font-size: 12px;
    color: red;    
    display: none;
}

#alertTxt {
    position: absolute;
    top: 19px;
    right: 38px;
    font-size: 12px;
    color: red;
    display: none;
}

/* 버튼 */

.btn_area {
    margin: 30px 0 91px;
}

#btnJoin {
    width: 100%;
    padding: 21px 0 17px;
    border: 0;
    cursor: pointer;
    color: #fff;
    background-color: black;
    font-size: 20px;
    font-weight: 400;
    font-family: 'Black Han Sans', sans-serif;
}
</style>
    </head>
    <body>
        <!-- header -->
        <header>
		<div class="headerButton">
			<div class="mainButton" id="loginButton">로그인</div>
			<div class="mainButton" id="mypageButton">마이페이지</div>
		</div>
		<div class="logo">음식예약 사이트</div>
	</header>


        <!-- wrapper -->
        <div id="wrapper">

            <!-- content-->
            <div id="content">

                <!-- ID -->
                <div>
                    <h3 class="join_title">
                        <label for="id">ID</label>
                    </h3>
                    <span class="box int_id">
                        <input type="text" id="id" class="int" maxlength="20">
                        <span class="step_url"></span>
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="pswd1">Password</label></h3>
                    <span class="box int_pass">
                        <input type="text" id="pswd1" class="int" maxlength="20">
                        <span id="alertTxt">사용불가</span>
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW2 -->
                <div>
                    <h3 class="join_title"><label for="pswd2">Reconfirm password</label></h3>
                    <span class="box int_pass_check">
                        <input type="text" id="pswd2" class="int" maxlength="20">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- NAME -->
                <div>
                    <h3 class="join_title"><label for="name">Name</label></h3>
                    <span class="box int_name">
                        <input type="text" id="name" class="int" maxlength="20">
                    </span>
                    <span class="error_next_box"></span>
                </div>

             
                <!-- EMAIL -->
                <div>
                    <h3 class="join_title"><label for="email">E-mail<span class="optional">(선택)</span></label></h3>
                    <span class="box int_email">
                        <input type="text" id="email" class="int" maxlength="100" placeholder="선택입력">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>

                <!-- MOBILE -->
                <div>
                    <h3 class="join_title"><label for="phoneNo">Mobile</label></h3>
                    <span class="box int_mobile">
                        <input type="tel" id="mobile" class="int" maxlength="16" placeholder="전화번호 입력">
                    
                    </span>
                    <span class="error_next_box"></span>    
                </div>


                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="button" id="btnJoin">
                        <span>JOIN</span>
                    </button>
                </div>

            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
    <script src="index.js"></script>
    </body>
</html>