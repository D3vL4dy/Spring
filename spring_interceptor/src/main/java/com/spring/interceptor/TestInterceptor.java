package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor {

	// preHandle() -> 컨트롤러가 호출되기 전에 실행됨.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Boolean result = true;
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		if(num != 0) {
			result = false;
			// 결과 -> 아무것도 안나옴.
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// modelAndView에서 model과 view를 꺼냄.
		System.out.println("Model Attribute : " + modelAndView.getModel().get("message"));
		System.out.println("view name : " + modelAndView.getViewName());
		
		modelAndView.addObject("message", "Hello Spring!");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(ex != null)
			System.out.println("Exception message : " + ex.getMessage());
	}

}
