package org.kp.cloud.app.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiStatus {
	private static Logger log = LoggerFactory.getLogger(ApiStatus.class);
	private HttpStatus status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public String getStatus() {
		return status.toString();
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd yyyy HH:mm:ss z", timezone = "PST")
	private Date timestamp = Calendar.getInstance(TimeZone.getDefault()).getTime();
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String message;
	
	public ApiStatus(String message) {
	       
		this(null, message, null);
		
	} // ApiStatus(String)
	
	public ApiStatus(HttpStatus status, String message) {
	       
		this(status, message, null);
		
	} // ApiStatus(HttpStatus, String)
	
	public ApiStatus(HttpStatus status, String message, Throwable ex) {
	       
		this.status = (status == null ? HttpStatus.OK : status);
		this.message = (message == null ? "Unexpected Error" : message);
		
		if(ex != null)
			log.error("[Status=" + status + "] " + message, ex);
		else
			log.error("[Status=" + status + "] " + message);
		
	} // ApiStatus(HttpStatus, String, Throwable)

} // class ApiStatus