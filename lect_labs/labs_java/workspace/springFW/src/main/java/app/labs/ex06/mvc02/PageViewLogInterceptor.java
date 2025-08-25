package app.labs.ex06.mvc02;

import java.sql.Date;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PageViewLogInterceptor implements HandlerInterceptor {

		@Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response
	    		, Object handler) throws Exception {
			System.out.println("컨트롤러가 실행되기 전입니다");
			
			request.setCharacterEncoding("UTF-8");
			
			System.out.println("URI : "+ request.getRequestURI());
			System.out.println("현재 시간 : "+ new java.util.Date().toString());
		
			// 세션을 쓴다면 (로그인 처리 ) 
			/*HttpSession session = request.getSession();
			String id = session.getAttribute("userId").toString();
			
			if(id.equals("") || id == null) {
				response.sendRedirect("/login");
				return false; 
				// 로그인이 안되어있으면 로그인 페이지로 이동시킨다 
			}
			*/
			
			return true;
		}
		
		@Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
			System.out.println("컨트롤러가 실행된 후 입니다(뷰가 실행되기 전 )");
			System.out.println("뷰 이름 : "+ modelAndView.getViewName());
			
		}
		
		@Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response
	    		, Object handler, Exception ex) {
			System.out.println("뷰가 실행된 후 입니다");

		}
	
	
	
}
