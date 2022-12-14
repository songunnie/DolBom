package handler.review;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class ReviewEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
//		int num = Integer.parseInt(request.getParameter("xx"));
		if(request.getMethod().toLowerCase().equals("get")) {
			ReviewService service = new ReviewService();
			ReviewVo vo = service.selectOne(num);
			request.setAttribute("vo", vo);
			return "/review/listuser.jsp";
		}
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String user_id = request.getParameter("userId");
		String content = request.getParameter("content");
//		System.out.println(content);
		ReviewService service = new ReviewService();
		service.updateReview(new ReviewVo(num, null, null, null, content));
		
		//펫시터 프로필 페이지 만들고 프로필에서 리뷰 볼 수 있게 수정하기.
		return "redirect:/DispatcherServlet?url=/review/listbyuser&userId="+user_id;
		
	}

}
