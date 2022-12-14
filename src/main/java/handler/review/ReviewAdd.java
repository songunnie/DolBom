package handler.review;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class ReviewAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/review/add.jsp";
		}
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sitter_id = request.getParameter("sitterId");
		String user_id = request.getParameter("userId");
		String content = request.getParameter("content");
		
		ReviewVo vo = new ReviewVo(0, sitter_id, user_id, null, content);
		ReviewService service = new ReviewService();
		service.addReview(vo); // 리뷰 남기기 완료
		
		//나중에 펫시터 프로필 페이지 만들어지면 거기로 이동되는걸로.
		return "redirect:/DispatcherServlet?url=/review/listbysitter&sitterId="+sitter_id;
	}

}
