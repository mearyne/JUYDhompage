<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index homepage</title>
</head>
<body>
	

	<form method="post">
		<select value="chkUser">
			<option>
			<option>
		</select>
        <input type="text" name="id" placeholder="아이디 입력">
        <input type="password" name="password" placeholder="비밀번호 입력">
        <input type="submit" value="로그인" onclick=chkLogin()>
    </form>
    
    <script src="./JS/index.js"></script>

</body>
</html>