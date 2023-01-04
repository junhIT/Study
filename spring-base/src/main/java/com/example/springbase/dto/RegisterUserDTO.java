package com.example.springbase.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterUserDTO {

	private Long id;
	private String userId;
	private String password;
	private String email;
	private String UserRole;
}
