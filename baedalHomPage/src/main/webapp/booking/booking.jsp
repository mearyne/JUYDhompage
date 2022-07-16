<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>booking</title>
</head>
<body>
	<%
	int shopCode = Integer.parseInt((String) request.getParameter("shopCode"));
	System.out.println(shopCode);
	
	%>

	<jsp:include page="../module/header.jsp"></jsp:include>
	<h1 style="text-align: center;">예약하기</h1>
	
	<jsp:include page="../module/footer.jsp"></jsp:include>


</body>
</html>