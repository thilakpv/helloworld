package org.kp.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kp.logger.KpLoggerUtil;

@SpringBootApplication
public class KpCloudJavaApplication extends SpringBootServletInitializer {
	
	private static Logger log = LoggerFactory.getLogger(KpCloudJavaApplication.class);
	// Main method used when this application is run as "Spring Boot Application"
	public static void main(String[] args) {
		log.info(KpLoggerUtil.fmt("ORG_BIO_SYS_I_30002", "booting application","Sample started as Spring Boot Application"));
		SpringApplication.run(KpCloudJavaApplication.class, args);
	}
	

} // class KpCloudJavaApplicationSample
