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
<h3>웹 앱</h3>
<c:if test="${sessionScope.loginId==null }">
	<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/member/add">회원가입</a>
	<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/member/login">로그인</a><br/>
</c:if>
<c:if test="${sessionScope.loginId!=null }">
${sessionScope.loginId}님 로그인중 <br/>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/member/detail&id=${sessionScope.loginId }">내정보</a>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/member/logout">로그아웃</a>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/member/out&id=${sessionScope.loginId }">탈퇴</a><br/>
<%-- <a href="${pageContext.request.contextPath }/DispatcherServlet?url=/member/">이미지 게시판</a> --%>
<%-- <a href="${pageContext.request.contextPath }/DispatcherServlet?url=/data/create">자료올리기</a> --%>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/petsitter/detail&sitterId=${sessionScope.loginId }">펫시터프로필</a>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/review/add&userId=${sessionScope.loginId }">리뷰남기기</a>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/review/listbysitter&sitterId=${sessionScope.loginId }">받은 리뷰보기</a>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/review/listbyuser&userId=${sessionScope.loginId }">내가 쓴 리뷰보기</a>
</c:if>
</body>
</html>