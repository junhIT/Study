package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.demo")
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ClientNoContentRuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected CommonResponse handleClientNoContentRuntimeException(Exception e) {
		log.error("handleClientNoContentRuntimeException", e);
		return CommonResponse.builder()
				.message(e.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.build();
		
	}
}
