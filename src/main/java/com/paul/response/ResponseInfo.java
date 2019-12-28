package com.paul.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ResponseInfo {

	private long timestamp;
	private int status;
    private String message;    
    private Object data;

    /***
     * Constructor
     * @param status
     * @param message
     * @param uriRequested
     */
    public ResponseInfo(HttpStatus status, String message) {
        this.message = message;
        this.status = status.value();
        this.timestamp = new Date().getTime();
    }
    
    /***
     * Constructor
     * @param status
     * @param uriRequested
     * @param data
     */
    public ResponseInfo(HttpStatus status, Object data) {
        this.message = "exito";
        this.status = status.value();
        this.data = data;
        this.timestamp = new Date().getTime();
    }
    
    /***
     * Constructor
     * @param status
     * @param message
     * @param uriRequested
     * @param data
     */
    public ResponseInfo(HttpStatus status, String message, Object data) {
        this.message = message;
        this.status = status.value();
        this.data = data;
        this.timestamp = new Date().getTime();
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

	public long getTimestamp() {
		return timestamp;
	}

	public Object getData() {
		return data;
	}
    
}
