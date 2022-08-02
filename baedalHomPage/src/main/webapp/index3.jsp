<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
  Connection conn=null;
    
    Boolean connect=false;
    try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("booking");
		
		conn = ds.getConnection();
		connect = true;
    }catch(Exception e){
       connect=false;
       e.printStackTrace();
    }
    
    if(connect){
    	System.out.println("연결o");
    }else{
    	System.out.println("연결x");
    }
	%>

</body>
</html>