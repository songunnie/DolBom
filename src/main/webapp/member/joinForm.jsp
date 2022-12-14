<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">

const check = () => {
	const xhttp = new XMLHttpRequest();
	xhttp.onload = () => {
	  let obj = JSON.parse(xhttp.responseText);
	  let div = document.getElementById("ch_res");
	  div.innerHTML = obj.msg; //응답 텍스트
	  if(obj.flag){
		  f.flag.value='true';
	  }
	}
	
	let param = "user_id="+f.user_id.value;
	param += "&url=/member/idcheck";
	
	//전송방식, 서버페이지 설정
	xhttp.open("post", "${pageContext.request.contextPath }/DispatcherServlet");
	
	//post header 설정
	xhttp.setRequestHeader("Content-type", 
			"application/x-www-form-urlencoded");
	
	//요청 보냄
	xhttp.send(param);
}
const a = () =>{
	if(f.flag.value!='true'){
		alert('아이디 중복체크 하시오');
		return;
	}
	
	if(f.pwd.value==''){
		alert('패스워드 필수');
		return;
	}
	
	f.submit();//전송
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/DispatcherServlet" method="post" name="f">
<input type="hidden" name="url" value="/member/add">
<table border="1">
<tr><th>ID</th><td><input type="text" name="user_id">
<input type="button" value="중복체크" onclick="check()">
<span id="ch_res"></span>
</td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
<tr><th>TEL</th><td><input type="text" name="tel"></td></tr>
<tr><th>ADDRESS</th><td><input type="text" name="address"></td></tr>
<tr><th>회원타입</th>
	<td>
		<input type="radio" name="type" value="0" checked>일반회원
		<input type="radio" name="type" value="1">펫시터
	</td>
</tr>
<tr><th>가입완료</th><td><input type="button" value="가입" onclick="a()"></td></tr>
</table>
<input type="hidden" name="flag" value="false">
</form>
</body>
</html>