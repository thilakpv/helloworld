package org.kp.cloud.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigureApplication implements WebMvcConfigurer {

	@Autowired
	RESTApiInterceptor restApiInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(restApiInterceptor).addPathPatterns("/api/**");
	}
} // class ConfigureApplication