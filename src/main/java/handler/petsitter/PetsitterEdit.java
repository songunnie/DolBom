package handler.petsitter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import petsitter.PetsitterService;
import petsitter.PetsitterVo;

public class PetsitterEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sitter_id = request.getParameter("sitterId");
//		System.out.println("edit id: " + sitter_id);
		if(request.getMethod().toLowerCase().equals("get")) {
			PetsitterService service = new PetsitterService();
			PetsitterVo vo = service.selectById(sitter_id);
			request.setAttribute("vo", vo);
			return "/petsitter/edit.jsp";
		}
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String region = request.getParameter("region");
		String[] value = request.getParameterValues("type");
		String type = "";
		for(String val : value) {
			type+= val + " ";
		}
		
		PetsitterService service = new PetsitterService();
		service.updatePetsitter(new PetsitterVo(sitter_id, region, type));
		
		return "redirect:/DispatcherServlet?url=/petsitter/detail&sitterId="+sitter_id;
	}

}
