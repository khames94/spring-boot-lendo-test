package com.lendo.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
public  class BusinessException extends RuntimeException {

    private String message;
    private String code;
    private Throwable cause;
    private HttpStatus status;
    private Map<String, String> details;
    private List<String> args;
    private String error;
    private String type;

    public BusinessException() {
       
    }
    public BusinessException(HttpStatus status) {
        this.status = status;
    }
    public BusinessException(String message, HttpStatus status, List<String> args) {
        super(message);
        this.message = message;
        this.args = args;
        this.status = status;
    }
    
    public BusinessException(String message, HttpStatus status,String type) {
        this.message = message;
        this.status = status;
        this.type = type;
    }
    
    public BusinessException(String message, HttpStatus status,String type, String code) {
      this.message = message;
      this.status = status;
      this.type = type;
      this.code=code;
  }
    
    public BusinessException(String message, HttpStatus status,String type, String code,String error) {
      this.message = message;
      this.status = status;
      this.error = error;
      this.type = type;
      this.code=code;
  }
    
    public BusinessException(String message, String  error,String type) {
      super();
      this.message = message;
      this.error = error;
      this.type = type;
  }

    public BusinessException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public BusinessException(String message, HttpStatus status, Map<String, String> details) {
        super(message);
        this.message = message;
        this.status = status;
        this.details = details;
    }

    public BusinessException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

	

}
