package com.example.demo.noDI;

import java.util.Arrays;
import java.util.List;

public class JunRepositoryImpl implements BeanRepository{
	
	public JunRepositoryImpl() {
	}

	@Override
	public List<BeanDTO> search(String q) {
		return Arrays.asList(
				BeanDTO.builder().beanCode("01").beanName("Си1").build()
				, BeanDTO.builder().beanCode("02").beanName("Си2").build()
				);
				
	}
}
