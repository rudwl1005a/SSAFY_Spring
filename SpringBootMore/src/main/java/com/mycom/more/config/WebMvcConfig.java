package com.mycom.more.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.more.common.TestInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor)
			.addPathPatterns("/users/**") // 다른 Controller를 이용해서 다양한 테스트를 하고 있기 때문!
			.excludePathPatterns("/login/**");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("http://127.0.0.1:5500")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
			.allowedHeaders("*")
			.allowCredentials(true)
			.maxAge(3000);
	}
}
