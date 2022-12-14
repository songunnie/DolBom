package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;

public class MemberOut implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		MemberService service = new MemberService();
		service.delMember(user_id);
		//request.getContextPath(): 프로젝트 base 경로 => /프로젝트명
		return "/DispatcherServlet?url=/member/logout";
	}

}
