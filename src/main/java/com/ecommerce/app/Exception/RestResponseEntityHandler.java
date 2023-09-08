package com.ecommerce.app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ecommerce.app.Model.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomException exception){
		return new ResponseEntity<>(new ErrorResponse().builder()
				.errorMessage(exception.getMessage())
				.errorCode(exception.getErrorCode()).build(),HttpStatus.NOT_FOUND);
	}

}
