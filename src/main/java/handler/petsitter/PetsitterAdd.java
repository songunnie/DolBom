package handler.petsitter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import petsitter.PetsitterService;
import petsitter.PetsitterVo;

public class PetsitterAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/petsitter/add.jsp";
		}
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String sitter_id = request.getParameter("sitterId");
		String region = request.getParameter("region");
		String[] value = request.getParameterValues("type");
		String type = "";
		for(String val : value) {
			type+= val + " ";
		}
		
		PetsitterVo vo = new PetsitterVo(sitter_id, region, type);
//		System.out.println(vo);
		PetsitterService service = new PetsitterService();
		service.addPetsitter(vo);
		return "redirect:/petsitter/detail.jsp";
	}

}
