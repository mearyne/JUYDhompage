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
<link rel="stylesheet" href="../css/QA.css">
<title>QA</title>
</head>

	<%
		QnaDAO dao = QnaDAO.getInstance();
		userDAO udao = userDAO.getInstance();
		
		ArrayList<QnaDTO> list = dao.getQnaData();
	%>
<body>
	<jsp:include page="/module/header.jsp"></jsp:include>
	<h1 style="text-align: center;"> QA 게시판 </h1>	
	
	<input type="button" value="글쓰기">
	
	<table>
		<thead>
			<tr id="firstTr">
				<td id="no"> no </td>
				<td id="title"> title </td>

				<td id="date"> date </td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
				
				for(int i=0;i<list.size();i++){
					QnaDTO dto = list.get(i);
					userDTO udto = udao.getData(dto.getUserCode());
					
					int no=dto.getNo();
					int userCode= udto.getUserCode();
					String title = dto.getTitle();
					String contents=dto.getContents();
					

				%>
				<td><%=no %></td>
				<td><%=title %></td>
				<td><%=dto.getYear()%>-<%=dto.getMonth()%>-<%=dto.getDay()%></td>
				
				<%
				}
				%>
			</tr>
		</tbody>
	</table>
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>