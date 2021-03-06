package org.kp.cloud.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kp.logger.KpLoggerUtil;
import com.google.gson.JsonObject;

@RestController
public class RESTApiController {

	private static Logger log = LoggerFactory.getLogger(RESTApiController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> rootEndpoint() throws Exception {
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("greeting", "Welcome to your boiler plate App, generated by KP CloudStarter! Try /health to makesure app health");
		log.info(KpLoggerUtil.fmt("ORG_BIO_SYS_I_30001", "Welcome note","Welcome to your boiler plate App, generated by KP CloudStarter!"));
		return ResponseEntity.status(HttpStatus.OK).body(jsonObj.toString());		
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> helloEndpoint() throws Exception {
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("message", "This message is from /hello endpoint!");
		log.info(KpLoggerUtil.fmt("ORG_BIO_SYS_I_30002", "Endpoint for test","This message is from /hello endpoint!"));
		return ResponseEntity.status(HttpStatus.OK).body(jsonObj.toString());		
	}

	@RequestMapping(value = "/secured", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> securedEndpoint() throws Exception {
		
		/*
			The expected response if KPOAuth library added:
			{
				"timestamp": "2019-11-05T05:19:47.899+0000",
				"status": 403,
				"error": "Forbidden",
				"message": "Client is not authorized.",
				"path": "/rest/secured"
			}
		*/
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("greeting", "Validated success with KPOAuth library!");
		log.info(KpLoggerUtil.fmt("ORG_BIO_SYS_I_30003", "OAuth Provider","Validated success with KPOAuth library!!"));
		return ResponseEntity.status(HttpStatus.OK).body(jsonObj.toString());
			
	}

	
} // class RESTApiController