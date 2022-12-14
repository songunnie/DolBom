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
<h3>상세페이지</h3>
<form action="${pageContext.request.contextPath }/DispatcherServlet" 
method="post">
<input type="hidden" name="url" value="/member/detail">
id:<input type="text" value="${vo.user_id }" name="user_id" readonly><br/>
pwd:<input type="text" value="${vo.pwd }" name="pwd"><br/>
name:<input type="text" value="${vo.name }" readonly><br/>
tel:<input type="text" value="${vo.tel }" readonly><br/>
address:<input type="text" value="${vo.address }" readonly><br/>
type:
<c:if test="${vo.status==0 }">일반회원</c:if>
<c:if test="${vo.status==1 }">펫시터</c:if>
<br/>
<input type="submit" value="수정">
</form>
</body>
</html>