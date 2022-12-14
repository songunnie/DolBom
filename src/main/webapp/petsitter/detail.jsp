<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:if test="${sessionScope.loginId != vo.sitter_id }">
<c:set var="str">readonly</c:set>
</c:if> --%>
<h3>펫시터 프로필 페이지</h3>
<%-- <form action="${pageContext.request.contextPath }/DispatcherServlet" method="post"> --%>
<form action="${pageContext.request.contextPath }/DispatcherServlet" method="post">
<input type="hidden" name="url" value="/petsitter/detail">
펫시터ID: <input type="text" value="${sessionScope.loginId}" name="sitterId" readonly><br/>
<%-- ${vo.region } / ${vo.type } --%>
<c:if test="${empty vo.region || empty vo.type }"> 
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/petsitter/add">프로필 등록하기</a>
</c:if>
<c:if test="${not empty vo.region && not empty vo.type }"> 
활동지역: <input type="text" name="region" value="${vo.region }" readonly><br/>
돌봄가능크기 <input type="text" name="type" value="${vo.type }" readonly><br/>
</c:if>
<c:if test="${sessionScope.loginId == vo.sitter_id }">
수정
<input type="button" value="수정하기" onclick="javascript:location.href='${pageContext.request.contextPath }/DispatcherServlet?url=/petsitter/edit&sitterId=${sessionScope.loginId }'">
<%-- <input type="button" value="삭제" 
onclick="javascript:location.href=''${pageContext.request.contextPath }/DispatcherServlet?url=/petsitter/del&sitterId=${sessionScope.loginId }'"> --%>
</c:if>
</form>
</body>
</html>