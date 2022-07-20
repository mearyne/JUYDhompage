<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="./css/join.css">
</head>
<body>
	<%
	int shopCode= Integer.parseInt(request.getParameter("shopCode"));
	System.out.println(shopCode);

	%>
	<jsp:include page="/header"></jsp:include>
	<form method="post" action="./Service" >
		<input type="hidden" name="command" value="addMenu">
		 <input type="hidden" name="shopCode" value="<%=shopCode %>">
			<div id="wrapper">
				<div id="content">
	
					<!-- 이름 -->
					<div>
						<h3 class="menu_name">
							<label for="name">메뉴 이름</label>
						</h3>
						<span class="box"> <input type="text" id="name"
							name="name" class="int" maxlength="20"> <span
							class="step_url"></span>
						</span> <span class="error_next_box">필수 입력</span>
					</div>
	
					<!-- 가격 -->
					<div>
						<h3 class="menu_price">
							<label for="price">가격</label>
						</h3>
						<span class="box"> <input type="number" id="price"
							name="price" class="int" > 
						</span> <span class="error_next_box">필수 입력</span>
					</div>
					
					<!-- 정보 -->
					<div>
						<h3 class="menu_contents">
							<label for="contents">메뉴 정보</label>
						</h3>
						<span class="box"> <input type="text" id="contents"
							name="contents" class="int" maxlength="200"> <span
							class="step_url"></span>
						</span> <span class="error_next_box">필수 입력</span>
					</div>
	
					<!-- 사진 -->
					<div>
						<h3 class="join_title">
							<label for="pic">메뉴 사진</label>
						</h3>
						<span class="box"> <input type="text"
							id="picture" name="picture" class="int" >
						</span> <span class="error_next_box">필수 입력</span>
					</div>
		
					<!-- JOIN BTN-->
					<div class="btn_area">
						<input type="button" id="btnJoin" onclick="checkJoinVal(form)" value="추가">
					</div>
						<input type="button" id="btnJoin" onclick="location.href='menuView?shopCode=<%=shopCode%>'" value="취소">
				</div>
	
			</div>
	</form>
	<script src="./js/join.js"></script>
</body>
</html>