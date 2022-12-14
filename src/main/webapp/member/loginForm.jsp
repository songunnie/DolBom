<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인폼</h3>
<form action="${pageContext.request.contextPath }/DispatcherServlet" method="post">
<input type="hidden" name="url" value="/member/login">
<table border="1">
<tr><th>ID</th><td><input type="text" name="user_id"></td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>LOGIN</th><td><input type="submit" value="login">
<a href="${pageContext.request.contextPath }/member/join">회원가입</a>
</td></tr>
</table>
</form>
</body>
</html>