<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const editReview = (num) => {
	showEdit(num);
	var content = document.getElementById(num+"_content");
	var review = document.getElementById(num+"_textarea");
	review.innerHTML = content.innerText;
}

const showEdit = (num) => {
	var editarea = document.getElementById(num+"_editarea");
	editarea.style.display="";
	var old = document.getElementById(num+"_content");
	old.style.display="none";
	
	var edit = document.getElementById("edit"+num);
	edit.style.display="none";
	var del = document.getElementById("del"+num);
	del.style.display="none";
	
	var submit = document.getElementById("submit"+num);
	submit.style.display="";
	var cancel = document.getElementById("cancel"+num);
	cancel.style.display="";
}

const hideEdit = (num) => {
	var editarea = document.getElementById(num+"_editarea");
	editarea.style.display="none";
	var old = document.getElementById(num+"_content");
	old.style.display="";
	
	var edit = document.getElementById("edit"+num);
	edit.style.display="";
	var del = document.getElementById("del"+num);
	del.style.display="";
	
	var submit = document.getElementById("submit"+num);
	submit.style.display="none";
	var cancel = document.getElementById("cancel"+num);
	cancel.style.display="none";
	
}

</script>
</head>
<body>
<a href="${pageContext.request.contextPath }/DispatcherServlet?url=/review/add&userId=${sessionScope.loginId }">리뷰남기기</a>
<table border="1">
<tr><th style="display:none" id="${vo.num }">No</th><th>펫시터아이디</th><th>회원아이디</th><th>날짜</th><th>내용</th><th>수정/삭제</th>
<c:forEach var="vo" items="${arr }">
<form action="${pageContext.request.contextPath }/DispatcherServlet?url=/review/edit&num=${vo.num }" method="post">
<input type="hidden" name="num" value="${vo.num }">
<tr>
<td style="display:none">${vo.num }</td>
<td>
${vo.sitter_id }
</td>
<td>
<input text="text" name="userId" value="${vo.user_id }">
</td>
<td>${vo.review_date }</td>
<td><div id="${vo.num }_content" style="display:show">${vo.content }</div>
<div id="${vo.num }_editarea" style="display:none">
<textarea id="${vo.num }_textarea" name="content" rows="1" style="resize:none"></textarea>
</div>
</td>
<td>
<input type="button" id="edit${vo.num }" value="수정하기" onclick="editReview(${vo.num })">
<input type="button" id="del${vo.num }" value="삭제하기" onclick="javascript:location.href='${pageContext.request.contextPath }/DispatcherServlet?url=/review/del&num=${vo.num }&&userId=${vo.user_id }'">
<input type="submit" id="submit${vo.num }" value="수정완료" style="display:none">
<input type="button" id="cancel${vo.num }" value="수정취소" style="display:none" onclick="hideEdit(${vo.num })">
</td>
</tr>
</form>
</c:forEach>
</table>

</body>
</html>
