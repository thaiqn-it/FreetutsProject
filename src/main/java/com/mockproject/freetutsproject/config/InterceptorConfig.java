package com.mockproject.freetutsproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mockproject.freetutsproject.interceptor.HeaderHandlerInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private HeaderHandlerInterceptor headerHandlerInterceptor;

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerHandlerInterceptor);
		super.addInterceptors(registry);
	}
	
	
}
