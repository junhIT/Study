package com.example.springbase.code;

public enum UserRole {
	ADMIN("A"),
	USER("U");
	
	private final String code;
	
	UserRole(String code) {
		this.code = code;
	}
	
	String getCode() {
		return code;
	}
}
