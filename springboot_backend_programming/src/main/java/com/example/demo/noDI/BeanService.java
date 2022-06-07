package com.example.demo.noDI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.MovieService;

public class BeanService {
	
	private final BeanRepository beanRepository;
	
	BeanService(BeanRepository beanRepository) {
		this.beanRepository = beanRepository;
	}

	public List<BeanDTO> search(String query) {
		return beanRepository.search(query);
	}
}
