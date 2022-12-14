<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	var region = document.getElementById("a");
	
	alert(region.innerHTML);
}

</script>
</head>
<body>
<h3  style="background-color: #f1f8ff"> 펫시터 프로필 등록</h3>
<form action="${pageContext.request.contextPath }/DispatcherServlet?url=/petsitter/add" method="post">
<%-- <input type="hidden" name="xx" value="${sessionScope.loginId }"> --%>
<table border="1">
<tr><th>펫시터아이디</th>
<td><input type="text" name="sitterId" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>활동지역</th>
<td><input type="text" name="region"></td></tr>
<tr><th>견종타입</th>
<td>
<input type="checkbox" name="type" value="large">대형견
<input type="checkbox" name="type" value="medium">중형견
<input type="checkbox" name="type" value="small">소형견
</td>
</tr>
<tr>
<th>전송</th>
<td><input type="submit" value="등록">
</td>
</tr>
</table>

</form>

</body>
</html>