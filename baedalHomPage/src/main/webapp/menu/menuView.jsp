<%@page import="menu.menuDTO"%>
<%@page import="menu.menuDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.masterDTO"%>
<%@page import="user.masterDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/mypage_master.css">
    <title>mypage</title>
</head>
<body>
    
	<%	
		// 삭제여부 판단해서 alert 띄움
		Object chkDelObject = request.getAttribute("chkDel");
		if (chkDelObject != null) {
			int chkDel = (int) chkDelObject;
			if (chkDel == 1) {
				%><script> alert("삭제 완료");</script> <%
			} else {
				%><script> alert("삭제 실패");</script> <%
			}
		}
	
		// 마스터 코드를 읽어옴
		String masterCode = (String) session.getAttribute("logCode");
		String masterCode1 = masterCode.substring(1); // 0000 String
		
	   	int masterCodeInteger = Integer.parseInt(masterCode1); // 0000 int
    		
    	masterDAO dao = masterDAO.getInstance();
    	// dto = 유저데이터
    	masterDTO dto = dao.getData(masterCodeInteger);
    			
    	// dto를 이용해서 데이터를 뽑아냈다
    	String id = dto.getMasterId();
    	String name = dto.getMasterName();
    	String contact =dto.getMasterContact();
    	int shopcode = dto.getMastrShopCode();
    	
    	// test
    	System.out.println("shopcodeshopcodeshopcodeshopcodeshopcode : " + shopcode);
    	
    	menuDAO mdao = menuDAO.getInstance(); 
    	
    	ArrayList<menuDTO> menulist = mdao.menuInfo(shopcode);
    	
    %>
	<jsp:include page="/header"></jsp:include>
	<aside><img id="masterChef" src="https://img.freepik.com/premium-vector/chef-cook-vector-line-sketch-hand-drawn-illustration_77430-45.jpg" width=260px; height=850px;></aside>

	<section class="mypage">
		<div class="pagelist">
			<a class="userpage" id="mypage" href="mypage"><img src= "https://icons.veryicon.com/png/o/miscellaneous/frozenui/info-92.png" width=40px; height=40px;>내 정보</a>
       		<a class="userpage" id="updateShop" href="updateShop">가게주소 변경하기</a>
           <a class="userpage" id="orederlist" href="menuView"><img src="https://img.icons8.com/dotty/12x/cash-receipt.png" width=40px; height=40px;>메뉴 보기</a>
        </div>
        <form method ="post" action="./Service">
        <input type="hidden" name="command" value="delMenu">
        <input type="hidden" name="logCode" value="<%=masterCode %>">
        
        <div class="pagedetail">
        <input type="button" value="메뉴 추가" onclick="location.href='addMenu?shopCode=<%=shopcode%>'">
        
			<%
			for (int i = 0; i < menulist.size(); i++) {
				menuDTO mdto = menulist.get(i);
				int price = mdto.getMenuPrice();
				String pic = mdto.getMenuPicture();
				String mname = mdto.getMenuName();
				String contents = mdto.getMenuContents();
				int mcode = mdto.getMenuCode();
				System.out.println("mcode"+mcode);
			%>
			<article>
				<div id="name"><%=mname %></div>
				<div id="price"><%=price %>원</div>
				<div id="pic"><img src ="<%=pic%>"></div>
				<div id="contents"><%=contents %></div>
				<input type="hidden" name="menucode" value="<%=mcode%>">
				<input type="submit" value="메뉴 삭제">
			</article>
			<%
			}
			%>

		</div>
        </form>
	</section>

	<aside></aside>
	<jsp:include page="/footer"></jsp:include>
    
</body>
</html>