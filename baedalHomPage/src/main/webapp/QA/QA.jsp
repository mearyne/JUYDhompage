<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="user.userDAO"%>
<%@page import="user.userDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="qna.QnaDTO"%>
<%@page import="qna.QnaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/QA.css">
<title>QA</title>
</head>

	<%
		QnaDAO dao = QnaDAO.getInstance();
		userDAO udao = userDAO.getInstance();
		
		ArrayList<QnaDTO> list = dao.getQnaData(); 
		Object logCodeObject = session.getAttribute("logCode");
	%>
<body>
	<jsp:include page="/module/header.jsp"></jsp:include>
	<h1 style="text-align: center;"> QA 게시판 </h1>
		
	<form action="../Service"  method="post">
	<input type="hidden" name="command" value="QnaWriteAction">	
	<% if (logCodeObject != null) { %>
		<input type="button" value="글쓰기" onclick='location.href="./QnaWrite"'>
	<% } %>
		<table>
			<thead>
				<tr id="firstTr">
					<td id="no"> no </td>
					<td id="title"> title </td>
					<td id="name"> name </td>
					<td id="date"> date </td>
				</tr>
			</thead>
			<tbody>
					<%
					for(int i=0;i<list.size();i++){
						QnaDTO dto = list.get(i);
						userDTO udto = udao.getData(dto.getUserCode());
						
						int no=dto.getNo();
						int userCode= udto.getUserCode();
						String title = dto.getTitle();
						String contents=dto.getContents();
						String userName = udto.getUserName();
						String up_date=String.valueOf(dto.getUp_date());
					%>
					<tr>
					<td><%=no %></td>
					<td onclick='location.href=`QAview?no=<%=no%>`'><%=title %></td>
					<td><%=userName%></td>
					<td><%=up_date%></td>
					</tr>
					<%
					}
					%>
			</tbody>
		</table>
	</form>
	<jsp:include page="/module/footer.jsp"></jsp:include>
	
</body>
</html>