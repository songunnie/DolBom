package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/member/joinForm.jsp";
		}
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		String user_id = request.getParameter("user_id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		int status = Integer.parseInt(request.getParameter("status"));
		MemberVo vo = new MemberVo(user_id, pwd, name, tel, address, status);
		MemberService service = new MemberService();
		service.addMember(vo);// 회원가입 완료
		return "redirect:/index.jsp";
	}

}
