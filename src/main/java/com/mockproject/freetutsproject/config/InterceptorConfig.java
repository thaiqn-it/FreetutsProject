package com.mockproject.freetutsproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mockproject.freetutsproject.interceptor.LayoutPreloadInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private LayoutPreloadInterceptor layoutPreloadInterceptor;

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(layoutPreloadInterceptor);
		super.addInterceptors(registry);
	}
	
	
}
