<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>리뷰 추가하기</h3>
<form action="${pageContext.request.contextPath }/DispatcherServlet?url=/review/add" method="post">
<table border="1">
<tr><th>펫시터아이디</th>
<td><input type="text" name="sitterId" value="${vo.sitter_id }"></td></tr>
<tr><th>회원아이디</th>
<td><input type="text" name="userId" value="${sessionScope.loginId }"></td></tr>
<tr><th>내용</th>
<td><textarea name="content"></textarea></td></tr>
<tr><th>전송</th>
<td><input type="submit" value="리뷰등록"></td></tr>
</table>
</form>
</body>
</html>