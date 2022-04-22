package com.mycom.myadv.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		// return true : 통과
		// return false : 통과x
		System.out.println("preHandle()");
		System.out.println(handler);

		// 무조건 통과
		// return true;

		// session
//		HttpSession session = request.getSession();
//		String login = (String) session.getAttribute("login");
//		if ("success".equals(login)) return true;
//		return false;

		// header api_key
		String apiKey = request.getHeader("API_KEY");
		if (apiKey == null || "".equals(apiKey)) return false;
		if (isApiKeyValid(apiKey)) return true;
		return false;
	}

	private boolean isApiKeyValid(String key) {
		return true;
	}
}
