<%@page import="user.userDTO"%>
<%@page import="user.userDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/mypage.css">
    <title>mypage</title>
</head>
<body>
	<jsp:include page="/header"></jsp:include>
	<aside></aside>

	<section class="mypage">
		<div class="pagelist">
			<a class="userpage" id="mypage" href="../mypage">내 정보</a>
           <a class="userpage" id="orederlist" href="../ordered">주문 목록</a>
           <a class="userpage" id="favlistlist" href="../favoriteList">찜 목록</a>
           <a class="userpage" id="reviewlist" href="../review">리뷰 목록</a>
        </div>
        <div class="pagedetail"> 
			
			<form method="post" action="../Service">
				<input type="hidden" name="command" value="changePw">
				현재 비밀번호 : <input type="text" id="pw" name="pw"> <br>
				바꿀 비밀번호 : <input type="text" id="pw" name="changePw"> <br>
				바꿀 비밀번호 확인 : <input type="text" id="pw" name="douChkPw"> <br>
				<input type="submit" value="비밀번호 변경" class="mydetail" id="changpw">
			</form>
        </div>
	</section>

	<aside></aside>
	<jsp:include page="/footer"></jsp:include>
    
</body>
</html>