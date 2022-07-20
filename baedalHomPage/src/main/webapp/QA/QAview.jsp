<%@page import="qna.QnaDTO"%>
<%@page import="qna.QnaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="../css/QnaWrite.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/module/header.jsp"></jsp:include>
	<%
	int no = Integer.parseInt(request.getParameter("no"))   ;
	QnaDAO dao = QnaDAO.getInstance();
	QnaDTO dto = dao.getOneQna(no);
	
	String title = dto.getTitle();
	String contents = dto.getContents();
	int writeUserCode=dto.getUserCode();
	
	String userCodeString = (String) session.getAttribute("logCode"); // u0000
	userCodeString = userCodeString.substring(1); // 0000 문자열
	int userCode = Integer.parseInt(userCodeString); // 0000 숫자
	
	%>
	
	  <form method="post" action="../Service." id="table_form"style="text-align: center; padding-top:100px;">
				<input type="hidden" name="command" value="QnaDeleteAction">
		<table border="1">
		
			<tr>
				<td><label for="title">title</label></td>
				<td><%=title %> </td>
			</tr>
			
		</table>
		<textarea name="contents" id="contents" cols="100" rows="30" required 
		style="overflow-x:hidden; overflow-y:scroll; resize: none; margin:50px;"><%=contents %></textarea><br>
		<div id="button" >
			<input type="submit" value="목록" onclick="location.href='./QA'">
			<%
				if(userCode == writeUserCode){
			%>
			<input type="button" value="삭제하기" onclick = "location.href='QA.jsp?no=<%=no%>'">
			<input type="submit" value="수정하기">
			<%
				}
			%>
			
		</div>
	</form>
	<jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>