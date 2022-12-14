package handler.petsitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import petsitter.PetsitterService;
import petsitter.PetsitterVo;
import review.ReviewService;

public class PetsitterDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sitter_id = request.getParameter("sitterId");
		System.out.println("detail id:"+ sitter_id);
		PetsitterService service = new PetsitterService();
		PetsitterVo vo = service.selectById(sitter_id);
//		PetsitterVo vo = (new PetsitterService()).selectById(sitter_id);
		System.out.println("detail vo:" + vo);
		
		//추가된거
//		ReviewService revservice = new ReviewService();
//		vo.setRevs(revservice.selectById(vo.getSitter_id()));
		//
		request.setAttribute("vo", vo);
		return "/petsitter/detail.jsp";
	}
}
