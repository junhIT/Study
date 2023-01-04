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
	
	// 로그인 페이지
	@GetMapping("/login")
	public String login() {
		
		return "/user/login";
	}
	
	// 회원가입 페이지
	@GetMapping("/regi")
	public String regi() {
		return "/user/regi";
	}

	// 회원가입 처리
	@PostMapping("/regi")
	public RegisterUserDTO registerUser(RegisterUserDTO req) {
		
		return null;
//		return userService.registerUser(req);
	}
}
