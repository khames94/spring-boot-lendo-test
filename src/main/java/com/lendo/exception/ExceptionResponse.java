package com.lendo.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionResponse extends BusinessException {

	private String code;
	private String type;
	private String message;
	private String error;
	private HttpStatus status;

	public ExceptionResponse() {
		super();
	}
	
	 public ExceptionResponse(String message, HttpStatus status,String code,String type,String  error) {
		 super();
       this.message = message;
       this.error = error;
       this.status = status;
       this.type = type;
       this.code = code;
   }
	 
	 public ExceptionResponse(String message, HttpStatus status,String code,String type) {
		 super();
       this.message = message;
       this.status = status;
       this.type = type;
       this.code = code;
   }

	 public ExceptionResponse(String message,String code,String type,String  error) {
		 super();
       this.message = message;
       this.error = error;
       this.type = type;
       this.code = code;
   }
	 
	 
	 public ExceptionResponse(String message) {
		 super();
	       this.message = message;
	   }
	 
	 

	

}
