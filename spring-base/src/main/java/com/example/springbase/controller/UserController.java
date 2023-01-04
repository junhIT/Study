package com.example.springbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbase.dto.RegisterUserDTO;
import com.example.springbase.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// �α��� ������
	@GetMapping("/login")
	public String login() {
		
		return "/user/login";
	}
	
	// ȸ������ ������
	@GetMapping("/regi")
	public String regi() {
		return "/user/regi";
	}

	// ȸ������ ó��
	@PostMapping("/regi")
	public RegisterUserDTO registerUser(RegisterUserDTO req) {
		
		return null;
//		return userService.registerUser(req);
	}
}
