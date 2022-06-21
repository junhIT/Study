package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.constants.ExceptionMessage;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "�˻� ��� ����")
public class ClientNoContentRuntimeException extends Exception {

	public ClientNoContentRuntimeException() {
		super(ExceptionMessage.NO_CONTENT.getMessage());
	}
}
