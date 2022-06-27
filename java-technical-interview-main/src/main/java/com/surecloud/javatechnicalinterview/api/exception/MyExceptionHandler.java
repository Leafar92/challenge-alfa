package com.surecloud.javatechnicalinterview.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> tratarExceptionGeneric(Exception e, WebRequest request) {

		String msg = "Something wrong happened, pleae try again later or if the problem persists, please contact the ADM";

		return handleExceptionInternal(e, msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> catchResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {

		return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);

	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

}
