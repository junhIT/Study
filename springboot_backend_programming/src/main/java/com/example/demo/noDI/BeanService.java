package com.example.demo.noDI;

import java.util.List;

public class BeanService {
	
	private final BeanRepository beanRepository;
	
	BeanService(BeanRepository beanRepository) {
		this.beanRepository = beanRepository;
	}

	public List<BeanDTO> search(String query) {
		return beanRepository.search(query);
	}
}
