<%@page import="qna.QnaDTO"%>
<%@page import="qna.QnaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="./css/QnaWrite.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/module/header.jsp"></jsp:include>
	
	<%
	// 게시글 코드를 받아옴
	int no = Integer.parseInt(request.getParameter("no"));
	QnaDAO dao = QnaDAO.getInstance();
	QnaDTO dto = dao.getOneQna(no);
	
	String title = dto.getTitle();
	String contents = dto.getContents();
	int writeUserCode=dto.getUserCode();
	
	// 유저가 로그인 되어있다면 코드를 추출한다
	Object userCodeObject = session.getAttribute("logCode");
	int userCode = -1;
	if (userCodeObject != null) {
		String userCodeString = ((String) userCodeObject); // u0000
		userCodeString = userCodeString.substring(1); // 0000 문자열
		userCode = Integer.parseInt(userCodeString); // 0000 숫자
	}
	
	%>
	
	<form method="post" action="Service" id="table_form" style="text-align: center; padding-top:100px;">
		<input type="hidden" name="command" value="QnaDeleteAction">
		<input type="hidden" name="no" value="<%=no %>">
		<table border="1">
			<tr>
				<td><label for="title">title</label></td>
				<td><%=title %> </td>
			</tr>
		</table>
		<textarea name="contents" id="contents" cols="100" rows="30" readonly style="overflow-x:hidden; overflow-y:scroll; resize: none; margin:50px;"><%=contents %></textarea><br>
		<div id="button">
			<input type="button" value="목록" onclick="location.href='QA'">
			<% if(userCode == writeUserCode){ %>
			<input type="submit" value="삭제하기">
			<% } %>
		</div>
	</form>
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>