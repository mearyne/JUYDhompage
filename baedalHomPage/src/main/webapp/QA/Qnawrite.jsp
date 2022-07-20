<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <link rel="stylesheet" href="../css/QnaWrite.css">
    <title>Q&A WRITE</title>
</head>
<body>
	<jsp:include page="/module/header.jsp"></jsp:include>
   
    <form method="post" action="../Service" id="table_form"style="text-align: center; padding-top:100px;">
				<input type="hidden" name="command" value="QnaWriteAction">
		<table border="1">
			<tr>
				
				<td><label for="title">Title </label></td>
				<td><input type="text" name="title" id="title" required></td>
			</tr>

		</table>
		<textarea name="contents" id="contents" cols="100" rows="30" placeholder='내용을 입력하세요.' required style="overflow-x:hidden; overflow-y:scroll; resize: none; margin:50px;"></textarea><br>
		<div id="button" >
			<input type="submit" value="글쓰기" onclick="location.href='./QnaWriteAction'">
			<input type="button" value="목록" onclick="location.href='./QA'">
		</div>
	</form>
       <jsp:include page="/module/footer.jsp"></jsp:include>
</body>
</html>