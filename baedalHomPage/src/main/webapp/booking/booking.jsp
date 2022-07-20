<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>booking</title>
 <link rel="stylesheet" href="./css/calendar.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<%
	int shopCode = Integer.parseInt((String) request.getParameter("shopCode"));
	System.out.println(shopCode);
	
	int userCode =-1;
	String user= (String)session.getAttribute("logCode");
	System.out.println("user :"+user);
	if(user!=null){
	String tempuser=user.substring(1);
	userCode = Integer.parseInt(tempuser);
	System.out.println("!!!logCode ="+ tempuser);
	} 
	System.out.println("userCode=" + userCode);
	System.out.println("!!!user ="+ user);
	
	%>

	<jsp:include page="/module/header.jsp"></jsp:include>
	<h1 style="text-align: center">예약하기</h1>
	<form method="post" action="./Service">
	<input type="hidden" name="command" value="addorder">
	<input type="hidden" name="date" value="0" id="selday">
	<input type="hidden" name="year" value="0" id="selyear">
	<input type="hidden" name="month" value="0" id="selmonth">
	<input type="hidden" value="<%=userCode %>" name="usercode">
	<input type="hidden" value="<%=shopCode %>" name="shopcode">
	 <div id="calendarForm" ></div>
	<input type="button" value="예약하기" onclick="chkday(form)">
	</form>
	
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
<script src="./js/calendar.js" ></script>
</html>