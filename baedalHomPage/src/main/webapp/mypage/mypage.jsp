<%@page import="user.userDTO"%>
<%@page import="user.userDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/mypage.css">
    
    <style>
    
    </style>
    <title>mypage</title>
</head>
<body>
    
	<%	
	
		// 세션에 올라와있는 로그인된 유저코드
		String tmpUser = (String) session.getAttribute("logCode");
		tmpUser = tmpUser.substring(1);
	   	int userCode = Integer.parseInt(tmpUser);
	   	
	   	// 확인용
	   	System.out.println(userCode);
    	
    	userDAO dao = userDAO.getInstance();
    	// dto = 유저데이터
		userDTO dto = dao.getData(userCode);
    	
    	// dto를 이용해서 데이터를 뽑아냈다
    	String name = dto.getUserName();
    	String id = dto.getUserId();
    	String contact = dto.getUserContact();
    	
    %>
	<jsp:include page="/header"></jsp:include>
	<aside>
	<img id="masterChef" src="https://img.freepik.com/premium-vector/chef-cook-vector-line-sketch-hand-drawn-illustration_77430-45.jpg" width=260px; height=850px;>
	</aside>

	<section class="mypage">
		<div class="pagelist">
			<a class="userpage" id="mypage" href="mypage"><img src= "https://icons.veryicon.com/png/o/miscellaneous/frozenui/info-92.png" width=40px; height=40px;>내 정보</a>
           <a class="userpage" id="orederlist" href="ordered"><img src="https://img.icons8.com/dotty/12x/cash-receipt.png" width=40px; height=40px;>주문 목록</a>
           <a class="userpage" id="favlistlist" href="favoriteList"><img src="https://media.istockphoto.com/vectors/click-here-the-button-vector-id1172207434?k=20&m=1172207434&s=612x612&w=0&h=7AjuglgvFgLffL3F1SO67XWf_zycRjCe5DJvdayQFrc=" width=40px; height=40px;>찜 목록</a>
           <a class="userpage" id="reviewlist" href="review" > <img src="https://www.pngkey.com/png/full/288-2884257_free-food-clip-art-black-and-white.png" width=40px; height=40px;>리뷰 목록</a>
         
        </div>
        <div class="pagedetail"> 
        <div style="text-align : center;">
        	<img src="https://mindart.co.kr/mindart/assets/common/img/tab_mypage.png" width=200px; height=200px; >
		</div>
			<a class="mydetail" id="id">아이디 :<%=id %></a>
			<a class="mydetail" id="name">이름 : <%=name %></a>
			<a class="mydetail" id="contact">전화 번호 : <%=contact %></a>
			
			<form method="post" action="./mypage/changePw.jsp">
				<input type="submit" value="비밀번호 변경" class="mydetail" id="changePw" >
			</form>
			
        </div>
	</section>

	<aside></aside>
	<jsp:include page="/footer"></jsp:include>
    
</body>
</html>