package com.netsurfingzone.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.netsurfingzone.annotation.NotSecuredApi;
import com.netsurfingzone.constants.ApplicationConstant;
import com.netsurfingzone.error.UserNotAuthorizedException;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HandlerMethod handlerMethod = null;
		if (handler instanceof HandlerMethod) {
			handlerMethod = (HandlerMethod) handler;
		}

		// Below implementation is for http://localhost:9091/user/login API
		NotSecuredApi notSecuredApi = handlerMethod.getMethodAnnotation(NotSecuredApi.class);
		if (notSecuredApi != null && notSecuredApi instanceof NotSecuredApi) {
			return true;
		}

		// username and password that we are sending from postman
		String username = request.getHeader("username");
		String password = request.getHeader("password");

		// Dummy logic for second API for authentication
		// This should token based authentication so need to send username and
		// password again and again
		if (ApplicationConstant.USERNAME.equals(username) && ApplicationConstant.PASSWORD.equals(password)) {
			return true;
		}

		// if username and password is not admin & admin then show error
		if (!ApplicationConstant.USERNAME.equals(username) || !ApplicationConstant.PASSWORD.equals(password)) {

			throw new UserNotAuthorizedException("Not a valid user");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Some more logic if needed
		System.out.println("postHandle() is invoked");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Some more logic if needed
		System.out.println("afterCompletion() is invoked");
	}

}