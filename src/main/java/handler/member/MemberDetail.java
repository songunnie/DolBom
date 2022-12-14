package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getMethod().toLowerCase().equals("get")) {
			String user_id = request.getParameter("user_id");
			MemberService service = new MemberService();
			MemberVo vo = service.selectById(user_id);
			request.setAttribute("vo", vo);
			return "/member/detail.jsp";
		}
		String user_id = request.getParameter("user_id");
		String pwd = request.getParameter("pwd");
		MemberService service = new MemberService();
		service.updateMember(new MemberVo(user_id, pwd, null, null ,null, 0));

		return "redirect:/index.jsp";
	}
}
