package org.kp.cloud.app.controller;

import org.junit.Before;
import org.junit.Test;
import org.kp.cloud.app.controller.RESTApiController;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RESTApiControllerTest {

	private static Logger log = LoggerFactory.getLogger(RESTApiControllerTest.class);
	RESTApiController restApiController = null;
	
	@Before
    public void setUp() throws Exception {

		restApiController = new RESTApiController();
		
    }
	
	@Test
	public void checkAppHealthTest() throws Exception {
		
		try {
			ResponseEntity<String> resp = restApiController.helloEndpoint();
			log.info("Response from controller: " + resp.toString());
		} catch (Exception e) {
			log.info("Test Expected error: " + e.getMessage());
		}
		
	}
	
} // class RESTApiControllerTest
