<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 수정 페이지</h3>
<form action="${pageContext.request.contextPath }/DispatcherServlet?url=/petsitter/edit" method="post">
<table border="1">
<tr><th>펫시터ID</th>
<td><input type="text" name="sitterId" value="${vo.sitter_id }" readonly></td></tr>
<tr><th>지역</th>
<td><input type="text" name="region" value="${vo.region }"></td></tr>
<tr><th>견종 크기</th>
<td>
<input type="checkbox" name="type" value="large">대형견
<input type="checkbox" name="type" value="medium">중형견
<input type="checkbox" name="type" value="small">소형견
</td></tr>
<tr><th>수정</th><td><input type="submit" value="저장"></td></tr>
</table>
</form>
</body>
</html>