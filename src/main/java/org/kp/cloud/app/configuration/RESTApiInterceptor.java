package org.kp.cloud.app.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component

public class RESTApiInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = LoggerFactory.getLogger(RESTApiInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		log.info("pre -> [" + request.getMethod() + "] " + request.getRequestURI());		
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {

		log.debug("post -> [" + request.getMethod() + "] " + request.getRequestURI());

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {

		log.debug("complete -> [" + request.getMethod() + "] " + request.getRequestURI());

	}

} // class RESTApiInterceptor