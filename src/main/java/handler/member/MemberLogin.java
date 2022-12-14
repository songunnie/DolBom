package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberLogin implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/member/loginForm.jsp";
		}
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		response.setCharacterEncoding("UTF-8");
		
		String user_id = request.getParameter("user_id");
		String pwd = request.getParameter("pwd");
		
		MemberService service = new MemberService();
		MemberVo vo = service.selectById(user_id);
		
		//로그인 처리
		if(vo != null && pwd.equals(vo.getPwd())) {//로그인 성공
			//현재 사용중인 세션 반환
			HttpSession session = request.getSession();
			session.setAttribute("loginId", user_id);//로그인 아이디
			session.setAttribute("status", vo.getStatus());//로그인 사람의 타입
		}
		return "/index.jsp";
	}

}

