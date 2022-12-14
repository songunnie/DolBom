package req;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;

///**
// * Servlet implementation class DispatcherServlet
// */
////서블릿은 딱한게! 요청을 받는 곳이다
//@WebServlet("/DispatcherServlet")
//public class DispatcherServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	/**
//	 * /guestbook/add=handler.guest.AddHandler = 키
//	 * /guestbook/list=handler.guest.ListHandler = 값
//	 * 이 두개를 쌍으로 저장할, 즉 명령어와 실행할 hanlder 객체를 쌍으로 저장할 맵 생성
//	 */
//	private Map<String, Handler> map = new HashMap<>();
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public DispatcherServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	//init 메서드는 서블릿이 호출될 때 서블릿을 초기화 해주는 메서드이다.
//	//최초 한번만 이 메서드가 활용되고 명령어가 저장하려고 쓰는거다!
//	public void init() throws ServletException {
//		// TODO Auto-generated method stub
//		//Properties은 Map과 비슷하게 키와 값을 저장하는 클래스.
//		Properties prop = new Properties();
//		
//		//Properties파일의 경로
//		String path = "/WEB-INF/command.properties";
//		
//		//웹에서 접근할 수 있는 주소로 변환
//		String path2 = getServletContext().getRealPath(path);
//		try {
//			//FileReader는 문자단위로 읽어들이는 stream
//			//파일의 내용을 읽어서 Properties에 복구
//			prop.load(new FileReader(path2));
//			
//			//맵에 저장하는 키는 순서가 없다.
//			//Set은 중복이안되는 모든 키의 집합
//			//Properties의 키값 묶음에 .iterator();는 반복자 붙여줌 
//			Iterator iter = prop.keySet().iterator();
//			
//			//Properties의 키가 읽을 동안 반복
//			while (iter.hasNext()) {
//				String url = (String) iter.next();
//				
//				//키에 묶인 값을 읽는다(ListHandler)
//				String className = prop.getProperty(url);
//				
//				try {
//					//클래스 이름으로 클래스 정보를 읽어서 반환한다
//					Class<?> handlerClass = Class.forName(className);
//					
//					//클래스 정보로 뭘하냐면, Class 객체의 .newInstance(); 메서드는 
//					//클래스 정보를 기반으로 객체를 생성해준다.
//					Handler handler = (Handler) handlerClass.newInstance();
//					
//					map.put(url, handler);
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InstantiationException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String url = request.getParameter("url");
//		//명령어로 등록된 핸들러 객체를 꺼내서 
//		Handler handler = map.get(url);
//		//.process로 호출
//		String view = handler.process(request, response);
//		if (view.startsWith("redirect:")) {
//			String path = view.split(":")[1];
//			//split으로 쪼개면서 sendRedirect
//			response.sendRedirect(request.getContextPath() + path);
//		} else if(view.startsWith("responsebody/")) {
//			String body = view.split("/")[1];
//			System.out.println("body:" + body);
//			response.getWriter().append(body);
//		} else {
//			//뷰페이지로 이동
//			RequestDispatcher dis = request.getRequestDispatcher(view);
//			dis.forward(request, response);
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}

import handler.Handler;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 명령어와 실행할 handler객체를 쌍으로 저장할 맵생성
	private Map<String, Handler> map = new HashMap<String, Handler>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 서블릿 초기화 메서드
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		// Properties. Map과 비슷하게 키와 값 저장하는 클래스.
		Properties prop = new Properties();

		// properties 파일 경로
		String path = "/WEB-INF/command.properties";
		// 웹 주소로 변경
		String path2 = getServletContext().getRealPath(path);
		try {
			// 파일의 내용을 읽어서 properties에 복구
			prop.load(new FileReader(path2));

			// properties의 키값 묶음에 반복자 붙여서
			Iterator iter = prop.keySet().iterator();

			// 읽을 키가 있을 동안 반복
			while (iter.hasNext()) {
				String url = (String) iter.next();// 키를 하나씩 읽어서
				// 키에 묶인 값을 읽는다(클래스명)
				String className = prop.getProperty(url);

				try {
					// 클래스 정보를 읽어서 반환
					Class<?> handlerClass = Class.forName(className);

					Constructor<?> cons = handlerClass.getConstructor(null);
					Handler handler = (Handler) cons.newInstance();

					// 명령어와 핸들러객체를 쌍으로 등록
					map.put(url, handler);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getParameter("url"); //*로 바뀌면서 필요없어짐
		System.out.println(url);
//		//요청받은 url 정보
//		String url =request.getPathInfo();
//		System.out.println("요청받은 url:"+ url);
		
		// 명령어로 등록된 핸들러 객체를 꺼내서
		Handler handler = map.get(url);
		// process()를 호출
		String view = handler.process(request, response);
		System.out.println(view);
		if(view==null) {
			return;
		} //뷰페이지 리턴을 안하면 그냥 끝나는걸로~
		if (view.startsWith("redirect:")) {
			String path = view.split(":")[1];
			response.sendRedirect(request.getContextPath() + path);
		} else if (view.startsWith("responsebody/")) {
			String body = view.split("/")[1];
			System.out.println("body:" + body);
			response.getWriter().append(body);
		} else {
			RequestDispatcher dis = request.getRequestDispatcher(view);
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}