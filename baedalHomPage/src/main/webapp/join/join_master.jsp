<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c74772d00f549d2606dc566151ba1cd&libraries=services"></script>
		
		<style> /* 맵을 생성하기 위해서 존재함 */
		   .map_wrap {position:relative;width:100%;height:350px;}
		   .title {font-weight:bold;display:block;}
		   .hAddr {position:absolute;left:10px;top:10px;border-radius: 2px;background:#fff;background:rgba(255,255,255,0.8);z-index:1;padding:5px;}
		   #centerAddr {display:block;margin-top:2px;font-weight: normal;}
		   .bAddr {padding:5px;text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
		</style>
        
        <link rel="stylesheet" href="./css/master_join.css">
   
    </head>
    <body>
        <!-- header -->
		<jsp:include page="/module/header.jsp"></jsp:include>
		
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
						<span class="box int_id">
							<input type="text" id="id" name="id" class="int" maxlength="20">
							<span class="step_url"> </span>
						</span>
						<span class="error_next_box">필수 입력</span>
					</div>
	
					<!-- PW1 -->
					<div>
						<h3 class="join_title">
							<label for="pswd1">Password</label>
						</h3>
						<span class="box int_pass">
							<input type="password" id="pswd1" name="pw" class="int" maxlength="20"> <span id="alertTxt">사용불가</span>
						</span> 
						<span class="error_next_box">필수 입력</span>
					</div>
	
					<!-- PW2 -->
					<div>
						<h3 class="join_title">
							<label for="pswd2">Reconfirm password</label>
						</h3>
						<span class="box int_pass_check">
							<input type="password" id="pswd2" name="pw2" class="int" maxlength="20">
						</span>
						<span class="error_next_box">필수 입력</span>
					</div>
	
					<!-- NAME -->
					<div>
						<h3 class="join_title">
							<label for="name">Name</label>
						</h3>
						<span class="box int_name">
						<input type="text" id="name" name="name" class="int" maxlength="20">
						</span>
						<span class="error_next_box">필수 입력</span>
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
						<span class="box int_mobile">
							<input type="tel" id="mobile" name="mobile" class="int" maxlength="16" placeholder="전화번호 입력">
						</span>
						<span class="error_next_box">필수 입력</span>
					</div>
	
	
					<!-- 가게 등록 -->
					<!-- 맵에 들어설 공간 -->
					<h3>상점의 위치를 클릭하세요</h3>
					<div id="MapBlock">
						<div class="map_wrap">
						    <div id="map" style="width:350px;height:350px;"></div>
						    <div class="hAddr">
						        <span class="title">지도중심기준 행정동 주소정보</span>
						        <span id="centerAddr"></span>
						    </div>
						</div>
					</div>
					
					<!-- 여기에 좌표, 주소가 표시된다 -->
					<div id="clickAddress"></div>
					<div id="clickLatlng"></div>
	
	                <!-- JOIN BTN-->
	                <div class="btn_area">
	                  <input type="button" id="btnJoin" onclick="checkJoinVal(form)" value="JOIN">
	                </div>
	
	            </div> 
	
	        	</div> 
	        </form>
	        
	        <!-- wrapper -->
	    <script src="index.js"></script>
	    <script src="./js/join.js"></script>
	    <script src="./js/updateShop.js"></script>
	
	</body>
    
</html>