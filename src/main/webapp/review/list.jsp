<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3>리뷰 모음</h3>

<!-- 펫시터 로그인시 받은 리뷰만 확인 -->
<%-- <c:if test="${sessionScope.loginId == vo.sitter_id }"> --%>
<table border="1">
<tr><th style="display:none">No</th><th>펫시터아이디</th><th>회원아이디</th><th>날짜</th><th>내용</th>
<c:forEach var="vo" items="${list }">
<tr>
<td style="display:none">${vo.num }</td>
<td><%-- <input type="text" name="sitterId" value="${vo.sitter_id }" readonly> --%>
${vo.sitter_id }
</td>
<td><%-- <input type="text" name="userId" value="${vo.user_id }"> --%>
${vo.user_id }
</td>
<td>${vo.review_date }</td>
<td>${vo.content }</td>
</tr>
</c:forEach>
</table>



</body>
</html>