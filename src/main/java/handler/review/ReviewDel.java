package handler.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;


public class ReviewDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		String user_id = request.getParameter("userId");
		System.out.println(user_id);
		ReviewService service = new ReviewService();
		service.delReview(num);
		
		//TODO: 펫시터 프로필 페이지 만들어지면 바꾸기! 리뷰 볼 수 있던 페이지로 이동.
		return "redirect:/DispatcherServlet?url=/review/listbyuser&userId="+user_id;
	}

}
