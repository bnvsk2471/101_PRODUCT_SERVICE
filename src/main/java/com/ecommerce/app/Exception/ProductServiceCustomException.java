package com.ecommerce.app.Exception;

import lombok.Data;

@Data
public class ProductServiceCustomException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	
	public ProductServiceCustomException(String message, String errorcode) {
		super(message);
		this.errorCode=errorcode;
	}
}
