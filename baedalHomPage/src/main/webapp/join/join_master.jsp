<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <link rel="stylesheet" href="./css/join.css">
   
    </head>
    <body>
        <!-- header -->
        <header>
		<div class="headerButton">
			
		</div>
		<div class="logo">음식예약 사이트</div>
	</header>

<form method="post" action="../Service" >
        <input type="hidden" name="command" value="joinmaster">
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


				<!-- Address -->
				  <div>
                    <h3 class="join_title"><label for="Address">Address</label></h3>
                   <input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_detailAddress" placeholder="상세주소">
<input type="text" id="sample4_extraAddress" placeholder="참고항목">


                    <span class="error_next_box"></span>    
                </div>
				

                <!-- JOIN BTN-->
                <div class="btn_area">
                  <input type="button" id="btnJoin" onclick="checkJoinVal(form)"
						value="JOIN">
                </div>

            </div> 
            <!-- content-->

        </div> 
        </form>
        
        <!-- wrapper -->
    <script src="index.js"></script>
    <script src="./js/join.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
    </body>
    
</html>