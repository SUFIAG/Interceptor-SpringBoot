package com.netsurfingzone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.netsurfingzone.interceptors.AuthenticationInterceptor;

@Component
public class WebAppConfigAdapter implements WebMvcConfigurer {

	@Autowired
	private AuthenticationInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {

		System.out.println("This method will get invoked by container while deployment");
		System.out.println("Value of interceptor is " + interceptor);
		// adding custom interceptor
		interceptorRegistry.addInterceptor(interceptor);
	}
}