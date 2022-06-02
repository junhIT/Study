package com.example.demo.noDI;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class BeanController {
	
	private final BeanService beanService;	
	
	public BeanController(BeanService beanService) {
		this.beanService = beanService;
	}
	
	@GetMapping("/search")
	private List<BeanDTO> search(@RequestParam(name = "q")String query) {
		return beanService.search(query);
	}
}
