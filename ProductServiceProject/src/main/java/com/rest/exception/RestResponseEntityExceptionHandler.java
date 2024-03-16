package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.model.ErrorrResponse;
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 

@ExceptionHandler(ProductServiceException.class)
 public ResponseEntity<ErrorrResponse> handleProductServiceException(ProductServiceException exception){
	ErrorrResponse response=ErrorrResponse.builder()
			.message(exception.getMessage())
			.errorCode(exception.getErrorCode())
			.build();
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	 
 }
}
