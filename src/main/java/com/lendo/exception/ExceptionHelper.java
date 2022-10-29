package com.lendo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {


	@ExceptionHandler(value = { BusinessException.class })
	public ResponseEntity<Object> handleInvalidInputException(BusinessException ex) {
		Map<String, String> map = new HashMap<String, String>();
		if (ex.getMessage() != null)
			map.put("message", ex.getMessage());
		if (ex.getStatus() != null)
			map.put("status", ex.getStatus().toString());
		if (ex.getError() != null)
			map.put("error", ex.getError());
		if (ex.getType() != null)
			map.put("type", ex.getType().toString());
		if (ex.getCode() != null)
			map.put("code", ex.getCode().toString());
		return new ResponseEntity<Object>(map,(ex.getStatus() !=null)?ex.getStatus() : HttpStatus.EXPECTATION_FAILED);
	}

	
	@ExceptionHandler(value = { MissingServletRequestParameterException.class })
	public ResponseEntity<Object> handleUnAuthorizedException(MissingServletRequestParameterException ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("status", HttpStatus.BAD_REQUEST);
		map.put("timestamp", LocalDateTime.now());
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
