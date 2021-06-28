package org.kp.cloud.app.controller;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.kp.cloud.app.util.ApiStatus;
import org.kp.cloud.app.util.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kp.logger.KpLoggerUtil;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerController {

  private static Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseEntity<ApiStatus> defaultErrorHandler(Exception e) {
    	
    		log.error(KpLoggerUtil.fmt("ORG_BIO_SYS_E_50001", "Unknown Exception","Exception message"), e);
    		return new ResponseEntity<ApiStatus>(
			new ApiStatus(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown Exception"), HttpStatus.INTERNAL_SERVER_ERROR);
    
    } // defaultErrorHandler(Exception)

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ApiStatus> illegalArgumentExceptionHandler(IllegalArgumentException ile) {
    
		return new ResponseEntity<ApiStatus>(
			new ApiStatus(HttpStatus.BAD_REQUEST, ile.getMessage()), HttpStatus.BAD_REQUEST);
    
    } // illegalArgumentExceptionHandler(IllegalArgumentException)

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ApiStatus> notFoundExceptionHandler(NotFoundException nfe) {
    
		return new ResponseEntity<ApiStatus>(
			new ApiStatus(HttpStatus.NOT_FOUND, nfe.getMessage()), HttpStatus.NOT_FOUND);
    
    } // notFoundExceptionHandler(NotFoundException)


} // class ExceptionHandlerController