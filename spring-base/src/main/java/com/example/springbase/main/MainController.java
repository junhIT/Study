package com.example.springbase.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public String sample() {
		return "HelloWorld";
	}
}
