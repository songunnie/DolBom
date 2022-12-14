package handler.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class ReviewListBySitter implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String sitter_id = request.getParameter("sitterId");
//		ReviewService service = new ReviewService();
//		
//		ArrayList<ReviewVo> list = service.selectById(sitter_id);
		ArrayList<ReviewVo> list = (new ReviewService()).selectBySitter(sitter_id);
		request.setAttribute("list", list);	
		
		return "/review/list.jsp";
	}

}
