package handler.member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberIdCheck implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String user_id = request.getParameter("user_id");
		MemberService service = new MemberService();
		MemberVo vo = service.selectById(user_id);
		boolean flag = false;
		String msg = "사용 불가능한 아이디";

		if (vo == null) {
			msg = "사용 가능한 아이디";
			flag = true;
		}
		
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		obj.put("msg", msg);
		String txt = obj.toJSONString();
		return "responsebody/" + txt;
	}

}
