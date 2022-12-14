package handler.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class ReviewListByUser implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("userId");
		
		ArrayList<ReviewVo> arr = (new ReviewService()).selectByUser(user_id);
		request.setAttribute("arr", arr);
		return "/review/listuser.jsp";
	}

}
